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

package snw.jkook.message.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the component with a file.
 */
public class FileComponent extends BaseComponent {
    private final String url;
    private final String title;
    private final int size;
    private final Type type;

    public FileComponent(String url, String title, int size, Type type) {
        this.url = url;
        this.title = title;
        this.size = size;
        this.type = type;
    }

    /**
     * Get the targeted image url of this module.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Return the title of this file.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the size of this file. Unit is byte.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the type of this file.
     */
    public Type getType() {
        return type;
    }

    /**
     * Represents the types allowed by this module.
     */
    public enum Type {

        /**
         * Represents the normal file.
         */
        FILE("file"),

        /**
         * Represents the audio file.
         */
        AUDIO("audio"),

        /**
         * Represents the video file.
         */
        VIDEO("video"),

        /**
         * Represents the image file.
         */
        IMAGE("image");

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
         * @param value The value
         */
        public static Type value(String value) {
            return values.get(value);
        }
    }
}
