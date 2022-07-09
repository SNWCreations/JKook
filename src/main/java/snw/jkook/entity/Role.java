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

import snw.jkook.Permission;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.util.RequirePermission;

/**
 * Represents a role in a Kook guild.
 */
public interface Role extends Nameable {

    /**
     * Get the ID of this role.
     */
    int getId();

    /**
     * Get the color of this role.
     */
    int getColor();

    /**
     * Get the position of this role. <p>
     * The color a user displays in the user list depends on the role in which the user has the highest position (and the lowest numerical value).
     */
    int getPosition();

    /**
     * Return true if this role has the provided permission.
     *
     * @param permission The permission constant
     */
    boolean isPermissionSet(Permission permission);

    /**
     * Return true if the user that have this role can be mentioned.
     */
    boolean isMentionable();

    /**
     * Return true if put the role's users first in the user list.
     */
    boolean isHoist();

    /**
     * Set whether this role can be mentioned.
     *
     * @param value The value to set
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setMentionable(boolean value);

    /**
     * Set the "hoist" status for this role.
     *
     * @param value The value to set
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setHoist(boolean value);

    /**
     * Set the permissions of this role.
     *
     * @param permValueSum The sum of all the permissions' value.
     * @see Permission#getValue()
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void setPermissions(int permValueSum);

    /**
     * Delete this role if possible. (Fails silently.)
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    void delete();
}
