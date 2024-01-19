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

import snw.jkook.entity.Reaction;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * Represents an event that means a user removed a reaction to a message.
 */
public class UserRemoveReactionEvent extends UserEvent {

    private final String messageId;
    private final Reaction reaction;

    public UserRemoveReactionEvent(final long timeStamp, final User user, final String messageId, final Reaction reaction) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * Get the message related to this event.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Get the reaction that the user removed.
     */
    public Reaction getReaction() {
        return reaction;
    }

    @Override
    public String toString() {
        return "UserRemoveReactionEvent{" +
                "timeStamp=" + timeStamp +
                ", messageId='" + messageId + '\'' +
                ", reaction=" + reaction +
                ", user=" + getUser() +
                '}';
    }
}
