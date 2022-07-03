package snw.jkook.entity;

import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;

import java.util.Collection;

/**
 * Represents a Guild.
 */
public interface Guild extends Nameable, AvatarHolder, MasterHolder {

    /**
     * Get the ID of this guild.
     */
    String getId();

    /**
     * Get the users in this guild.
     */
    Iterable<User> getUsers();

    /**
     * Get the online users in this guild.
     */
    Iterable<User> getOnlineUsers();

    /**
     * Get the voice server region of this guild.
     */
    String getVoiceChannelServerRegion();

    /**
     * Get the custom emojis in this guild.
     */
    Collection<CustomEmoji> getCustomEmojis();

    /**
     * Get the online user count.
     */
    int getOnlineUserCount();

    /**
     * Get the total user count.
     */
    int getUserCount();

    /**
     * Return true if this guild is public.
     */
    boolean isPublic();
}
