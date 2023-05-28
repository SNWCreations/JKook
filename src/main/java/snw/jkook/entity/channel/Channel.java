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
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * Represents a channel.
 */
public interface Channel extends Nameable, MasterHolder {

    /**
     * Set the name of this channel.
     *
     * @param name The new name of this channel
     */
    void setName(String name);

    /**
     * Get the guild that contains this channel.
     */
    Guild getGuild();

    /**
     * Get the ID of this channel.
     */
    String getId();

    /**
     * Return true if the permissions of this channel is the same as its parent.
     */
    boolean isPermissionSync();

    /**
     * Return true if this channel is {@link Category}.
     */
    default boolean isCategory() {
        return (this instanceof Category);
    }

    /**
     * Get the "level" of this channel. (I think it should be called as "sort order")
     */
    int getLevel();

    /**
     * Set the "level" of this channel. (I think it should be called as "sort order")
     *
     * @param level The "level"
     */
    void setLevel(int level);

    /**
     * Delete this channel.
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void delete();

    /**
     * Get the overwritten role permission representations of this channel. <p>
     * The result is read-only.
     */
    Collection<RolePermissionOverwrite> getOverwrittenRolePermissions();

    /**
     * Get the overwritten user permission representations of this channel. <p>
     * The result is read-only.
     */
    Collection<UserPermissionOverwrite> getOverwrittenUserPermissions();

    /**
     * Get the permission overwrite data for specified user. Return null if not found.
     *
     * @param user The search condition
     * @return The data object
     */
    @Nullable
    UserPermissionOverwrite getUserPermissionOverwriteByUser(User user);

    /**
     * Get the permission overwrite data for specified role. Return null if not found.
     *
     * @param role The search condition
     * @return The data object
     */
    @Nullable
    RolePermissionOverwrite getRolePermissionOverwriteByRole(Role role);

    /**
     * Get the permission overwrite data for specified role. Return null if not found.
     *
     * @param roleId The search condition
     * @return The data object
     */
    @Nullable
    RolePermissionOverwrite getRolePermissionOverwriteByRole(int roleId);

    /**
     * Represents a permission overwrite configuration.
     *
     * @param <T> The target type
     */
    abstract class PermissionOverwrite<T> {
        protected final T target;
        protected final int rawAllow;
        protected final int rawDeny;

        protected PermissionOverwrite(T target, int rawAllow, int rawDeny) {
            this.target = target;
            this.rawAllow = rawAllow;
            this.rawDeny = rawDeny;
        }

        /**
         * Get the affected object.
         */
        public T getTarget() {
            return target;
        }

        /**
         * Get the allowed permissions' sum. You can use the result for {@link Permission#hasPermission}.
         */
        public int getRawAllow() {
            return rawAllow;
        }

        /**
         * Get the denied permissions' sum. You can use the result for {@link Permission#hasPermission}.
         */
        public int getRawDeny() {
            return rawDeny;
        }

    }

    /**
     * Represents the overwritten permissions for a role in the channel.
     */
    class RolePermissionOverwrite extends PermissionOverwrite<Integer> {

        public RolePermissionOverwrite(int roleId, int rawAllow, int rawDeny) {
            super(roleId, rawAllow, rawDeny);
        }

        /**
         * Get the role ID that related to this representation.
         */
        public int getRoleId() {
            return getTarget();
        }

        @Override
        public String toString() {
            return "RolePermissionOverwrite{" +
                    "roleId=" + getRoleId() +
                    ", rawAllow=" + rawAllow +
                    ", rawDeny=" + rawDeny +
                    '}';
        }
    }

    /**
     * Represents the overwritten permissions for a user in the channel.
     */
    class UserPermissionOverwrite extends PermissionOverwrite<User> {

        public UserPermissionOverwrite(User user, int rawAllow, int rawDeny) {
            super(user, rawAllow, rawDeny);
        }

        /**
         * Get the user that related to this representation.
         */
        public User getUser() {
            return getTarget();
        }

        @Override
        public String toString() {
            return "UserPermissionOverwrite{" +
                    "user=" + getUser() +
                    ", rawAllow=" + rawAllow +
                    ", rawDeny=" + rawDeny +
                    '}';
        }
    }

    /**
     * Update the role permission of this channel. Will not affect the rights they already have.
     *
     * @param roleId   The role ID
     * @param rawAllow The sum of the allowed permissions' value (see {@link Permission})
     * @param rawDeny  The sum of the denied permissions' value
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(int roleId, int rawAllow, int rawDeny);

    /**
     * Update the role permission of this channel. Will not affect the rights they already have.
     *
     * @param role     The role
     * @param rawAllow The sum of the allowed permissions' value (see {@link Permission})
     * @param rawDeny  The sum of the denied permissions' value
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(Role role, int rawAllow, int rawDeny);

    /**
     * Update the user's permission of this channel. Will not affect the rights they already have.
     *
     * @param user     The role
     * @param rawAllow The sum of the allowed permissions' value (see {@link Permission})
     * @param rawDeny  The sum of the denied permissions' value
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void updatePermission(User user, int rawAllow, int rawDeny);

    /**
     * Add a specified special permission for the user to this channel. Will not affect the rights they already have.
     *
     * @param user     The user
     * @param perms The permissions being added (see {@link Permission})
     */
    void addPermission(User user, Permission... perms);

    /**
     * Remove the user's specified special permission from this channel. Will not affect the rights they already have.
     *
     * @param user     The user
     * @param perms The permissions being removed (see {@link Permission})
     */
    void removePermission(User user, Permission... perms);

    /**
     * Add a specified special permission for the role to this channel. Will not affect the rights they already have.
     *
     * @param role The role
     * @param perms The permissions being added (see {@link Permission})
     */
    void addPermission(Role role, Permission... perms);

    /**
     * Remove the role's specified special permission from this channel. Will not affect the rights they already have.
     *
     * @param role The role
     * @param perms The permissions being removed (see {@link Permission})
     */
    void removePermission(Role role, Permission... perms);

    /**
     * Add a specified special permission for the role to this channel. Will not affect the rights they already have.
     *
     * @param roleId The role ID
     * @param perms The permissions being added (see {@link Permission})
     */
    void addPermission(int roleId, Permission... perms);

    /**
     * Remove the role's specified special permission from this channel. Will not affect the rights they already have.
     *
     * @param roleId The role ID
     * @param perms The permissions being removed (see {@link Permission})
     */
    void removePermission(int roleId, Permission... perms);

    /**
     * Delete the permission of the role in this channel. Will not affect the rights they already have.
     *
     * @param role The role
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void deletePermission(Role role);

    /**
     * Delete the permission of the user in this channel. Will not affect the rights they already have.
     *
     * @param user The user
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    void deletePermission(User user);
}
