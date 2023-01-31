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

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 此事件在用户离开一个服务器时触发。<br>
 * 此事件提供给你的前提是你的机器人在用户新加入的服务器。
 */
public class UserLeaveGuildEvent extends UserEvent {

    private final Guild guild;

    public UserLeaveGuildEvent(final long timeStamp, final User user, final Guild guild) {
        super(timeStamp, user);
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * 获取用户离开的服务器。
     */
    public Guild getGuild() {
        return guild;
    }

}
