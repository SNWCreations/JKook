package snw.jkook.command;

/**
 * Represents the command manager.
 */
public interface CommandManager {

    /**
     * Register a command.
     *
     * @param command The command to register
     * @throws IllegalArgumentException Thrown if the command with the same root name was registered
     */
    void registerCommand(JKookCommand command) throws IllegalArgumentException;

    /**
     * Execute a command with given command line.
     * The value of "sender" in the method is {@link ConsoleCommandSender}.
     *
     * @param cmdLine The command line, prefix is needed (e.g. <code>/hello</code>)
     * @throws CommandException Thrown if unexpected situation happened during the execution of the command
     * @return True if command found and executed, false otherwise
     * @deprecated Use {@link #executeCommand(CommandSender, String)} instead.
     */
    @Deprecated
    boolean executeCommand(String cmdLine) throws CommandException;

    /**
     * Execute a command with given command line.
     *
     * @param sender The sender of this command
     * @param cmdLine The command line, prefix is needed (e.g. <code>/hello</code>)
     * @throws CommandException Thrown if unexpected situation happened during the execution of the command
     * @return True if command found and executed, false otherwise
     */
    boolean executeCommand(CommandSender sender, String cmdLine) throws CommandException;
}
