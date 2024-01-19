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

package snw.jkook.entity;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.util.RequirePermission;

/**
 * Represents a reaction.
 */
public interface Reaction extends Receivable {

    /**
     * Get the ID of the message which holds this reaction.
     */
    String getMessageId();

    /**
     * Get the emoji used by this reaction.
     */
    CustomEmoji getEmoji();

    /**
     * Get the time stamp that the user sent this reaction. <p>
     * -1 will be returned if this reaction was deleted, and we constructed this instance for first time. So this method is <b>unsafe</b>. <p>
     * Tips: Although this reaction was deleted, the normal value will be returned if we already stored this before.
     */
    @Override
    long getTimeStamp();

    /**
     * Delete this reaction . <p>
     * Need {@link Permission#MESSAGE_MANAGE} <b>unless this reaction has been sent by you</b>.
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
