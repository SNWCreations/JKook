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

package snw.jkook.plugin;

import java.io.File;

/**
 * Represents a Plugin loader.
 */
public interface PluginLoader extends MarkedClassLoader {

    /**
     * Load a Plugin (its main class) and return its instance. <p>
     * You don't need to call any methods in the plugin instance,
     * just load it into the memory and return it.
     *
     * @param file The Plugin data source
     * @return The Plugin instance
     * @throws InvalidPluginException Thrown if an error occurred while the loader attempting to load the Plugin
     */
    Plugin loadPlugin(final File file) throws InvalidPluginException;
}
