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

package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

/**
 * Represents an event that means a user's nickname was updated.
 */
public class GuildUserNickNameUpdateEvent extends GuildEvent {

    private final User user;
    private final String newNickName;

    public GuildUserNickNameUpdateEvent(long timeStamp, Guild guild, User user, String newNickName) {
        super(timeStamp, guild);
        this.user = user;
        this.newNickName = newNickName;
    }

    /**
     * Get the user that related to this event.
     */
    public User getUser() {
        return user;
    }

    /**
     * Get the new nickname of the user.
     */
    public String getNewNickName() {
        return newNickName;
    }

    @Override
    public String toString() {
        return "GuildUserNickNameUpdateEvent{" +
                "timeStamp=" + timeStamp +
                ", user=" + user +
                ", newNickName='" + newNickName + '\'' +
                ", guild=" + getGuild() +
                '}';
    }
}
