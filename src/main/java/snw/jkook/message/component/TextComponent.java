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

package snw.jkook.message.component;

/**
 * 表示一个纯文本消息组件。<br>
 * 
 * <b>注意: KOOK 已弃用纯文本消息组件。</b>KOOK 会将所有的纯文本消息组件自动转换为 Markdown 消息组件。<br>
 * 所以严格意义上，此类和 {@link MarkdownComponent} 在使用上已经没有区别了，并且更推荐使用后者。
 */
public class TextComponent extends BaseComponent {
    private final String rawContent;

    public TextComponent(String rawContent) {
        this.rawContent = rawContent;
    }

    /**
     * 获取此消息组件的内容。
     */
    public String toString() {
        return rawContent;
    }
}
