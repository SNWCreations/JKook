package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a channel was updated.
 */
public class ChannelInfoUpdateEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    public ChannelInfoUpdateEvent(final long timeStamp, final Channel channel) {
        super(timeStamp, channel);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
