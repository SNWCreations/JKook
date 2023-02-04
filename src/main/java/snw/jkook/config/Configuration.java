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
 * 配置文件与相关设置的基类。
 */
public interface Configuration extends ConfigurationSection {

    /**
     * 设置指定路径的缺省值。<br>
     * 如果没有默认的 {@link Configuration} 在对应的路径上，
     * 那么将会建立一个新的 {@link MemoryConfiguration} 用于保存。<br>
     * 如果值为 {@code null} ，该值将被从默认的配置源中删除。
     *
     * @param path 路径
     * @param value 缺省值
     * @throws IllegalArgumentException 路径为 {@code null} 时抛出此异常
     */
    @Override
    void addDefault(@NotNull String path, @Nullable Object value);

    /**
     * 将指定 {@link Map} 中的键值都加入到此配置对象的缺省值。<br>
     * 如果没有缺省值 {@link Configuration} 用于存储，那么将会建立一个新的 {@link MemoryConfiguration} 用于保存缺省值。
     * <p>
     * 如果值为 {@code null} ，将会删除该路径上的缺省值.
     *
     * @param defaults 键为路径，值为对应路径的值
     * @throws IllegalArgumentException {@code defaults} 为 {@code null} 时抛出此异常
     */
    void addDefaults(@NotNull Map<String, Object> defaults);

    /**
     * 把指定 {@link Configuration} 中的所有数据全部加入到缺省值对象。<br>
     * 如果没有缺省值 {@link Configuration}, 那么将会建立一个新的 {@link snw.jkook.config.MemoryConfiguration} 用于保存。<br>
     * 你可以使用 {@link #setDefaults(snw.jkook.config.Configuration)} 来设置缺省值对象来源。
     *
     * @param defaults 数据来源
     * @throws IllegalArgumentException 指定的 {@code defaults} 为 {@code null} 或者自己时抛出
     */
    void addDefaults(@NotNull Configuration defaults);

    /**
     * 设置新的缺省值对象。<br>
     * 若此配置对象已有缺省值对象，则将直接替换原有的。
     *
     * @param defaults 将作为新的缺省值对象的 {@link Configuration} 对象
     * @throws IllegalArgumentException 指定的 {@code defaults} 为 {@code null} 或者是本身原有的缺省值对象时抛出
     */
    void setDefaults(@NotNull Configuration defaults);

    /**
     * 获取这个 {@link Configuration} 的缺省值 {@link Configuration} 对象。<br>
     * 如果设置过缺省值，即使没有设置缺省值对象，也会返回 {@link Configuration} 。(原因见 {@link #addDefault(String, Object)})<br>
     * 如果都没有，则返回 null 。
     *
     * @return 缺省值对象，如果没有则返回 {@code null}
     */
    @Nullable Configuration getDefaults();

    /**
     * 获取这个 {@link Configuration} 的 {@link ConfigurationOptions} 设置对象。<br>
     * 如果需要修改配置对象，直接修改返回值就可以了。
     *
     * @return 这个配置文件的一些配置
     * @see ConfigurationOptions
     */
    @NotNull ConfigurationOptions options();
}
