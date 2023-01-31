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

import snw.jkook.entity.User;

/**
 * 此事件在一个用户上线时触发。<br>
 * <b>在一些用户量极大的服务器中，这可能是一个容易高频发布的事件。</b> <br>
 * 这个事件提供给你的前提是你的机器人在这个用户已加入的任意一个服务器中。
 */
public class UserOnlineEvent extends UserEvent {

    public UserOnlineEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

}
