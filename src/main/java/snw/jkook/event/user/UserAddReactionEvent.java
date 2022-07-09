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

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;
import snw.jkook.message.Message;

import java.util.Objects;

/**
 * Represents an event related to a user added a reaction to a message.
 */
public class UserAddReactionEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Message message;
    private final CustomEmoji emoji;

    public UserAddReactionEvent(final long timeStamp, final User user, final Message message, final CustomEmoji emoji) {
        super(timeStamp, user);
        this.message = Objects.requireNonNull(message);
        this.emoji = Objects.requireNonNull(emoji);
    }

    /**
     * Get the message related to this event.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Get the emoji that the user added.
     */
    public CustomEmoji getEmoji() {
        return emoji;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
