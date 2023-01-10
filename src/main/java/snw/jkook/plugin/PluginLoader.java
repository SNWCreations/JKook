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

import java.io.File;

/**
 * 表示一个插件加载器。
 */
public interface PluginLoader extends MarkedClassLoader {

    /**
     * 尝试加载一个插件并返回其实例。<br>
     * 只需要构造出实例即可，不需要调用诸如 {@link Plugin#onLoad()} 之类的方法。
     *
     * @param file 插件的 JAR 存档文件
     * @return 插件实例
     * @throws InvalidPluginException 当加载器无法加载目标文件时，或目标插件不是一个有效的插件时抛出
     */
    Plugin loadPlugin(final File file) throws InvalidPluginException;
}
