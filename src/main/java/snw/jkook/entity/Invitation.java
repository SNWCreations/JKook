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

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.channel.Channel;
import snw.jkook.util.RequirePermission;

/**
 * 表示一个邀请。
 */
public interface Invitation extends MasterHolder {

    /**
     * 获取与此邀请关联的服务器。
     */
    Guild getGuild();

    /**
     * 获取与此邀请关联的频道。<br>
     * 若此邀请不是指向频道的，此方法将返回 {@code null} 。
     */
    @Nullable
    Channel getChannel();

    /**
     * 获取此邀请的邀请码。
     */
    String getUrlCode();

    /**
     * 获取指向此邀请的邀请链接。
     */
    String getUrl();

    /**
     * 使此邀请失效。
     */
    @RequirePermission(Permission.INVITE_MANAGE)
    void delete();
}
