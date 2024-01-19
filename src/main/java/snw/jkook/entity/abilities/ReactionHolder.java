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

package snw.jkook.entity.abilities;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;

import java.util.Collection;

/**
 * Represents an object that can hold the reactions.
 */
public interface ReactionHolder {

    /**
     * Get the users that added the specified emoji to this object.
     *
     * @param emoji The emoji as the search condition
     * @throws IllegalStateException Thrown if the Bot does not have permission to access the specified emoji.
     *                               (e.g. The Bot is not a member of the guild behind the emoji)
     */
    Collection<User> getUserByReaction(CustomEmoji emoji) throws IllegalStateException;

    /**
     * Add an emoji as the reaction to this object.
     *
     * @param emoji The target emoji
     */
    void sendReaction(CustomEmoji emoji);

    /**
     * Remove the specified emoji from this object.
     *
     * @param emoji The target emoji
     */
    void removeReaction(CustomEmoji emoji);
}
