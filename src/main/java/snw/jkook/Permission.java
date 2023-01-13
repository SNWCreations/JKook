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

package snw.jkook;

import snw.jkook.entity.channel.TextChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * 此枚举存放了所有的 KOOK 权限值。
 *
 * @see snw.jkook.entity.Role
 */
public enum Permission {

    //// ------ Abilities - 能力 ------ ////

    /**
     * 拥有此权限的成员对服务器有完整的管理权限，包括规避所有其他权限限制（包括通道权限）的能力。<br>
     * 除了不能删服务器，什么都能干。<br>
     * <b>所以它是很危险的。</b>
     */
    ADMIN(1),

    /**
     * 拥有此权限的服务器成员可以修改服务器的名称，更改服务器的语音频道。
     */
    OPERATOR(2),

    /**
     * 拥有此权限的成员可以查看服务器的管理日志。
     */
    ADMIN_LOG(4),

    /**
     * 拥有此权限的成员可以邀请其他人。
     */
    INVITE(8),

    /**
     * 拥有此权限的成员可以管理服务器的现有邀请。
     */
    INVITE_MANAGE(16),

    /**
     * 拥有此权限的成员可以创建、编辑或者删除现有的频道。
     */
    CHANNEL_MANAGE(32),

    /**
     * 拥有此权限的成员可以踢出其他的普通成员。
     */
    KICK(64),

    /**
     * 拥有此权限的成员可以禁止当前服务器中的其他普通成员在当前服务器中活动。
     */
    BAN(128),

    /**
     * 拥有此权限的成员可以管理服务器中上传的自定义表情。
     */
    EMOJI_MANAGE(256),

    /**
     * 拥有此权限的成员可以更改普通成员的昵称。（注：昵称不是用户的名称！用户可以在不同的服务器拥有不同的昵称）
     */
    CHANGE_NICKNAME(512),

    /**
     * 拥有此权限的成员可以更改和他们同等权限成员的昵称。（注：昵称不是用户的名称！用户可以在不同的服务器拥有不同的昵称）
     */
    CHANGE_OTHERS_NICKNAME(67108864),

    /**
     * 拥有此权限的成员可以管理服务器中的角色。
     */
    ROLE_MANAGE(1024),

    /**
     * 拥有此权限的成员可以看到服务器中的频道。
     */
    SEE_CHANNELS(2048),

    /**
     * 拥有此权限的成员可以通过 {@link TextChannel} 发送消息。
     */
    SEND_MESSAGE(4096),

    /**
     * 拥有此权限的成员可以通过 {@link TextChannel} 管理消息。
     */
    MESSAGE_MANAGE(8192),

    /**
     * 拥有此权限的成员可以上传文件。
     */
    UPLOAD_FILE(16384),

    /**
     * 拥有此权限的成员可以连接到语音频道。
     */
    VOICE_LINK(32768),

    /**
     * 拥有此权限的成员可修改频道发言模式，管理频道成员上麦，将频道成员转移至其他频道和提出频道。
     */
    VOICE_MANAGE(65536),

    /**
     * 拥有此权限的成员在没有语音连接权限时，可以被动邀请或被人移动进语音频道。
     */
    PASSIVE_CONNECT_TO_VOICE_CHANNEL(1048576),

    /**
     * 拥有此权限的成员可以在文字频道 @全体成员。
     */
    MENTION_ALL(131072),

    /**
     * 拥有此权限的成员可以给消息添加回应。
     */
    ADD_REACTION(262144),

    /**
     * 拥有此权限的成员可以在其他用户已添加的回应中跟着 +1
     */
    FOLLOW_ADD_REACTION(524288),

    //// ----- Permissions related to voice channels - 与语音频道相关的权限 ----- ////

    /**
     * 没有此权限的成员不能在语音频道中说话。
     */
    TALK(8388608),

    /**
     * 拥有此权限的成员可以在语音频道中播放伴奏。
     */
    PLAY_MUSIC(134217728),

    /**
     * 没有此权限的成员必须通过按指定键在频道上发言（按键由此用户自己配置，默认为 F2）
     */
    FREE_TALK(4194304),

    /**
     * 拥有此权限的成员可以使其他成员在语音频道中听不见其他用户的声音。
     */
    HEAR_NOTHING(16777216),

    /**
     * 拥有此权限的成员可以使其他成员在语音频道中不能说话。
     */
    SPEAK_NOTHING(33554432),

    /**
     * 拥有此权限的成员可以在语音频道中使用屏幕分享。
     */
    SCREEN_SHARE(268435456),

    //// ----- Restrictions - 限制 ----- ////

    /**
     * 没有此权限的成员必须在语音频道中使用按键说话。
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
     * 当 {@code permission} 参数所代表的权限在 {@code rawPermissionSum} 参数的值中被包含时，返回 {@code true} 。
     *
     * @param permission 待检查的权限
     * @param rawPermissionSum 一些权限值的和
     */
    public static boolean hasPermission(Permission permission, int rawPermissionSum) {
        if ((rawPermissionSum & 1) == 1) {
            return true;
        }
        return (rawPermissionSum & permission.getValue()) == permission.getValue();
    }

    /**
     * 返回 {@code permVal} 参数的值所对应的权限枚举对象。
     * 如果你想知道 {@code permVal} 的值是否包含一种权限（不是等于），使用 {@link #hasPermission} 方法。
     *
     * @param permVal 权限值
     */
    public static Permission value(int permVal) {
        return values.get(permVal);
    }
}
