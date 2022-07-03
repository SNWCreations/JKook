package snw.jkook.message.component.card;

/**
 * Represents the available sizes of the cards.
 */
public enum Size {

    /**
     * The default card size. <p>
     * This parameter is valid only on the PC. (Mobile will render the LG cards using SM size.)
     */
    LG("lg"),

    SM("sm"),

    // The unsupported size for card (not its module) is following:

    XS("xs"),

    MD("md");

    private final String value;

    Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
