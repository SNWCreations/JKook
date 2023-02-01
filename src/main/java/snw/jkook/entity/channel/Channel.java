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

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.Guild;
import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * 表示一个频道。
 */
public interface Channel extends Nameable, InviteHolder, MasterHolder {

    /**
     * 获取此频道所在的服务器。
     */
    Guild getGuild();

    /**
     * 获取此频道的 ID 。
     */
    String getId();

    /**
     * 若此频道的权限设置已与其父分组同步，则此方法返回 {@code true} .
     */
    boolean isPermissionSync();

    /**
     * 若此频道是一个分组，则此方法返回 {@code true} 。
     */
    default boolean isCategory() {
        return (this instanceof Category);
    }

    /**
     * 获取此频道的父分组，没有则返回 {@code null} 。
     */
    @Nullable
    Category getParent();

    /**
     * 设置此频道的父分组。
     *
     * @param parent 新的父分组，传入 {@code null} 时将此频道从原本所在的分组移出
     */
    void setParent(@Nullable Category parent);

    /**
     * 获取此频道的"等级"。(我认为这应该叫做"排序顺序"，但 KOOK API 将其命名为"等级"。)
     */
    int getLevel();

    /**
     * 设置此频道的"等级"。(我认为这应该叫做"排序顺序"，但 KOOK API 将其命名为"等级"。)
     *
     * @param level "等级"
     */
    void setLevel(int level);

    /**
     * 删除此频道。
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void delete();

    /**
     * 获取此频道特定的角色权限。
     */
    Collection<RolePermissionOverwrite> getOverwrittenRolePermissions();

    /**
     * 获取此频道特定的用户权限。
     */
    Collection<UserPermissionOverwrite> getOverwrittenUserPermissions();

    /**
     * 表示一个角色在频道中拥有的特定权限的信息。
     */
    class RolePermissionOverwrite {
        private final int roleId;
        private final int rawAllow;
        private final int rawDeny;

        public RolePermissionOverwrite(int roleId, int rawAllow, int rawDeny) {
            this.roleId = roleId;
            this.rawAllow = rawAllow;
            this.rawDeny = rawDeny;
        }

        /**
         * 获取与此信息关联的角色的 ID 。
         */
        public int getRoleId() {
            return roleId;
        }

        /**
         * 获取允许的权限值的总和。
         *
         * @see Permission#hasPermission
         */
        public int getRawAllow() {
            return rawAllow;
        }

        /**
         * 获取拒绝的权限值的总和。
         *
         * @see Permission#hasPermission
         */
        public int getRawDeny() {
            return rawDeny;
        }
    }

    /**
     * 表示一个用户在频道中拥有的特定权限的信息。
     */
    class UserPermissionOverwrite {
        private final User user;
        private final int rawAllow;
        private final int rawDeny;

        public UserPermissionOverwrite(User user, int rawAllow, int rawDeny) {
            this.user = user;
            this.rawAllow = rawAllow;
            this.rawDeny = rawDeny;
        }

        /**
         * 获取与此信息关联的用户。
         */
        public User getUser() {
            return user;
        }

        /**
         * 获取允许的权限值的总和。
         *
         * @see Permission#hasPermission
         */
        public int getRawAllow() {
            return rawAllow;
        }

        /**
         * 获取拒绝的权限值的总和。
         *
         * @see Permission#hasPermission
         */
        public int getRawDeny() {
            return rawDeny;
        }
    }

    /**
     * 更新一个角色在此频道中拥有的特定权限。
     *
     * @param roleId   角色 ID
     * @param rawAllow 允许的权限值的总和
     * @param rawDeny  拒绝的权限值的总和
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(int roleId, int rawAllow, int rawDeny);

    /**
     * 更新一个角色在此频道中拥有的特定权限。
     *
     * @param role     角色
     * @param rawAllow 允许的权限值的总和
     * @param rawDeny  拒绝的权限值的总和
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(Role role, int rawAllow, int rawDeny);

    /**
     * 更新一个用户在此频道中拥有的特定权限。
     *
     * @param user     用户
     * @param rawAllow 允许的权限值的总和
     * @param rawDeny  拒绝的权限值的总和
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(User user, int rawAllow, int rawDeny);

    /**
     * 移除一个角色在此频道中拥有的特定权限。
     *
     * @param role 指定的角色
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void deletePermission(Role role);

    /**
     * 移除一个用户在此频道中拥有的特定权限。
     *
     * @param user 指定的用户
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void deletePermission(User user);
}
