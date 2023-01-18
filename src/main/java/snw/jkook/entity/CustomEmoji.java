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

package snw.jkook.entity;

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

/**
 * Represents a emoji.
 */
public interface CustomEmoji extends Nameable {

    /**
     * Get the ID of this emoji.
     */
    String getId();

    /**
     * Set the name of this emoji.
     *
     * @param name The new name of this emoji
     */
    void setName(String name);

    /**
     * Get the guild that owns this emoji. <p>
     * If this emoji has not owned by a guild, or you don't have permission to access it, this method will return null.
     */
    @Nullable
    Guild getGuild();

    /**
     * Delete this emoji.
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    void delete();
}
