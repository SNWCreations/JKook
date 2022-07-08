package snw.jkook;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.VoiceChannel;

import java.io.File;
import java.util.Collection;

/**
 * Represents the entry of Kook HTTP API.
 */
public interface HttpAPI {

    /**
     * Get the joined guilds.
     */
    Collection<Guild> getJoinedGuilds();

    /**
     * Get a user by user id.
     *
     * @param id The ID of a user
     */
    User getUser(String id);

    /**
     * Get a guild by guild ID.
     *
     * @param id The ID of a guild
     */
    Guild getGuild(String id);

    /**
     * Get a channel by ID.
     *
     * @param id The channel ID
     */
    Channel getChannel(String id);

    /**
     * Get a category by ID.
     *
     * @param id The ID
     */
    Category getCategory(String id);

    /**
     * Get a "channel group" by ID.
     *
     * @param id The ID
     * @deprecated Actually, it is {@link Category}. So use {@link #getCategory(String)} instead.
     */
    Category getChannelGroup(String id);

    /**
     * Get a user by user id.
     *
     * @param id The ID of a user
     * @deprecated Unsafe, because Kook returns string ids.
     */
    @Deprecated
    User getUser(long id);

    /**
     * Get a guild by guild ID.
     *
     * @param id The ID of a guild
     * @deprecated Unsafe, because Kook returns string ids.
     */
    @Deprecated
    Guild getGuild(long id);

    /**
     * Get a channel by ID.
     *
     * @param id The channel ID
     * @deprecated Unsafe, because Kook returns string ids.
     */
    @Deprecated
    Channel getChannel(long id);

    /**
     * Get a "channel group" by ID.
     *
     * @param id The ID
     * @deprecated Use {@link #getChannel} instead, because {@link Category} is a subclass of {@link Channel}.
     */
    @Deprecated
    Category getChannelGroup(long id);

    /**
     * Upload a file to Kook server.
     *
     * @param file The file to upload
     * @return The URL string of the remote file
     */
    String uploadFile(File file);

    /**
     * Upload a file to Kook server.
     *
     * @param binary The binary data to upload
     * @return The URL string of the remote file
     */
    String uploadFile(String binary);

    /**
     * Move the users to another voice channel if possible. (Fails silently.)
     *
     * @param channel The target channel
     * @param users   The users to move
     * @deprecated Use {@link VoiceChannel#moveToHere(Collection)} instead. This method still works but not recommended.
     */
    @Deprecated
    void moveUser(VoiceChannel channel, Collection<User> users);
}
