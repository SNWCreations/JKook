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

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * Represents an event that means a user left the guild.
 */
public class UserLeaveGuildEvent extends UserEvent {

    private final Guild guild;
    private final String guildId;

    public UserLeaveGuildEvent(final long timeStamp, final User user, final Guild guild) {
        super(timeStamp, user);
        this.guild = Objects.requireNonNull(guild);
        this.guildId = guild.getId();
    }

    /*
     * Just prepared for the situation which is noticed in the Javadoc of getGuild method.
     * You won't need it normally.
     */
    public UserLeaveGuildEvent(long timeStamp, User user, String guildId) {
        super(timeStamp, user);
        this.guild = null;
        this.guildId = guildId;
    }

    /**
     * Get the guild which the user left. <br>
     * <b>Tips:</b> If this method returns null, it means that you can't access this guild anymore
     *  and we can't provide guild instance for you because it is known for the first time. <br>
     * This situation always happens if the user which is related to this event is the Bot user in this VM,
     *  at this time, because we has already left the guild, we can't get guild information through the
     *   HTTP API.
     */
    @Nullable
    public Guild getGuild() {
        return guild;
    }

    public String getGuildId() {
        return guildId;
    }

    @Override
    public String toString() {
        return "UserLeaveGuildEvent{" +
                "timeStamp=" + timeStamp +
                ", guild=" + guild +
                ", user=" + getUser() +
                '}';
    }
}
