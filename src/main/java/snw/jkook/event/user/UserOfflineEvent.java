package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

/**
 * Represents an event about a user offline.
 */
public class UserOfflineEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    public UserOfflineEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
