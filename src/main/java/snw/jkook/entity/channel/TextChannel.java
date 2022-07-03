package snw.jkook.entity.channel;

import snw.jkook.message.component.BaseComponent;

/**
 * Represents a channel that can chat using texts.
 */
public interface TextChannel extends Channel {

    /**
     * Send a message to this channel.
     *
     * @param component The message to send
     */
    void sendComponent(BaseComponent component);
}
