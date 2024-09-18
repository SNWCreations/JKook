package snw.jkook.permissions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.plugin.Plugin;
import snw.jkook.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Holds information about a permission attachment on a {@link Permissible}
 * object
 */
public class PermissionAttachment {
    private final Map<Pair<PermissionContext, String>, Boolean> permissions = new LinkedHashMap<Pair<PermissionContext, String>, Boolean>();
    private final Permissible permissible;
    private final Plugin plugin;

    public PermissionAttachment(@NotNull Plugin plugin, @NotNull Permissible permissible) {
        if (!plugin.isEnabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion() + " is disabled");
        }

        this.permissible = permissible;
        this.plugin = plugin;
    }

    /**
     * Gets the plugin responsible for this attachment
     *
     * @return Plugin responsible for this permission attachment
     */
    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Gets the Permissible that this is attached to
     *
     * @return Permissible containing this attachment
     */
    @NotNull
    public Permissible getPermissible() {
        return permissible;
    }

    /**
     * Gets a copy of all set permissions and values contained within this
     * attachment.
     * <p>
     * This map may be modified but will not affect the attachment, as it is a
     * copy.
     *
     * @return Copy of all permissions and values expressed by this attachment
     */
    @NotNull
    public Map<Pair<PermissionContext, String>, Boolean> getPermissions() {
        return new LinkedHashMap<Pair<PermissionContext, String>, Boolean>(permissions);
    }

    /**
     * Sets a permission to the given value, by its fully qualified name
     *
     * @param name  Name of the permission
     * @param value New value of the permission
     */
    public void setPermission(@NotNull PermissionContext context, @NotNull String name, boolean value) {
        permissions.put(Pair.of(context, name.toLowerCase(java.util.Locale.ENGLISH)), value);
        permissible.recalculatePermissions(context);
    }

    /**
     * Sets a permission to the given value
     *
     * @param perm  Permission to set
     * @param value New value of the permission
     */
    public void setPermission(PermissionContext context, @NotNull PermissionNode perm, boolean value) {
        setPermission(context, perm.getName(), value);
    }

    /**
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param name Name of the permission to remove
     */
    public void unsetPermission(PermissionContext context, @NotNull String name) {
        permissions.remove(Pair.of(context, name.toLowerCase(java.util.Locale.ENGLISH)));
        permissible.recalculatePermissions(context);
    }

    /**
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param context if the context is null, all will be removed
     * @param perm    Permission to remove
     */
    public void unsetPermission(@Nullable PermissionContext context, @NotNull PermissionNode perm) {
        unsetPermission(context, perm.getName());
    }

    /**
     * Removes this attachment from its registered {@link Permissible}
     *
     * @param context if the context is null, all will be removed
     * @return true if the permissible was removed successfully, false if it
     * did not exist
     */
    public boolean remove(@Nullable PermissionContext context) {
        try {
            permissible.removeAttachment(context, this);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
