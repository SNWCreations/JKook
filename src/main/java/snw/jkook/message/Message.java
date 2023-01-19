/*
 * Copyright 2022 - 2023 JKook contributors
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

import org.jetbrains.annotations.Nullable;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.ReactionHolder;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.message.component.MarkdownComponent;
import snw.jkook.message.component.card.CardComponent;
import snw.jkook.message.component.card.MultipleCardComponent;
import snw.jkook.util.RequirePermission;

/**
 * Represents a message.
 */
public interface Message extends Receivable, ReactionHolder {

    /**
     * Get the component in this message.
     */
    BaseComponent getComponent();

    /**
     * Set the component that stored by this message. <p>
     * Only support messages that contains {@link MarkdownComponent} or Card (both {@link CardComponent} and {@link MultipleCardComponent}) <b>now</b>.
     *
     * @param component The component
     */
    void setComponent(BaseComponent component);

    /**
     * Get the ID of this message.
     */
    String getId();

    /**
     * Get the message that quoted by this message. <p>
     * <b>WARNING!</b> In the result of this method, only the following methods are safe:
     * <ul>
     *     <li>{@link #getComponent()}</li>
     *     <li>{@link #getId()}</li>
     *     <li>{@link #getSender()}</li>
     *     <li>{@link #getTimeStamp()}</li>
     * </ul>
     * The result of the other methods are <b>undefined</b>. Maybe throwing exceptions? Or providing incorrect result?
     */
    @Nullable
    Message getQuote();

    /**
     * Send a component <b>as the reply</b> of this message.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String reply(String message);

    /**
     * Send a component to the source of this message (e.g. a user, a text channel),
     * <b>IT IS DIFFERENT FROM {@link #reply}</b>.
     *
     * @param message     The message content
     * @return            The Message ID
     */
    String sendToSource(String message);

    /**
     * Send a component <b>as the reply</b> of this message.
     *
     * @param component   The component
     * @return            The Message ID
     */
    String reply(BaseComponent component);

    /**
     * Send a component to the source of this message (e.g. a user, a text channel),
     * <b>IT IS DIFFERENT FROM {@link #reply}</b>.
     *
     * @param component   The component
     * @return            The Message ID
     */
    String sendToSource(BaseComponent component);

    /**
     * Delete this message .
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
