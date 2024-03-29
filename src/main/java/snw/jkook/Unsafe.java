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

package snw.jkook;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Game;
import snw.jkook.entity.User;
import snw.jkook.message.ChannelMessage;
import snw.jkook.message.PrivateMessage;

/**
 * A simple class that provide some <b>insecure</b> operations. <p>
 * The methods under this class <b>won't</b> check the arguments they have received. <p>
 * <b>DO NOT</b> provide wrong arguments if possible! <p>
 * Or you should solve the problems that caused by this class by yourself. <p>
 * <b>Many methods in the result from this class <b>may be</b> not available or can't work correctly! Beware.</b>
 */
public interface Unsafe {

    /**
     * Just simply constructs the text channel message with the provided ID and return it.
     *
     * @param id Message ID
     * @deprecated We have {@link HttpAPI#getChannelMessage(String)} as the replacement now,
     *             if you just need simple features like delete, use this can get better performance
     */
    @Deprecated
    ChannelMessage getChannelMessage(String id);

    /**
     * Just simply constructs the private message with the provided ID and return it.
     *
     * @param id Message ID
     * @deprecated We have {@link HttpAPI#getPrivateMessage(User, String)} as the replacement now,
     *             if you just need simple features like delete, use this can get better performance
     */
    @Deprecated
    PrivateMessage getPrivateMessage(String id);

    /**
     * Just simply constructs the emoji with the provided ID and return it.
     *
     * @param id Emoji ID
     */
    CustomEmoji getEmoji(String id);

    /**
     * Just simple constructs the Game data record representation with the provided ID and return it.
     *
     * @param id The Game ID
     */
    Game getGame(int id);
}
