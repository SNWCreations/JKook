package snw.jkook;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.ChannelGroup;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.entity.mute.MuteResult;

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
     * Get a voice channel by the provided user.
     *
     * @param user The user
     */
    VoiceChannel getVoiceChannelByUser(User user);

    /**
     * Get the mute status of a guild.
     *
     * @param guild The guild
     */
    MuteResult getMuteStatus(Guild guild);

    /**
     * Get a user by user id.
     *
     * @param id The ID of a user
     */
    User getUser(long id);

    /**
     * Get a guild by guild ID.
     *
     * @param id The ID of a guild
     */
    Guild getGuild(long id);

    /**
     * Get a channel by ID.
     *
     * @param id The channel ID
     */
    Channel getChannel(long id);

    /**
     * Get a channel group by ID.
     *
     * @param id The ID
     */
    ChannelGroup getChannelGroup(long id);
}
