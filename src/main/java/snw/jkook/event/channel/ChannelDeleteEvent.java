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

package snw.jkook.event.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;

import java.util.Objects;

/**
 * Represents an event related to an operator deleted a channel.
 */
public class ChannelDeleteEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();
    private final String channelId;

    private final User operator;

    // please always provide null to channel argument.
    // Because some situations (e.g. we know this channel first time), we can't provide the channel instance.
    public ChannelDeleteEvent(final long timeStamp, final String channelId, final User operator) {
        super(timeStamp, null);
        this.operator = Objects.requireNonNull(operator);
        this.channelId = Objects.requireNonNull(channelId);
    }

    /**
     * Get the ID of the deleted channel.
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Get the channel related to this event. <p>
     * <b>DO NOT USE THIS METHOD</b>. <p>
     * Because in some situations (e.g. We know this channel for first time), we can't provide this.
     *
     * @return Always <code>null</code>
     */
    @Deprecated
    @Override
    public Channel getChannel() {
        return null;
    }

    /**
     * Get the operator.
     */
    public User getOperator() {
        return operator;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
