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
import snw.jkook.entity.channel.VoiceChannel;

import java.util.Objects;

/**
 * Represents an event that means a user joined a voice channel.
 */
public class UserJoinVoiceChannelEvent extends UserEvent {

    private final VoiceChannel channel;

    public UserJoinVoiceChannelEvent(final long timeStamp, final User user, final VoiceChannel channel) {
        super(timeStamp, user);
        this.channel = Objects.requireNonNull(channel);
    }

    /**
     * Get the voice channel related to this event.
     */
    public VoiceChannel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "UserJoinVoiceChannelEvent{" +
                "timeStamp=" + timeStamp +
                ", channel=" + channel +
                '}';
    }
}
