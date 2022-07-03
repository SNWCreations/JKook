package snw.jkook.message.component.card;

/**
 * Represents themes for the cards. <p>
 * Affects the sidebar color.
 */
public enum Theme {

    PRIMARY("primary"),
    SUCCESS("success"),
    DANGER("danger"),
    WARNING("warning"),
    INFO("info"),
    SECONDARY("secondary"),
    NONE("none");

    private final String value;

    Theme(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
