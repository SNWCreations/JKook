package snw.jkook.entity;

import org.jetbrains.annotations.Contract;
import snw.jkook.Permission;
import snw.jkook.util.RequirePermission;

/**
 * Represents a emoji in a {@link Guild}.
 */
public interface CustomEmoji {

    /**
     * Get the image url of this emoji.
     *
     * @return Always return <code>null</code>
     * @deprecated This method can't work because the Kook official does <b>NOT</b> provide URL.
     */
    @Contract("-> null")
    @Deprecated
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
