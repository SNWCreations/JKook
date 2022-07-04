package snw.jkook.event.guild;

import snw.jkook.entity.Guild;
import snw.jkook.event.Event;

import java.util.Objects;

/**
 * Represents an event related to a guild.
 */
public abstract class GuildEvent extends Event {
    private final Guild guild;

    GuildEvent(final long timeStamp, final Guild guild) {
        super(timeStamp);
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * Get the guild related to this event.
     */
    public Guild getGuild() {
        return guild;
    }

}
