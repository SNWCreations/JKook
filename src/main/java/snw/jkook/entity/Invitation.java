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

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.channel.Channel;
import snw.jkook.util.RequirePermission;

/**
 * Represents an invitation.
 */
public interface Invitation extends MasterHolder {

    /**
     * Get the guild related to this invitation.
     */
    Guild getGuild();

    /**
     * Get the channel related to this invitation. <p>
     * Null is returned if this invitation does not relate to a channel.
     */
    @Nullable
    Channel getChannel();

    /**
     * Get the url code of this invitation.
     */
    String getUrlCode();

    /**
     * Get the link URL of this invitation.
     */
    String getUrl();

    /**
     * Mark this invitation as invalid.
     */
    @RequirePermission(Permission.INVITE_MANAGE)
    void delete();
}
