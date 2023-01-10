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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 表示一个 JKook 插件的描述信息。<br>
 * 这只是为了存储插件的 plugin.yml 中的数据而设计的。
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
     * 获取此插件的名字。
     */
    public String getName() {
        return name;
    }

    /**
     * 获取此插件的版本，
     */
    public String getVersion() {
        return version;
    }

    /**
     * 获取此插件使用的 JKook API 的版本。
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 获取此插件的完整简介。
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取此插件的官方网站的链接。<br>
     * 当 plugin.yml 中未提供时，返回空字符串。
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 获取此插件的作者列表。
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * 获取此插件的主类名称。
     */
    public String getMainClassName() {
        return mainClassName;
    }

    /**
     * 获取此插件的硬依赖列表。<br>
     * 当无法找到此插件的某项硬依赖时，此插件将不会运行。
     */
    public List<String> getDepend() {
        return depend;
    }

    /**
     * 获取此插件的软依赖列表。<br>
     * 当无法找到此插件的某项硬依赖时，仅给出警告，插件仍然会正常地启用。
     */
    public List<String> getSoftDepend() {
        return softDepend;
    }
}
