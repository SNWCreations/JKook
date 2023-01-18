/*
 * Copyright 2022 - 2023 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snw.jkook.entity;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.entity.mute.MuteResult;
import snw.jkook.util.PageIterator;
import snw.jkook.util.RequirePermission;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    PageIterator<Set<User>> getUsers();

    /**
     * Get the users in this guild. <p>
     * This method provides more conditions to use. <p>
     * All the arguments in this method will be regard as the search condition.
     *
     * @param keyword The search keywords, search in username or nickname
     * @param roleId The role that the users have. See {@link Role#getId()}
     * @param isMobileVerified Is the target user's mobile verified?
     * @param isActiveTimeFirst Sort according to active time, <code>true</code> is in order, <code>false</code> is in reverse order
     * @param isJoinedTimeFirst Sort according to joined time, <code>true</code> is in order, <code>false</code> is in reverse order
     */
    PageIterator<Set<User>> getUsers(
            String keyword,
            @Nullable Integer roleId,
            @Nullable Boolean isMobileVerified,
            @Nullable Boolean isActiveTimeFirst,
            @Nullable Boolean isJoinedTimeFirst
    );

    /**
     * Get all the channels in this guild.
     */
    PageIterator<Set<Channel>> getChannels();

    /**
     * Get all the roles in this guild.
     */
    PageIterator<Set<Role>> getRoles();

    /**
     * Get the voice server region of this guild.
     */
    String getVoiceChannelServerRegion();

    /**
     * Get the custom emojis in this guild.
     */
    PageIterator<Set<CustomEmoji>> getCustomEmojis();

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
    @RequirePermission(Permission.BAN)
    void ban(User user, @Nullable String reason, int delMessageDays);

    /**
     * Unban the user from this guild.
     *
     * @param user The user to be unbanned
     */
    @RequirePermission(Permission.BAN)
    void unban(User user);

    /**
     * Kick the user from this guild. This <b>CANNOT</b> be undone!
     *
     * @param user The user to be kicked
     */
    @RequirePermission(Permission.KICK)
    void kick(User user);

    /**
     * Create a text channel in this guild with given information.
     *
     * @param name The name of the new channel
     * @param parent The parent category of the new channel
     * @return The new channel representation
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
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
    @RequirePermission(Permission.CHANNEL_MANAGE)
    VoiceChannel createVoiceChannel(
            String name,
            @Nullable Category parent,
            @Range(from = 1, to = 99) int size,
            @Range(from = 1, to = 3) int quality
    );

    /**
     * Create a category in this guild with given information.
     *
     * @param name The name of the new category
     * @return The new category representation
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    Category createCategory(String name);

    /**
     * Create a role with given information.
     *
     * @param name The name of new role
     * @return The new role representation
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    Role createRole(String name);

    /**
     * Upload an emoji to this guild.
     *
     * @param binary The binary value of the emoji. Allows PNG only. The size can not exceed 512 KB.
     *               <b>Use {@link java.nio.charset.StandardCharsets#ISO_8859_1} instead of
     *               default charset when you creating the String instance for the binary value.</b>
     * @param name The name of the new emoji. If empty, it will be a random string
     * @return The new emoji representation
     * @deprecated We shouldn't use String to represent the binary values,
     *             use {@link #uploadEmoji(byte[], String, String)} instead.
     */
    @Deprecated
    @RequirePermission(Permission.EMOJI_MANAGE)
    CustomEmoji uploadEmoji(String binary, @Nullable String name);

    /**
     * Upload an emoji to this guild.
     *
     * @param binary The binary value of the emoji. The size can not exceed 512 KB.
     * @param type The media type string of the emoji. Only support PNG, JPG, JPEG, GIF.
     *             (e.g. "image/png")
     * @param name The name of the new emoji. If empty, it will be a random string
     * @return The new emoji representation
     * @throws IllegalArgumentException Thrown if the media type is invalid, or the length of
     *                                  the emoji name is not greater or equals 2.
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    CustomEmoji uploadEmoji(byte[] binary, String type, @Nullable String name)
            throws IllegalArgumentException;

    /**
     * Get the users banned by this guild.
     */
    PageIterator<Set<User>> getBannedUsers();

    /**
     * Get notify type of this guild.
     */
    NotifyType getNotifyType();

    /**
     * Get the avatar url of this guild.
     *
     * @param vip Do <b>NOT</b> provide true, or you will get {@link IllegalArgumentException}.
     * @return The avatar url.
     * @throws IllegalArgumentException Thrown if value of argument <code>vip</code> is <code>true</code>
     */
    @Override
    String getAvatarUrl(boolean vip) throws IllegalArgumentException;

    /**
     * Get the boost information in the provided time range. <br>
     * The timestamp is in <b>seconds</b>.
     * 
     * @param start The start of the range
     * @param end The end of the range
     * @throws IllegalArgumentException Thrown if the "start" timestamp is greater than the "end" timestamp, or one of them is negative.
     */
    @RequirePermission(Permission.OPERATOR)
    Collection<BoostInfo> getBoostInfo(int start, int end) throws IllegalArgumentException;

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

        private static final Map<Integer, NotifyType> values = new HashMap<>();

        static {
            for (NotifyType value : values()) {
                values.put(value.getValue(), value);
            }
        }

        private final int value;

        NotifyType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * Return the enum instance that represented the provided value.
         *
         * @param value The value
         */
        public static NotifyType value(int value) {
            return values.get(value);
        }
    }

    /**
     * Represents the boost info.
     */
    interface BoostInfo {

        /**
         * Get the user as the booster.
         */
        User getBooster();

        /**
         * Get the start timestamp of this boost. <br>
         * The timestamp is in seconds.
         */
        int getStartTime();

        /**
         * Get the end timestamp of this boost. <br>
         * The timestamp is in seconds.
         */
        int getEndTime();
    }
}
