package snw.jkook.entity.abilities;

import snw.jkook.entity.abilities.Accessory;

/**
 * Represents the modules that can include other modules.
 */
public interface AccessoryHolder {

    /**
     * Get the accessory that this object currently holds.
     */
    Accessory getAccessory();
}
