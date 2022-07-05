package snw.jkook.bot;

import java.io.File;

/**
 * Represents a Bot loader.
 */
public interface BotLoader {

    /**
     * Load a Bot (its main class) and return its instance.
     *
     * @param file The Bot data source
     * @return The Bot instance
     * @throws InvalidBotException Thrown if an error occurred while the loader attempting to load the Bot
     */
    Bot loadBot(final File file, final String token) throws InvalidBotException;
}
