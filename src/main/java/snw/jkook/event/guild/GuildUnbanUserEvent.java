package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event that a guild unbanned a user.
 */
public class GuildUnbanUserEvent extends GuildEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User unbanned;
    private final User operator;

    public GuildUnbanUserEvent(final long timeStamp, final Guild guild, final User unbanned, final User operator) {
        super(timeStamp, guild);
        this.unbanned = Objects.requireNonNull(unbanned);
        this.operator = Objects.requireNonNull(operator);
    }

    /**
     * Get the unbanned user.
     */
    public User getUnbanned() {
        return unbanned;
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
