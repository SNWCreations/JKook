package snw.jkook.entity.abilities;

/**
 * Represents the modules that can be included in other modules.
 */
public interface Accessory {

    /**
     * Get the current mode of this accessory.
     */
    Mode getMode();

    /**
     * Represents the available modes of the accessories.
     */
    enum Mode {
        /**
         * The default card size. <p>
         * This parameter is valid only on the PC. (Mobile will render the LG cards using SM size.)
         */
        LEFT("left"),

        /**
         * This size has the best compatibility.
         */
        RIGHT("right");

        private final String value;

        Mode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
