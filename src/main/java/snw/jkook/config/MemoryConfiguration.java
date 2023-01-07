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

package snw.jkook.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This is a {@link Configuration} implementation that does not save or load
 * from any source, and stores all values in memory only.
 * This is useful for temporary Configurations for providing defaults.
 */
public class MemoryConfiguration extends MemorySection implements Configuration {
    protected Configuration defaults;
    protected MemoryConfigurationOptions options;

    /**
     * Creates an empty {@link MemoryConfiguration} with no default values.
     */
    public MemoryConfiguration() {
    }

    /**
     * Creates an empty {@link MemoryConfiguration} using the specified {@link
     * Configuration} as a source for all default values.
     *
     * @param defaults Default value provider
     * @throws IllegalArgumentException Thrown if defaults is null
     */
    public MemoryConfiguration(@Nullable Configuration defaults) {
        this.defaults = defaults;
    }

    @Override
    public void addDefault(@NotNull String path, @Nullable Object value) {

        if (defaults == null) {
            defaults = new MemoryConfiguration();
        }

        defaults.set(path, value);
    }

    @Override
    public void addDefaults(@NotNull Map<String, Object> defaults) {
        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            addDefault(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void addDefaults(@NotNull Configuration defaults) {
        for (String key : defaults.getKeys(true)) {
            if (!defaults.isConfigurationSection(key)) {
                addDefault(key, defaults.get(key));
            }
        }
    }

    @Override
    public void setDefaults(@NotNull Configuration defaults) {
        this.defaults = defaults;
    }

    @Override
    @Nullable
    public Configuration getDefaults() {
        return defaults;
    }

    @Nullable
    @Override
    public ConfigurationSection getParent() {
        return null;
    }

    @Override
    @NotNull
    public MemoryConfigurationOptions options() {
        if (options == null) {
            options = new MemoryConfigurationOptions(this);
        }

        return options;
    }
}
