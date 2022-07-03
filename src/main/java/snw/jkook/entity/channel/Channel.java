package snw.jkook.entity.channel;

import snw.jkook.entity.abilities.Nameable;

/**
 * Represents a channel.
 */
public interface Channel extends Nameable {

    /**
     * Get the ID of this channel.
     */
    long getId();

    /**
     * Return true if the permissions of this channel is the same as its parent.
     */
    boolean isPermissionSync();

    /**
     * Get the group that holds this channel.
     */
    ChannelGroup getParent();
}
