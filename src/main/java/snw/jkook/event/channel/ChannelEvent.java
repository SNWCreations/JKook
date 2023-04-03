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

import snw.jkook.entity.channel.Channel;
import snw.jkook.event.TimedEvent;

/**
 * Represents an event related to a {@link Channel}.
 */
public abstract class ChannelEvent extends TimedEvent {
    private final Channel channel;

    ChannelEvent(final long timeStamp, final Channel channel) {
        super(timeStamp);
        this.channel = channel;
    }

    /**
     * Get the channel related to this event.
     */
    public Channel getChannel() {
        return channel;
    }

}
