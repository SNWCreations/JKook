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

package snw.jkook.event.user;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.TextChannel;

import java.util.Objects;

/**
 * Represents the event that means a user clicked a button in a message.
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
     * Get the message related to the button.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Get the returned value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the channel on which the button is clicked. <p>
     * Null is returned if user clicked this button in private chat session.
     */
    @Nullable
    public TextChannel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "UserClickButtonEvent{" +
                "timeStamp=" + timeStamp +
                ", messageId='" + messageId + '\'' +
                ", value='" + value + '\'' +
                ", channel=" + channel +
                ", user=" + getUser() +
                '}';
    }
}
