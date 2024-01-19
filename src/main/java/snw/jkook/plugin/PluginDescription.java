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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents the description of a Kook Plugin. <p>
 * It is not visible for Kook users. This is just designed for store the data of "plugin.yml" file.
 */
public final class PluginDescription {
    private final String name;
    private final String version;
    private final String apiVersion;
    private final String description;
    private final String website;
    private final String mainClassName;
    private final List<String> authors; // UNMODIFIABLE
    private final List<String> depend;
    private final List<String> softDepend;

    public PluginDescription(String name, String version, String apiVersion, String description, String website, String mainClassName, List<String> authors, List<String> depend, List<String> softDepend) {
        this.name = Objects.requireNonNull(name);
        this.version = Objects.requireNonNull(version);
        this.apiVersion = Objects.requireNonNull(apiVersion);
        this.description = Objects.requireNonNull(description);
        this.website = Objects.requireNonNull(website);
        this.mainClassName = Objects.requireNonNull(mainClassName);
        this.authors = Collections.unmodifiableList(authors);
        this.depend = Collections.unmodifiableList(depend);
        this.softDepend = Collections.unmodifiableList(softDepend);
    }

    /**
     * Get the name of this Plugin.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the version of this Plugin.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Get the API version that the Plugin used.
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Get the full description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the website of this Plugin. <p>
     * Empty string is returned if the description is not provided in the description file.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Get the authors of this Plugin.
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Get the main class name of this Plugin.
     */
    public String getMainClassName() {
        return mainClassName;
    }

    /**
     * Get the dependency plugins of this Plugin.
     */
    public List<String> getDepend() {
        return depend;
    }

    /**
     * Get the soft dependency plugins of this Plugin.
     */
    public List<String> getSoftDepend() {
        return softDepend;
    }
}
