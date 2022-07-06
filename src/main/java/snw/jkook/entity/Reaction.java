package snw.jkook.entity;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.Message;
import snw.jkook.util.RequirePermission;

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

    /**
     * Delete this reaction if possible. (Fails silently.) <p>
     * Need {@link Permission#MESSAGE_MANAGE} <b>unless this reaction has been sent by you</b>.
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
