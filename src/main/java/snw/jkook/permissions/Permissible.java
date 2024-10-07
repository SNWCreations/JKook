package snw.jkook.permissions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.channel.Channel;
import snw.jkook.plugin.Plugin;

import java.util.Set;

/**
 * Represents an object which could hold permissions.
 */
public interface Permissible {

    /**
     * @param permission Permission nodes to be checked
     * @return If allowed
     * @see snw.jkook.permissions.Permissions
     */
    @Contract(value = "_, null -> true", pure = true)
    boolean hasPermission(@Nullable Channel context, @Nullable String permission);

    @Contract(value = "null -> true", pure = true)
    default boolean hasPermission(@Nullable String permission) {
        return hasPermission(null, permission);
    }

    default boolean hasPermission(Channel context, snw.jkook.Permission permission) {
        return hasPermission(context, Permissions.getPermission(permission));
    }


    /**
     * Gets the value of the specified permission, if set.
     * <p>
     * If a permission override is not set on this object, the default value
     * of the permission will be returned
     *
     * @param perm Permission to get
     * @return Value of the permission
     */
    boolean hasPermission(@Nullable Channel context, @NotNull PermissionNode perm);

    default boolean hasPermission(@NotNull PermissionNode perm) {
        return hasPermission(null, perm);
    }

    /**
     * Checks if this object contains an override for the specified
     * permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    boolean isPermissionSet(Channel context, @NotNull String name);

    default boolean isPermissionSet(@NotNull String name) {
        return isPermissionSet(null, name);
    }

    /**
     * Checks if this object contains an override for the specified {@link
     * PermissionNode}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    boolean isPermissionSet(@Nullable Channel context, @NotNull PermissionNode perm);

    default boolean isPermissionSet(@NotNull PermissionNode perm) {
        return isPermissionSet(null, perm);
    }

    void recalculatePermissions();

    void removeAttachment(PermissionAttachment permissionAttachment);

    /**
     * Adds a new {@link PermissionAttachment} with a single permission by
     * name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *               or disabled
     * @param name   Name of the permission to attach
     * @param value  Value of the permission
     * @return The PermissionAttachment that was just created
     */
    @NotNull PermissionAttachment addAttachment(@Nullable Channel context, @NotNull Plugin plugin, @NotNull String name, boolean value);

    @NotNull
    default PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return addAttachment(null, plugin, name, value);
    }

    /**
     * Gets a set containing all the permissions currently in effect by
     * this object
     *
     * @return Set of currently effective permissions
     */
    @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions(@Nullable Channel context);

    @NotNull
    default Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return getEffectivePermissions(null);
    }
}
