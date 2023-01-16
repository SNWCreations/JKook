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
import snw.jkook.util.Validate;

import java.util.*;

/**
 * 表示 JKook 框架中的命令。
 */
public final class JKookCommand {
    private final String rootName;
    private CommandExecutor executor;
    private UserCommandExecutor userCommandExecutor;
    private ConsoleCommandExecutor consoleCommandExecutor;
    private final Collection<JKookCommand> subcommands = new ArrayList<>();
    private final Collection<String> aliases = new HashSet<>();
    private final Collection<String> prefixes = new HashSet<>();
    private final Collection<Class<?>> arguments = new ArrayList<>();
    private final OptionalArgumentContainer optionalArguments = new OptionalArgumentContainer();
    private String description;
    private String helpContent;

    private boolean registerFlag = false; // just a flag!

    /**
     * 只向命令提供一个前缀的构造器。
     *
     * @param rootName 命令名称（比如 "example"）
     * @param prefix   命令前缀的 {@code char} 对象（比如 '.'）
     */
    public JKookCommand(String rootName, char prefix) {
        this(rootName, Collections.singletonList(String.valueOf(prefix)));
    }

    /**
     * 只向命令提供一个前缀的构造器。
     *
     * @param rootName 命令名称（比如 "example"）
     * @param prefix   命令前缀的 {@link String} 对象（比如 '.'）
     */
    public JKookCommand(String rootName, String prefix) {
        this(rootName, Collections.singletonList(prefix));
    }

    /**
     * 主构造方法。
     *
     * @param rootName 命令名称（比如 "example"）
     * @param prefixes 别称的列表
     */
    public JKookCommand(String rootName, Collection<String> prefixes) {
        Validate.notNull(rootName);
        Validate.notNull(prefixes);
        Validate.isFalse(prefixes.isEmpty(), "You must provide at least one prefix.");
        Validate.isFalse(rootName.contains(" "), "Space characters are not allowed in the root name of a command.");
        Validate.isFalse(prefixes.stream().anyMatch(IT -> IT.contains(" ")), "Space characters are not allowed in the prefix of a command.");
        this.rootName = rootName;
        prefixes.forEach(this::addPrefix);
    }

    /**
     * 使用默认前缀 "/" 的构造器。
     *
     * @param rootName 命令名称（比如 "example"）
     */
    public JKookCommand(String rootName) {
        this(rootName, '/');
    }

    /**
     * 设置此命令的执行器。<br>
     * 实际上我们不再推荐 {@link CommandExecutor}，因为杂糅控制台和用户的命令对开发者很不友好。
     *
     * @param executor 执行器对象
     */
    public JKookCommand setExecutor(CommandExecutor executor) {
        ensureNotRegistered();
        this.executor = executor;
        return this;
    }

    /**
     * 设置此命令的为 KOOK 用户服务的命令执行器。
     *
     * @param userCommandExecutor 执行器对象
     */
    public JKookCommand executesUser(UserCommandExecutor userCommandExecutor) {
        ensureNotRegistered();
        this.userCommandExecutor = userCommandExecutor;
        return this;
    }

    /**
     * 设置此命令的为控制台用户服务的命令执行器。
     *
     * @param consoleCommandExecutor 执行器对象
     */
    public JKookCommand executesConsole(ConsoleCommandExecutor consoleCommandExecutor) {
        ensureNotRegistered();
        this.consoleCommandExecutor = consoleCommandExecutor;
        return this;
    }

    /**
     * 向此命令添加子命令。
     *
     * @param command 子命令对象
     */
    public JKookCommand addSubcommand(JKookCommand command) {
        ensureNotRegistered();
        Validate.isFalse(this.subcommands.stream().anyMatch(IT -> Objects.equals(IT.getRootName(), command.getRootName())), "A subcommand with the same root name has already registered to this command.");
        this.subcommands.add(command);
        return this;
    }

    /**
     * 设置此命令的简介。<br>
     * 简介应该尽可能简短，可以写诸如介绍此命令的作用的内容。<br>
     * 若需要具体讲解命令的使用方法，建议写进帮助信息，见 {@link #setHelpContent(String)} 方法。
     *
     * @param description 命令简介内容
     */
    public JKookCommand setDescription(String description) {
        ensureNotRegistered();
        this.description = description;
        return this;
    }

    /**
     * 设置此命令的帮助信息。<br>
     * 举个例子，我有一个名称是 "hi" 的命令，如果用户使用了 /help 而未刻意指定此命令的名称，则 /help 命令应该将简介展示给用户。<br>
     * 若用户使用 "/help hi"（指定了此命令的名称），则帮助信息将被提供给用户。<br>
     * （注：此处的 /help 命令只是假想的，即使有，它应该由 JKook API 的实现提供）
     *
     * @param helpContent 帮助信息内容
     */
    public JKookCommand setHelpContent(String helpContent) {
        ensureNotRegistered();
        this.helpContent = helpContent;
        return this;
    }

    /**
     * 向此命令添加一个前缀。
     *
     * @param prefix 前缀
     */
    public JKookCommand addPrefix(String prefix) {
        ensureNotRegistered();
        Validate.isFalse(prefix.contains(" "), "Space characters are not allowed in the prefix of a command.");
        prefixes.add(prefix);
        return this;
    }

    /**
     * 向此命令添加一个别称。
     *
     * @param alias 别称
     */
    public JKookCommand addAlias(String alias) {
        ensureNotRegistered();
        Validate.isFalse(alias.contains(" "), "Space characters are not allowed in the alias of a command.");
        aliases.add(alias);
        return this;
    }

    /**
     * 向此命令添加一个必选参数。
     *
     * @param clazz 参数类型的 {@link Class} 对象
     */
    public JKookCommand addArgument(Class<?> clazz) {
        ensureNotRegistered();
        Validate.isFalse(clazz == Object.class, "Object.class is not allowed to be an argument.");
        Validate.isTrue(optionalArguments.isEmpty(), "You cannot add more arguments after optional arguments got added.");
        arguments.add(clazz);
        return this;
    }

    /**
     * 向此命令添加一个可选参数。<br>
     * 提供的默认值将在命令被执行时却没有为参数提供值时使用。
     *
     * @param clazz        参数类型的 {@link Class} 对象
     * @param defaultValue 默认值
     * @param <T>          参数类型
     */
    public <T> JKookCommand addOptionalArgument(Class<T> clazz, T defaultValue) {
        ensureNotRegistered();
        Validate.notNull(defaultValue);
        optionalArguments.add(clazz, defaultValue);
        return this;
    }

    /**
     * 注册命令。<br>
     * 这等同于 {@link CommandManager#registerCommand(Plugin, JKookCommand)}。
     */
    public void register(Plugin plugin) {
        plugin.getCore().getCommandManager().registerCommand(plugin, this);
        registerFlag = true;
    }

    // Getters are following:

    /**
     * 获取命令的名称。
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * 获取命令的执行器。
     */
    public CommandExecutor getExecutor() {
        return executor;
    }

    /**
     * 获取此命令的为 KOOK 用户服务的命令执行器。
     */
    public UserCommandExecutor getUserCommandExecutor() {
        return userCommandExecutor;
    }

    /**
     * 获取此命令的为控制台用户服务的命令执行器。
     */
    public ConsoleCommandExecutor getConsoleCommandExecutor() {
        return consoleCommandExecutor;
    }

    /**
     * 获取此命令的所有子命令。
     */
    public Collection<JKookCommand> getSubcommands() {
        return Collections.unmodifiableCollection(subcommands);
    }

    /**
     * 获取此命令的所有别称。
     */
    public Collection<String> getAliases() {
        return Collections.unmodifiableCollection(aliases);
    }

    /**
     * 获取此命令的简介。
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取此命令的所有前缀。
     */
    public Collection<String> getPrefixes() {
        return prefixes;
    }

    /**
     * 获取此命令的帮助信息，
     */
    public String getHelpContent() {
        return helpContent;
    }

    /**
     * 获取此命令的所有必选参数。
     */
    public Collection<Class<?>> getArguments() {
        return Collections.unmodifiableCollection(arguments);
    }

    /**
     * 获取此命令的可选参数容器。
     *
     * @see OptionalArgumentContainer
     */
    public OptionalArgumentContainer getOptionalArguments() {
        return optionalArguments;
    }

    // specific-methods following:

    private void ensureNotRegistered() {
        Validate.isTrue(!registerFlag, "This command has already registered.");
    }
}
