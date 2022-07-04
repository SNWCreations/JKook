package snw.jkook.event.channel;

import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.Message;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event that a user sends a message in a text channel.
 */
public class ChannelMessageEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;

    public ChannelMessageEvent(final long timeStamp, final TextChannel channel, final Message message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    @Override
    public TextChannel getChannel() {
        return (TextChannel) super.getChannel();
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
