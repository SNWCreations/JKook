package snw.jkook.event.user;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a user left the guild.
 */
public class UserLeaveGuildEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Guild guild;

    public UserLeaveGuildEvent(User user, Guild guild) {
        super(user);
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * Get the guild which the user left.
     */
    public Guild getGuild() {
        return guild;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
