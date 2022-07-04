package snw.jkook.event.user;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;
import snw.jkook.message.Message;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a user added a reaction to a message.
 */
public class UserRemoveReactionEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;
    private final CustomEmoji emoji;

    public UserRemoveReactionEvent(final long timeStamp, final User user, final Message message, final CustomEmoji emoji) {
        super(timeStamp, user);
        this.message = Objects.requireNonNull(message);
        this.emoji = Objects.requireNonNull(emoji);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Get the emoji that the user added.
     */
    public CustomEmoji getEmoji() {
        return emoji;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
