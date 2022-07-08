package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import snw.jkook.entity.User;
import snw.jkook.message.Message;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.message.component.BaseComponent;

import java.util.Collection;

/**
 * Represents a channel that can chat using texts.
 */
public interface TextChannel extends Channel {

    /**
     * Get the messages in this channel by given information.
     *
     * @param refer The reference message, remote will query the data around this. <p> Null to get the latest message
     * @param isPin True if query pinned message. If you provide true, then you must provide null to "refer" argument, and only the pinned messages will be returned
     * @param queryMode The query mode. Only accepts "before", "around" and "after". Case Sensitive!
     * @param pageSize The size of the page
     */
    Collection<TextChannelMessage> getMessages(
            @Nullable String refer,
            boolean isPin,
            String queryMode,
            @Range(from = 1, to = 100) int pageSize
    );

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
