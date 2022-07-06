package snw.jkook.event;

import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import snw.jkook.JKook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a list that contains all the handlers related to an event type.
 */
public final class HandlerList extends HashMap<Method, Object> {

    /**
     * Add a method to this list.
     *
     * @param object The instance of the class that contains the provided method
     * @param method The method instance.
     * @throws IllegalArgumentException Thrown if this operation is invalid (e.g. Static method with a valid object)
     */
    @Contract("_, _ -> null")
    public Object put(Method method, Object object) throws IllegalArgumentException {
        // region Verification
        Validate.isTrue(!containsKey(method), "The method has already registered.");
        if (Modifier.isStatic(method.getModifiers())) {
            Validate.isTrue(object == null, "We cannot invoke the static method with a object. Call this method with the target method and null instead.");
        }
        Validate.isTrue(!Modifier.isPublic(method.getModifiers()), "We can't call the non-public methods.");
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

        super.put(method, object);
        return null;
    }

    /**
     * Call all listeners under this list.
     *
     * @param event The event instance
     */
    public void callAll(Event event) {
        synchronized (this) {
            for (Map.Entry<Method, Object> entry : entrySet()) {
                try {
                    entry.getKey().invoke(entry.getValue(), event);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    JKook.getLogger().error("Unexpected situation happened. :(", e);
                } catch (Throwable e) {
                    JKook.getLogger().error("Something went wrong when we attempting to call a handler.", e);
                }
            }
        }
    }
}
