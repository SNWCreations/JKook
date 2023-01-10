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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * 表示一个插件管理器。
 */
public interface PluginManager {

    /**
     * 检查一个插件是否存储在此管理器中，若有，则返回其实例。<br>
     * 注意: 插件名区分大小写！
     *
     * @param name 插件名称
     * @return 插件实例，找不到时返回 {@code null}
     */
    @Nullable Plugin getPlugin(String name);

    /**
     * 获取此管理器当前储存的所有插件实例。
     *
     * @return 插件实例的数组
     */
    Plugin[] getPlugins();

    /**
     * 检查一个插件是否存储在此管理器中并启用。<br>
     * 注意: 插件名区分大小写！
     *
     * @param name 插件名称
     * @return 当目标插件已被启用时返回 {@code true}
     */
    boolean isPluginEnabled(String name);

    /**
     * 检查一个插件是否已启用。<br>
     * 注意: 插件名区分大小写！
     *
     * @param plugin 插件对象
     * @return 当目标插件已被启用时返回 {@code true}
     */
    boolean isPluginEnabled(Plugin plugin);

    /**
     * 尝试加载一个插件并返回其实例。<br>
     * 注意: 此方法真的仅仅只是<b>加载</b>插件，
     * 不会调用 {@link Plugin#onLoad()}，{@link Plugin#reloadConfig()} 和 {@link Plugin#onEnable()}，
     * 不会将加载后的插件实例传递到 {@link #addPlugin(Plugin)} 以保存其引用。
     *
     * @param file 插件的 {@link File} 对象
     * @return 插件对象
     * @throws InvalidPluginException 当目标文件不是一个有效的插件时抛出
     */
    @NotNull Plugin loadPlugin(File file) throws InvalidPluginException;

    /**
     * 尝试从目标目录中加载插件。
     *
     * @param directory 将用于寻找插件文件的目录
     * @return 由所有成功加载的插件对象组成的数组
     * @see #enablePlugin(Plugin)
     */
    Plugin[] loadPlugins(File directory);

    /**
     * 禁用此管理器中存储的所有插件。
     */
    void disablePlugins();

    /**
     * 禁用并移出此管理器中存储的所有插件。
     */
    void clearPlugins();

    /**
     * 启用指定的插件。<br>
     * 尝试启用一个已经被启用的插件没有任何作用。
     *
     * @param plugin 插件对象
     * @throws UnknownDependencyException 当此插件指定的硬依赖找不到时抛出
     */
    void enablePlugin(Plugin plugin) throws UnknownDependencyException;

    /**
     * 禁用指定的插件。<br>
     * 尝试启用一个已经被禁用的插件没有任何作用。
     *
     * @param plugin 插件对象
     */
    void disablePlugin(Plugin plugin);

    /**
     * 将指定的插件存入此管理器。
     *
     * @param plugin 插件对象
     */
    void addPlugin(Plugin plugin);

    /**
     * 将指定的插件移出此管理器。
     *
     * @param plugin 插件对象
     */
    void removePlugin(Plugin plugin);
}
