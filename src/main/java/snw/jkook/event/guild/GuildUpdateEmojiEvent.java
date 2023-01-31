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
 * 此事件在服务器更新了表情信息时（如修改了表情的名称）触发。
 */
public class GuildUpdateEmojiEvent extends GuildEvent {
    private final CustomEmoji emoji;

    public GuildUpdateEmojiEvent(long timeStamp, Guild guild, CustomEmoji emoji) {
        super(timeStamp, guild);
        this.emoji = emoji;
    }

    /**
     * 获取与此事件关联的表情对象。
     */
    public CustomEmoji getEmoji() {
        return emoji;
    }
}
