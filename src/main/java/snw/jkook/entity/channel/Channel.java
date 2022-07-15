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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.Nameable;

import java.util.Collection;

/**
 * Represents a channel.
 */
public interface Channel extends Nameable, InviteHolder {

    /**
     * Get the ID of this channel.
     */
    String getId();

    /**
     * Return true if the permissions of this channel is the same as its parent.
     */
    boolean isPermissionSync();

    /**
     * Get the limit of minimum speaking time between two statements. (in seconds)
     */
    default int getChatLimitTime() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return true if this channel is {@link Category}.
     */
    default boolean isCategory() {
        return (this instanceof Category);
    }

    /**
     * Get the category that holds this channel.
     */
    @Nullable
    Category getParent();

    /**
     * Return true if this channel has been protected using password. <p>
     * <b>WARNING: This method does not have effect for {@link TextChannel}. Because the field behind this method does not applicable for {@link TextChannel}.</b>
     */
    boolean hasPassword();

    /**
     * Delete this channel if possible. (Fails silently.)
     */
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
     * Represents the overwritten permissions for a role in the channel.
     */
    class RolePermissionOverwrite {
        private final Role role;
        private final int rawAllow;
        private final int rawDeny;

        public RolePermissionOverwrite(Role role, int rawAllow, int rawDeny) {
            this.role = role;
            this.rawAllow = rawAllow;
            this.rawDeny = rawDeny;
        }

        /**
         * Get the role that related to this representation.
         */
        public Role getRole() {
            return role;
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
     * Represents the overwritten permissions for a user in the channel.
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
         * Get the user that related to this representation.
         */
        public User getUser() {
            return user;
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
     * Update the role permission of this channel. Will not affect the rights they already have. (Fails silently.)
     *
     * @param role     The role
     * @param rawAllow The sum of the allowed permissions' value (see {@link Permission})
     * @param rawDeny  The sum of the denied permissions' value
     */
    void updatePermission(Role role, int rawAllow, int rawDeny);

    /**
     * Update the user's permission of this channel. Will not affect the rights they already have. (Fails silently.)
     *
     * @param user     The role
     * @param rawAllow The sum of the allowed permissions' value (see {@link Permission})
     * @param rawDeny  The sum of the denied permissions' value
     */
    void updatePermission(User user, int rawAllow, int rawDeny);

    /**
     * Delete the permission of the role in this channel. Will not affect the rights they already have.
     *
     * @param role The role
     */
    void deletePermission(Role role);

    /**
     * Delete the permission of the user in this channel. Will not affect the rights they already have.
     *
     * @param user The user
     */
    void deletePermission(User user);
}
