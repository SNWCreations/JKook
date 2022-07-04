package snw.jkook.message.component.card;

import snw.jkook.message.component.BaseComponent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents the component with multiple cards.
 */
public class MultipleCardComponent extends BaseComponent {
    private final List<CardComponent> components;

    public MultipleCardComponent(List<CardComponent> components) {
        if (components.size() > 5) { // Kook Official limit!
            throw new IllegalStateException("Unexpected card count. Expected <= 5, got " + components.size());
        }
        AtomicInteger totalModules = new AtomicInteger();
        for (CardComponent component : components) {
            totalModules.addAndGet(component.moduleCount());
        }
        if (totalModules.get() > 50) {
            throw new IllegalStateException("The card module count is out of allowed range! Expected <= 50, got " + totalModules);
        }
        this.components = Collections.unmodifiableList(new LinkedList<>(components));
    }

    /**
     * Get the components stored by this component.
     */
    public List<CardComponent> getComponents() {
        return components;
    }
}
