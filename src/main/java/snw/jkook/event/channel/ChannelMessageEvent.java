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

package snw.jkook.event.channel;

import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.TextChannelMessage;

import java.util.Objects;

/**
 * 此事件在用户向文字频道成功发送了一条消息时触发。
 */
public class ChannelMessageEvent extends ChannelEvent {


    private final TextChannelMessage message;

    public ChannelMessageEvent(final long timeStamp, final TextChannel channel, final TextChannelMessage message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * 获取与此事件关联的消息对象。
     */
    public TextChannelMessage getMessage() {
        return message;
    }

    @Override
    public TextChannel getChannel() {
        return (TextChannel) super.getChannel();
    }

}
