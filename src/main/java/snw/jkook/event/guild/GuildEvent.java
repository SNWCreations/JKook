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
import snw.jkook.event.TimedEvent;

/**
 * 表示一个与 {@link Guild} 有关的事件。
 */
public abstract class GuildEvent extends TimedEvent {
    private final Guild guild;

    GuildEvent(final long timeStamp, final Guild guild) {
        super(timeStamp);
        this.guild = guild;
    }

    /**
     * 获取与此事件关联的服务器对象。
     */
    public Guild getGuild() {
        return guild;
    }

}
