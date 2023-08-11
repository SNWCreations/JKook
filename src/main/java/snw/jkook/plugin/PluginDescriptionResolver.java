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
import java.io.InputStream;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * An resolver of the plugin description files. <br>
 * <b>Implementation Note:</b> The implementations of this interface must be registered
 *  using {@link PluginManager#registerPluginDescriptionResolver(Predicate, Supplier)} method.
 */
public interface PluginDescriptionResolver {

    /**
     * Convert the plugin description content inside the provided file to a {@link PluginDescription} object.
     *
     * @param file The input file
     * @return The plugin description object
     */
    PluginDescription resolve(File file);

    /**
     * Convert the content in the provided input stream to a {@link PluginDescription} object.
     *
     * @param stream The input stream
     * @return The plugin description object
     */
    PluginDescription resolve(InputStream stream);
}
