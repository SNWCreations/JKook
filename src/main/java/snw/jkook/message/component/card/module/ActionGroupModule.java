package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a group of something can cause some actions. (e.g. {@link ActionModule})
 */
public class ActionGroupModule extends BaseModule {
    private final List<ActionModule> buttons;

    public ActionGroupModule(List<ActionModule> buttons) {
        Validate.isTrue(buttons.size() >= 1, "Unexpected image module count, expected >= 1, got " + buttons.size());
        Validate.isTrue(buttons.size() <= 4, "Unexpected image module count, expected <= 4, got " + buttons.size());
        this.buttons = Collections.unmodifiableList(new LinkedList<>(buttons));
    }

    /**
     * Get the images that already stored in this module.
     */
    public List<ActionModule> getButtons() {
        return buttons;
    }
}
