package snw.jkook.event.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a user modified a message.
 */
public class ChannelMessageUpdateEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User operator;
    private final TextChannelMessage message;

    public ChannelMessageUpdateEvent(final long timeStamp, final Channel channel, final User operator, final TextChannelMessage message) {
        super(timeStamp, channel);
        this.operator = operator;
        this.message = message;
    }

    /**
     * Get the message related to this event.
     */
    public TextChannelMessage getMessage() {
        return message;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
