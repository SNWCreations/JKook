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

package snw.jkook;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Game;
import snw.jkook.message.PrivateMessage;
import snw.jkook.message.TextChannelMessage;

/**
 * 一个可以提供部分<b>不安全</b>操作的接口。<br>
 * 此接口下的所有方法不会检查它们所得到的参数。<br>
 * 你需要自行处理因为不恰当地使用此接口导致的异常。<br>
 * 由此接口下的方法返回的对象中的部分方法可能不会按设计预期工作。
 */
public interface Unsafe {

    /**
     * 使用 {@code id} 构造 {@link TextChannelMessage} 。返回的结果中只有 {@code id} 可用。
     *
     * @param id 消息 ID
     */
    TextChannelMessage getTextChannelMessage(String id);

    /**
     * 使用 {@code id} 构造 {@link PrivateMessage} 。返回的结果中只有 {@code id} 可用。
     *
     * @param id 消息 ID
     */
    PrivateMessage getPrivateMessage(String id);

    /**
     * 使用 {@code id} 构造 {@link CustomEmoji} 。返回的结果中只有 {@code id} 可用。
     *
     * @param id Emoji ID
     */
    CustomEmoji getEmoji(String id);

    /**
     * 使用 {@code id} 构造 {@link Game} 。返回的结果中只有 {@code id} 可用。
     *
     * @param id 游戏 ID
     */
    Game getGame(int id);
}
