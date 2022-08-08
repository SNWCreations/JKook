/*
 * Copyright 2022 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snw.jkook.event;

import snw.jkook.JKook;
import snw.jkook.plugin.Plugin;
import snw.jkook.util.Validate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Represents a list that contains all the handlers related to an event type.
 */
public final class HandlerList {
    private final Set<RegisteredListener> listeners = new HashSet<>();

    /**
     * Add a method to this list.
     *
     * @param plugin The plugin instance
     * @param object The instance of the class that contains the provided method
     * @param method The method instance.
     * @throws IllegalArgumentException Thrown if this operation is invalid (e.g. Static method with a valid object)
     */
    public void add(Plugin plugin, Method method, Listener object) throws IllegalArgumentException {
        // region Verification
        Validate.isFalse(listeners.stream().anyMatch(IT -> IT.getMethod() == method), "The method has already registered.");
        if (Modifier.isStatic(method.getModifiers())) {
            Validate.isTrue(object == null, "We cannot invoke the static method with a object. Call this method with the target method and null instead.");
        }
        Validate.isTrue(Modifier.isPublic(method.getModifiers()), "We can't call the non-public methods.");
        Validate.isTrue(method.getParameterCount() == 1, "Unexpected argument count, expected 1, got " + method.getParameterCount());

        final Class<?> param = method.getParameterTypes()[0];
        Validate.isTrue(!Modifier.isAbstract(param.getModifiers()), "You cannot listen to the abstract event classes.");
        Validate.isTrue(Event.class.isAssignableFrom(param), "Unexpected parameter type, the parameter should be the subclass of " + Event.class.getSimpleName());

        try {
            final Method staticHandlerListMethod = param.getMethod("getHandlers");
            Validate.isTrue(Modifier.isStatic(staticHandlerListMethod.getModifiers()), "The getHandlers() method should be static.");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("The target event class does not have method getHandlers().", e);
        }

        Validate.isTrue(method.isAnnotationPresent(EventHandler.class), "We cannot find the " + EventHandler.class.getSimpleName() + " annotation from the provided method.");

        // endregion
        listeners.add(new RegisteredListener(plugin, object, method));
    }

    /**
     * Call all listeners under this list.
     *
     * @param event The event instance
     */
    public void callAll(Event event) {
        synchronized (this) {
            final List<RegisteredListener> internals = new ArrayList<>();
            final List<RegisteredListener> nonInternals = new ArrayList<>();
            for (RegisteredListener listener : listeners) {
                if (listener.getMethod().getAnnotation(EventHandler.class).internal()) {
                    internals.add(listener);
                } else {
                    nonInternals.add(listener);
                }
            }
            callAll0(internals, event);
            callAll0(nonInternals, event);
        }
    }

    private void callAll0(Collection<RegisteredListener> listeners, Event event) {
        for (RegisteredListener listener : listeners) {
            if (listener.getPlugin() != null && !listener.getPlugin().isEnabled()) continue;
            try {
                listener.getMethod().invoke(listener.getListener(), event);
            } catch (InvocationTargetException | IllegalAccessException e) {
                JKook.getLogger().error("Unexpected situation happened. :(", e);
            } catch (Throwable e) {
                JKook.getLogger().error("Something went wrong when we attempting to call a handler.", e);
            }
        }
    }

    /**
     * Represents a registered listener. Included some useful information.
     */
    private static class RegisteredListener {
        private final Plugin plugin;
        private final Object listenerObj;
        private final Method method;

        private RegisteredListener(Plugin plugin, Object listenerObj, Method method) {
            this.plugin = plugin;
            this.listenerObj = listenerObj;
            this.method = method;
        }

        public Plugin getPlugin() {
            return plugin;
        }

        public Object getListener() {
            return listenerObj;
        }

        public Method getMethod() {
            return method;
        }
    }
}
