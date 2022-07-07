package snw.jkook;

import org.slf4j.Logger;
import snw.jkook.bot.Bot;
import snw.jkook.command.CommandManager;
import snw.jkook.command.ConsoleCommandSender;
import snw.jkook.command.JKookCommand;
import snw.jkook.event.EventManager;
import snw.jkook.scheduler.Scheduler;

/**
 * Represents the JKook core implementation.
 */
public interface Core {

    /**
     * Get the JKook API version.
     */
    String getAPIVersion();

    /**
     * Get the JKook implementation brand.
     */
    String getImplementationName();

    /**
     * Get the version of the JKook implementation.
     */
    String getImplementationVersion();

    /**
     * Get the scheduler.
     *
     * @see Scheduler
     */
    Scheduler getScheduler();

    /**
     * Get the event manager.
     *
     * @see EventManager
     */
    EventManager getEventManager();

    /**
     * Get the root logger. Provided by JKook API implementation. <p>
     * <b>But it's recommended to use {@link Bot#getLogger()} instead.</b>
     */
    Logger getLogger();

    /**
     * Get the console command sender.
     */
    ConsoleCommandSender getConsoleCommandSender();

    /**
     * Get the command manager.
     */
    CommandManager getCommandManager();

    /**
     * Register a command.
     *
     * @param command The command to register
     * @deprecated Use {@link CommandManager#registerCommand(JKookCommand)} instead.
     */
    @Deprecated
    void registerCommand(JKookCommand command);

    /**
     * Shutdown the client. Stops everything.
     */
    void shutdown();
}
