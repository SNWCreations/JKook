/*
 * Copyright 2022 - 2024 JKook contributors
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
import snw.jkook.Permission;
import snw.jkook.command.CommandSender;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.message.PrivateMessage;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.PageIterator;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * Represents a user.
 */
public interface User extends Nameable, AvatarHolder, CommandSender {

    /**
     * Get the ID of this user.
     */
    String getId();

    /**
     * Get the nickname of this user. <p>
     *
     * @param guild The guild that contains this user
     */
    String getNickName(Guild guild);

    /**
     * Get the full name of this user, including the name and identify number. <br>
     * If the {@code guild} object is provided, we will use the user's nickname in the
     * provided {@code guild}.
     *
     * @param guild The guild as the nickname provider
     */
    String getFullName(@Nullable Guild guild);

    /**
     * Set the nickname of this user in the specified guild. <p>
     * If this object represents the Bot in this VM, then you won't need {@link Permission#CHANGE_OTHERS_NICKNAME}, but you will need {@link Permission#CHANGE_NICKNAME}.
     *
     * @param guild The guild that contains this user
     * @param name  The new nickname of this user
     */
    @RequirePermission({Permission.CHANGE_NICKNAME, Permission.CHANGE_OTHERS_NICKNAME})
    void setNickName(Guild guild, String name);

    /**
     * Return identify number. It can be changed! <br>
     * <b>WARNING: The value returned by this method does NOT in a format like "0001", which means, no "0" as padding,
     *   If you need the correct form of the value, use {@link #getIdentifyNumberAsString()} instead.</b>
     */
    int getIdentifyNumber();

    /**
     * Get the identify number as string.
     */
    default String getIdentifyNumberAsString() {
        final int num = getIdentifyNumber();
        final String s = String.valueOf(num);
        if (s.length() < 4) {
            final StringBuilder sb = new StringBuilder();
            final int padLength = 4 - s.length();
            for (int i = 1; i <= padLength; i++) {
                sb.append(0);
            }
            sb.append(num);
            return sb.toString();
        }
        return s;
    }

    /**
     * Return true if this user has "Kook BUFF".
     */
    boolean isVip();

    /**
     * Return true if this user is a Bot.
     */
    boolean isBot();

    /**
     * Return true if this user is online.
     */
    boolean isOnline();

    /**
     * Return true if this user is currently banned by Kook Official.
     */
    boolean isBanned();

    /**
     * Get the roles that this user have. <p>
     * The result is a set of role ID.
     * The result is read-only.
     *
     * @param guild The guild as the search target
     */
    Collection<Integer> getRoles(Guild guild);

    /**
     * Send a component to this user.
     *
     * @param message The message content
     * @return The Message ID
     */
    String sendPrivateMessage(String message);

    /**
     * Send a component to this user.
     *
     * @param message The message content
     * @param quote   If this parameter is passed in, the incoming message
     *                  will be considered a reply to the message corresponding to this parameter
     * @return The Message ID
     */
    String sendPrivateMessage(String message, PrivateMessage quote);

    /**
     * Send a component to this user.
     *
     * @param component The component to send
     * @return The Message ID
     */
    String sendPrivateMessage(BaseComponent component);

    /**
     * Send a component to this user.
     *
     * @param component The component to send
     * @param quote     If this parameter is passed in, the incoming message
     *                  will be considered a reply to the message corresponding to this parameter
     * @return The Message ID
     */
    String sendPrivateMessage(BaseComponent component, PrivateMessage quote);

    /**
     * Send a component to this user.
     *
     * @param message    The message content
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     * @return The Message ID
     */
    String sendPrivateMessage(String message, @Nullable PrivateMessage quote, @Nullable String replyMsgId);

    /**
     * Send a component to this user.
     *
     * @param component  The component to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     * @return The Message ID
     */
    String sendPrivateMessage(BaseComponent component, @Nullable PrivateMessage quote, @Nullable String replyMsgId);

    /**
     * Get the voice channel which this user joined.<br>
     *
     * Why this method return a {@code PageIterator<Collection<VoiceChannel>>}?<br>
     * 
     * Kook will support Bots join multiple voice channels, and current API returns array (based on iterable page).
     * 
     * @param guild The guild as the search condition
     * @return The collection of the joined voice channels
     */
    PageIterator<Collection<VoiceChannel>> getJoinedVoiceChannel(Guild guild);

    /**
     * Get the intimacy score of this user.
     */
    int getIntimacy();

    /**
     * Get the intimacy info of this user.
     */
    IntimacyInfo getIntimacyInfo();

    /**
     * Set the intimacy score of this user.
     *
     * @param intimacy The intimacy value
     */
    void setIntimacy(int intimacy);

    /**
     * Set the intimacy data of this user.
     *
     * @param intimacy The intimacy value
     * @param socialInfo See {@link User.IntimacyInfo#getSocialInfo()}
     * @param socialImageID See {@link User.IntimacyInfo.SocialImage#getId()}
     */
    void setIntimacy(int intimacy, String socialInfo, @Nullable Integer socialImageID);

    /**
     * Grant the specified role to this user. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param role The role to grant
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Role role);

    /**
     * Revoke the specified role that this user have. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param role The role to revoke
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Role role);

    /**
     * Grant the specified role to this user. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param roleId The role to grant
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Guild guild, int roleId);

    /**
     * Revoke the specified role that this user have. <p>
     * It is <b>DANGEROUS</b>!
     *
     * @param roleId The role to revoke
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Guild guild, int roleId);

    /**
     * Add this user to the Bots personal black list.
     */
    void block();

    /**
     * Remove this user from the Bots personal black list.
     */
    void unblock();

    /**
     * Represents the Bots' intimacy information of the user. <br>
     * It is a snapshot. Don't save it.
     */
    interface IntimacyInfo {

        /**
         * Get the url of the current social image that shown to the user.
         */
        String getSocialImage();

        /**
         * Get the social info that shown to the user.
         */
        String getSocialInfo();

        /**
         * Get the timestamp of the user last read the social info.
         */
        int getLastRead();

        /**
         * Get the intimacy score of this user. <br>
         * It is the same as {@link User#getIntimacy()}.
         */
        int getScore();

        /**
         * Get the collection of available social image data. <br>
         * The result is read-only.
         */
        Collection<SocialImage> getSocialImages();

        /**
         * Represents the social image.
         */
        interface SocialImage {

            /**
             * Get the ID of this social image.
             */
            String getId();

            /**
             * Get the url of this social image.
             */
            String getUrl();
        }
    }
}
