/*
 * Copyright 2022 JKook contributors
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

import snw.jkook.JKook;
import snw.jkook.util.Validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a command in JKook framework.
 */
public final class JKookCommand {
    private final String rootName;
    private CommandExecutor executor;
    private UserCommandExecutor userCommandExecutor;
    private ConsoleCommandExecutor consoleCommandExecutor;
    private final Collection<JKookCommand> subcommands = new ArrayList<>();
    private final Collection<String> aliases = new HashSet<>();
    private final Collection<String> prefixes = new HashSet<>();
    private String description;
    private String helpContent;

    private boolean registerFlag = false; // just a flag!

    /**
     * The constructor with only one prefix.
     *
     * @param rootName The name of this command (e.g. "example")
     * @param prefix   The prefix (default '/', e.g. '.')
     */
    public JKookCommand(String rootName, char prefix) {
        this(rootName, Collections.singletonList(String.valueOf(prefix)));
    }

    /**
     * The constructor with only one prefix.
     *
     * @param rootName The name of this command (e.g. "example")
     * @param prefix   The prefix (default '/', e.g. '.')
     */
    public JKookCommand(String rootName, String prefix) {
        this(rootName, Collections.singletonList(prefix));
    }

    /**
     * The main constructor.
     *
     * @param rootName The name of this command (e.g. "example")
     * @param prefixes   The prefixes (default only add '/', e.g. '.')
     */
    public JKookCommand(String rootName, Collection<String> prefixes) {
        this.rootName = Objects.requireNonNull(rootName);
        this.prefixes.addAll(prefixes);
    }

    /**
     * The constructor with default prefix '/'.
     *
     * @param rootName The name of this command (e.g. "example")
     */
    public JKookCommand(String rootName) {
        this(rootName, '/');
    }

    /**
     * Set the executor of this command.
     *
     * @param executor The executor of this command
     */
    public JKookCommand setExecutor(CommandExecutor executor) {
        ensureNotRegistered();
        this.executor = executor;
        return this;
    }

    /**
     * Set the executor for Kook users of this command.
     *
     * @param userCommandExecutor The executor of this command
     */
    public JKookCommand executesUser(UserCommandExecutor userCommandExecutor) {
        ensureNotRegistered();
        this.userCommandExecutor = userCommandExecutor;
        return this;
    }

    /**
     * Set the executor for console of this command.
     *
     * @param consoleCommandExecutor The executor of this command
     */
    public JKookCommand executesConsole(ConsoleCommandExecutor consoleCommandExecutor) {
        ensureNotRegistered();
        this.consoleCommandExecutor = consoleCommandExecutor;
        return this;
    }

    /**
     * Add a subcommand to this command.
     *
     * @param command The subcommand object
     */
    public JKookCommand addSubcommand(JKookCommand command) {
        ensureNotRegistered();
        Validate.isFalse(this.subcommands.stream().anyMatch(IT -> Objects.equals(IT.getRootName(), command.getRootName())), "A subcommand with the same root name has already registered to this command.");
        this.subcommands.add(command);
        return this;
    }

    /**
     * Set the description of this command.
     *
     * @param description The description to set
     */
    public JKookCommand setDescription(String description) {
        ensureNotRegistered();
        this.description = description;
        return this;
    }

    /**
     * Set the help content of this command. <p>
     * The provided value will show if the user requested the help of this command. <p>
     * For example, I have command called "hi", if user just use "/help" (provided by API implementations),
     *  The description will show. But if user use "/help hi", the help content will be sent to the user.
     * @param helpContent The help message content
     */
    public JKookCommand setHelpContent(String helpContent) {
        ensureNotRegistered();
        this.helpContent = helpContent;
        return this;
    }

    /**
     * Add a prefix to this command.
     * @param prefix The prefix to be added
     */
    public JKookCommand addPrefix(String prefix) {
        ensureNotRegistered();
        prefixes.add(prefix);
        return this;
    }

    /**
     * Add an alias for this command.
     *
     * @param alias The alias to be added
     */
    public JKookCommand addAlias(String alias) {
        ensureNotRegistered();
        aliases.add(alias);
        return this;
    }

    /**
     * Register this command. <p>
     * Also, you can register this command using {@link CommandManager#registerCommand(JKookCommand)}. <p>
     * But this is easier than that. Isn't it?
     */
    public void register() {
        JKook.getCommandManager().registerCommand(this);
        registerFlag = true;
    }

    // Getters is following:

    /**
     * Get the root name of this command.
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * Get the executor of this command.
     */
    public CommandExecutor getExecutor() {
        return executor;
    }

    /**
     * Get the executor for Kook users of this command.
     */
    public UserCommandExecutor getUserCommandExecutor() {
        return userCommandExecutor;
    }

    /**
     * Get the executor for console of this command.
     */
    public ConsoleCommandExecutor getConsoleCommandExecutor() {
        return consoleCommandExecutor;
    }

    /**
     * Get the subcommands of this command.
     */
    public Collection<JKookCommand> getSubcommands() {
        return subcommands;
    }

    /**
     * Get aliases of this command.
     */
    public Collection<String> getAliases() {
        return Collections.unmodifiableCollection(aliases);
    }

    /**
     * Get the description of this command.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the prefixes of this command.
     */
    public Collection<String> getPrefixes() {
        return prefixes;
    }

    /**
     * Get the help message content of this command.
     */
    public String getHelpContent() {
        return helpContent;
    }

    // specific-methods following:

    private void ensureNotRegistered() {
        Validate.isTrue(!registerFlag, "This command has already registered.");
    }
}
