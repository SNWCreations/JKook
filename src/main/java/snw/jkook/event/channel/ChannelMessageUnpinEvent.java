package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;
import snw.jkook.message.Message;

import java.util.Objects;

/**
 * Represents an event related to a message was unpinned.
 */
public class ChannelMessageUnpinEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;

    public ChannelMessageUnpinEvent(final long timeStamp, final Channel channel, final Message message) {
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
