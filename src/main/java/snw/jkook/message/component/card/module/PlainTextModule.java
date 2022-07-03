package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;
import snw.jkook.entity.abilities.Accessory;
import snw.jkook.entity.abilities.AccessoryHolder;

/**
 * Represents the module with plain text.
 */
public class PlainTextModule extends BaseModule implements AccessoryHolder {
    private final String value;
    private final Accessory accessory;

    public PlainTextModule(String value, Accessory accessory) {
        Validate.notNull(value, "The value cannot be null");
        Validate.isTrue(value.length() <= 2000, "Unexpected content length, expected <= 2000, got " + value.length());
        this.value = value;
        this.accessory = accessory;
    }

    /**
     * Get the value of this module.
     */
    public String getValue() {
        return value;
    }

    @Override
    public Accessory getAccessory() {
        return accessory;
    }
}
