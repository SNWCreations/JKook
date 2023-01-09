/*
 * Copyright 2022 - 2023 JKook contributors
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

package snw.jkook.message.component.card.module;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a countdown module.
 */
public class CountdownModule extends BaseModule {
    private final Type type;
    private final long endTime;

    public CountdownModule(Type type, long endTime) {
        this.type = type;
        this.endTime = endTime;
    }

    /**
     * Return the type of this module.
     */
    public Type getType() {
        return type;
    }

    /**
     * Get the end time of this countdown.
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Represents the type of countdown.
     */
    public enum Type {

        DAY("day"),

        HOUR("hour"),

        SECOND("second");

        private static final Map<String, Type> values = new HashMap<>();

        static {
            for (Type value : values()) {
                values.put(value.getValue(), value);
            }
        }

        private final String value;

        Type(String value) {
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
        public static Type value(String name) {
            return values.get(name);
        }
    }
}
