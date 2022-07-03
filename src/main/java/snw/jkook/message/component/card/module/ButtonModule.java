package snw.jkook.message.component.card.module;

import snw.jkook.event.user.UserClickButtonEvent;
import snw.jkook.message.component.card.Theme;

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
