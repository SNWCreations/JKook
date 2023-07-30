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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.NotNull;
import snw.jkook.Permission;
import snw.jkook.entity.User;
import snw.jkook.util.RequirePermission;
import snw.jkook.util.Validate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a channel that can chat using voice.
 */
public interface VoiceChannel extends NonCategoryChannel {

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

    /**
     * Return the current voice quality level of this channel.
     */
    int getQuality();

    /**
     * Return the current voice quality level of this channel. But the value is represented by {@link Quality}.
     *
     * @throws IllegalArgumentException Thrown if result from {@link #getQuality()} is not bound to any constant
     *                                   in {@link Quality} enum.
     */
    default Quality getQualityAsEnum() throws IllegalArgumentException {
        final int quality = getQuality();
        final Quality result = Quality.value(quality);
        if (result == null) {
            throw new IllegalArgumentException("Cannot find an enum constant in Quality with value " + quality);
        }
        return result;
    }

    /**
     * Set the voice quality level for this channel.
     *
     * @param quality New quality level
     */
    default void setQuality(@NotNull Quality quality) {
        Validate.notNull(quality, "Quality enum object must be not null");
        setQuality(quality.getValue());
    }

    /**
     * Same as {@link #setQuality(Quality)}. Just exist for further compatibility.
     *
     * @param qualityLevel New quality level
     */
    void setQuality(int qualityLevel);

    /**
     * Represents possible voice quality level for a voice channel.
     */
    enum Quality {
        FLUENCY(0),
        NORMAL(1),
        HIGH(2);
        private static final Map<Integer, Quality> byId = new HashMap<>();
        private final int value;

        static {
            for (Quality value : values()) {
                byId.put(value.getValue(), value);
            }
        }

        Quality(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * Return the enum instance that represented the provided value.
         *
         * @param value The value
         */
        public static Quality value(int value) {
            return byId.get(value);
        }
    }
}
