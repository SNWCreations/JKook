package snw.jkook.message.component;

/**
 * Represents the module with a file.
 */
public class FileComponent extends BaseComponent {
    private final String url;
    private final String title;
    private final int size;
    private final Type type;

    public FileComponent(String url, String title, int size, Type type) {
        this.url = url;
        this.title = title;
        this.size = size;
        this.type = type;
    }

    /**
     * Get the targeted image url of this module.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Return the title of this file.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the size of this file. Unit is byte.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the type of this file.
     */
    public Type getType() {
        return type;
    }

    /**
     * Represents the types allowed by this module.
     */
    public enum Type {

        /**
         * Represents the normal file.
         */
        FILE("file"),

        /**
         * Represents the audio file.
         */
        AUDIO("audio"),

        /**
         * Represents the video file.
         */
        VIDEO("video"),

        /**
         * Represents the image file.
         */
        IMAGE("image");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
