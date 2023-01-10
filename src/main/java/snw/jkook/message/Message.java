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

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.ReactionHolder;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.MarkdownComponent;
import snw.jkook.message.component.card.CardComponent;
import snw.jkook.message.component.card.MultipleCardComponent;
import snw.jkook.util.RequirePermission;

/**
 * 表示一条消息。
 */
public interface Message extends Receivable, ReactionHolder {

    /**
     * 获取此消息中包含的消息组件。
     */
    BaseComponent getComponent();

    /**
     * 更新此消息中包含的消息组件。<br>
     * 目前仅支持包含了 {@link MarkdownComponent} 或卡片（{@link CardComponent} 和 {@link MultipleCardComponent}）的消息。
     *
     * @param component 新的消息组件
     */
    void setComponent(BaseComponent component);

    /**
     * 获取此消息的 ID 。
     */
    String getId();

    /**
     * 获取被此消息回复的消息。<br>
     * <b>注意！</b>在此方法的返回值中，只有下列方法是安全的：
     * <ul>
     *     <li>{@link #getComponent()}</li>
     *     <li>{@link #getId()}</li>
     *     <li>{@link #getSender()}</li>
     *     <li>{@link #getTimeStamp()}</li>
     * </ul>
     * 其他方法的行为是<b>不确定</b>的。也许它们会抛出异常？或者提供不正确的结果？
     */
    @Nullable
    Message getQuote();

    /**
     * 发送一个消息组件作为此消息的回复。<br>
     * 当消息来源是用户时，调用此方法等同于 {@code this.getSender().sendPrivateMessage(component, this)} 。<br>
     * 当消息来源是文字频道时（即此对象是 {@link TextChannelMessage} 的实例时），
     * 调用此方法等同于 {@code ((TextChannelMessage) this).getChannel().sendComponent(component, this, null)} 。
     *
     * @param message 消息组件
     * @return        新消息的 ID
     */
    String reply(String message);

    /**
     * 发送一个消息组件到此消息的来源。<br>
     * <b>它不同于 {@link #reply}</b>。<br>
     * 当消息来源是用户时，调用此方法等同于 {@code this.getSender().sendPrivateMessage(component)} 。<br>
     * 当消息来源是文字频道时（即此对象是 {@link TextChannelMessage} 的实例时），
     * 调用此方法等同于 {@code ((TextChannelMessage) this).getChannel().sendComponent(component, null, null)} 。
     *
     * @param message 消息组件
     * @return        新消息的 ID
     */
    String sendToSource(String message);

    /**
     * 发送一个消息组件作为此消息的回复。<br>
     * 当消息来源是用户时，调用此方法等同于 {@code this.getSender().sendPrivateMessage(component, this)} 。<br>
     * 当消息来源是文字频道时（即此对象是 {@link TextChannelMessage} 的实例时），
     * 调用此方法等同于 {@code ((TextChannelMessage) this).getChannel().sendComponent(component, this, null)} 。
     *
     * @param component   消息组件
     * @return            新消息的 ID
     */
    String reply(BaseComponent component);

    /**
     * 发送一个消息组件到此消息的来源。<br>
     * <b>它不同于 {@link #reply}</b>。<br>
     * 当消息来源是用户时，调用此方法等同于 {@code this.getSender().sendPrivateMessage(component)} 。<br>
     * 当消息来源是文字频道时（即此对象是 {@link TextChannelMessage} 的实例时），
     * 调用此方法等同于 {@code ((TextChannelMessage) this).getChannel().sendComponent(component, null, null)} 。
     *
     * @param component   消息组件
     * @return            新消息的 ID
     */
    String sendToSource(BaseComponent component);

    /**
     * 删除此消息。
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
