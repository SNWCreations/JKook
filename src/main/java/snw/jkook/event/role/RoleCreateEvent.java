package snw.jkook.event.role;

import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a role was created.
 */
public class RoleCreateEvent extends RoleEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User operator;

    public RoleCreateEvent(final long timeStamp, final Role role, final User operator) {
        super(timeStamp, role);
        this.operator = Objects.requireNonNull(operator);
    }

    /**
     * Get the operator of the new role.
     */
    public User getOperator() {
        return operator;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
