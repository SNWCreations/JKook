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

package snw.jkook;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.util.PageIterator;

import java.io.File;
import java.util.Collection;

/**
 * Represents the entry of Kook HTTP API.
 */
public interface HttpAPI {

    /**
     * Get the joined guilds.
     */
    PageIterator<Collection<Guild>> getJoinedGuilds();

    /**
     * Get a user by user id.
     *
     * @param id The ID of a user
     */
    User getUser(String id);

    /**
     * Get a guild by guild ID. <p>
     * <b>Null will be returned if you don't have permission to access it.</b>
     *
     * @param id The ID of a guild
     */
    Guild getGuild(String id);

    /**
     * Get a channel by ID.
     *
     * @param id The channel ID
     */
    Channel getChannel(String id);

    /**
     * Get a category by ID.
     *
     * @param id The ID
     */
    Category getCategory(String id);

    /**
     * Upload a file to Kook server.
     *
     * @param file The file to upload
     * @return The URL string of the remote file
     */
    String uploadFile(File file);

    /**
     * Upload a file to Kook server.
     *
     * @param binary The binary data to upload
     * @return The URL string of the remote file
     */
    String uploadFile(String binary);

    /**
     * Mark the invitation that represented by the provided url code as invalid.
     *
     * @param urlCode The target
     */
    void removeInvite(String urlCode);
}
