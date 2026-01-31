/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.message.ChannelMessage;
import snw.jkook.message.component.BaseComponent;

/**
 * Represents a type of channel which is not a {@link Category}.
 */
public interface NonCategoryChannel extends Channel, InviteHolder {

    /**
     * Get the category that holds this channel.
     */
    @Nullable
    Category getParent();

    /**
     * Set the category that holds this channel.
     *
     * @param parent The parent of this channel, provide null if you don't want this channel belongs to any category
     */
    void setParent(@Nullable Category parent);

    /**
     * Send a message to this channel.
     *
     * @param message The message to send
     * @return Message ID
     */
    String sendComponent(String message);

    /**
     * Send a message to this channel.
     *
     * @param message    The message to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param tempTarget If you pass this parameter,
     *                   only the user to whom it corresponds can see the incoming message
     * @return Message ID
     */
    String sendComponent(String message, @Nullable ChannelMessage quote, @Nullable User tempTarget);

    /**
     * Send a message to this channel.
     *
     * @param component The message to send
     * @return Message ID
     */
    String sendComponent(BaseComponent component);

    /**
     * Send a message to this channel.
     *
     * @param component  The message to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param tempTarget If you pass this parameter,
     *                   only the user to whom it corresponds can see the incoming message
     * @return Message ID
     */
    String sendComponent(BaseComponent component, @Nullable ChannelMessage quote, @Nullable User tempTarget);

    /**
     * Get the limit of minimum speaking time between two statements. (in seconds)
     */
    int getChatLimitTime();

    /**
     * Set the limit of minimum speaking time between two statements.
     * (in <b>milliseconds</b>, it is different from {@link #getChatLimitTime()}) <p>
     * Only the following values are supported now:
     * <ul>
     *     <li>0</li>
     *     <li>5000</li>
     *     <li>10000</li>
     *     <li>15000</li>
     *     <li>30000</li>
     *     <li>60000</li>
     *     <li>120000</li>
     *     <li>300000</li>
     *     <li>600000</li>
     *     <li>900000</li>
     *     <li>1800000</li>
     *     <li>3600000</li>
     *     <li>7200000</li>
     *     <li>21600000</li>
     * </ul>
     *
     * @param ms The time in <b>milliseconds</b>
     */
    void setChatLimitTime(int ms);

    /**
     * Send a message to this channel.
     *
     * @param message    The message to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param tempTarget If you pass this parameter,
     *                   only the user to whom it corresponds can see the incoming message
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes in the same channel.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     * @return Message ID
     */
    String sendComponent(String message, @Nullable ChannelMessage quote, @Nullable User tempTarget, @Nullable String replyMsgId);

    /**
     * Send a message to this channel.
     *
     * @param component  The message to send
     * @param quote      If this parameter is passed in, the incoming message
     *                   will be considered a reply to the message corresponding to this parameter
     * @param tempTarget If you pass this parameter,
     *                   only the user to whom it corresponds can see the incoming message
     * @param replyMsgId The msg_id of a message sent by the user within 5 minutes in the same channel.
     *                   If this is the first reply from the bot, the daily quota consumption will be reduced.
     * @return Message ID
     */
    String sendComponent(BaseComponent component, @Nullable ChannelMessage quote, @Nullable User tempTarget, @Nullable String replyMsgId);
}
