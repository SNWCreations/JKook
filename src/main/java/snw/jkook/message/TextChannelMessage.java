/*
 * Copyright 2022 JKook contributors
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

import snw.jkook.entity.channel.TextChannel;

/**
 * Represents a message from a text channel.
 */
public interface TextChannelMessage extends Message {

    /**
     * Get the channel that contains this message.
     */
    TextChannel getChannel();

    /**
     * Return true if this message is pinned in the channel.
     *
     * @deprecated We can't implement this.
     * @return Always false
     */
    @Deprecated
    boolean isPinned();

    /**
     * Set the pinned status of this message.
     *
     * @param pinned The status
     * @deprecated We can't implement this. So this will do nothing.
     */
    @Deprecated
    void setPinned(boolean pinned);
}
