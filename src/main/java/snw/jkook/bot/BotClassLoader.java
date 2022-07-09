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

package snw.jkook.bot;

import org.apache.commons.lang.Validate;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Represents a basic Bot loader implementation.
 */
public abstract class BotClassLoader extends URLClassLoader implements BotLoader {

    static {
        ClassLoader.registerAsParallelCapable(); // I think it will make the loader faster.
    }

    public BotClassLoader() {
        super(new URL[]{});
    }

    @Override
    public Bot loadBot(File file, String token) throws InvalidBotException {
        try {
            return loadBot0(file, token);
        } catch (Exception e) {
            throw new InvalidBotException(e);
        }
    }

    private Bot loadBot0(File file, String token) throws Exception {
        Validate.isTrue(file.exists(), "The Bot file does not exists.");
        Validate.isTrue(file.isFile(), "The Bot file is invalid.");
        Validate.isTrue(file.canRead(), "The Bot file does not accessible. (We can't read it!)");
        Validate.isTrue(!token.isEmpty(), "The Bot Token is empty.");

        // load the given file as JarFile
        try (final JarFile jar = new JarFile(file)) { // try-with-resources!
            // try to find bot.yml
            JarEntry entry = jar.getJarEntry("bot.yml");
            if (entry == null) {
                throw new IllegalArgumentException("We cannot find bot.yml ."); // bot.yml is not found, so we don't know where is the main class
            }
            // or we should read the bot.yml and parse it to get information
            final InputStream bot = jar.getInputStream(entry);
            final Yaml parser = new Yaml();

            // construct description
            final BotDescription description;
            try {
                final Map<String, Object> ymlContent = parser.load(bot);
                // noinspection unchecked
                description = new BotDescription(
                        (String) ymlContent.get("name"),
                        (String) ymlContent.get("version"),
                        (String) ymlContent.get("api-version"),
                        (String) ymlContent.getOrDefault("description", ""),
                        (String) ymlContent.getOrDefault("website", ""),
                        (String) ymlContent.get("main"),
                        (List<String>) ymlContent.getOrDefault("authors", new ArrayList<String>())
                );
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Invalid bot.yml", e);
            }

            // if the class has already loaded, a conflict has been found.
            // so many things can cause the conflict, such as a class with the same binary name, or the Bot author trying to use internal classes (e.g. java.lang.Object)
            if (findLoadedClass(description.getMainClassName()) != null) {
                throw new IllegalArgumentException("The main class defined in bot.yml has already been defined in the VM.");
            }

            addURL(file.toURI().toURL()); // add URL of the Bot archive file so that the classloader can find the Bot main class.
            // No check, because the Exception will be handled by the caller
            Class<? extends Bot> main = loadClass(description.getMainClassName(), true).asSubclass(Bot.class);

            if (main.getDeclaredConstructors().length != 1) {
                throw new IllegalAccessException("Unexpected constructor count, expected 1, got " + main.getDeclaredConstructors().length);
            }

            return construct(main, description, token); // construct the final instance and return it
        }
    }

    /**
     * Construct the Bot instance with given information and return it.
     *
     * @param cls         The Bot main class
     * @param description The description object
     * @param token       The token for the Bot
     * @throws Exception Thrown if something went really wrong
     */
    protected abstract <T extends Bot> T construct(final Class<T> cls, final BotDescription description, final String token) throws Exception;
}
