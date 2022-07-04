package snw.jkook.event.user;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a user joined the guild.
 */
public class UserJoinGuildEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Guild guild;

    public UserJoinGuildEvent(final long timeStamp, final User user, final Guild guild) {
        super(timeStamp, user);
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * Get the guild which the user joined.
     */
    public Guild getGuild() {
        return guild;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
