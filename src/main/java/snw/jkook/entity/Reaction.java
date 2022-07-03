package snw.jkook.entity;

import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.Message;

/**
 * Represents a reaction.
 */
public interface Reaction extends Receivable {

    /**
     * Get the message that holds this reaction.
     */
    Message getMessage();

    /**
     * Get the emoji used by this reaction.
     */
    CustomEmoji getEmoji();
}
