/*
 * Copyright 2022 JKook contributors
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
import snw.jkook.event.HandlerList;
import snw.jkook.message.Message;

import java.util.Objects;

/**
 * Represents an event related to a user removed a reaction to a message.
 */
public class UserRemoveReactionEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;
    private final Reaction reaction;

    public UserRemoveReactionEvent(final long timeStamp, final User user, final Message message, final Reaction reaction) {
        super(timeStamp, user);
        this.message = Objects.requireNonNull(message);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Get the reaction that the user removed.
     */
    public Reaction getReaction() {
        return reaction;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
