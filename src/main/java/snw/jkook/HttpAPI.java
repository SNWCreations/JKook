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

package snw.jkook;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.Game;
import snw.jkook.entity.Guild;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.message.PrivateMessage;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.util.PageIterator;

import java.io.File;
import java.util.Collection;
import java.util.NoSuchElementException;

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
     * <b>Null is returned if you don't have permission to access it.</b>
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
     * @param filename The name of the file (with the extension name)
     * @param content The content byte array of the file
     * @return The URL string of the remote file
     */
    String uploadFile(String filename, byte[] content);

    /**
     * Upload a file to Kook server.
     *
     * @param filename The name of the file (with the extension name)
     * @param url The URL of another remote file
     * @return The URL string of the remote file
     */
    String uploadFile(String filename, String url);

    /**
     * Mark the invitation that represented by the provided url code as invalid.
     *
     * @param urlCode The target
     */
    void removeInvite(String urlCode);

    /**
     * Get the game data that stored in the Kook's database.
     */
    PageIterator<Collection<Game>> getGames();

    /**
     * Get the game data that stored in the Kook's database.
     *
     * @param type The game data type. <br>
     *             0 - All, <br>
     *             1 - Created by user (including Bot?), <br>
     *             2 - Created by KOOK
     */
    PageIterator<Collection<Game>> getGames(int type);

    /**
     * Create a new game data record at the Kook's database.
     * This method can be called only five times a day.
     *
     * @param name The name of the game
     * @param icon The icon url of the game
     * @return The game data record representation
     */
    Game createGame(String name, @Nullable String icon);

    /**
     * Set the game which the Bot is playing.
     *
     * @param game The game representation, null if you want to clear the playing status of the Bot
     */
    void setPlaying(@Nullable Game game);

    /**
     * Set the music which the Bot is listening.
     *
     * @param softwareName The music software name. Currently supports: cloudmusic, qqmusic, kugou
     * @param singerName The singer name
     * @param musicName The music name
     */
    void setListening(
            @NotNull String softwareName,
            @NotNull String singerName,
            @NotNull String musicName
    );

    /**
     * Clear the listening status. This should fail silently.
     */
    void stopListening();

    /**
     * Get a {@link TextChannelMessage} which matches the provided ID.
     *
     * @param id The ID
     * @return The requested {@link TextChannelMessage} object
     * @throws NoSuchElementException Thrown if there is no message object matches the provided ID
     */
    TextChannelMessage getTextChannelMessage(String id) throws NoSuchElementException;

    /**
     * Get a {@link PrivateMessage} which matches the provided ID.
     *
     * @param user The user of the chat session where the message resides
     * @param id The message ID
     * @return The requested {@link PrivateMessage} object
     * @throws NoSuchElementException Thrown if there is no message object matches the provided ID
     */
    PrivateMessage getPrivateMessage(User user, String id) throws NoSuchElementException;

    // -------- Friend API --------

    /**
     * Represents a friend request. <br>
     * Just a snapshot, don't save it.
     */
    interface FriendRequest {

        /**
         * Get the ID of this request.
         */
        int getId();

        /**
         * Get the requester.
         */
        User getRequester();

        /**
         * Handle it.
         * 
         * @param accept True if you want to accept this request
         */
        void handle(boolean accept);

    }

    /**
     * Represents the friend state. <br>
     * Just a snapshot, don't save it.
     */
    interface FriendState {

        /**
         * Get the pending friend requests.
         */
        Collection<FriendRequest> getPendingFriendRequests();

        /**
         * Get the friends.
         */
        Collection<User> getFriends();

        /**
         * Get the users which is currently blocked by current user.
         */
        Collection<User> getBlockedUsers();

    }

    /**
     * Get the friend state.
     * 
     * @see FriendState
     * @param lazyInit True if you don't need all data before returning the final object,
     *                 which means the API request won't be performed until you called the method
     *                 of the resulting object
     */
    FriendState getFriendState(boolean lazyInit);

    /**
     * Send a friend request to the specified user.
     * 
     * @param user The target user
     * @param method How did you found the specified user. (Maybe a client-specific argument?) 0 - Search, 2 - From a guild
     * @param from From which server did you add this user, should be NOT NULL if {@code method == 2}
     */
    void addFriend(User user, int method, String from);

    /**
     * Handle a friend request.
     * 
     * @param requestId The ID of the friend request
     * @param accept True if you want to accept the request
     */
    void handleFriendRequest(int requestId, boolean accept);

    /**
     * Delete a user from your friend list.
     * 
     * @param user The user which is being deleted from your friend list
     */
    void deleteFriend(User user);

}
