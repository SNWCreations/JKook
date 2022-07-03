package snw.jkook.message.component;

/**
 * Represents a component that contains the text.
 */
public class TextComponent extends BaseComponent {
    private final String rawContent;

    public TextComponent(String rawContent) {
        this.rawContent = rawContent;
    }

    /**
     * Return the content of this component.
     */
    public String toString() {
        return rawContent;
    }
}
