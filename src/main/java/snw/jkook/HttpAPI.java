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
import snw.jkook.util.PageIterator;

import java.io.File;
import java.util.Collection;

/**
 * 表示一部分 HTTP API 的方法。这些方法因为没有合适的安置地点而统一聚集在此。
 */
public interface HttpAPI {

    /**
     * 获取当前机器人加入的所有服务器。
     */
    PageIterator<Collection<Guild>> getJoinedGuilds();

    /**
     * 通过用户的 ID 获取用户。
     *
     * @param id 用户的 ID
     */
    User getUser(String id);

    /**
     * 通过服务器 ID 获取服务器<br>
     * 如果你没有权限访问它，则会返回 {@code null} 值。
     *
     * @param id 服务器 ID
     */
    Guild getGuild(String id);

    /**
     * 通过频道的 ID 获取频道。
     *
     * @param id 频道的 ID
     */
    Channel getChannel(String id);

    /**
     * 通过分组的 ID 获取分组。
     *
     * @param id 分组的 ID
     */
    Category getCategory(String id);

    /**
     * 将一个文件上传至 KOOK 的服务器。
     *
     * @param file 需要上传的本地文件对象
     * @return 文件在 KOOK 服务器的链接
     */
    String uploadFile(File file);

    /**
     * 将一个文件上传至 KOOK 的服务器。
     * 
     * @param filename 文件名称（包括扩展名）
     * @param content 文件的二进制数据
     * @return 文件在 KOOK 服务器的链接
     */
    String uploadFile(String filename, byte[] content);

    /**
     * 使 {@code urlCode} 所表示的邀请链接 ID 无效。
     *
     * @param urlCode 邀请链接 ID
     */
    void removeInvite(String urlCode);

    /**
     * 获取 KOOK 服务器上保存的所有游戏。
     *
     * @see Game
     */
    PageIterator<Collection<Game>> getGames();

    /**
     * 在 KOOK 服务器上新建一个游戏。
     * 此方法一天可以调用五次。
     *
     * @param name 游戏名称
     * @param icon 游戏图标的 URL
     * @return 游戏对象
     * @see Game
     */
    Game createGame(String name, @Nullable String icon);

    /**
     * 设置当前机器人正在玩的游戏。
     *
     * @param game 游戏对象，传入 {@code null} 以清除在玩状态。
     */
    void setPlaying(@Nullable Game game);

    /**
     * 设置当前机器人正在听的音乐。
     *
     * @param softwareName 音乐软件的名称，目前支持：cloudmusic, qqmusic, kugou
     * @param singerName 歌手名称
     * @param musicName 歌曲名称
     */
    void setListening(
            @NotNull String softwareName,
            @NotNull String singerName,
            @NotNull String musicName
    );

    /**
     * 清除在听状态。
     */
    void stopListening();
}
