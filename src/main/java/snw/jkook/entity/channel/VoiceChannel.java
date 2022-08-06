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

package snw.jkook.entity.channel;

import snw.jkook.Permission;
import snw.jkook.entity.User;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * Represents a channel that can chat using voice.
 */
public interface VoiceChannel extends Channel {

    /**
     * Return the max user counts that this channel can hold. <p>
     * If this channel can hold infinity users, <code>0</code> will be returned.
     */
    int getMaxSize();

    /**
     * Get the users that already joined this channel.
     */
    Collection<User> getUsers();

    /**
     * Get the count of the users that already joined this channel.
     */
    default int getUserCount() {
        return getUsers().size();
    }

    /**
     * Return true if this channel has been protected using password.
     */
    boolean hasPassword();

    /**
     * Move the specified users to this channel. <p>
     * Only the users that already connected to another voice channel in the list will be moved.
     *
     * @param users The target users
     */
    @RequirePermission(Permission.VOICE_MANAGE)
    void moveToHere(Collection<User> users);
}
