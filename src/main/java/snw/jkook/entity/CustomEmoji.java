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

package snw.jkook.entity;

import org.jetbrains.annotations.Contract;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

/**
 * Represents a emoji in a {@link Guild}.
 */
public interface CustomEmoji extends Nameable {

    /**
     * Get the image url of this emoji.
     *
     * @return Always return <code>null</code>
     * @deprecated This method can't work because the Kook official does <b>NOT</b> provide URL.
     */
    @Contract("-> null")
    @Deprecated
    String getUrl();

    /**
     * Get the guild that owns this emoji.
     */
    Guild getGuild();

    /**
     * Get the uploader of this emoji.
     */
    User getUploader();

    /**
     * Delete this emoji if possible. (Fails silently.)
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    void delete();
}
