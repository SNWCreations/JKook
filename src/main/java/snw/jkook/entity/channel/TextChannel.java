package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.message.Message;
import snw.jkook.message.component.BaseComponent;

/**
 * Represents a channel that can chat using texts.
 */
public interface TextChannel extends Channel {

    /**
     * Send a message to this channel.
     *
     * @param component  The message to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param tempTarget If you pass this parameter,
     *                   only the user to whom it corresponds can see the incoming message
     */
    void sendComponent(BaseComponent component, @Nullable Message quote, @Nullable User tempTarget);
}
