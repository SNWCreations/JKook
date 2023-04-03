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

import snw.jkook.entity.User;

/**
 * Represents an event that means a user's information (nickname, avatar) was updated. <p>
 * To get new information, use methods in {@link User} interface. <p>
 * <b>This event will be fired only the one of the following condition is true:</b>
 * <ul>
 * <li>The user have chat sessions with the Bot.</li>
 * <li>The user is the friend of the Bot.</li>
 * </ul>
 */
public class UserInfoUpdateEvent extends UserEvent {

    public UserInfoUpdateEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

    @Override
    public String toString() {
        return "UserInfoUpdateEvent{" +
                "timeStamp=" + timeStamp +
                ", user=" + getUser() +
                '}';
    }
}
