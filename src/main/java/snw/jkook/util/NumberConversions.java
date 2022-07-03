package snw.jkook.util;

import org.jetbrains.annotations.Nullable;

/**
 * The methods under this class can cast the numbers into different types.
 */
public final class NumberConversions {

    /* This class should not be constructed. */
    private NumberConversions() {
    }

    public static int toInt(@Nullable Object object) {
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }

        if (object == null) {
            return 0;
        }

        try {
            return Integer.parseInt(object.toString());
        } catch (NumberFormatException ignored) {
        }

        return 0;
    }

    public static double toDouble(@Nullable Object object) {
        if (object instanceof Number) {
            return ((Number) object).doubleValue();
        }

        if (object == null) {
            return 0;
        }

        try {
            return Double.parseDouble(object.toString());
        } catch (NumberFormatException ignored) {
        }
        return 0;
    }

    public static long toLong(@Nullable Object object) {
        if (object instanceof Number) {
            return ((Number) object).longValue();
        }

        if (object == null) {
            return 0;
        }

        try {
            return Long.parseLong(object.toString());
        } catch (NumberFormatException ignored) {
        }
        return 0;
    }

}
