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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.PageIterator;

import java.util.Collection;

/**
 * 表示一个文字频道。
 */
public interface TextChannel extends Channel {

    /**
     * 获取此频道的简介。
     */
    String getTopic();

    /**
     * 设置此频道的简介。
     *
     * @param topic 简介文本，长度不可超过 500
     */
    void setTopic(String topic);

    /**
     * 使用提供的信息获取此频道的消息历史。
     *
     * @param refer     参考消息，KOOK 服务端将根据这个参数查询消息，传 {@code null} 时将最新消息看着参考消息
     * @param isPin     是否查询置顶消息。置顶消息只支持查询最新的消息(因此，当此项为 {@code true} 时，{@code refer} 参数必须为 {@code null})
     * @param queryMode 查询模式，仅接受 "before"，"around" 和 "after"，<b>区分大小写！</b>
     */
    PageIterator<Collection<TextChannelMessage>> getMessages(
            @Nullable String refer,
            boolean isPin,
            String queryMode
    );

    /**
     * 向此频道发送消息。
     *
     * @param message    消息内容
     * @return           新消息的 ID
     */
    String sendComponent(String message);

    /**
     * 向此频道发送消息。
     *
     * @param message    消息内容
     * @param quote      若传入了，则新的消息将被看作是指定消息的回复
     * @param tempTarget 若传入了，则发送的消息将只有指定的用户能看见，并且消息将被看作临时消息
     * @return           新消息的 ID
     */
    String sendComponent(String message, @Nullable TextChannelMessage quote, @Nullable User tempTarget);

    /**
     * 向此频道发送消息。
     *
     * @param component  消息内容
     * @return           新消息的 ID
     */
    String sendComponent(BaseComponent component);

    /**
     * 向此频道发送消息。
     *
     * @param component  消息内容
     * @param quote      若传入了，则新的消息将被看作是指定消息的回复
     * @param tempTarget 若传入了，则发送的消息将只有指定的用户能看见，并且消息将被看作临时消息
     * @return           新消息的 ID
     */
    String sendComponent(BaseComponent component, @Nullable TextChannelMessage quote, @Nullable User tempTarget);

    /**
     * 获取此频道在限速模式下发送消息需要的间隔时间。<br>
     * <b>返回值以秒为单位。</b>
     */
    int getChatLimitTime();

    /**
     * 设置此频道在限速模式下发送消息需要的间隔时间。<br>
     * <b>参数要求以毫秒为单位。这与 {@link #getChatLimitTime()} 不同。</b><br>
     * 以下提供了一些预先计算好的间隔时间(<b>KOOK 服务端也仅支持这些值！</b>):
     * <ul>
     *     <li>0</li>
     *     <li>5000 - 5 秒</li>
     *     <li>10000 - 10 秒</li>
     *     <li>15000 - 15 秒</li>
     *     <li>30000 - 30 秒</li>
     *     <li>60000 - 1 分钟</li>
     *     <li>120000 - 2 分钟</li>
     *     <li>300000 - 5 分钟</li>
     *     <li>600000 - 10 分钟</li>
     *     <li>900000 - 15 分钟</li>
     *     <li>1800000 - 30 分钟</li>
     *     <li>3600000 - 1 小时</li>
     *     <li>7200000 - 2 小时</li>
     *     <li>21600000 - 6 小时</li>
     * </ul>
     *
     * @param ms <b>以毫秒为单位的时间</b>
     */
    void setChatLimitTime(int ms);
}
