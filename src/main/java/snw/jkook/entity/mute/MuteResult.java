package snw.jkook.entity.mute;

import snw.jkook.HttpAPI;
import snw.jkook.entity.Guild;

import java.util.Collection;

/**
 * Represents a mute result.
 *
 * @see Guild#getMuteStatus()
 */
public interface MuteResult extends Collection<MuteData> {
}
