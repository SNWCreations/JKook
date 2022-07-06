package snw.jkook.bot;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import snw.jkook.HttpAPI;
import snw.jkook.config.file.FileConfiguration;
import snw.jkook.config.file.YamlConfiguration;
import snw.jkook.entity.User;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Represents a basic Kook Bot implementation. Use YAML as configuration. <p>
 * Bot developers should extend this class to make their own Bot program.
 */
public class BaseBot implements Bot {
    private final String token;
    private User user = null; // DO NOT MODIFY THIS FIELD, OR SOMETHING BAD WILL HAPPEN
    private final Logger logger;
    private final File configFile;
    private FileConfiguration configuration;
    private final File dataFolder;
    private final HttpAPI httpAPI;
    private final File file;

    // Bot developers should NEVER use this constructor.
    // And they should NEVER define new constructor.
    // This constructor should be called by Bot loaders (provided by API implementations).
    public BaseBot(
            final String token,
            final File configFile,
            final FileConfiguration configuration,
            final File dataFolder,
            final HttpAPI httpAPI,
            final File file
    ) {
        if (!(getClass().getClassLoader() instanceof BotLoader)) {
            throw new InvalidBotException("The Bot class should be loaded by using BotLoader.");
        }
        this.token = Objects.requireNonNull(token);
        this.configFile = Objects.requireNonNull(configFile);
        Validate.isTrue(configFile.exists(), "The configuration file does not exists.");
        Validate.isTrue(configFile.isFile(), "The configuration file is not a file, (Is it a directory?)");
        this.configuration = Objects.requireNonNull(configuration);
        this.dataFolder = Objects.requireNonNull(dataFolder);
        this.httpAPI = Objects.requireNonNull(httpAPI);
        this.file = Objects.requireNonNull(file);
        this.logger = LoggerFactory.getLogger(getClass());
        // after this bot was constructed, the implementations should get the user information
        //  about this bot and call its setUser(User) method.
    }

    @Override
    public User getUser() {
        return user;
    }

    // This method should be called by API implementations only.
    public void setUser(final User user) {
        Objects.requireNonNull(user);
        if (this.user != null) {
            throw new IllegalStateException();
        }
        this.user = user;
    }

    @Override
    public Logger getLogger() {
        return logger;
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
        saveResource("config.yml", false, false);
    }

    @Override
    public void saveResource(final String path, final boolean replace, final boolean ignorePathStructure) throws IllegalArgumentException {
        try (final InputStream stream = getResource(path)) {
            if (stream == null) {
                throw new IllegalArgumentException("The target resource does not embedded in the Bot JAR file");
            }

            final String targetPath;
            if (ignorePathStructure) {
                final String[] pathSplit = path.split("/");
                targetPath = pathSplit[pathSplit.length - 1];
            } else {
                targetPath = path;
            }

            final File local = new File(dataFolder, targetPath);
            if (local.exists()) {
                if (!replace) {
                    getLogger().warn("Cannot save resource \"" + path + "\" because it has already exists.");
                    return;
                }
                local.delete();
            } else {
                local.mkdirs();
            }

            try (final FileOutputStream out = new FileOutputStream(local)) {
                int index;
                byte[] bytes = new byte[1024];
                while ((index = stream.read(bytes)) != -1) {
                    out.write(bytes, 0, index);
                }
            }
        } catch (IOException e) {
            getLogger().warn("Cannot save resource because an error occurred.", e);
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
    public String getToken() {
        return token;
    }

    @Override
    public HttpAPI getHttpAPI() {
        return httpAPI;
    }

    @Override
    public File getFile() {
        return file;
    }

}
