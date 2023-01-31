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

package snw.jkook.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 表示一个游戏。
 *
 * @see snw.jkook.HttpAPI#setPlaying(Game)
 */
public interface Game {

    /**
     * 获取这个游戏的 ID 。
     */
    int getId();

    /**
     * 获取这个游戏的名称。
     */
    String getName();

    /**
     * 设置这个游戏的名称。
     *
     * @param name 这个游戏的新名称
     */
    void setName(String name);

    /**
     * 获取这个游戏的图标的 URL 地址。<br>
     * 若这个游戏暂无图标，此方法将返回空字符串。
     */
    String getIcon();

    /**
     * 设置这个游戏的图标。
     *
     * @param iconUrl 图标的 URL 地址
     */
    void setIcon(String iconUrl);

    /**
     * 提供新的名称与图标，然后作一次设置。
     *
     * @param name 新的名称
     * @param icon 新的图标 URL 地址
     */
    void setNameAndIcon(@NotNull String name, @NotNull String icon);

}
