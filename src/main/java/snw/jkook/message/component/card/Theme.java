/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.message.component.card;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents themes for the cards and buttons. <p>
 * Affects the card sidebar color and button color.
 */
public enum Theme {

    PRIMARY("primary"),

    SUCCESS("success"),

    DANGER("danger"),

    WARNING("warning"),

    INFO("info"),

    SECONDARY("secondary"),

    INVISIBLE("invisible"),

    // This is unsupported for buttons!
    NONE("none");

    private static final Map<String, Theme> values = new HashMap<>();

    static {
        for (Theme value : values()) {
            values.put(value.getValue(), value);
        }
    }

    private final String value;

    Theme(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Return the enum instance that represented the provided value.
     *
     * @param name The value
     */
    public static Theme value(String name) {
        return values.get(name);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
