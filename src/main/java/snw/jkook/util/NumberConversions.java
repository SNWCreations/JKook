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
