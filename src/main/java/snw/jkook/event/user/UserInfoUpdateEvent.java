package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a user's information (e.g. nickname?) was updated. <p>
 * To get new information, use methods in {@link User} interface.
 * <b>This event will be fired if the following situations happened:</b>
 * <ul>
 *     <li>The user's avatar or username was updated.</li>
 *     <li>The user have chat sessions with the Bot.</li>
 *     <li>The user is the friend of the Bot.</li>
 * </ul>
 */
public class UserInfoUpdateEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    public UserInfoUpdateEvent(final User user) {
        super(user);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
