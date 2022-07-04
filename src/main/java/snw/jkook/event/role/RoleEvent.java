package snw.jkook.event.role;

import snw.jkook.entity.Role;
import snw.jkook.event.Event;

import java.util.Objects;

/**
 * Represents an event related to a role.
 */
public abstract class RoleEvent extends Event {
    private final Role role;

    RoleEvent(final long timeStamp, final Role role) {
        super(timeStamp);
        this.role = Objects.requireNonNull(role);
    }

    /**
     * Get the role.
     */
    public Role getRole() {
        return role;
    }
}
