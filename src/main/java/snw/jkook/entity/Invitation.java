package snw.jkook.entity;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.channel.Channel;
import snw.jkook.util.RequirePermission;

/**
 * Represents an invitation.
 */
public interface Invitation extends MasterHolder {

    /**
     * Get the guild related to this invitation.
     */
    Guild getGuild();

    /**
     * Get the channel related to this invitation.
     */
    Channel getChannel();

    /**
     * Get the url code of this invitation.
     */
    String getUrlCode();

    /**
     * Get the link URL of this invitation.
     */
    String getUrl();

    /**
     * Mark this invitation as invalid.
     */
    @RequirePermission(Permission.INVITE_MANAGE)
    void delete();
}
