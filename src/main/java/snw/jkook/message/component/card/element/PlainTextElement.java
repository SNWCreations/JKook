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

package snw.jkook.message.component.card.element;

import snw.jkook.util.Validate;

/**
 * 表示一个不使用 KMarkdown 语法的纯文本元素。
 */
public class PlainTextElement extends BaseElement {
    private final String content;
    private final boolean emoji;

    public PlainTextElement(String content) {
        this(content, false);
    }

    public PlainTextElement(String content, boolean emoji) {
        Validate.isTrue(content.length() <= 2000, "Too long content is not allowed.");
        this.content = content;
        this.emoji = emoji;
    }

    /**
     * 获取此元素的文本内容。
     */
    public String getContent() {
        return content;
    }

    /**
     * 若 KOOK 客户端在渲染此元素时会将文本中的 Emoji Shortcut（如 ":smile:"）渲染为对应 Emoji ，返回 {@code true}。
     */
    public boolean willConvertEmoji() {
        return emoji;
    }
}
