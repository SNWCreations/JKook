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
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

/**
 * 表示一个表情。
 */
public interface CustomEmoji extends Nameable {

    /**
     * 获取这个表情的 ID 。
     */
    String getId();

    /**
     * 设置这个表情的名称。
     *
     * @param name 新的表情名称
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    void setName(String name);

    /**
     * 获取拥有此表情的服务器。<br>
     * 如果这个表情不是一个服务器表情 (KOOK 原生表情？)，或者你无权访问对应的服务器，此方法将返回 {@code null} 。
     */
    @Nullable
    Guild getGuild();

    /**
     * 删除这个服务器表情。
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    void delete();
}
