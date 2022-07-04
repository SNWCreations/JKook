package snw.jkook.message.component;

/**
 * Represents a basic component in Kook. <p>
 * This interface should <b>NOT</b> be implemented. Implement its sub-interface instead.
 */
public class BaseComponent implements Cloneable {

    protected BaseComponent() {
    }

    @Override
    public BaseComponent clone() {
        try {
            return (BaseComponent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
