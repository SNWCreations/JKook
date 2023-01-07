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
 * Represents the JKook core. Handles the singleton call.
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
     * Get the HTTP API entry.
     *
     * @see HttpAPI
     */
    public static HttpAPI getHttpAPI() {
        return core.getHttpAPI();
    }

    /**
     * Get the JKook API version.
     */
    public static String getAPIVersion() {
        return getCore().getAPIVersion();
    }

    /**
     * Get the JKook implementation brand.
     */
    public static String getImplementationName() {
        return getCore().getImplementationName();
    }

    /**
     * Get the version of the JKook implementation.
     */
    public static String getImplementationVersion() {
        return getCore().getImplementationVersion();
    }

    /**
     * Get the scheduler.
     *
     * @see Scheduler
     */
    public static Scheduler getScheduler() {
        return getCore().getScheduler();
    }

    /**
     * Get the event manager.
     *
     * @see EventManager
     */
    public static EventManager getEventManager() {
        return getCore().getEventManager();
    }

    /**
     * Get the root logger. Provided by JKook API implementation. <p>
     * <b>But it's recommended to use {@link Plugin#getLogger()} instead.</b>
     */
    public static Logger getLogger() {
        return getCore().getLogger();
    }

    /**
     * Get the command manager.
     */
    public static CommandManager getCommandManager() {
        return core.getCommandManager();
    }

    /**
     * Get the plugin manager.
     */
    public static PluginManager getPluginManager() {
        return core.getPluginManager();
    }

    /**
     * Get the console command sender.
     */
    public static ConsoleCommandSender getConsoleCommandSender() {
        return core.getConsoleCommandSender();
    }
}
