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

import snw.jkook.entity.Reaction;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 此事件在某位用户移除了一个回应时触发。<br>
 * 这个事件提供给你的前提是你的机器人在这个消息所在的服务器中。
 */
public class UserRemoveReactionEvent extends UserEvent {

    private final String messageId;
    private final Reaction reaction;

    public UserRemoveReactionEvent(final long timeStamp, final User user, final String messageId, final Reaction reaction) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * 获取与此事件关联的消息 ID 。
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取回应信息对象。
     */
    public Reaction getReaction() {
        return reaction;
    }

}
