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

package snw.jkook.message.component.card.element;

import snw.jkook.entity.abilities.Accessory;
import snw.jkook.event.user.UserClickButtonEvent;
import snw.jkook.message.component.card.Theme;
import snw.jkook.util.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a button. It can cause a {@link UserClickButtonEvent}.
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
        Validate.isFalse(theme == Theme.INVISIBLE, "Theme.INVISIBLE is unsupported for buttons!");
        this.theme = theme;
        this.value = value;
        this.type = type;
        this.element = element;
    }

    /**
     * Get theme of this button.
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Get the value that stored by this button.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the type of the event that can be caused by this button.
     */
    public EventType getEventType() {
        return type;
    }

    /**
     * Get the shown text of this button.
     */
    public BaseElement getText() {
        return element;
    }

    /**
     * Represents the event types of button modules.
     */
    public enum EventType {

        /**
         * This event type makes the button do nothing. And it is default value.
         */
        NO_ACTION(""),

        /**
         * This event type makes the users that clicked this button jump to the URL represented by "value" field.
         */
        LINK("link"),

        /**
         * This event type makes the users that clicked this button will fire a {@link UserClickButtonEvent}.
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
         * Return the enum instance that represented the provided value.
         *
         * @param name The value
         */
        public static EventType value(String name) {
            return values.get(name);
        }
    }

    @Override
    public String toString() {
        return "ButtonElement{" +
                "theme=" + theme +
                ", value='" + value + '\'' +
                ", type=" + type +
                ", element=" + element +
                '}';
    }
}
