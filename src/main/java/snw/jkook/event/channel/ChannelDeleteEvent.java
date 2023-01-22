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

package snw.jkook.event.channel;

import org.jetbrains.annotations.Contract;
import snw.jkook.entity.Guild;
import snw.jkook.entity.channel.Channel;

import java.util.Objects;

/**
 * Represents an event that means an operator deleted a channel.
 */
public class ChannelDeleteEvent extends ChannelEvent {
    private final String channelId;
    private final Guild guild;

    public ChannelDeleteEvent(final long timeStamp, final String channelId, Guild guild) {
        super(timeStamp, null);
        this.channelId = Objects.requireNonNull(channelId);
        this.guild = guild;
    }

    /**
     * Get the ID of the deleted channel.
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Get the guild that related to this event.
     */
    public Guild getGuild() {
        return guild;
    }

    /**
     * Get the channel related to this event. <p>
     * <b>DO NOT USE THIS METHOD</b>. <p>
     * Because in some situations (e.g. We know this channel for first time), we can't provide this.
     */
    @Deprecated
    @Override
    @Contract("-> fail")
    public Channel getChannel() {
        throw new UnsupportedOperationException("No channel available for ChannelDeleteEvent!");
    }

}
