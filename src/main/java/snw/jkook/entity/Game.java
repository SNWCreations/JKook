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

import org.jetbrains.annotations.NotNull;

/**
 * Represents a game, just a record.
 */
public interface Game {

    /**
     * Get the ID of this game.
     */
    int getId();

    /**
     * Get the name of this game.
     */
    String getName();

    /**
     * Set the name of this game.
     *
     * @param name New name of this game
     */
    void setName(String name);

    /**
     * Get the icon url of this game. Empty string is returned if this game does not have an icon yet.
     */
    String getIcon();

    /**
     * Set the icon url of this game.
     *
     * @param iconUrl The icon url
     */
    void setIcon(String iconUrl);

    /**
     * Set the name and the icon of this game at once. This method maybe can save the network resource.
     *
     * @param name The new name of this game
     * @param icon The new icon of this game
     */
    void setNameAndIcon(@NotNull String name, @NotNull String icon);

}
