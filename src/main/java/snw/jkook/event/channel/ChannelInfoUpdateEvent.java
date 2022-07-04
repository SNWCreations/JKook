package snw.jkook.event.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a channel was updated.
 */
public class ChannelInfoUpdateEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    public ChannelInfoUpdateEvent(final Channel channel) {
        super(channel);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
