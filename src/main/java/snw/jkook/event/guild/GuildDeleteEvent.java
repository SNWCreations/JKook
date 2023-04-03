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

package snw.jkook.event.guild;

import snw.jkook.entity.Guild;

/**
 * Represents an event that means a guild was deleted.
 */
public class GuildDeleteEvent extends GuildEvent {

    private final String guildId;

    public GuildDeleteEvent(final long timeStamp, String guildId) {
        super(timeStamp, null);
        this.guildId = guildId;
    }

    /**
     * Get the guild related to this event.
     *
     * @deprecated Because of the guild was deleted, so we can't construct the instance of guild. Use {@link #getGuildId()} instead.
     */
    @Deprecated
    @Override
    public Guild getGuild() {
        throw new UnsupportedOperationException("Use GuildDeleteEvent#getGuildId instead");
    }

    /**
     * Get the ID of the deleted guild.
     */
    public String getGuildId() {
        return guildId;
    }

    @Override
    public String toString() {
        return "GuildDeleteEvent{" +
                "timeStamp=" + timeStamp +
                ", guildId='" + guildId + '\'' +
                '}';
    }
}
