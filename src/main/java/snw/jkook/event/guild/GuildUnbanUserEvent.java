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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents an event that a guild unbanned some users.
 */
public class GuildUnbanUserEvent extends GuildEvent {

    private final List<User> unbanned;
    private final User operator;

    public GuildUnbanUserEvent(final long timeStamp, final Guild guild, final List<User> unbanned, final User operator) {
        super(timeStamp, guild);
        this.unbanned = Collections.unmodifiableList(Objects.requireNonNull(unbanned));
        this.operator = Objects.requireNonNull(operator);
    }

    /**
     * Get the unbanned user.
     */
    public List<User> getUnbanned() {
        return unbanned;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "GuildUnbanUserEvent{" +
                "timeStamp=" + timeStamp +
                ", unbanned=" + unbanned +
                ", operator=" + operator +
                ", guild=" + getGuild() +
                '}';
    }
}
