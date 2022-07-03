package snw.jkook.entity.channel;

import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;

import java.util.Collection;

/**
 * Represents a group of channel.
 */
public interface ChannelGroup extends Nameable, MasterHolder {

    /**
     * Return the channels in this group.
     */
    Collection<Channel> getChannels();
}
