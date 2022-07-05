package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;

/**
 * Represents the module with Markdown text.
 */
public class MarkdownModule extends BaseModule {
    private final String value;

    public MarkdownModule(String value) {
        Validate.notNull(value, "The value cannot be null");
        Validate.isTrue(value.length() <= 5000, "Unexpected content length, expected <= 5000, got " + value.length());
        this.value = value;
    }

    /**
     * Get the value of this module.
     */
    public String getValue() {
        return value;
    }
}
