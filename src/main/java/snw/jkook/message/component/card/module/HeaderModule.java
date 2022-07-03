package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;

/**
 * Represents the header module. Accepts plain text only.
 */
public class HeaderModule extends BaseModule {
    private final String value;

    public HeaderModule(String value) {
        Validate.notNull(value, "The value cannot be null");
        Validate.isTrue(value.length() <= 100, "Unexpected header text length. Expected <= 100, got " + value.length());
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
