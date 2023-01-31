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
 * 此事件在频道被删除时触发。
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
     * 获取被删除的频道的 ID 。
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 获取被删除的频道所在的服务器。
     */
    public Guild getGuild() {
        return guild;
    }

    /**
     * <b>不要使用这个方法。</b>
     */
    @Deprecated
    @Override
    @Contract("-> fail")
    public Channel getChannel() {
        throw new UnsupportedOperationException("No channel available for ChannelDeleteEvent!");
    }

}
