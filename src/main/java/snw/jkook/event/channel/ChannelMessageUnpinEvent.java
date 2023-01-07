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

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;

/**
 * Represents an event that means a message was unpinned.
 */
public class ChannelMessageUnpinEvent extends ChannelEvent {


    private final String messageId;
    private final User operator;

    public ChannelMessageUnpinEvent(final long timeStamp, final Channel channel, final String messageId, User operator) {
        super(timeStamp, channel);
        this.messageId = messageId;
        this.operator = operator;
    }

    /**
     * Get the ID of the message that related to this event.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

}
