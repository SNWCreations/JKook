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

package snw.jkook.message;

import snw.jkook.Permission;
import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.MarkdownComponent;
import snw.jkook.message.component.card.CardComponent;
import snw.jkook.message.component.card.MultipleCardComponent;
import snw.jkook.util.RequirePermission;

/**
 * 表示一条来自文字频道的消息。
 */
public interface TextChannelMessage extends Message {

    /**
     * 获取此消息所在的频道。
     */
    TextChannel getChannel();

    /**
     * Send a component <b>as the reply</b> of this message,
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String replyTemp(String message);

    /**
     * Send a component to the source of this message (e.g. a user, a text channel),
     * <b>IT IS DIFFERENT FROM {@link #replyTemp}</b>.
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String sendToSourceTemp(String message);

    /**
     * 发送一个消息组件作为此消息的回复。<br>
     * 但是发送的内容不会保存在 KOOK 的数据库中，且只有发送了此消息的用户才能看见。<br>
     * 发送的内容会在发送了此消息的用户重启 KOOK 客户端后消失。
     *
     * @param component   消息组件
     * @return            消息 ID
     */
    String replyTemp(BaseComponent component);

    /**
     * 发送一个消息组件到此消息的来源。<br>
     * <b>它不同于 {@link #replyTemp}</b>。<br>
     * 发送的内容不会保存在 KOOK 的数据库中，且只有发送了此消息的用户才能看见。<br>
     * 发送的内容会在发送了此消息的用户重启 KOOK 客户端后消失。
     *
     * @param component   消息组件
     * @return            消息 ID
     */
    String sendToSourceTemp(BaseComponent component);

    /**
     * 使用指定的消息组件临时更新此消息，但只有通过参数指定的用户才能看见新的消息组件。<br>
     * 目前仅支持包含了 {@link MarkdownComponent} 或卡片（{@link CardComponent} 和 {@link MultipleCardComponent}）的消息。<br>
     * 更新的内容不会保存在 KOOK 的数据库中。<br>
     * 更新的内容会在发送了此消息的用户重启 KOOK 客户端后消失，此消息会还原为它发出去时的样子。
     *
     * @param user 将会看到新的消息组件的用户
     * @param component 消息组件
     */
    void setComponentTemp(User user, BaseComponent component);

    /**
     * Remove a reaction that added by the specified user.
     *
     * @param emoji The emoji of the reaction
     * @param user The user as the reaction's creator
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void removeReaction(CustomEmoji emoji, User user);

}
