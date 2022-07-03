package snw.jkook.event.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a channel was updated.
 */
public class ChannelInfoUpdateEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User operator;

    public ChannelInfoUpdateEvent(final Channel channel, final User operator) {
        super(channel);
        this.operator = operator;
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
