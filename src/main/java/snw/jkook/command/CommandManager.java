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

package snw.jkook.command;

import snw.jkook.message.Message;
import snw.jkook.plugin.Plugin;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Represents the command manager.
 */
public interface CommandManager {

    /**
     * Register a command.
     *
     * @param plugin The plugin as the command owner
     * @param command The command to register
     * @throws IllegalArgumentException Thrown if the command with the same root name was registered,
     *                                  or the argument inside the command is not supported.
     */
    void registerCommand(Plugin plugin, JKookCommand command) throws IllegalArgumentException;

    /**
     * Register a command.
     *
     * @param plugin The plugin as the command owner
     * @param command The supplier that provides the real command.
     * @throws NullPointerException     Thrown if the supplier returned null.
     * @throws IllegalArgumentException Thrown if the command with the same root name was registered,
     *                                  or the argument inside the command is not supported.
     */
    void registerCommand(Plugin plugin, Supplier<JKookCommand> command) throws NullPointerException, IllegalArgumentException;

    /**
     * Execute a command with given command line.
     *
     * @param sender  The sender of this command
     * @param cmdLine The command line, prefix is needed (e.g. <code>/hello</code>)
     * @return True if command found and executed, false otherwise
     * @throws CommandException Thrown if unexpected situation happened during the execution of the command
     */
    boolean executeCommand(CommandSender sender, String cmdLine) throws CommandException;

    /**
     * Execute a command with given command line.
     *
     * @param sender  The sender of this command
     * @param cmdLine The command line, prefix is needed (e.g. <code>/hello</code>)
     * @param message The message object as the cause of this command execution
     * @return True if command found and executed, false otherwise
     * @throws CommandException Thrown if unexpected situation happened during the execution of the command
     */
    boolean executeCommand(CommandSender sender, String cmdLine, Message message) throws CommandException;

    /**
     * Register the binding between the specified class and the parser.
     * <p>
     * The requirements of the valid argument parser are following:
     * <ul>
     *     <li>Don't throw exception if possible, or the command execution will be failed.</li>
     *     <li>Return {@code null} instead of throwing exceptions if the parser can't understand the source string.</li>
     * </ul>
     *
     * @param clazz  The runtime class of argument
     * @param parser The parser function
     * @param <T>    The argument type
     * @throws IllegalStateException Thrown if the specified class has already bound to a parser.
     */
    <T> void registerArgumentParser(Class<T> clazz, Function<String, T> parser) throws IllegalStateException;
}
