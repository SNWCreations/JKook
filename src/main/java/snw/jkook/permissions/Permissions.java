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

package snw.jkook.permissions;

import snw.jkook.Permission;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The class has been modified to define the default permissions for 'KOOK'
 */
public final class Permissions {
    private static final Map<Permission, Permissions> PERMISSIONS_MAP = new HashMap<>();
    private final String name;

    private Permissions(String name) {
        this.name = name;
    }

    public String getPermission() {
        return "kook." + name;
    }

    /**
     * @see Permission#ADMIN
     */
    public static final String ADMIN = create(Permission.ADMIN);
    /**
     * @see Permission#OPERATOR
     */
    public static final String OPERATOR = create(Permission.OPERATOR);
    /**
     * @see Permission#ADMIN_LOG
     */
    public static final String ADMIN_LOG = create(Permission.ADMIN_LOG);
    /**
     * @see Permission#INVITE
     */
    public static final String INVITE = create(Permission.INVITE);
    /**
     * @see Permission#INVITE_MANAGE
     */
    public static final String INVITE_MANAGE = create(Permission.INVITE_MANAGE);
    /**
     * @see Permission#CHANNEL_MANAGE
     */
    public static final String CHANNEL_MANAGE = create(Permission.CHANNEL_MANAGE);
    /**
     * @see Permission#KICK
     */
    public static final String KICK = create(Permission.KICK);
    /**
     * @see Permission#BAN
     */
    public static final String BAN = create(Permission.BAN);
    /**
     * @see Permission#EMOJI_MANAGE
     */
    public static final String EMOJI_MANAGE = create(Permission.EMOJI_MANAGE);
    /**
     * @see Permission#CHANGE_NICKNAME
     */
    public static final String CHANGE_NICKNAME = create(Permission.CHANGE_NICKNAME);
    /**
     * @see Permission#CHANGE_OTHERS_NICKNAME
     */
    public static final String CHANGE_OTHERS_NICKNAME = create(Permission.CHANGE_OTHERS_NICKNAME);
    /**
     * @see Permission#ROLE_MANAGE
     */
    public static final String ROLE_MANAGE = create(Permission.ROLE_MANAGE);
    /**
     * @see Permission#SEE_CHANNELS
     */
    public static final String SEE_CHANNELS = create(Permission.SEE_CHANNELS);
    /**
     * @see Permission#SEND_MESSAGE
     */
    public static final String SEND_MESSAGE = create(Permission.SEND_MESSAGE);
    /**
     * @see Permission#MESSAGE_MANAGE
     */
    public static final String MESSAGE_MANAGE = create(Permission.MESSAGE_MANAGE);
    /**
     * @see Permission#UPLOAD_FILE
     */
    public static final String UPLOAD_FILE = create(Permission.UPLOAD_FILE);
    /**
     * @see Permission#VOICE_LINK
     */
    public static final String VOICE_LINK = create(Permission.VOICE_LINK);
    /**
     * @see Permission#VOICE_MANAGE
     */
    public static final String VOICE_MANAGE = create(Permission.VOICE_MANAGE);
    /**
     * @see Permission#MENTION_ALL
     */
    public static final String MENTION_ALL = create(Permission.MENTION_ALL);
    /**
     * @see Permission#ADD_REACTION
     */
    public static final String ADD_REACTION = create(Permission.ADD_REACTION);
    /**
     * @see Permission#FOLLOW_ADD_REACTION
     */
    public static final String FOLLOW_ADD_REACTION = create(Permission.FOLLOW_ADD_REACTION);
    /**
     * @see Permission#TALK
     */
    public static final String TALK = create(Permission.TALK);
    /**
     * @see Permission#PLAY_MUSIC
     */
    public static final String PLAY_MUSIC = create(Permission.PLAY_MUSIC);
    /**
     * @see Permission#FREE_TALK
     */
    public static final String FREE_TALK = create(Permission.FREE_TALK);
    /**
     * @see Permission#HEAR_NOTHING
     */
    public static final String HEAR_NOTHING = create(Permission.HEAR_NOTHING);
    /**
     * @see Permission#SPEAK_NOTHING
     */
    public static final String SPEAK_NOTHING = create(Permission.SPEAK_NOTHING);
    /**
     * @see Permission#SCREEN_SHARE
     */
    public static final String SCREEN_SHARE = create(Permission.SCREEN_SHARE);
    /**
     * @see Permission#PASSIVE_CONNECT_TO_VOICE_CHANNEL
     */
    public static final String PASSIVE_CONNECT_TO_VOICE_CHANNEL = create(Permission.PASSIVE_CONNECT_TO_VOICE_CHANNEL);
    /**
     * @see Permission#KEY_TALK_ONLY
     */
    public static final String KEY_TALK_ONLY = create(Permission.KEY_TALK_ONLY);

    private static String create(Permission permission) {
        Permissions permissions = new Permissions(permission.name());
        PERMISSIONS_MAP.put(permission, permissions);
        return permissions.getPermission();
    }

    /**
     * @return Get the string of built-in permissions
     */
    public static String getPermission(Permission permission) {
        if (PERMISSIONS_MAP.containsKey(permission)) {
            return PERMISSIONS_MAP.get(permission).getPermission();
        }
        return null;
    }

    public Collection<Permissions> values() {
        return PERMISSIONS_MAP.values();
    }
}
