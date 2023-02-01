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

import snw.jkook.Permission;
import snw.jkook.entity.User;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * 表示一个语音频道。
 */
public interface VoiceChannel extends Channel {

    /**
     * 获取此语音频道的最大人数限制。<br>
     * 若不作限制，则此方法返回 {@code 0} 。
     */
    int getMaxSize();

    /**
     * 获取已加入此频道的用户。
     */
    Collection<User> getUsers();

    /**
     * 获取已加入此频道的用户的数量。
     */
    default int getUserCount() {
        return getUsers().size();
    }

    /**
     * 若此频道已使用密码保护，则此方法返回 {@code true} .
     */
    boolean hasPassword();

    /**
     * 把<b>在其他语音频道</b>的一些用户移动到此频道。<br>
     * 这意味着若指定用户中的某一位不在任何一个语音频道中时，对 TA 的操作将失败。
     *
     * @param users 指定的用户
     */
    @RequirePermission(Permission.VOICE_MANAGE)
    void moveToHere(Collection<User> users);
}
