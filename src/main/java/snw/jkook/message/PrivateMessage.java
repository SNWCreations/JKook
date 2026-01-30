/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.message;

import org.jetbrains.annotations.Nullable;
import snw.jkook.message.component.BaseComponent;

/**
 * Represents a private message.
 */
public interface PrivateMessage extends Message {

    /**
     * Set the component that stored by this message.
     *
     * @param component  The component
     * @param quote      The msgId to quote. Pass empty string to remove quote, pass null to keep unchanged.
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     */
    void setComponent(BaseComponent component, @Nullable String quote, @Nullable String replyMsgId);

    /**
     * Set the content that stored by this message.
     *
     * @param content    The new content
     * @param quote      The msgId to quote. Pass empty string to remove quote, pass null to keep unchanged.
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     */
    void setComponent(String content, @Nullable String quote, @Nullable String replyMsgId);
}
