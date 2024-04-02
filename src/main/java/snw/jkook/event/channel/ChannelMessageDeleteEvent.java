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

package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;

/**
 * Represents the event that means a message in a channel was deleted.
 */
public class ChannelMessageDeleteEvent extends ChannelEvent {

    private final String messageId;

    public ChannelMessageDeleteEvent(long timeStamp, Channel channel, String messageId) {
        super(timeStamp, channel);
        this.messageId = messageId;
    }

    /**
     * Get the ID of the deleted message.
     */
    public String getMessageId() {
        return messageId;
    }

    @Override
    public String toString() {
        return "ChannelMessageDeleteEvent{" +
                "timeStamp=" + timeStamp +
                ", messageId='" + messageId + '\'' +
                ", channel=" + getChannel() +
                '}';
    }
}
