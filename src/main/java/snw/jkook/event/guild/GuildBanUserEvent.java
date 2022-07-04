package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.List;
import java.util.Objects;

/**
 * Represents an event that a guild banned some users.
 */
public class GuildBanUserEvent extends GuildEvent {
    private static final HandlerList handlers = new HandlerList();

    private final List<User> banned;
    private final User operator;
    private final String reason;

    public GuildBanUserEvent(final long timeStamp, final Guild guild, final List<User> banned, final User operator, String reason) {
        super(timeStamp, guild);
        this.banned = Objects.requireNonNull(banned);
        this.operator = Objects.requireNonNull(operator);
        this.reason = Objects.requireNonNull(reason);
    }

    /**
     * Get the banned users.
     */
    public List<User> getBanned() {
        return banned;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

    /**
     * Get the reason.
     */
    public String getReason() {
        return reason;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
