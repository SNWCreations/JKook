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

package snw.jkook.entity.abilities;

import snw.jkook.entity.Invitation;
import snw.jkook.util.PageIterator;

import java.util.Set;

/**
 * Represents the objects that can hold the invitations.
 *
 * @see Invitation
 */
public interface InviteHolder {

    /**
     * Get invitations related to this object.
     */
    PageIterator<Set<InviteHolder>> getInvitations();

    /**
     * Create an invitation of this object.
     *
     * @param validSeconds The length of time the invitation link is valid (in seconds)
     * @param validTimes   Number of times the link is valid.
     * @return The invite link URL string
     */
    String createInvite(int validSeconds, int validTimes);

    /**
     * Mark the invite link that matches the specified url code as invalid.
     *
     * @param urlCode The url code to be marked
     * @see Invitation#getUrlCode()
     */
    void removeInvite(String urlCode);

}
