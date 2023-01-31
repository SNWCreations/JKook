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
 * 此事件在一个服务器已被其所有者删除时触发。
 */
public class GuildDeleteEvent extends GuildEvent {

    private final String guildId;

    public GuildDeleteEvent(final long timeStamp, String guildId) {
        super(timeStamp, null);
        this.guildId = guildId;
    }

    /**
     * <b>不要使用这个方法。</b>
     *
     * @deprecated 在此事件发生时，对应服务器的信息就已经不可用了。使用 {@link #getGuildId()} 以获取本次事件发生后被删除的服务器的 ID 。
     */
    @Deprecated
    @Override
    public Guild getGuild() {
        throw new UnsupportedOperationException("Use GuildDeleteEvent#getGuildId instead");
    }

    /**
     * 获取本次事件发生后已被删除的服务器的 ID 。
     */
    public String getGuildId() {
        return guildId;
    }
}
