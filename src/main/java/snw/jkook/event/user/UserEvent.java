package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.Event;

import java.util.Objects;

/**
 * Represents an event related to a user.
 */
public abstract class UserEvent extends Event {
    private final User user;

    UserEvent(final long timeStamp, final User user) {
        super(timeStamp);
        this.user = Objects.requireNonNull(user);
    }

    /**
     * Get the user related to this event.
     */
    public User getUser() {
        return user;
    }
}
