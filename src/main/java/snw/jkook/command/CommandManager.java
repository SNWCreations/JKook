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

package snw.jkook.command;

import snw.jkook.plugin.Plugin;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 表示命令管理器。
 */
public interface CommandManager {

    /**
     * 注册命令。
     *
     * @param plugin  插件作为命令的所有者
     * @param command 命令对象
     * @throws IllegalArgumentException 当发现与将注册的命令对象重名的命令时，或此命令指定的参数类型
     *                                  不受支持时抛出
     */
    void registerCommand(Plugin plugin, JKookCommand command) throws IllegalArgumentException;

    /**
     * 注册命令。
     *
     * @param plugin  插件作为命令的所有者
     * @param command 将提供命令对象的 {@link Supplier}
     * @throws NullPointerException     当给定的 {@link Supplier} 为 null 或返回了 null 时抛出
     * @throws IllegalArgumentException 当发现与将注册的命令对象重名的命令时，或此命令指定的参数类型
     *                                  不受支持时抛出
     */
    void registerCommand(Plugin plugin, Supplier<JKookCommand> command) throws NullPointerException, IllegalArgumentException;

    /**
     * 使用给定的执行者与命令行执行命令。
     *
     * @param sender  命令的执行者
     * @param cmdLine 带有命令前缀的命令行（比如 <code>/hello</code>）
     * @return 找到命令并执行后返回 {@code true}
     * @throws CommandException 执行命令却遇到了异常时抛出
     */
    boolean executeCommand(CommandSender sender, String cmdLine) throws CommandException;

    /**
     * 注册一个参数解析器。<br>
     * 以下为对参数解析器的要求：<br>
     * <ul>
     *     <li>尽可能不要抛出异常。</li>
     *     <li>当解析器无法理解传入的 {@link String} 时，返回 {@code null} 而不是抛出异常。</li>
     * </ul>
     *
     * @param clazz  参数类型的 {@link Class} 对象
     * @param parser 解析器对象
     * @param <T>    参数类型
     * @throws IllegalStateException 当给定的参数类型已有解析器时抛出
     */
    <T> void registerArgumentParser(Class<T> clazz, Function<String, T> parser) throws IllegalStateException;
}
