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

package snw.jkook.message.component.card.element;

import snw.jkook.entity.abilities.Accessory;
import snw.jkook.event.user.UserClickButtonEvent;
import snw.jkook.message.component.card.Theme;
import snw.jkook.util.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示一个按钮。这与 {@link UserClickButtonEvent} 有关。
 */
public class ButtonElement extends InteractElement implements Accessory {
    private final Theme theme;
    private final String value;
    private final EventType type;
    private final BaseElement element;

    public ButtonElement(Theme theme, String value, BaseElement element) {
        this(theme, value, EventType.NO_ACTION, element);
    }

    public ButtonElement(Theme theme, String value, EventType type, BaseElement element) {
        Validate.isTrue(
                element instanceof PlainTextElement ||
                element instanceof MarkdownElement,
                "Button only accepts plain-text and kmarkdown as the text."
        );
        Validate.isFalse(theme == Theme.NONE, "Theme.NONE is unsupported for buttons!");
        this.theme = theme;
        this.value = value;
        this.type = type;
        this.element = element;
    }

    /**
     * 获取此按钮的主题。
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * 获取此按钮存储的"值"。
     *
     * @see UserClickButtonEvent#getValue()
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取此按钮被点击时发生的事件类型。
     */
    public EventType getEventType() {
        return type;
    }

    /**
     * 获取此按钮的显示文本。
     */
    public BaseElement getText() {
        return element;
    }

    /**
     * 表示按钮被点击时可以产生的事件类型。
     */
    public enum EventType {

        /**
         * 表示按钮在被点击后，什么都不会发生。
         */
        NO_ACTION(""),

        /**
         * 使用此类型意味着按钮的"值"将被看作一个链接，用户在点击按钮后，TA 的设备会打开"值"所代表的链接。
         */
        LINK("link"),

        /**
         * 使用此类型意味着按钮被点击后，其"值"将被 {@link UserClickButtonEvent} 包装后传回给机器人。
         */
        RETURN_VAL("return-val");

        private static final Map<String, EventType> values = new HashMap<>();

        static {
            for (EventType value : values()) {
                values.put(value.getValue(), value);
            }
        }

        private final String value;

        EventType(String value) {
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
        public static EventType value(String name) {
            return values.get(name);
        }
    }
}
