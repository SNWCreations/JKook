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

package snw.jkook.entity.abilities;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.User;

import java.util.Collection;

/**
 * 表示一种可以接收回应的对象。
 */
public interface ReactionHolder {

    /**
     * 获取所有向此对象添加了指定表情的用户。
     *
     * @param emoji 表情对象
     * @throws IllegalStateException 当无法访问指定的表情时抛出
     */
    Collection<User> getUserByReaction(CustomEmoji emoji) throws IllegalStateException;

    /**
     * 向此对象添加指定的表情作为回应。
     *
     * @param emoji 表情对象
     */
    void sendReaction(CustomEmoji emoji);

    /**
     * 从此对象上移除来自自己的指定的表情回应。
     *
     * @param emoji 表情对象
     */
    void removeReaction(CustomEmoji emoji);
}
