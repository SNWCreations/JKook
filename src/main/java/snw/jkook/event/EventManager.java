/*
 * Copyright 2022 - 2023 JKook contributors
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

import snw.jkook.plugin.Plugin;

/**
 * Represents an event manager.
 */
public interface EventManager {

    /**
     * Call an event. The listeners of the provided event type will be called. <p>
     * It is a sync method.
     *
     * @param event The event to call
     */
    void callEvent(Event event);

    /**
     * Register a handler that can process events.
     *
     * @param plugin   The plugin as the listener's owner
     * @param listener The listener to register
     */
    void registerHandlers(Plugin plugin, Listener listener);

    /**
     * Unregister the specified handler, and it won't receive events.
     *
     * @param listener The listener to unregister
     */
    void unregisterHandlers(Listener listener);

    /**
     * Unregister all handlers that is registered by provided plugin.
     * @param plugin The plugin as the owner of Listeners
     */
    void unregisterAllHandlers(Plugin plugin);
}
