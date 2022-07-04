package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a user joined a voice channel.
 */
public class UserLeaveVoiceChannelEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final VoiceChannel channel;

    public UserLeaveVoiceChannelEvent(final long timeStamp, final User user, final VoiceChannel channel) {
        super(timeStamp, user);
        this.channel = Objects.requireNonNull(channel);
    }

    /**
     * Get the voice channel related to this event.
     */
    public VoiceChannel getChannel() {
        return channel;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
