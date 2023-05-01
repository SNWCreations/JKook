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

import org.yaml.snakeyaml.Yaml;
import snw.jkook.util.Validate;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Represents a basic Plugin loader implementation.
 */
public abstract class PluginClassLoader extends URLClassLoader implements PluginLoader {
    protected static final String PLUGIN_METADATA_ENTRY = "plugin.yml";

    static {
        ClassLoader.registerAsParallelCapable(); // I think it will make the loader faster.
    }

    public PluginClassLoader(ClassLoader classLoader) {
        super(new URL[]{}, classLoader);
    }

    public PluginClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    public Plugin loadPlugin(File file) throws InvalidPluginException {
        try {
            return loadPlugin0(file);
        } catch (Exception e) {
            throw new InvalidPluginException(e);
        }
    }

    protected Plugin loadPlugin0(File file) throws Exception {
        beforeOpen(file);

        // load the given file as JarFile
        try (final JarFile jar = new JarFile(file)) { // try-with-resources!
            // try to find plugin.yml
            JarEntry entry = jar.getJarEntry(PLUGIN_METADATA_ENTRY);
            if (entry == null) { // if not found
                throw new IllegalArgumentException("We cannot find " + PLUGIN_METADATA_ENTRY); // fail
            }
            // or we should read the plugin.yml and parse it to get information
            final InputStream pluginYmlStream = jar.getInputStream(entry);

            // construct description
            final PluginDescription description = createDescription(pluginYmlStream);
            final String mainClassName = description.getMainClassName();
            final Class<? extends Plugin> main = lookForMainClass(mainClassName, file);
            return construct(main, description);
        }
    }

    protected void beforeOpen(File file) {
        Validate.isTrue(file.exists(), "The Plugin file does not exists.");
        Validate.isTrue(file.isFile(), "The Plugin file is invalid.");
        Validate.isTrue(file.canRead(), "The Plugin file does not accessible. (We can't read it!)");
    }

    protected Class<? extends Plugin> lookForMainClass(String mainClassName, File file) throws Exception {
        // if the class has already loaded, a conflict has been found.
        // so many things can cause the conflict, such as a class with the same binary name, or the Plugin author trying to use internal classes (e.g. java.lang.Object)
        if (findLoadedClass(mainClassName) != null) {
            throw new IllegalArgumentException("The main class defined in plugin.yml has already been defined in the VM.");
        }

        addURL(file.toURI().toURL()); // add URL of the Plugin archive file so that the classloader can find the Plugin main class.
        // No check, because the Exception will be handled by the caller
        Class<? extends Plugin> main = loadClass(mainClassName, true).asSubclass(Plugin.class);

        if (main.getDeclaredConstructors().length != 1) {
            throw new IllegalStateException("Unexpected constructor count, expected 1, got " + main.getDeclaredConstructors().length);
        }
        return main;
    }

    protected PluginDescription createDescription(InputStream stream) {
        final Yaml parser = new Yaml();
        try {
            final Map<String, Object> ymlContent = parser.load(stream);
            // noinspection unchecked
            return new PluginDescription(
                    Objects.requireNonNull(ymlContent.get("name"), "name is missing").toString(),
                    Objects.requireNonNull(ymlContent.get("version"), "version is missing").toString(),
                    Objects.requireNonNull(ymlContent.get("api-version"), "api-version is missing").toString(),
                    ymlContent.getOrDefault("description", "").toString(),
                    ymlContent.getOrDefault("website", "").toString(),
                    Objects.requireNonNull(ymlContent.get("main"), "main is missing").toString(),
                    (List<String>) ymlContent.getOrDefault("authors", Collections.emptyList()),
                    (List<String>) ymlContent.getOrDefault("depend", Collections.emptyList()),
                    (List<String>) ymlContent.getOrDefault("softdepend", Collections.emptyList())
            );
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid plugin.yml", e);
        }
    }

    /**
     * Construct the Plugin instance with given information and return it.
     *
     * @param cls         The Plugin main class
     * @param description The description object
     * @throws Exception Thrown if something went really wrong
     */
    protected abstract <T extends Plugin> T construct(final Class<T> cls, final PluginDescription description) throws Exception;
}
