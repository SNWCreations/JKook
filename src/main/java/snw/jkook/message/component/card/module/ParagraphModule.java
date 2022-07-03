package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;
import snw.jkook.entity.abilities.Accessory;
import snw.jkook.entity.abilities.AccessoryHolder;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the module with columns.
 */
public class ParagraphModule extends BaseModule implements AccessoryHolder {
    private final List<PlainTextModule> modules = new LinkedList<>();
    private final int cols;
    private final Accessory accessory;

    public ParagraphModule(int cols, Accessory accessory) {
        Validate.isTrue(cols > 0, "Columns cannot be negative.");
        Validate.isTrue(cols <= 3, "Columns cannot be greater than 3."); // Kook Official limit!
        this.cols = cols;
        this.accessory = accessory;
    }

    public int size() {
        return modules.size();
    }

    public boolean add(PlainTextModule plainTextModule) {
        if (modules.size() > 50) {
            throw new IllegalStateException("The paragraph modules can hold up to 50 elements.");
        }
        return modules.add(plainTextModule);
    }

    public boolean remove(PlainTextModule o) {
        return modules.remove(o);
    }

    public void clear() {
        modules.clear();
    }

    public int getColumns() {
        return cols;
    }

    @Override
    public Accessory getAccessory() {
        return accessory;
    }
}
