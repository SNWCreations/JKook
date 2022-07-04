package snw.jkook.entity;

import snw.jkook.Permission;

/**
 * Represents a role in a Kook guild.
 */
public interface Role {

    /**
     * Get the name of this role.
     */
    String getName();

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

}
