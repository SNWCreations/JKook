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
 * 表示一个文件消息组件。
 */
public class FileComponent extends BaseComponent {
    private final String url;
    private final String title;
    private final int size;
    private final Type type;

    /**
     * @param url 文件的链接
     * @param title 文件名称（包括扩展名）
     * @param size 文件大小（以字节为单位，这个一般由 KOOK 服务端提供，你可以随便填）
     * @param type 文件类型（这决定了文件的展示形式）
     */
    public FileComponent(String url, String title, int size, Type type) {
        this.url = url;
        this.title = title;
        this.size = size;
        this.type = type;
    }

    /**
     * 获取文件的链接。
     */
    public String getUrl() {
        return url;
    }

    /**
     * 获取文件名称。（包括扩展名）
     */
    public String getTitle() {
        return title;
    }

    /**
     * 获取文件的大小。以字节为单位。
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取文件类型。（这决定了文件的展示形式）
     */
    public Type getType() {
        return type;
    }

    /**
     * 表示文件消息组件的展示形式。
     */
    public enum Type {

        /**
         * 表示一个普通的文件。
         */
        FILE("file"),

        /**
         * 表示音乐文件。
         */
        AUDIO("audio"),

        /**
         * 表示视频文件。
         */
        VIDEO("video"),

        /**
         * 表示图像文件。
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
         * 获取提供的值对应的枚举对象。
         *
         * @param value 值
         */
        public static Type value(String value) {
            return values.get(value);
        }
    }
}
