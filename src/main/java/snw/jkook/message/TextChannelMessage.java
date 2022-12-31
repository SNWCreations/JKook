/*
 * Copyright 2022 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snw.jkook.message;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.MarkdownComponent;
import snw.jkook.message.component.card.CardComponent;
import snw.jkook.message.component.card.MultipleCardComponent;

/**
 * Represents a message from a text channel.
 */
public interface TextChannelMessage extends Message {

    /**
     * Get the channel that contains this message.
     */
    TextChannel getChannel();


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

}
