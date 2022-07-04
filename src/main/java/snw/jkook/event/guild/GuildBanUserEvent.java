package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event that a guild banned a user.
 */
public class GuildBanUserEvent extends GuildEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User banned;
    private final User operator;

    public GuildBanUserEvent(final long timeStamp, final Guild guild, final User banned, final User operator) {
        super(timeStamp, guild);
        this.banned = Objects.requireNonNull(banned);
        this.operator = Objects.requireNonNull(operator);
    }

    /**
     * Get the banned user.
     */
    public User getBanned() {
        return banned;
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
