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
import snw.jkook.event.EventManager;
import snw.jkook.plugin.Plugin;
import snw.jkook.plugin.PluginManager;
import snw.jkook.scheduler.Scheduler;

import java.util.Objects;


/**
 * 表示一个 JKook 核心。处理单例调用。<br>
 * 但推荐使用 {@link Plugin#getCore()} 。
 */
public final class JKook {

    /* This class should not be constructed. */
    private JKook() {
    }

    private static Core core = null;

    public static Core getCore() {
        return core;
    }

    /* This method should be called only once. */
    /* Only JKook API implementations can access this method. */
    public static void setCore(Core core) {
        Objects.requireNonNull(core);
        if (JKook.core != null) {
            throw new IllegalStateException("The core implementation has already registered.");
        }
        JKook.core = core;
    }

    /**
     * 获得 {@link HttpAPI} 的实例。
     *
     * @see HttpAPI
     */
    public static HttpAPI getHttpAPI() {
        return core.getHttpAPI();
    }

    /**
     * 获取当前使用的 JKook API 版本。
     */
    public static String getAPIVersion() {
        return getCore().getAPIVersion();
    }

    /**
     * 获取当前的 JKook API 实现 的名称。
     */
    public static String getImplementationName() {
        return getCore().getImplementationName();
    }

    /**
     * 获取当前的 JKook API 实现 的版本。
     */
    public static String getImplementationVersion() {
        return getCore().getImplementationVersion();
    }

    /**
     * 获取任务调度器。
     *
     * @see Scheduler
     */
    public static Scheduler getScheduler() {
        return getCore().getScheduler();
    }

    /**
     * 获取事件管理器。
     *
     * @see EventManager
     */
    public static EventManager getEventManager() {
        return getCore().getEventManager();
    }

    /**
     * 获取根日志记录器。使用此方法返回的记录器记录的日志内容不会有插件名称作为前缀。 <p>
     * <b>但是更推荐使用 {@link Plugin#getLogger()} 。</b>
     */
    public static Logger getLogger() {
        return getCore().getLogger();
    }

    /**
     * 获取命令管理器。
     */
    public static CommandManager getCommandManager() {
        return core.getCommandManager();
    }

    /**
     * 获取插件管理器。
     */
    public static PluginManager getPluginManager() {
        return core.getPluginManager();
    }

    /**
     * 获取控制台命令发送者的实例。
     */
    public static ConsoleCommandSender getConsoleCommandSender() {
        return core.getConsoleCommandSender();
    }
}
