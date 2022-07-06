package snw.jkook.entity.channel;

import snw.jkook.Permission;
import snw.jkook.entity.User;
import snw.jkook.util.RequirePermission;

import java.util.Collection;
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

    /**
     * Move the specified users to this channel. <p>
     * Only the users that already connected to another voice channel in the list will be moved.
     *
     * @param users The target users
     */
    @RequirePermission(Permission.VOICE_MANAGE)
    void moveToHere(Collection<User> users);
}
