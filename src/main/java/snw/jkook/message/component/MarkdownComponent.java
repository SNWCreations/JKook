package snw.jkook.message.component;

/**
 * Represents the text component using Markdown syntax. <p>
 * <b>If you want to send the message using Markdown, use this instead of {@link TextComponent}.</b>
 */
public class MarkdownComponent extends TextComponent {
    public MarkdownComponent(String rawContent) {
        super(rawContent);
    }
}
