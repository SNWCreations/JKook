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
 * 表示一个用户。
 */
public interface User extends Nameable, AvatarHolder, CommandSender {

    /**
     * 获取此用户的 ID 。
     */
    String getId();

    /**
     * 获取此用户在指定服务器中的昵称。
     *
     * @param guild 指定的服务器
     */
    String getNickName(Guild guild);

    /**
     * 获取此用户的完整名称。格式为: 昵称#认证数字。<br>
     * 若指定了 {@code guild} ，昵称将使用服务器昵称，而不是 {@link #getName()} 的结果。
     *
     * @param guild 提供昵称的服务器
     * @see #getName()
     * @see #getNickName(Guild)
     * @see #getIdentifyNumber()
     */
    String getFullName(@Nullable Guild guild);

    /**
     * 设置此用户在指定服务器中的昵称。<br>
     * 若此用户为自己，则不需要 {@link Permission#CHANGE_OTHERS_NICKNAME} 权限，但需要 {@link Permission#CHANGE_NICKNAME} 权限。
     *
     * @param guild 指定的服务器
     * @param name  新昵称
     */
    @RequirePermission({Permission.CHANGE_NICKNAME, Permission.CHANGE_OTHERS_NICKNAME})
    void setNickName(Guild guild, String name);

    /**
     * 返回此用户的"认证数字"。它是可变的。
     *
     * @see #getFullName(Guild)
     */
    int getIdentifyNumber();

    /**
     * 若此用户当前正在享用 KOOK BUFF ，则此方法返回 {@code true} 。
     */
    boolean isVip();

    /**
     * 若此用户是一个机器人，则此方法返回 {@code true} 。
     */
    boolean isBot();

    /**
     * 若此用户当前在线，则此方法返回 {@code true} 。
     */
    boolean isOnline();

    /**
     * 若此用户当前已被 KOOK 官方封禁，则此方法返回 {@code true} 。
     */
    boolean isBanned();

    /**
     * 获取此用户在指定服务器中拥有的所有角色的 ID 。
     *
     * @param guild 指定的服务器
     */
    Collection<Integer> getRoles(Guild guild);

    /**
     * 向此用户发送一条私信。
     *
     * @param message 消息内容
     * @return 新消息的 ID
     */
    String sendPrivateMessage(String message);

    /**
     * 向此用户发送一条私信。
     *
     * @param message 消息内容
     * @param quote   若传入了，则新的消息将被看作是指定消息的回复
     * @return 新消息的 ID
     */
    String sendPrivateMessage(String message, PrivateMessage quote);

    /**
     * Send a component to this user.
     *
     * @param component 消息内容
     * @return 新消息的 ID
     */
    String sendPrivateMessage(BaseComponent component);

    /**
     * Send a component to this user.
     *
     * @param component 消息内容
     * @param quote   若传入了，则新的消息将被看作是指定消息的回复
     * @return 新消息的 ID
     */
    String sendPrivateMessage(BaseComponent component, PrivateMessage quote);

    /**
     * 获取用户当前加入的语音频道。<br>
     *
     * 为什么此方法返回一个 {@code PageIterator<Collection<VoiceChannel>>} ？<br>
     * KOOK 有计划在未来支持机器人在多个语音频道中推流，并且当前的 KOOK API 返回的数据是数组。
     *
     * @param guild 指定的服务器
     * @return 此用户当前已加入的语音频道
     */
    PageIterator<Collection<VoiceChannel>> getJoinedVoiceChannel(Guild guild);

    /**
     * 获取当前用户与机器人的亲密度。
     */
    int getIntimacy();

    /**
     * 获取当前用户与机器人的亲密度信息。
     */
    IntimacyInfo getIntimacyInfo();

    /**
     * 设置当前用户与机器人的亲密度。
     *
     * @param intimacy 亲密度
     */
    void setIntimacy(int intimacy);

    /**
     * 设置当前用户与机器人的"社交信息"。
     *
     * @param intimacy 亲密度
     * @param socialInfo 见 {@link User.IntimacyInfo#getSocialInfo()}
     * @param socialImageID 见 {@link User.IntimacyInfo.SocialImage#getId()}
     */
    void setIntimacy(int intimacy, String socialInfo, @Nullable Integer socialImageID);

    /**
     * 将指定的角色授予此用户。
     *
     * @param role 将授予的角色
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Role role);

    /**
     * 将指定的角色从此用户身上移除。
     *
     * @param role 将移除的角色
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Role role);

    /**
     * 将指定的角色授予此用户。
     *
     * @param guild 将授予的角色所在的服务器
     * @param roleId 将授予的角色的 ID
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void grantRole(Guild guild, int roleId);

    /**
     * 将指定的角色从此用户身上移除。
     *
     * @param guild 将移除的角色所在的服务器
     * @param roleId 将移除的角色
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void revokeRole(Guild guild, int roleId);

    /**
     * 表示用户与机器人的亲密度信息。<br>
     * <b>这只是一个快照，请不要保存它。</b>
     */
    interface IntimacyInfo {

        /**
         * 获取当前展示给用户的形象图片的 URL 。
         */
        String getSocialImage();

        /**
         * 获取当前展示给用户的社交信息。
         */
        String getSocialInfo();

        /**
         * 获取用户上一次查看社交消息的时间戳。
         */
        int getLastRead();

        /**
         * @see #getIntimacy()
         */
        int getScore();

        /**
         * 获取当前可用的所有形象图片信息。
         */
        Collection<SocialImage> getSocialImages();

        /**
         * 表示一个形象图片。
         */
        interface SocialImage {

            /**
             * 获取此形象图片的 ID 。
             */
            String getId();

            /**
             * 获取此形象图片的 URL 地址。
             */
            String getUrl();
        }
    }
}
