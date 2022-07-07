package snw.jkook.command;

/**
 * Represents the command manager.
 */
public interface CommandManager {

    /**
     * Register a command.
     *
     * @param command The command to register
     */
    void registerCommand(JKookCommand command);

    /**
     * Execute a command with given command line.
     * @param cmdLine The command line, prefix is needed (e.g. <code>/hello</code>)
     * @throws CommandException Thrown if unexpected situation happened during the execution of the command
     * @return True if command found and executed, false otherwise
     */
    boolean executeCommand(String cmdLine) throws CommandException;
}
