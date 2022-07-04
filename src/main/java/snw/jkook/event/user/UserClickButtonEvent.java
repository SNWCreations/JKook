package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents the event related to a user clicked a button in a message.
 */
public class UserClickButtonEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final String messageId;
    private final String value;

    public UserClickButtonEvent(final long timeStamp, final User user, final String messageId, final String value) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.value = Objects.requireNonNull(value);
    }

    /**
     * Get the message related to the button.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Get the returned value.
     */
    public String getValue() {
        return value;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
