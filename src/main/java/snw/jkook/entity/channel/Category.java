package snw.jkook.entity.channel;

import org.jetbrains.annotations.Contract;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;

import java.util.Collection;

/**
 * Represents a group of channel.
 */
public interface Category extends Channel, Nameable, MasterHolder {

    @Contract("_, _-> fail")
    @Override
    default String createInvite(int validSeconds, int validTimes) {
        throw new UnsupportedOperationException("Kook does not support the users inviting other users to a category.");
    }

    @Contract("_ -> fail")
    @Override
    default void removeInvite(String urlCode) {
        throw new UnsupportedOperationException("Kook does not support the users inviting other users to a category.");
    }

    /**
     * Return the channels in this group.
     */
    Collection<Channel> getChannels();
}
