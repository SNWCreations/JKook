package snw.jkook.event.user;

import snw.jkook.entity.Reaction;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;
import snw.jkook.message.Message;

import java.util.Objects;

/**
 * Represents an event related to a user removed a reaction to a message.
 */
public class UserRemoveReactionEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;
    private final Reaction reaction;

    public UserRemoveReactionEvent(final long timeStamp, final User user, final Message message, final Reaction reaction) {
        super(timeStamp, user);
        this.message = Objects.requireNonNull(message);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Get the reaction that the user removed.
     */
    public Reaction getReaction() {
        return reaction;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
