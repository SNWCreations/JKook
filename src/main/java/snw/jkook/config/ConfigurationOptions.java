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

/**
 * {@link Configuration} 的设置类。<br>
 * 它有一部分基于建造者模式设计。
 */
public class ConfigurationOptions {
    private char pathSeparator = '.';
    private boolean copyDefaults = false;
    private final Configuration configuration;

    protected ConfigurationOptions(@NotNull Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 返回关联这个配置的 {@link Configuration} 。
     *
     * @return 关联的配置对象
     */
    @NotNull
    public Configuration configuration() {
        return configuration;
    }

    /**
     * 获取用于分离 {@link ConfigurationSection} 中路径的 char 对象。<br>
     * 这并不会影响数据的储存，它只是路径的分隔符。<br>
     * 这只会影响你在程序中怎样读取数据。<br>
     * 举个例子:<br>
     * 你有一个配置对象，但是它的 {@code pathSeparator} 是 "," ，那么像 "snw.name" 这种键就不是指 "snw" 项下的 "name" 项了，
     * 这时获取原 "snw.name" 的数据就要用 "snw,name" 作为键。<br>
     * 这与 Microsoft Windows 使用 "\" 作为路径分隔符，而 GNU/Linux 使用 "/" 是一个道理。
     *
     * @return 路径分割符
     */
    public char pathSeparator() {
        return pathSeparator;
    }

    /**
     * 设置用于分离 {@link ConfigurationSection} 中路径的 char 对象。<br>
     * 关于这个 {@code char} 对象的解释见 {@link #pathSeparator()} 方法。
     *
     * @param value 路径分割符
     */
    @NotNull
    public ConfigurationOptions pathSeparator(char value) {
        this.pathSeparator = value;
        return this;
    }

    /**
     * 检查与这个设置对象关联的 {@link Configuration} 的值是否直接从缺省值 {@link Configuration} 复制。<br>
     * 如果为 {@code true} ，则关联的 {@link Configuration} 中的值都是从缺省值 {@link Configuration} 中复制的。<br>
     * 在这时，这个列表将被锁定. 并始终返回缺省值对象中的值. 可以看作是只读的缺省值对象。<br>
     * 默认为 {@code false} 。
     *
     * @return 与这个设置对象关联的 {@link Configuration} 的值是否直接从缺省值 {@link Configuration} 复制
     */
    public boolean copyDefaults() {
        return copyDefaults;
    }

    /**
     * 设置与这个设置对象关联的 {@link Configuration} 的值是否直接从缺省值 {@link Configuration} 复制。
     *
     * @param value 与这个设置对象关联的 {@link Configuration} 的值是否直接从缺省值 {@link Configuration} 复制
     * @see #copyDefaults()
     */
    @NotNull
    public ConfigurationOptions copyDefaults(boolean value) {
        this.copyDefaults = value;
        return this;
    }
}
