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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.util.PageIterator;

import java.util.Collection;

/**
 * Represents a channel that can chat using texts.
 */
public interface TextChannel extends NonCategoryChannel {

    /**
     * Get the "topic" of this channel. (I think it should be called as "description")
     */
    String getTopic();

    /**
     * Set the "topic" of this channel. (I think it should be called as "description")
     *
     * @param topic The "topic" content, length up to 500 is allowed
     */
    void setTopic(String topic);

    /**
     * Get the messages in this channel by given information.
     *
     * @param refer     The reference message, remote will query the data around this. <p> Null to get the latest message
     * @param isPin     True if query pinned message. If you provide true, then you must provide null to "refer" argument, and only the pinned messages will be returned
     * @param queryMode The query mode. Only accepts "before", "around" and "after". Case Sensitive!
     */
    PageIterator<Collection<TextChannelMessage>> getMessages(
            @Nullable String refer,
            boolean isPin,
            String queryMode
    );

}
