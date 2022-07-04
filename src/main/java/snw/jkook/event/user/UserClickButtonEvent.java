package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

/**
 * Represents the event related to a user clicked a button in a message.
 */
public class UserClickButtonEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final String messageId;
    private final String value;

    public UserClickButtonEvent(final long timeStamp, final User user, final String messageId, final String value) {
        super(timeStamp, user);
        this.messageId = messageId;
        this.value = value;
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
