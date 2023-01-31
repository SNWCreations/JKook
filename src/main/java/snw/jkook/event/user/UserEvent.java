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
import snw.jkook.event.TimedEvent;

import java.util.Objects;

/**
 * 表示一个与 {@link User} 有关的事件。
 */
public abstract class UserEvent extends TimedEvent {
    private final User user;

    UserEvent(final long timeStamp, final User user) {
        super(timeStamp);
        this.user = Objects.requireNonNull(user);
    }

    /**
     * 获取与此事件关联的用户对象。
     */
    public User getUser() {
        return user;
    }
}
