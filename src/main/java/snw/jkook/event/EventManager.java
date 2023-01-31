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
 * 表示一个事件管理器。
 */
public interface EventManager {

    /**
     * 将提供的事件发布给所有处理事件的方法。
     * 在所有匹配的方法返回后，此方法才会返回。
     *
     * @param event The event to call
     */
    void callEvent(Event event);

    /**
     * 注册提供的 {@code Listener} ，以使其可以接收事件。
     *
     * @param plugin   拥有 {@code listener} 的插件
     * @param listener 将被注册的 {@link Listener}
     */
    void registerHandlers(Plugin plugin, Listener listener);

    /**
     * 注销提供的 {@code Listener} ，以使其不再可以接收事件。
     *
     * @param listener 将被注销的 {@link Listener}
     */
    void unregisterHandlers(Listener listener);

    /**
     * 注销提供的 {@link Plugin} 所拥有的所有 {@link Listener} 。
     * @param plugin 目标插件
     */
    void unregisterAllHandlers(Plugin plugin);
}
