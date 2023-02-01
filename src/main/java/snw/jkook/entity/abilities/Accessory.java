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

package snw.jkook.entity.abilities;

/**
 * 表示一种可以被嵌入到其他卡片模块的卡片模块。<br>
 * 这是 {@link snw.jkook.message.component.card} 包的一员。
 */
public interface Accessory {

    /**
     * 模式。
     */
    enum Mode {

        LEFT("left"),

        RIGHT("right");

        private final String value;

        Mode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        /**
         * 获取提供的值对应的枚举对象。
         *
         * @param name The value
         */
        public static Mode value(String name) {
            switch (name) {
                case "left":
                    return LEFT;
                case "right":
                    return RIGHT;
                default:
                    return null;
            }
        }
    }
}
