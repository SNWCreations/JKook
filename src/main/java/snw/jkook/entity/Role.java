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

import snw.jkook.Permission;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

/**
 * 表示一个服务器角色。
 */
public interface Role extends Nameable {

    /**
     * 获取此角色所在的服务器。
     */
    Guild getGuild();

    /**
     * 获取此角色的 ID 。<br>
     * <b>这个 ID 不是唯一的。</b>在不同的服务器，相同的 ID 指向的并不是同一个角色。
     */
    int getId();

    /**
     * 获取此角色使用的颜色值。<br>
     * 这个值影响 KOOK 客户端的渲染。
     */
    int getColor();

    /**
     * 获取这个角色在服务器中的"位置"。<br>
     * 这个值影响服务器在线列表中有对应角色的用户所处的位置。
     */
    int getPosition();

    /**
     * 若此角色拥有传入的权限，则返回 {@code true} 。
     *
     * @param permission 权限常量
     */
    boolean isPermissionSet(Permission permission);

    /**
     * 若允许任何人 @ 提及此角色，则此方法返回 {@code true}。<br>
     * <b>请注意:</b> 拥有提及 @全体成员，@在线成员 和 @所有角色 权限的成员，可以绕开这个限制。
     */
    boolean isMentionable();

    /**
     * 若将该角色成员与普通在线成员分开显示，则此方法返回 {@code true}。
     */
    boolean isHoist();

    /**
     * 设置是否允许任何人 @ 提及此角色。
     *
     * @param value 是否允许
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setMentionable(boolean value);

    /**
     * 设置是否将该角色成员与普通在线成员分开显示。
     *
     * @param value 是否将该角色成员与普通在线成员分开显示
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setHoist(boolean value);

    /**
     * 设置此角色拥有的权限。
     *
     * @param permValueSum 计算方法: 将所有需要的权限加在一起
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setPermissions(int permValueSum);

    /**
     * 删除这个角色。
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void delete();
}
