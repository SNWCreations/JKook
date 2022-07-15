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

import org.apache.commons.lang.Validate;
import snw.jkook.JKook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Represents a command in JKook framework.
 */
public final class JKookCommand {
    private final String rootName;
    private final char prefix;
    private CommandExecutor executor;
    private final Collection<JKookCommand> subcommands = new ArrayList<>();
    private final Collection<String> aliases = new ArrayList<>();
    private String description;

    private boolean registerFlag = false; // just a flag!

    /**
     * The main constructor.
     *
     * @param rootName The name of this command (e.g. "example")
     * @param prefix   The prefix (default '/', e.g. '.')
     */
    public JKookCommand(String rootName, char prefix) {
        this.rootName = Objects.requireNonNull(rootName);
        this.prefix = prefix;
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
     * Add a subcommand to this command.
     *
     * @param command The subcommand object
     */
    public JKookCommand addSubcommand(JKookCommand command) {
        ensureNotRegistered();
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
     * Get the prefix of this command.
     */
    public char getPrefix() {
        return prefix;
    }

    /**
     * Get the executor of this command.
     */
    public CommandExecutor getExecutor() {
        return executor;
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

    // specific-methods following:

    private void ensureNotRegistered() {
        Validate.isTrue(!registerFlag, "This command has already registered.");
    }
}
