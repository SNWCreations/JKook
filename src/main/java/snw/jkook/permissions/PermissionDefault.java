package snw.jkook.permissions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the possible default values for permissions
 */
public enum PermissionDefault {
    TRUE("true"),
    FALSE("false")
    ;

    private final String[] names;
    private static final Map<String, PermissionDefault> lookup = new HashMap<String, PermissionDefault>();

    PermissionDefault(String... names) {
        this.names = names;
    }

    /**
     * Calculates the value of this PermissionDefault for the given operator
     * value
     *
     * @return True if the default should be true, or false
     */
    public boolean getValue() {
        return this == PermissionDefault.TRUE;
    }

    /**
     * Looks up a PermissionDefault by name
     *
     * @param name Name of the default
     * @return Specified value, or null if not found
     */
    @Nullable
    public static PermissionDefault getByName(@NotNull String name) {
        return lookup.get(name.toLowerCase(java.util.Locale.ENGLISH).replaceAll("[^a-z!]", ""));
    }

    @Override
    public String toString() {
        return names[0];
    }

    static {
        for (PermissionDefault value : values()) {
            for (String name : value.names) {
                lookup.put(name, value);
            }
        }
    }
}
