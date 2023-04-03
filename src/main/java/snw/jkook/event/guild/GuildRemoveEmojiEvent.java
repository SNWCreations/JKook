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

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Guild;

/**
 * Represents the event that means an emoji was removed from a guild.
 */
public class GuildRemoveEmojiEvent extends GuildEvent {
    private final CustomEmoji emoji;

    public GuildRemoveEmojiEvent(long timeStamp, Guild guild, CustomEmoji emoji) {
        super(timeStamp, guild);
        this.emoji = emoji;
    }

    /**
     * Get the emoji that related to this event.
     */
    public CustomEmoji getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return "GuildRemoveEmojiEvent{" +
                "timeStamp=" + timeStamp +
                ", emoji=" + emoji +
                ", guild=" + getGuild() +
                '}';
    }
}
