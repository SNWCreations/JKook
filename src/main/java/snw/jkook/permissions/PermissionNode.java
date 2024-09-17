package snw.jkook.permissions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a unique permission node that may be attached to a {@link
 * Permissible}
 */
public class PermissionNode {
    private final String name;
    private final Map<String, Boolean> children = new LinkedHashMap<String, Boolean>();
    private PermissionDefault defaultValue = PermissionDefault.FALSE;
    private String description;

    public PermissionNode(@NotNull String name) {
        this(name, null, null, null);
    }

    public PermissionNode(@NotNull String name, @Nullable String description) {
        this(name, description, null, null);
    }

    public PermissionNode(@NotNull String name, @Nullable PermissionDefault defaultValue) {
        this(name, null, defaultValue, null);
    }

    public PermissionNode(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue) {
        this(name, description, defaultValue, null);
    }

    public PermissionNode(@NotNull String name, @Nullable Map<String, Boolean> children) {
        this(name, null, null, children);
    }

    public PermissionNode(@NotNull String name, @Nullable String description, @Nullable Map<String, Boolean> children) {
        this(name, description, null, children);
    }

    public PermissionNode(@NotNull String name, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        this(name, null, defaultValue, children);
    }

    public PermissionNode(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        this.name = name;
        this.description = (description == null) ? "" : description;

        if (defaultValue != null) {
            this.defaultValue = defaultValue;
        }

        if (children != null) {
            this.children.putAll(children);
        }
    }

    /**
     * Returns the unique fully qualified name of this Permission
     *
     * @return Fully qualified name
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Gets the children of this permission.
     *
     * @return Permission children
     */
    @NotNull
    public Map<String, Boolean> getChildren() {
        return children;
    }

    /**
     * Gets the default value of this permission.
     *
     * @return Default value of this permission.
     */
    @NotNull
    public PermissionDefault getDefault() {
        return defaultValue;
    }

    /**
     * Sets the default value of this permission.
     *
     * @param value The new default to set
     */
    public void setDefault(@NotNull PermissionDefault value) {
        if (defaultValue == null) {
            throw new IllegalArgumentException("Default value cannot be null");
        }

        defaultValue = value;
    }

    /**
     * Gets a brief description of this permission, may be empty
     *
     * @return Brief description of this permission
     */
    @NotNull
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this permission.
     * <p>
     * This will not be saved to disk, and is a temporary operation until the
     * server reloads permissions.
     *
     * @param value The new description to set
     */
    public void setDescription(@Nullable String value) {
        if (value == null) {
            description = "";
        } else {
            description = value;
        }
    }


    /**
     * Loads a Permission from a map of data, usually used from retrieval from
     * a yaml file.
     * <p>
     * The data may contain the following keys:
     * <ul>
     * <li>default: Boolean true or false. If not specified, false.
     * <li>children: {@code Map<String, Boolean>} of child permissions. If not
     *     specified, empty list.
     * <li>description: Short string containing a very small description of
     *     this description. If not specified, empty string.
     * </ul>
     *
     * @param name   Name of the permission
     * @param data   Map of keys
     * @param def    Default permission value to use if not set
     * @param output A list to append any created child-Permissions to, may be null
     * @return Permission object
     */
    @NotNull
    public static PermissionNode loadPermission(@NotNull String name, @NotNull Map<?, ?> data, @Nullable PermissionDefault def, @Nullable List<PermissionNode> output) {
        String desc = null;
        Map<String, Boolean> children = null;

        if (data.get("default") != null) {
            PermissionDefault value = PermissionDefault.getByName(data.get("default").toString());
            if (value != null) {
                def = value;
            } else {
                throw new IllegalArgumentException("'default' key contained unknown value");
            }
        }

        if (data.get("children") != null) {
            Object childrenNode = data.get("children");
            if (childrenNode instanceof Iterable) {
                children = new LinkedHashMap<String, Boolean>();
                for (Object child : (Iterable<?>) childrenNode) {
                    if (child != null) {
                        children.put(child.toString(), Boolean.TRUE);
                    }
                }
            } else if (childrenNode instanceof Map) {
                children = extractChildren((Map<?, ?>) childrenNode, name, def, output);
            } else {
                throw new IllegalArgumentException("'children' key is of wrong type");
            }
        }

        if (data.get("description") != null) {
            desc = data.get("description").toString();
        }

        return new PermissionNode(name, desc, def, children);
    }

    @NotNull
    private static Map<String, Boolean> extractChildren(@NotNull Map<?, ?> input, @NotNull String name, @Nullable PermissionDefault def, @Nullable List<PermissionNode> output) {
        Map<String, Boolean> children = new LinkedHashMap<String, Boolean>();

        for (Map.Entry<?, ?> entry : input.entrySet()) {
            if ((entry.getValue() instanceof Boolean)) {
                children.put(entry.getKey().toString(), (Boolean) entry.getValue());
            } else if ((entry.getValue() instanceof Map)) {
                try {
                    PermissionNode perm = loadPermission(entry.getKey().toString(), (Map<?, ?>) entry.getValue(), def, output);
                    children.put(perm.getName(), Boolean.TRUE);

                    if (output != null) {
                        output.add(perm);
                    }
                } catch (Throwable ex) {
                    throw new IllegalArgumentException("Permission node '" + entry.getKey().toString() + "' in child of " + name + " is invalid", ex);
                }
            } else {
                throw new IllegalArgumentException("Child '" + entry.getKey().toString() + "' contains invalid value");
            }
        }

        return children;
    }
}
