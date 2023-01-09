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
 * Represents the JKook core implementation.
 */
public interface Core {

    /**
     * Get the HTTP API entry.
     *
     * @see HttpAPI
     */
    HttpAPI getHttpAPI();

    /**
     * Get the JKook API version.
     */
    String getAPIVersion();

    /**
     * Get the JKook implementation brand.
     */
    String getImplementationName();

    /**
     * Get the version of the JKook implementation.
     */
    String getImplementationVersion();

    /**
     * Get the scheduler.
     *
     * @see Scheduler
     */
    Scheduler getScheduler();

    /**
     * Get the event manager.
     *
     * @see EventManager
     */
    EventManager getEventManager();

    /**
     * Get the root logger. Provided by JKook API implementation. <p>
     * <b>But it's recommended to use {@link Plugin#getLogger()} instead.</b>
     */
    Logger getLogger();

    /**
     * Get the console command sender.
     */
    ConsoleCommandSender getConsoleCommandSender();

    /**
     * Get the command manager.
     */
    CommandManager getCommandManager();

    /**
     * Get the plugin manager.
     */
    PluginManager getPluginManager();

    /**
     * Get the user representation of the Bot in this VM.
     */
    User getUser();

    /**
     * Set the user that bound to this client. <p>
     * This method should be called by API implementations, <b>NOT Plugin</b>.
     *
     * @param user The user object
     * @throws IllegalStateException Thrown if the client has already bound to a user
     */
    void setUser(User user) throws IllegalStateException;

    /**
     * Get the unsafe object. It can provide some <i>insecure</i> operations.
     *
     * @see Unsafe
     */
    Unsafe getUnsafe();

    /**
     * Shutdown the client. Stops everything.
     */
    void shutdown();
}
