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

package snw.jkook.entity.mute;

import snw.jkook.entity.User;

/**
 * Represents the mute status of a user. <p>
 * It is a snapshot, you should not store it.
 */
public interface MuteData {

    /**
     * Get the user related to this data.
     */
    User getUser();

    /**
     * Return true if this user has disabled his microscope.
     */
    boolean isInputDisabled();

    /**
     * Return true if this user won't hear other users' voice.
     */
    boolean isOutputDisabled();
}
