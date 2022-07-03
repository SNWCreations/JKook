package snw.jkook.command;

import snw.jkook.JKook;

import java.util.ArrayList;
import java.util.Collection;
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

    private boolean registerFlag = false;

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
        this.executor = executor;
        return this;
    }

    /**
     * Add a subcommand to this command.
     *
     * @param command The subcommand object
     */
    public JKookCommand addSubcommand(JKookCommand command) {
        this.subcommands.add(command);
        return this;
    }

    /**
     * Register this command. <p>
     * Also, you can register this command using {@link snw.jkook.Core#registerCommand(JKookCommand)}. <p>
     * But this is more easier than that. Isn't it?
     */
    public void register() {
        if (registerFlag) {
            throw new IllegalStateException("This command has already registered.");
        }
        JKook.getCore().registerCommand(this);
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
        return aliases;
    }

}
