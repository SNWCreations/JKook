package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;
import snw.jkook.entity.abilities.Accessory;
import snw.jkook.entity.abilities.AccessoryHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the module with columns.
 */
public class ParagraphModule extends BaseModule implements AccessoryHolder {
    private final List<PlainTextModule> modules;
    private final int cols;
    private final Accessory accessory;

    public ParagraphModule(int cols, List<PlainTextModule> modules, Accessory accessory) {
        this.modules = Collections.unmodifiableList(new LinkedList<>(modules));
        Validate.isTrue(cols > 0, "Columns cannot be negative.");
        Validate.isTrue(cols <= 3, "Columns cannot be greater than 3."); // Kook Official limit!
        this.cols = cols;
        this.accessory = accessory;
    }

    /**
     * Get the columns of this module.
     */
    public int getColumns() {
        return cols;
    }

    @Override
    public Accessory getAccessory() {
        return accessory;
    }

    /**
     * Get the modules stored by this module.
     */
    public List<PlainTextModule> getModules() {
        return modules;
    }
}
