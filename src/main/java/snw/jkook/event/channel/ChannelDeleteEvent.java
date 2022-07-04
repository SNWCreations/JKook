package snw.jkook.event.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to an operator deleted a channel.
 */
public class ChannelDeleteEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User operator;

    public ChannelDeleteEvent(final long timeStamp, final Channel channel, final User operator) {
        super(timeStamp, channel);
        this.operator = Objects.requireNonNull(operator);
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
