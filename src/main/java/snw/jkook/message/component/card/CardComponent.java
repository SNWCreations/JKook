package snw.jkook.message.component.card;

import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.card.module.BaseModule;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a card component.
 */
public class CardComponent extends BaseComponent {
    private final List<BaseModule> modules;
    private final Size size;

    public CardComponent(List<BaseModule> modules, Size size) {
        this.modules = new LinkedList<>(modules);
        this.size = size;
    }

    /**
     * Get the "size" of this component.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Get the total module count of this component.
     */
    public int moduleCount() {
        return modules.size();
    }

}
