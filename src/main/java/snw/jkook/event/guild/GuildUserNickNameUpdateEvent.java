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

/**
 * 此事件会在某位用户于某个服务器中的昵称被修改时触发。
 */
public class GuildUserNickNameUpdateEvent extends GuildEvent {

    private final User user;
    private final String newNickName;

    public GuildUserNickNameUpdateEvent(long timeStamp, Guild guild, User user, String newNickName) {
        super(timeStamp, guild);
        this.user = user;
        this.newNickName = newNickName;
    }

    /**
     * 获取与此事件关联的用户对象。
     */
    public User getUser() {
        return user;
    }

    /**
     * 获取受影响的用户的新昵称。
     */
    public String getNewNickName() {
        return newNickName;
    }

}
