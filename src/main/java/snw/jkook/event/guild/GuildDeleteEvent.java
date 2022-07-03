package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a guild was deleted.
 */
public class GuildDeleteEvent extends GuildEvent {
    private static final HandlerList handlers = new HandlerList();

    public GuildDeleteEvent(Guild guild) {
        super(guild);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
