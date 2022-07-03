package snw.jkook.event.role;

import snw.jkook.entity.Role;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a role's information was updated. <p>
 * To get the new information, use methods in {@link Role} interface.
 */
public class RoleInfoUpdateEvent extends RoleEvent {
    private static final HandlerList handlers = new HandlerList();

    public RoleInfoUpdateEvent(final Role role) {
        super(role);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
