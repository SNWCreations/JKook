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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
     * Set the password for this channel.
     * Use a empty string to remove the password.
     *
     * @param password New password
     */
    @RequirePermission(Permission.VOICE_MANAGE)
    void setPassword(@NotNull String password);

    /**
     * Set the maximum number of people in the voice channel.
     * 0 means no maximum number of people.
     *
     * @param size New size
     */
    @RequirePermission(Permission.VOICE_MANAGE)
    void setSize(int size);

    /**
     * Return the current voice quality level of this channel. But the value is represented by {@link Quality}.
     *
     * @throws IllegalArgumentException Thrown if result from {@link #getQuality()} is not bound to any constant
     *                                  in {@link Quality} enum.
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
    @RequirePermission(Permission.VOICE_MANAGE)
    default void setQuality(@NotNull Quality quality) {
        Validate.notNull(quality, "Quality enum object must be not null");
        setQuality(quality.getValue());
    }

    /**
     * Same as {@link #setQuality(Quality)}. Just exist for further compatibility.
     *
     * @param qualityLevel New quality level
     */
    @RequirePermission(Permission.VOICE_MANAGE)
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

    /**
     * Request the streaming info with default values.
     *
     * @param password The password of this channel, used for authentication
     * @return The streaming info
     */
    StreamingInfo requestStreamingInfo(@Nullable String password);

    /**
     * Request the streaming info, this method allow you to decide if rtcpMux is enabled,
     *  but other arguments use their default values.
     *
     * @param password The password of this channel, used for authentication
     * @param rtcpMux Decides if RTCP and RTP will use same port for transferring, see RFC 5761. Default: true
     * @return The streaming info
     */
    StreamingInfo requestStreamingInfo(@Nullable String password, boolean rtcpMux);

    /**
     * Request the streaming info with specified values.
     *
     * @param password The password of this channel, used for authentication
     * @param audioSSRC The SSRC of transferred audio data, see RFC 3350. Default: 1111
     * @param audioPayloadType The payload type of transferred audio data, see RFC 3551. Default: 111
     * @param rtcpMux Decides if RTCP and RTP will use same port for transferring, see RFC 5761. Default: true
     * @return The streaming info
     */
    StreamingInfo requestStreamingInfo(
            @Nullable String password,
            String audioSSRC,
            String audioPayloadType,
            boolean rtcpMux
    );

    /**
     * Let the streaming server close our connection, if any.
     */
    void stopStreaming();

    /**
     * Represents the streaming information provided by KOOK API.
     */
    interface StreamingInfo {
        /**
         * Get the IP address of the streaming server.
         */
        String getIp();

        /**
         * Get the port of the streaming server.
         */
        int getPort();

        /**
         * Get the RTCP port of the streaming server.
         */
        int getRTCPPort();

        /**
         * Get the maximum bit-rate allowed by the server when streaming.
         */
        int getBitRate();
    }

}
