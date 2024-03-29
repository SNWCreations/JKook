package snw.jkook.message;

import snw.jkook.Permission;
import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.NonCategoryChannel;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.MarkdownComponent;
import snw.jkook.message.component.card.CardComponent;
import snw.jkook.message.component.card.MultipleCardComponent;
import snw.jkook.util.RequirePermission;

public interface ChannelMessage extends Message {

    /**
     * Get the channel that contains this message.
     */
    NonCategoryChannel getChannel();

    /**
     * Send a component <b>as the reply</b> of this message,
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String replyTemp(String message);

    /**
     * Send a component to the source of this message (e.g. a user, a text channel),
     * <b>IT IS DIFFERENT FROM {@link #replyTemp}</b>.
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String sendToSourceTemp(String message);

    /**
     * Send a component <b>as the reply</b> of this message,
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param component   The component
     * @return            The Message ID
     */
    String replyTemp(BaseComponent component);

    /**
     * Send a component to the source of this message (e.g. a user, a text channel),
     * <b>IT IS DIFFERENT FROM {@link #replyTemp}</b>.
     * but it will be marked as the temporary message, and it won't be saved in Kook's database.
     *
     * @param component   The component
     * @return            The Message ID
     */
    String sendToSourceTemp(BaseComponent component);

    /**
     * Temporary set the component that stored by this message. <p>
     * Only the user that specified by the user parameter will see the new component. <p>
     * Only support messages that contains {@link MarkdownComponent} or Card (both {@link CardComponent} and {@link MultipleCardComponent}) <b>now</b>.
     * It is similar to {@link #replyTemp(BaseComponent)}.
     *
     * @param user The user as the receiver of the new component
     * @param component The component
     */
    void setComponentTemp(User user, BaseComponent component);

    /**
     * Temporary set the component that stored by this message. <p>
     * Only the user that specified by the user parameter will see the new component. <p>
     * This method just constructs the {@link MarkdownComponent} with provided content and pass it to {@link #setComponentTemp(User, BaseComponent)}.
     *
     * @param user The user as the receiver of the new content
     * @param content The new content
     */
    void setComponentTemp(User user, String content);

    /**
     * Remove a reaction that added by the specified user.
     *
     * @param emoji The emoji of the reaction
     * @param user The user as the reaction's creator
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void removeReaction(CustomEmoji emoji, User user);

}
