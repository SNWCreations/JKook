package snw.jkook.message;

import snw.jkook.entity.channel.TextChannel;

/**
 * Represents a message from a text channel.
 */
public interface TextChannelMessage extends Message {

    /**
     * Get the channel that contains this message.
     */
    TextChannel getChannel();

    /**
     * Return true if this message is pinned in the channel.
     */
    boolean isPinned();

    /**
     * Set the pinned status of this message.
     *
     * @param pinned The status
     */
    void setPinned(boolean pinned);
}
