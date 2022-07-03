package snw.jkook.event.role;

import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to a role was deleted.
 */
public class RoleDeleteEvent extends RoleEvent {
    private static final HandlerList handlers = new HandlerList();

    private final User operator;

    public RoleDeleteEvent(final Role role, final User operator) {
        super(role);
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
