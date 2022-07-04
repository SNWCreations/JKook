package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;
import snw.jkook.message.Message;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a message was pinned.
 */
public class ChannelMessagePinEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;

    public ChannelMessagePinEvent(final long timeStamp, final Channel channel, final Message message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
