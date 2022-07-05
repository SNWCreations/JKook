package snw.jkook.entity;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.entity.mute.MuteResult;

import java.util.Collection;

/**
 * Represents a Guild.
 */
public interface Guild extends Nameable, AvatarHolder, MasterHolder, InviteHolder {

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
     * Get all the channels in this guild.
     */
    Iterable<Channel> getChannels();

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

    /**
     * Get the mute status of this guild.
     */
    MuteResult getMuteStatus();

    /**
     * Leave this guild. This <b>CANNOT</b> be undone!
     */
    void leave();

    /**
     * Ban the user from this guild.
     *
     * @param user           The user to be banned
     * @param reason         The reason
     * @param delMessageDays The value passed in determines how many days the message sent by this user is deleted
     */
    void ban(User user, @Nullable String reason, int delMessageDays);

    /**
     * Unban the user from this guild.
     *
     * @param user The user to be unbanned
     */
    void unban(User user);

    /**
     * Create a text channel in this guild with given information.
     *
     * @param name The name of the new channel
     * @param parent The parent category of the new channel
     * @return The new channel representation
     */
    TextChannel createTextChannel(String name, @Nullable Category parent);

    /**
     * Create a voice channel in this guild with given information.
     *
     * @param name The name of the new channel
     * @param parent The parent category of the new channel
     * @param size The max size of the new channel, determine the number of users this channel can hold
     * @param quality Voice quality. 1 smooth, 2 normal, 3 high quality
     * @return The new channel representation
     */
    VoiceChannel createVoiceChannel(
            String name,
            @Nullable Category parent,
            @Range(from = 1, to = 99) int size,
            @Range(from = 1, to = 3) int quality
    );

    /**
     * Get the users banned by this guild.
     */
    Collection<User> getBannedUsers();

    NotifyType getNotifyType();

    /**
     * Represents notify type.
     */
    enum NotifyType {

        /**
         * Use the settings defined by the guild.
         */
        DEFAULT(0),

        /**
         * Always notify.
         */
        ALL(1),

        /**
         * Notify on be mentioned only.
         */
        MENTION_ONLY(2),

        /**
         * Never notify.
         */
        NO_NOTIFY(3);

        private final int value;

        NotifyType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
