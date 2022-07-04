package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;
import snw.jkook.event.Event;

import java.util.Objects;

/**
 * Represents an event related to a {@link Channel}.
 */
public abstract class ChannelEvent extends Event {
    private final Channel channel;

    ChannelEvent(final long timeStamp, final Channel channel) {
        super(timeStamp);
        this.channel = Objects.requireNonNull(channel);
    }

    /**
     * Get the channel related to this event.
     */
    public Channel getChannel() {
        return channel;
    }
}
