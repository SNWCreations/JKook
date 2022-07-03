package snw.jkook.event.guild;

import snw.jkook.entity.Guild;

import java.util.Objects;

/**
 * Represents an event related to a guild.
 */
public abstract class GuildEvent {
    private final Guild guild;

    GuildEvent(final Guild guild) {
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * Get the guild related to this event.
     */
    public Guild getGuild() {
        return guild;
    }

}
