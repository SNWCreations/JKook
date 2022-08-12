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

package snw.jkook.plugin;

import org.slf4j.Logger;
import snw.jkook.Core;
import snw.jkook.config.file.FileConfiguration;

import java.io.File;
import java.io.InputStream;

/**
 * Represents a Plugin. <p>
 * To make a Plugin, extend {@link BasePlugin}.
 */
public interface Plugin {

    // NOTE:
    // If you want to implement this interface, I suggest you to use BasePlugin instead.
    // Still want to implement this? Alright, you won.
    // But I have something to tell you.
    // You should provide the things that BasePlugin#init requires.
    // Warning is here, if you don't do that and your implementation does not work, don't say anything!

    /**
     * Get logger of this Plugin. <p>
     * The result is different from {@link Core#getLogger()}.
     */
    Logger getLogger();

    /**
     * Set the value indicating whether this plugin is currently enabled.
     *
     * @param enabled The status
     */
    void setEnabled(boolean enabled);

    /**
     * Returns a value indicating whether this plugin is currently enabled.
     */
    boolean isEnabled();

    /**
     * Calls on loading this Plugin. <p>
     * You can do things (e.g. extract default configuration files) at this stage.
     */
    void onLoad();

    /**
     * Calls on enabling this Plugin. <p>
     * You can do things (e.g. Register commands) at this stage.
     */
    void onEnable();

    /**
     * Calls on disabling this Plugin (before client fully shutdown). <p>
     * You can do things (e.g. close services) at this stage. And the Plugin won't receive events at this stage.
     */
    void onDisable();

    /**
     * Get the configuration. <p>
     * A empty configuration will be returned if the embedded file does not exist, or it is invalid.
     */
    FileConfiguration getConfig();

    /**
     * Discards all the changes in the <b>main</b> configuration stored in memory and reloads from disk. <p>
     * This method should fail silently.
     */
    void reloadConfig();

    /**
     * Attempts to save default configuration file. <p>
     * This should fail silently.
     */
    void saveDefaultConfig();

    /**
     * Attempts to save a resource embedded in the Plugin archive file to the data folder of this Plugin.
     *
     * @param path                The canonical path (e.g. "/lang/en_US.json")
     * @param replace             Decides the API implementation will overwrite the file on the disk.
     * @param ignorePathStructure True if you want to save the file at the root of data folder
     * @throws IllegalArgumentException Thrown if the path is invalid
     */
    void saveResource(String path, boolean replace, boolean ignorePathStructure) throws IllegalArgumentException;

    /**
     * Get the input stream of a resource embedded in the Plugin archive file.
     *
     * @param path The canonical path (e.g. "/lang/en_US.json")
     * @return The input stream of the target resource, null is returned if the resource was not found
     */
    InputStream getResource(String path);

    /**
     * Get the data folder of this Plugin. <p>
     * This folder always exists, unless somebody deleted it manually.
     */
    File getDataFolder();

    /**
     * Get the binary file representation of this Plugin.
     */
    File getFile();

    /**
     * Get the description of this Plugin.
     */
    PluginDescription getDescription();
}
