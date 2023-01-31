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

package snw.jkook.event.user;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.TextChannel;

import java.util.Objects;

/**
 * 此事件在用户点击了一个按钮时触发。
 */
public class UserClickButtonEvent extends UserEvent {

    private final String messageId;
    private final String value;
    private final TextChannel channel;

    public UserClickButtonEvent(final long timeStamp, final User user, final String messageId, final String value, TextChannel channel) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.value = Objects.requireNonNull(value);
        this.channel = channel;
    }

    /**
     * 获取按钮所在的消息的 ID 。
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取按钮返回的值。
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取按钮所在的频道。<br>
     * 若此事件在私信中触发，此方法将返回 {@code null} 。
     */
    @Nullable
    public TextChannel getChannel() {
        return channel;
    }

}
