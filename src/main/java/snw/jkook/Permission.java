/*
 * Copyright 2022 JKook contributors
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

package snw.jkook;

import snw.jkook.entity.channel.TextChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the permission in Kook.
 */
public enum Permission {

    // ------ Abilities ------

    /**
     * Represents the administrator of a guild. <p>
     * Having this permission gives the guild members full administrative rights,
     * including the ability to circumvent all other permissions (including channel permissions).
     * So it is <b>DANGEROUS</b>.
     */
    ADMIN(1),

    /**
     * Guild members who have this permission can modify the guild name
     * and change the zone of the guild's voice channel.
     */
    OPERATOR(2),

    /**
     * Guild members that have this permission can view the administrative log for the server.
     */
    ADMIN_LOG(4),

    /**
     * Guild members that have this permission can create invitations.
     */
    INVITE(8),

    /**
     * Guild members that have this permission can manage invitations.
     */
    INVITE_MANAGE(16),

    /**
     * Guild members that have this permission can create new channels and edit or delete existing channels.
     */
    CHANNEL_MANAGE(32),

    /**
     * Guild members that have this permission can kick other guild members.
     */
    KICK(64),

    /**
     * Guild members that have this permission can ban other guild members from the guild. <p>
     * This permission does <b>NOT</b> prevent members from logging into the Kook,
     * but only deprives members of all privileges in the guild.
     */
    BAN(128),

    /**
     * Guild members that have this permission can manage the uploaded custom emojis in the guild.
     */
    EMOJI_MANAGE(256),

    /**
     * Guild members that have this permission can change their nickname. <p>
     * (Nickname is not user name!)
     */
    CHANGE_NICKNAME(512),

    /**
     * Guild members that have this permission can change other guild member's nickname. <p>
     * (Nickname is not user name!)
     */
    CHANGE_OTHERS_NICKNAME(67108864),

    /**
     * Guild members that have this permission can manage the roles in the guild.
     */
    ROLE_MANAGE(1024),

    /**
     * Guild members that have this permission can see the channels in the guild.
     */
    SEE_CHANNELS(2048),

    /**
     * Guild members that have this permission can send the messages in the {@link TextChannel}.
     */
    SEND_MESSAGE(4096),

    /**
     * Guild members that have this permission can manage the messages in the {@link TextChannel}.
     */
    MESSAGE_MANAGE(8192),

    /**
     * Guild members that have this permission can upload the files.
     */
    UPLOAD_FILE(16384),

    /**
     * Guild members that have this permission can create the links of voice channels.
     */
    VOICE_LINK(32768),

    /**
     * Guild members that have this permission can move and kick other members off the channel; however, such movement is limited to channel where both the member and the moved member have permission.
     */
    VOICE_MANAGE(65536),

    /**
     * Guild members that have this permission can use the @all in the text chat to refer to all members of the channel.
     */
    MENTION_ALL(131072),

    /**
     * Guild members that have this permission can add the reaction to a message.
     */
    ADD_REACTION(262144),

    /**
     * Guild members that have this permission can add the reaction that has been added to a message.
     */
    FOLLOW_ADD_REACTION(524288),

    //// ----- Permissions related to voice channels -----

    /**
     * Guild members who do not have this permission can't talk in the voice channels.
     */
    TALK(8388608),

    /**
     * Guild members that have this permission can play musics in the voice channels.
     */
    PLAY_MUSIC(134217728),

    /**
     * Guild members who do not have this permission must speak on the channel by pressing the specified key.
     * (The key is configured by users.)
     */
    FREE_TALK(4194304),

    /**
     * Guild members that have this permission can determine whether they can refuse to hear other member's voices on the voice channel.
     */
    HEAR_NOTHING(16777216),

    /**
     * Guild members that have this permission can decide if they can turn off their microphone while on the voice channel.
     */
    SPEAK_NOTHING(33554432),

    /**
     * Guild members that have this permission can share their screen in the voice channel.
     */
    SCREEN_SHARE(268435456),

    //// ----- Restrictions -----

    /**
     * Guild members with this restriction can not actively connect to voice channels and can only access voice channels when passively invited or moved.
     */
    PASSIVE_CONNECT_TO_VOICE_CHANNEL(1048576),

    /**
     * Guild members with this restriction can talk using the specified key in the voice channels only.
     */
    KEY_TALK_ONLY(2097152);

    private static final Map<Integer, Permission> values = new HashMap<>();

    static {
        for (Permission value : values()) {
            values.put(value.getValue(), value);
        }
    }

    private final int value;

    Permission(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Return true if the targeted permission is included in <code>rawPermissionSum</code>.
     *
     * @param permission The permission to check
     * @param rawPermissionSum The sum of a set of permissions
     */
    public static boolean hasPermission(Permission permission, int rawPermissionSum) {
        if ((rawPermissionSum & 1) == 1) {
            return true;
        }
        return (rawPermissionSum & permission.getValue()) == permission.getValue();
    }

    /**
     * Return the permission that represented by <code>permVal</code>. <p>
     * If you want to know whether <code>permVal</code> contains a certain permission <b>(not equal to)</b>, use {@link #hasPermission} instead.
     *
     * @param permVal The value
     */
    public static Permission value(int permVal) {
        return values.get(permVal);
    }
}
