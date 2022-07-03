package snw.jkook.command;

/**
 * Represents a executor for a command.
 *
 * @see JKookCommand
 */
public interface CommandExecutor {

    /**
     * Execute this command with given information.
     *
     * @param sender    The sender
     * @param arguments The arguments
     */
    void onCommand(CommandSender sender, String[] arguments);
}
