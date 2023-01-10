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

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import snw.jkook.Core;
import snw.jkook.JKook;
import snw.jkook.config.file.FileConfiguration;

import java.io.File;
import java.io.InputStream;

/**
 * 表示一个插件。 <br>
 * 您可以继承 {@link BasePlugin} 作为您的插件主类。
 */
public interface Plugin {

    // NOTE:
    // If you want to implement this interface, I suggest you to use BasePlugin instead.
    // Still want to implement this? Alright, you won.
    // But I have something to tell you.
    // You should provide the things that BasePlugin#init requires.
    // Warning is here, if you don't do that and your implementation does not work, don't say anything!

    /**
     * 获取属于此插件的日志记录器。<br>
     * 此方法返回的结果不同于 {@link Core#getLogger()} ，每个插件对象对于此方法都会返回不同的结果。
     */
    Logger getLogger();

    /**
     * 设置插件是否已被启用。
     *
     * @param enabled 插件是否被启用
     */
    void setEnabled(boolean enabled);

    /**
     * 当插件已被启用时，返回 {@code true} 。
     */
    boolean isEnabled();

    /**
     * 当此插件正在被加载时，此方法将被调用。<br>
     * 你可以在这个方法的实现中做一些诸如调用 {@link #saveDefaultConfig()} 以保存默认配置文件之类的事情。<br>
     * 此时，{@link #getConfig()} 是不可用的，因为配置数据还未加载。
     */
    void onLoad();

    /**
     * 当此插件正在被启用时，此方法将被调用。<br>
     * 你可以在这个方法的实现中做一些诸如注册命令之类的事情。
     */
    void onEnable();

    /**
     * 当此插件正在被启用时，此方法将被调用。<br>
     * 你可以在这个方法的实现中做一些诸如关闭你的服务之类的事情。<br>
     * 此时，此插件的命令与事件监听器已经被注销。
     */
    void onDisable();

    /**
     * 获取此插件的默认配置对象。（此方法返回的对象从此插件数据文件夹中的 config.yml 读取数据）<br>
     * 当此插件的配置文件不存在或无效时，此方法返回的对象内没有数据。
     */
    FileConfiguration getConfig();

    /**
     * 不保存 {@link #getConfig()} 方法返回的配置对象中的所有更改，直接从本地磁盘重新读取。<br>
     * 此方法应该静默地失败。
     */
    void reloadConfig();

    /**
     * 尝试从此插件本身的 JAR 存档中解压 config.yml 到此插件的数据文件夹。<br>
     * 此方法应该静默地失败。
     */
    void saveDefaultConfig();

    /**
     * 尝试将 {@link #getConfig()} 方法返回的配置对象中的数据保存到本地。<br>
     * 此方法应该静默地失败。
     */
    void saveConfig();

    /**
     * 尝试从此插件本身的 JAR 存档中解压一个指定的资源到此插件的数据文件夹。
     *
     * @param path                资源相对于 JAR 存档根的路径（比如 "lang/en_US.json"）
     * @param replace             当在数据文件夹中发现重名文件时，是否覆盖
     * @param ignorePathStructure 是否忽略资源原有的目录结构
     * @throws IllegalArgumentException 当此插件本身的 JAR 存档中没有目标资源时，或路径不合法时抛出
     */
    void saveResource(String path, boolean replace, boolean ignorePathStructure) throws IllegalArgumentException;

    /**
     * 从插件本身的 JAR 存档中获取指定的资源的 {@link InputStream} 。
     *
     * @param path  资源相对于 JAR 存档根的路径（比如 "lang/en_US.json"）
     * @return 目标资源的 {@link InputStream} ，当目标资源未找到时返回 {@code null} 。
     * @throws IllegalArgumentException 当 {@code path} 为 {@code null} 时抛出
     */
    @Nullable
    InputStream getResource(String path) throws IllegalArgumentException;

    /**
     * 返回此插件的数据文件夹的 {@link File} 对象。<br>
     * 返回的文件夹应该始终存在。
     */
    File getDataFolder();

    /**
     * 获取此插件本身的 JAR 存档的 {@link File} 对象。
     */
    File getFile();

    /**
     * 获取此插件的描述信息对象。
     */
    PluginDescription getDescription();

    /**
     * 获取加载了此插件的 {@link Core} 对象。<p>
     * 若 JKook API 的实现有多个实例存在于同一个 JVM 中，此方法将比 {@link JKook#getCore()} 更安全。
     */
    Core getCore();
}
