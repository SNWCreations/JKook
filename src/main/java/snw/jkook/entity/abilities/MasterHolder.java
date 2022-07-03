package snw.jkook.entity.abilities;

import snw.jkook.entity.User;

/**
 * Represents a object that can hold an owner.
 */
public interface MasterHolder {

    /**
     * Get the creator/owner of this object.
     */
    User getMaster();
}
