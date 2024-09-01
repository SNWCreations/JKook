package snw.jkook.permissions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.plugin.Plugin;

import java.util.Set;

public interface Permissible extends BotOperator {

    /**
     * @param permission Permission nodes to be checked
     * @return If allowed
     * @see snw.jkook.permissions.Permissions
     */
    @Contract(value = "null -> true", pure = true)
    boolean hasPermission(@Nullable String permission);

    default boolean hasPermission(snw.jkook.Permission permission) {
        return hasPermission(Permissions.getPermission(permission));
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
    public boolean hasPermission(@NotNull Permission perm);

    /**
     * Checks if this object contains an override for the specified
     * permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    public boolean isPermissionSet(@NotNull String name);

    /**
     * Checks if this object contains an override for the specified {@link
     * Permission}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    public boolean isPermissionSet(@NotNull Permission perm);

    void recalculatePermissions();

    void removeAttachment(PermissionAttachment permissionAttachment);

    /**
     * Adds a new {@link PermissionAttachment} with a single permission by
     * name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *     or disabled
     * @param name Name of the permission to attach
     * @param value Value of the permission
     * @return The PermissionAttachment that was just created
     */
    @NotNull
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value);

    /**
     * Adds a new empty {@link PermissionAttachment} to this object
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *     or disabled
     * @return The PermissionAttachment that was just created
     */
    @NotNull
    public PermissionAttachment addAttachment(@NotNull Plugin plugin);

    /**
     * Temporarily adds a new {@link PermissionAttachment} with a single
     * permission by name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *     or disabled
     * @param name Name of the permission to attach
     * @param value Value of the permission
     * @param ticks Amount of ticks to automatically remove this attachment
     *     after
     * @return The PermissionAttachment that was just created
     */
    @Nullable
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks);

    /**
     * Temporarily adds a new empty {@link PermissionAttachment} to this
     * object
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *     or disabled
     * @param ticks Amount of ticks to automatically remove this attachment
     *     after
     * @return The PermissionAttachment that was just created
     */
    @Nullable
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks);

    /**
     * Gets a set containing all the permissions currently in effect by
     * this object
     *
     * @return Set of currently effective permissions
     */
    @NotNull
    public Set<PermissionAttachmentInfo> getEffectivePermissions();
}