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

package snw.jkook;

import org.slf4j.Logger;
import snw.jkook.command.CommandManager;
import snw.jkook.command.ConsoleCommandSender;
import snw.jkook.entity.User;
import snw.jkook.event.EventManager;
import snw.jkook.plugin.Plugin;
import snw.jkook.plugin.PluginManager;
import snw.jkook.scheduler.Scheduler;

/**
 * 表示一个 JKook 核心。提供了很多重要的方法。
 */
public interface Core {

    /**
     * 获得 {@link HttpAPI} 的实例。
     *
     * @see HttpAPI
     */
    HttpAPI getHttpAPI();

    /**
     * 获取当前使用的 JKook API 版本。
     */
    String getAPIVersion();

    /**
     * 获取当前的 JKook API 实现 的名称。
     */
    String getImplementationName();

    /**
     * 获取当前的 JKook API 实现 的版本。
     */
    String getImplementationVersion();

    /**
     * 获取任务调度器。
     *
     * @see Scheduler
     */
    Scheduler getScheduler();

    /**
     * 获取事件管理器。
     *
     * @see EventManager
     */
    EventManager getEventManager();

    /**
     * 获取根日志记录器。<br>
     * 使用此方法返回的记录器记录的日志内容不会有插件名称作为前缀。<br>
     * <b>但是更推荐使用 {@link Plugin#getLogger()} 。</b>
     */
    Logger getLogger();

    /**
     * 获取控制台命令发送者的实例。
     *
     * @see ConsoleCommandSender
     */
    ConsoleCommandSender getConsoleCommandSender();

    /**
     * 获取命令管理器。
     */
    CommandManager getCommandManager();

    /**
     * 获取插件管理器。
     */
    PluginManager getPluginManager();

    /**
     * 获取此 JVM 中运行的机器人的用户实例。
     */
    User getUser();

    /**
     * 设置此 JVM 中运行的机器人的用户实例。<br>
     * <b>这个方法只应该被 JKook API 的实现 调用，不应该由插件调用。</b>
     *
     * @param user 用户实例
     * @throws IllegalStateException 当机器人的用户实例已被设置时抛出
     */
    void setUser(User user) throws IllegalStateException;

    /**
     * 获取 {@link Unsafe} 的实例。它可以提供一些<b>不安全</b>的操作。
     *
     * @see Unsafe
     */
    Unsafe getUnsafe();

    /**
     * 使当前的 JKook API 的实现停止运行。此方法在关闭一切内容 (如 {@link Scheduler}) 后返回。
     */
    void shutdown();
}
