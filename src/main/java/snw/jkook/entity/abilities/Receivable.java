package snw.jkook.entity.abilities;

import snw.jkook.entity.User;

/**
 * Represents an object that would be received by users.
 */
public interface Receivable {

    /**
     * Get the sender of this object.
     */
    User getSender();

    /**
     * Get the time stamp that the user sent this object.
     */
    long getTimeStamp();
}
