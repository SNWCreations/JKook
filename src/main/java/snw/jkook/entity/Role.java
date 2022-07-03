package snw.jkook.entity;

import snw.jkook.entity.channel.TextChannel;

/**
 * Represents a role in a Kook guild.
 */
public interface Role {

    /**
     * Get the name of this role.
     */
    String getName();

    /**
     * Get the ID of this role.
     */
    int getId();

    /**
     * Get the color of this role.
     */
    int getColor();

    /**
     * Get the position of this role. <p>
     * The color a user displays in the user list depends on the role in which the user has the highest position (and the lowest numerical value).
     */
    int getPosition();

    /**
     * Return true if this role has the provided permission.
     *
     * @param permission The permission constant
     */
    boolean isPermissionSet(Permission permission);

    /**
     * Return true if the user that have this role can be mentioned.
     */
    boolean isMentionable();

    /**
     * Represents the permission that a {@link Role} can hold.
     */
    enum Permission {

        // ------ Abilities ------

        /**
         * Represents the administrator of a guild. <p>
         * Having this permission gives the guild members full administrative rights,
         * including the ability to circumvent all other permissions (including channel permissions).
         * So it is <b>DANGEROUS</b>.
         */
        ADMIN,

        /**
         * Guild members who have this permission can modify the guild name
         * and change the zone of the guild's voice channel.
         */
        OPERATOR,

        /**
         * Guild members that have this permission can view the administrative log for the server.
         */
        ADMIN_LOG,

        /**
         * Guild members that have this permission can create invitations.
         */
        INVITE,

        /**
         * Guild members that have this permission can manage invitations.
         */
        INVITE_MANAGE,

        /**
         * Guild members that have this permission can create new channels and edit or delete existing channels.
         */
        CHANNEL_MANAGE,

        /**
         * Guild members that have this permission can kick other guild members.
         */
        KICK,

        /**
         * Guild members that have this permission can ban other guild members from the guild. <p>
         * This permission does <b>NOT</b> prevent members from logging into the Kook,
         * but only deprives members of all privileges in the guild.
         */
        BAN,

        /**
         * Guild members that have this permission can manage the uploaded custom emojis in the guild.
         */
        EMOJI_MANAGE,

        /**
         * Guild members that have this permission can change their nickname. <p>
         * (Nickname is not user name!)
         */
        CHANGE_NICKNAME,

        /**
         * Guild members that have this permission can change other guild member's nickname. <p>
         * (Nickname is not user name!)
         */
        CHANGE_OTHERS_NICKNAME,

        /**
         * Guild members that have this permission can manage the roles in the guild.
         */
        ROLE_MANAGE,

        /**
         * Guild members that have this permission can see the channels in the guild.
         */
        SEE_CHANNELS,

        /**
         * Guild members that have this permission can send the messages in the {@link TextChannel}.
         */
        SEND_MESSAGE,

        /**
         * Guild members that have this permission can manage the messages in the {@link TextChannel}.
         */
        MESSAGE_MANAGE,

        /**
         * Guild members that have this permission can upload the files.
         */
        UPLOAD_FILE,

        /**
         * Guild members that have this permission can create the links of voice channels.
         */
        VOICE_LINK,

        /**
         * Guild members that have this permission can move and kick other members off the channel; however, such movement is limited to channel where both the member and the moved member have permission.
         */
        VOICE_MANAGE,

        /**
         * Guild members that have this permission can use the @all in the text chat to refer to all members of the channel.
         */
        MENTION_ALL,

        /**
         * Guild members that have this permission can add the reaction to a message.
         */
        ADD_REACTION,

        /**
         * Guild members that have this permission can add the reaction that has been added to a message.
         */
        FOLLOW_ADD_REACTION,

        //// ----- Permissions related to voice channels -----

        /**
         * Guild members who do not have this permission can't talk in the voice channels.
         */
        TALK,

        /**
         * Guild members that have this permission can play musics in the voice channels.
         */
        PLAY_MUSIC,

        /**
         * Guild members who do not have this permission must speak on the channel by pressing the specified key.
         * (The key is configured by users.)
         */
        FREE_TALK,

        /**
         * Guild members that have this permission can determine whether they can refuse to hear other member's voices on the voice channel.
         */
        HEAR_NOTHING,

        /**
         * Guild members that have this permission can decide if they can turn off their microphone while on the audio channel.
         */
        SPEAK_NOTHING,

        //// ----- Restrictions -----

        /**
         * Guild members with this restriction can not actively connect to voice channels and can only access voice channels when passively invited or moved.
         */
        PASSIVE_CONNECT_TO_VOICE_CHANNEL,

        /**
         * Guild members with this restriction can talk using the specified key in the voice channels only.
         */
        KEY_TALK_ONLY
    }
}
