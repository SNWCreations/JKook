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

package snw.jkook.event.pm;

/**
 * Represents the event that means the content of a private message got updated.
 */
public class PrivateMessageUpdateEvent extends PrivateMessageEvent {

    private final String messageId;
    private final String content;

    public PrivateMessageUpdateEvent(long timeStamp, String messageId, String content) {
        super(timeStamp);
        this.messageId = messageId;
        this.content = content;
    }

    /**
     * Get the ID of the updated message.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Get the updated content of the message.
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "PrivateMessageUpdateEvent{" +
                "timeStamp=" + timeStamp +
                ", messageId='" + messageId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
