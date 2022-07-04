package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.event.HandlerList;

/**
 * Represents an event related to a guild was deleted.
 */
public class GuildDeleteEvent extends GuildEvent {
    private static final HandlerList handlers = new HandlerList();

    public GuildDeleteEvent(final long timeStamp, final Guild guild) {
        super(timeStamp, guild);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
