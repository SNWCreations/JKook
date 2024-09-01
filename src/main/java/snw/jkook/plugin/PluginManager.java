/*
 * Copyright 2022 - 2024 JKook contributors
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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.permissions.Permission;

import java.io.File;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Represents the plugin manager. Handles the management of the plugins.
 */
public interface PluginManager {

    /**
     * Checks if the given plugin is loaded and returns it.
     * <p>
     * Tips: Name of the plugin is case-sensitive!
     *
     * @param name Name of the plugin to check
     * @return Plugin if it exists, otherwise null
     */
    @Nullable Plugin getPlugin(String name);

    /**
     * Gets a list of all currently loaded plugins.
     *
     * @return Array of Plugins
     */
    Plugin[] getPlugins();

    /**
     * Checks if the given plugin is enabled or not.
     * <p>
     * Tips: Name of the plugin is case-sensitive.
     *
     * @param name Name of the plugin to check
     * @return true if the plugin is enabled, otherwise false
     */
    boolean isPluginEnabled(String name);

    /**
     * Checks if the given plugin is enabled or not.
     *
     * @param plugin Plugin to check
     * @return true if the plugin is enabled, otherwise false
     */
    boolean isPluginEnabled(Plugin plugin);

    /**
     * Loads the plugin in the specified file.
     * <p>
     * Tips: this method just <b>load</b> the plugin,
     * won't call {@link Plugin#onLoad()}, {@link Plugin#reloadConfig()} and {@link Plugin#onEnable()}, won't save the reference of the loaded plugin.
     *
     * @param file The file that represents a plugin
     * @return The loaded plugin
     * @throws InvalidPluginException Thrown when the specified file is not a valid plugin
     */
    @NotNull Plugin loadPlugin(File file) throws InvalidPluginException;

    /**
     * Loads the plugins contained within the specified directory.
     *
     * @param directory Directory to check for plugins
     * @return A list of all plugins loaded
     * @see #enablePlugin(Plugin)
     */
    Plugin[] loadPlugins(File directory);

    /**
     * Disables all the loaded plugins that stored in this manager.
     */
    void disablePlugins();

    /**
     * Disables and removes all plugins that stored in this manager.
     */
    void clearPlugins();

    /**
     * Enables the specified plugin.
     * <p>
     * Attempting to enable a plugin that is already enabled will have no effect.
     *
     * @param plugin Plugin to enable
     * @throws UnknownDependencyException Thrown if this plugin has an unknown dependency.
     */
    void enablePlugin(Plugin plugin) throws UnknownDependencyException;

    /**
     * Disables the specified plugin.
     * <p>
     * Attempting to disable a plugin that is not enabled will have no effect.
     *
     * @param plugin Plugin to disable
     */
    void disablePlugin(Plugin plugin);

    /**
     * Add the plugin reference to this manager. This should fail silently.
     *
     * @param plugin The plugin reference
     */
    void addPlugin(Plugin plugin);

    /**
     * Remove the plugin reference from this manager. This should fail silently.
     *
     * @param plugin The plugin reference
     */
    void removePlugin(Plugin plugin);

    /**
     * Register plugin loader for loading plugins which are not recognised by default plugin loader
     *
     * @param condition Condition to check whether the file is loadable by the provided loader type
     * @param provider  PluginLoader provider, requires a ClassLoader as its parent (maybe needed)
     */
    void registerPluginLoader(Predicate<File> condition, Function<ClassLoader, PluginLoader> provider);

    /**
     * Register the plugin description resolver for resolving plugin descriptions.
     *
     * @param condition        Condition to check whether the file is acceptable by the provided resolver type.
     *                         If you're going to register new plugin loader type, the resolver implementation
     *                         type you've provided must be same as the return value of your
     *                         {@link PluginLoader#getPluginDescriptionResolver()} method.
     * @param resolverSupplier The supplier of {@link PluginDescriptionResolver}
     */
    void registerPluginDescriptionResolver(Predicate<File> condition, Supplier<PluginDescriptionResolver> resolverSupplier);
}
