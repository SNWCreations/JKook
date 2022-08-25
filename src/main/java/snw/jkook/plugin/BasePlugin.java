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
import snw.jkook.config.file.FileConfiguration;
import snw.jkook.config.file.YamlConfiguration;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Represents a basic Kook Plugin implementation. Use YAML as configuration. <p>
 * Plugin developers should extend this class to make their own Plugin program.
 */
public abstract class BasePlugin implements Plugin {
    private Logger logger;
    private File configFile;
    private FileConfiguration configuration;
    private File dataFolder;
    private File file;
    private PluginDescription description;
    private volatile boolean enabled = false;
    private volatile boolean init = false;

    // Plugin developers should NEVER use this constructor.
    // And they should NEVER define new constructor.
    // This constructor should be called by Plugin loaders (provided by API implementations).
    public BasePlugin() {
        if (!(getClass().getClassLoader() instanceof PluginLoader)) {
            throw new InvalidPluginException("This class should be loaded by using PluginLoader.");
        }
    }

    /**
     * Initialize this plugin. This should be called by API implementations ONLY.
     *
     * @param configFile  The configuration file so that can be loaded as the default configuration
     *                    using {@link #reloadConfig()}
     * @param dataFolder  The data folder
     * @param description The description object
     * @param file        The file that contains this plugin
     * @param logger      The logger object
     * @throws IllegalStateException Thrown if this plugin has already initialized
     */
    public void init(
            final File configFile,
            final File dataFolder,
            final PluginDescription description,
            final File file,
            final Logger logger
    ) throws IllegalStateException {
        if (init) {
            throw new IllegalStateException();
        }
        this.configFile = Objects.requireNonNull(configFile);
        this.dataFolder = Objects.requireNonNull(dataFolder);
        this.description = Objects.requireNonNull(description);
        this.file = Objects.requireNonNull(file);
        this.logger = Objects.requireNonNull(logger);
        init = true;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public final void setEnabled(boolean enabled) {
        if (!this.enabled == enabled) {
            this.enabled = enabled;
            if (enabled) {
                onEnable();
            } else {
                onDisable();
            }
        }
    }

    @Override
    public final boolean isEnabled() {
        return enabled;
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public FileConfiguration getConfig() {
        return configuration;
    }

    // Override this if you don't want to use the YAML as the configuration.
    @Override
    public void reloadConfig() {
        configuration = YamlConfiguration.loadConfiguration(configFile);

        final InputStream backend = getResource("config.yml");
        if (backend == null) {
            return;
        }

        configuration.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(backend, StandardCharsets.UTF_8)));
    }

    @Override
    public void saveDefaultConfig() {
        try {
            saveResource("config.yml", false, false);
        } catch (IllegalArgumentException ignored) {}
    }

    @Override
    public void saveResource(String path, final boolean replace, final boolean ignorePathStructure) throws IllegalArgumentException {
        if (path == null || path.equals("")) {
            throw new IllegalArgumentException("Resource path cannot be null or empty");
        }

        path = path.replace('\\', '/');
        InputStream in = getResource(path);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + path + "' cannot be found in " + file);
        }

        File outFile = new File(dataFolder, path);
        int lastIndex = path.lastIndexOf('/');
        File outDir;
        if (!ignorePathStructure) {
            outDir = new File(dataFolder, path.substring(0, Math.max(lastIndex, 0)));
        } else {
            outDir = dataFolder;
        }

        if (!outDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            outDir.mkdirs();
        }

        try {
            if (!outFile.exists() || replace) {
                OutputStream out = Files.newOutputStream(outFile.toPath());
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                logger.warn("Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            logger.warn("Could not save " + outFile.getName() + " to " + outFile, ex);
        }
    }

    @Override
    public InputStream getResource(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        try {
            URL url = getClass().getClassLoader().getResource(path);

            if (url == null) {
                return null;
            }

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public File getDataFolder() {
        return dataFolder;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public PluginDescription getDescription() {
        return description;
    }
}
