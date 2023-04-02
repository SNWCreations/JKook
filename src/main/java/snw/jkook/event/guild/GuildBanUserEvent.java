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
import snw.jkook.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents an event that a guild banned some users.
 */
public class GuildBanUserEvent extends GuildEvent {

    private final List<User> banned;
    private final User operator;
    private final String reason;

    public GuildBanUserEvent(final long timeStamp, final Guild guild, final List<User> banned, final User operator, String reason) {
        super(timeStamp, guild);
        this.banned = Collections.unmodifiableList(Objects.requireNonNull(banned));
        this.operator = Objects.requireNonNull(operator);
        this.reason = Objects.requireNonNull(reason);
    }

    /**
     * Get the banned users.
     */
    public List<User> getBanned() {
        return banned;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

    /**
     * Get the reason.
     */
    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "GuildBanUserEvent{" +
                "timeStamp=" + timeStamp +
                ", banned=" + banned +
                ", operator=" + operator +
                ", reason='" + reason + '\'' +
                '}';
    }
}
