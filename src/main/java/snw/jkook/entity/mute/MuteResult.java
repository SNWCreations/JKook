package snw.jkook.entity.mute;

import snw.jkook.HttpAPI;
import snw.jkook.entity.Guild;

import java.util.Collection;

/**
 * Represents a mute result.
 *
 * @see HttpAPI#getMuteStatus(Guild)
 */
public interface MuteResult extends Collection<MuteData> {
}
