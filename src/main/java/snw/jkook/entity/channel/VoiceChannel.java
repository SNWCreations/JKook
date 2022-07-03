package snw.jkook.entity.channel;

import snw.jkook.entity.User;

import java.util.List;

/**
 * Represents a channel that can chat using voice.
 */
public interface VoiceChannel extends Channel {

    /**
     * Return the max user counts that this channel can hold. <p>
     * If this channel can hold infinity users, <code>-1</code> will be returned.
     */
    int getMaxSize(); // return -1 if this channel's size is infinity.

    /**
     * Get the users that already joined this channel.
     */
    List<User> getUsers();

    /**
     * Get the count of the users that already joined this channel.
     */
    default int getUserCount() {
        return getUsers().size();
    }
}
