package snw.jkook.permissions;

import org.jetbrains.annotations.NotNull;
import snw.jkook.plugin.Plugin;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Holds information about a permission attachment on a {@link Permissible}
 * object
 */
public class PermissionAttachment {
    private final Map<String, Boolean> permissions = new LinkedHashMap<String, Boolean>();
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
    public Map<String, Boolean> getPermissions() {
        return new LinkedHashMap<String, Boolean>(permissions);
    }

    /**
     * Sets a permission to the given value, by its fully qualified name
     *
     * @param name  Name of the permission
     * @param value New value of the permission
     */
    public void setPermission(@NotNull String name, boolean value) {
        permissions.put(name.toLowerCase(java.util.Locale.ENGLISH), value);
        permissible.recalculatePermissions();
    }

    /**
     * Sets a permission to the given value
     *
     * @param perm  Permission to set
     * @param value New value of the permission
     */
    public void setPermission(@NotNull Permission perm, boolean value) {
        setPermission(perm.getName(), value);
    }

    /**
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param name Name of the permission to remove
     */
    public void unsetPermission(@NotNull String name) {
        permissions.remove(name.toLowerCase(java.util.Locale.ENGLISH));
        permissible.recalculatePermissions();
    }

    /**
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param perm Permission to remove
     */
    public void unsetPermission(@NotNull Permission perm) {
        unsetPermission(perm.getName());
    }

    /**
     * Removes this attachment from its registered {@link Permissible}
     *
     * @return true if the permissible was removed successfully, false if it
     * did not exist
     */
    public boolean remove() {
        try {
            permissible.removeAttachment(this);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
