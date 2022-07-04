package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.Nameable;

/**
 * Represents a channel.
 */
public interface Channel extends Nameable, InviteHolder {

    /**
     * Get the ID of this channel.
     */
    long getId();

    /**
     * Return true if the permissions of this channel is the same as its parent.
     */
    boolean isPermissionSync();

    /**
     * Get the limit of minimum speaking time between two statements. (in seconds)
     */
    int getChatLimitTime();

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
     * Return true if this channel has been protected using password.
     */
    boolean hasPassword();

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

        public Role getRole() {
            return role;
        }

        public int getRawAllow() {
            return rawAllow;
        }

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

        public User getUser() {
            return user;
        }

        public int getRawAllow() {
            return rawAllow;
        }

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
