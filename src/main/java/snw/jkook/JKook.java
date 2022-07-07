package snw.jkook;

import org.slf4j.Logger;
import snw.jkook.bot.Bot;
import snw.jkook.command.CommandManager;
import snw.jkook.command.ConsoleCommandSender;
import snw.jkook.event.EventManager;
import snw.jkook.scheduler.Scheduler;

import java.util.Objects;


/**
 * Represents the JKook core. Handles the singleton call.
 */
public final class JKook {

    /* This class should not be constructed. */
    private JKook() {
    }

    private static Core core = null;

    public static Core getCore() {
        return core;
    }

    /* This method should be called only once. */
    /* Only JKook API implementations can access this method. */
    public static void setCore(Core core) {
        Objects.requireNonNull(core);
        if (JKook.core != null) {
            throw new IllegalStateException("The core implementation has already registered.");
        }
        JKook.core = core;
    }


    /**
     * Get the JKook API version.
     */
    public static String getAPIVersion() {
        return getCore().getAPIVersion();
    }

    /**
     * Get the JKook implementation brand.
     */
    public static String getImplementationName() {
        return getCore().getImplementationName();
    }

    /**
     * Get the version of the JKook implementation.
     */
    public static String getImplementationVersion() {
        return getCore().getImplementationVersion();
    }

    /**
     * Get the scheduler.
     *
     * @see Scheduler
     */
    public static Scheduler getScheduler() {
        return getCore().getScheduler();
    }

    /**
     * Get the event manager.
     *
     * @see EventManager
     */
    public static EventManager getEventManager() {
        return getCore().getEventManager();
    }

    /**
     * Get the root logger. Provided by JKook API implementation. <p>
     * <b>But it's recommended to use {@link Bot#getLogger()} instead.</b>
     */
    public static Logger getLogger() {
        return getCore().getLogger();
    }

    /**
     * Get the command manager.
     */
    public static CommandManager getCommandManager() {
        return core.getCommandManager();
    }

    /**
     * Get the console command sender.
     */
    public static ConsoleCommandSender getConsoleCommandSender() {
        return core.getConsoleCommandSender();
    }
}
