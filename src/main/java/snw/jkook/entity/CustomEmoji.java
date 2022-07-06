package snw.jkook.entity;

import snw.jkook.Permission;
import snw.jkook.util.RequirePermission;

/**
 * Represents a emoji in a {@link Guild}.
 */
public interface CustomEmoji {

    /**
     * Get the image url of this emoji.
     */
    String getUrl();

    /**
     * Get the guild that owns this emoji.
     */
    Guild getGuild();

    /**
     * Get the uploader of this emoji.
     */
    User getUploader();

    /**
     * Delete this emoji if possible. (Fails silently.)
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    void delete();
}
