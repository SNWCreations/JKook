package snw.jkook.message;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.ReactionHolder;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.RequirePermission;

/**
 * Represents a message.
 */
public interface Message extends Receivable, ReactionHolder {

    /**
     * Get the component in this message.
     */
    BaseComponent getComponent();

    /**
     * Get the ID of this message.
     */
    String getId();

    /**
     * Delete this message if possible. (Fails silently.)
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
