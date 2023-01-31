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
 * 表示一个服务器。
 */
public interface Guild extends Nameable, AvatarHolder, MasterHolder, InviteHolder {

    /**
     * 获取此服务器的 ID 。
     */
    String getId();

    /**
     * 获取此服务器的所有用户。
     */
    PageIterator<Set<User>> getUsers();

    /**
     * 获取此服务器的用户对象。<br>
     * 此方法提供更多的搜索条件。
     *
     * @param keyword 根据关键字筛选，这个参数用于从所有用户的用户名以及昵称中匹配
     * @param roleId 根据用户已有的角色筛选，见 {@link Role#getId()}
     * @param isMobileVerified 根据用户的手机号是否已验证筛选
     * @param isActiveTimeFirst 根据活跃时间排序，<code>true</code> 为正序(活跃的在前), <code>false</code> 为倒序
     * @param isJoinedTimeFirst 根据加入服务器的时间排序，<code>true</code> 为正序(活跃的在前), <code>false</code> 为倒序
     */
    PageIterator<Set<User>> getUsers(
            String keyword,
            @Nullable Integer roleId,
            @Nullable Boolean isMobileVerified,
            @Nullable Boolean isActiveTimeFirst,
            @Nullable Boolean isJoinedTimeFirst
    );

    /**
     * 获取此服务器中的所有频道。
     */
    PageIterator<Set<Channel>> getChannels();

    /**
     * 获取此服务器中的所有角色。
     */
    PageIterator<Set<Role>> getRoles();

    /**
     * 获取此服务器使用的语音服务器的所在地区代号。
     */
    String getVoiceChannelServerRegion();

    /**
     * 获取此服务器中的所有表情。
     */
    PageIterator<Set<CustomEmoji>> getCustomEmojis();

    /**
     * 获取此服务器的在线用户数。
     */
    int getOnlineUserCount();

    /**
     * 获取此服务器的总用户数。
     */
    int getUserCount();

    /**
     * 若此服务器为公开服务器，此方法返回 {@code true} 。
     */
    boolean isPublic();

    /**
     * 获取此服务器中用户的闭麦/静音情况。
     */
    MuteResult getMuteStatus();

    /**
     * 离开此服务器。<b>此操作不可逆。</b>
     */
    void leave();

    /**
     * 将指定的用户加入此服务器的黑名单。
     *
     * @param user           将被封禁的用户
     * @param reason         封禁理由
     * @param delMessageDays 删除最近几天的消息，最大 7 天, 默认 0 天 (不删除)
     */
    @RequirePermission(Permission.BAN)
    void ban(User user, @Nullable String reason, int delMessageDays);

    /**
     * 将指定的用户从此服务器的黑名单移除。
     *
     * @param user 将被封禁的用户
     */
    @RequirePermission(Permission.BAN)
    void unban(User user);

    /**
     * 将指定的用户从此服务器踢出。<br>
     * 若指定的用户拿到了一个指向此服务器的邀请链接，TA 仍然可以通过邀请链接再次加入此服务器。<br>
     * 因此，若需要<b>封禁</b> TA ，而不是简单的踢出，请使用 {@link #ban(User, String, int)} 方法。
     *
     * @param user 将被踢出的用户
     */
    @RequirePermission(Permission.KICK)
    void kick(User user);

    /**
     * 使用提供的信息在此服务器中新建一个文字频道。
     *
     * @param name 新频道的名称
     * @param parent 传入时，将新频道视作提供的分组的子频道
     * @return 频道对象
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    TextChannel createTextChannel(String name, @Nullable Category parent);

    /**
     * 使用提供的信息在此服务器中新建一个语音频道。
     *
     * @param name 新频道的名称
     * @param parent 传入时，将新频道视作提供的分组的子频道
     * @param size 语音频道人数限制，最大 99 ，传 0 时意味着不作限制
     * @param quality 语音音质等级，默认为 2，1 流畅，2 正常，3 高质量
     * @return 频道对象
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    VoiceChannel createVoiceChannel(
            String name,
            @Nullable Category parent,
            @Range(from = 0, to = 99) int size,
            @Range(from = 1, to = 3) int quality
    );

    /**
     * 使用提供的信息在此服务器中新建一个分组。
     *
     * @param name 新分组的名称
     * @return 分组对象
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    Category createCategory(String name);

    /**
     * 使用提供的信息在此服务器中新建一个角色。
     *
     * @param name 新角色的名称
     * @return 角色对象
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    Role createRole(String name);

    /**
     * 向此服务器上传一个表情。
     *
     * @param binary 表情的二进制数据字符串。此方法仅支持 PNG 。图像大小不可以大于 512 KB 。
     *               <b>在创建二进制数据字符串时使用 {@link java.nio.charset.StandardCharsets#ISO_8859_1} 编码，
     *               而不是默认字符集。</b>
     * @param name 新表情的名称，若不传，则由 KOOK 随机生成。若传了，则传入的字符串长度必须大于等于 2 。
     * @return 表情对象
     * @deprecated 不应该使用 {@link String} 表示二进制数据。并且此方法仅支持 PNG 。
     *             请使用 {@link #uploadEmoji(byte[], String, String)} 。
     */
    @Deprecated
    @RequirePermission(Permission.EMOJI_MANAGE)
    CustomEmoji uploadEmoji(String binary, @Nullable String name);

    /**
     * 向此服务器上传一个表情。
     *
     * @param binary 表情的二进制数据。图像大小不可以大于 512 KB
     * @param type 表情的文件类型。仅支持 PNG，JPG，JPEG，GIF(需要此服务器已有助力并达到至少 1 级)，例如 "image/png"
     * @param name 新表情的名称，若不传，则由 KOOK 随机生成。若传了，则传入的字符串长度必须大于等于 2 。
     * @return 表情对象
     * @throws IllegalArgumentException 当文件类型无效时，或传入的表情名称长度小于 2 时抛出
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    CustomEmoji uploadEmoji(byte[] binary, String type, @Nullable String name)
            throws IllegalArgumentException;

    /**
     * 获取在此服务器黑名单中的所有用户。
     */
    PageIterator<Set<User>> getBannedUsers();

    /**
     * 获取用户接收来自此服务器的消息提醒的设置。
     */
    NotifyType getNotifyType();

    /**
     * 获取此服务器图标的 URL 。
     *
     * @param vip 此参数在这里不可用
     * @return 服务器图标的 URL
     * @throws IllegalArgumentException 当 {@code vip} 参数为 {@code true} 时抛出，因为 {@code vip} 参数在此方法中不可用
     */
    @Override
    String getAvatarUrl(boolean vip) throws IllegalArgumentException;

    /**
     * 获取在指定时间区间中的所有助力记录。
     * <b>此方法中使用的时间戳以秒为单位。</b>
     * 
     * @param start 区间的开始
     * @param end 区间的结束
     * @throws IllegalArgumentException 当 {@code start} 参数的值比 {@code end} 参数的值大时，或者两者中有一个为负数时抛出
     */
    @RequirePermission(Permission.OPERATOR)
    Collection<BoostInfo> getBoostInfo(int start, int end) throws IllegalArgumentException;

    /**
     * @see #getNotifyType()
     */
    enum NotifyType {

        /**
         * 使用服务器的默认设置。
         */
        DEFAULT(0),

        /**
         * 总是提醒。
         */
        ALL(1),

        /**
         * 仅在被 @ 时提醒。
         */
        MENTION_ONLY(2),

        /**
         * 从不提醒。
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
         * 获取提供的值对应的枚举对象。
         *
         * @param value The value
         */
        public static NotifyType value(int value) {
            return values.get(value);
        }
    }

    /**
     * 表示服务器助力的信息。
     */
    interface BoostInfo {

        /**
         * 获取执行了此次助力的用户对象。
         */
        User getBooster();

        /**
         * 获取此次助力生效时的时间戳。<br>
         * <b>时间戳以秒为单位。</b>
         */
        int getStartTime();

        /**
         * 获取此次助力将失效时的时间戳。<br>
         * <b>时间戳以秒为单位。</b>
         */
        int getEndTime();
    }
}
