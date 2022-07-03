package snw.jkook.entity.mute;

import snw.jkook.entity.User;

/**
 * Represents the mute status of a user. <p>
 * It is a snapshot, you should not store it.
 */
public interface MuteData {

    /**
     * Get the user related to this data.
     */
    User getUser();

    /**
     * Return true if this user has disabled his microscope.
     */
    boolean isInputDisabled();

    /**
     * Return true if this user won't hear other users' voice.
     */
    boolean isOutputDisabled();
}
