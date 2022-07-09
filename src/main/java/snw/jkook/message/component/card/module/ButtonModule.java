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

package snw.jkook.message.component.card.module;

import snw.jkook.event.user.UserClickButtonEvent;
import snw.jkook.message.component.card.Theme;

/**
 * Represents a button module. It can cause a {@link UserClickButtonEvent}.
 */
public class ButtonModule extends ActionModule {
    private final EventType type;
    private final Theme theme;
    private final String value;
    private final String text;


    public ButtonModule(Theme theme, String value, String text) {
        this(EventType.NO_ACTION, theme, value, text);
    }

    public ButtonModule(EventType type, Theme theme, String value, String text) {
        this.type = type;
        this.theme = theme;
        this.value = value;
        this.text = text;
    }

    /**
     * Get theme of this module.
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Get the value of this module.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the text of this module.
     */
    public String getText() {
        return text;
    }

    /**
     * Get the event type of this module.
     */
    public EventType getType() {
        return type;
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

        private final String value;

        EventType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
