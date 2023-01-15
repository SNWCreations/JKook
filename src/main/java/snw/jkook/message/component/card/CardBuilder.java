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

package snw.jkook.message.component.card;

import snw.jkook.message.component.card.module.BaseModule;
import snw.jkook.util.Validate;

import java.util.LinkedList;
import java.util.List;

/**
 * 表示一个卡片构造器。
 */
public class CardBuilder {
    private Theme theme;
    private Size size;
    private String color;
    private List<BaseModule> modules = new LinkedList<>();
    private final List<CardComponent> cards = new LinkedList<>();

    /**
     * 为当前的卡片设置主题。
     *
     * @param theme 主题的枚举对象
     * @see Theme
     */
    public CardBuilder setTheme(Theme theme) {
        this.theme = theme;
        return this;
    }

    /**
     * 设置卡片的渲染大小。
     *
     * @param size 卡片大小的枚举对象
     */
    public CardBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    /**
     * 设置当前卡片的侧边颜色。
     *
     * @param color 十六进制颜色字符串（如 "#AAAAAA"）
     * @see CardComponent#getColor()
     */
    public CardBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * 向当前卡片增加一个模块。
     *
     * @param module 模块对象
     */
    public CardBuilder addModule(BaseModule module) {
        this.modules.add(module);
        return this;
    }

    /**
     * 将当前的数据保存到一个卡片对象，并重置此构造器的数据。<br>
     * 在这之后，新的数据将被看作是为新卡片准备的。<br>
     * 使用示例:
     * <blockquote><pre>
     *     new CardBuilder()
     *         .setTheme(Theme.PRIMARY)
     *         .setSize(Size.LG)
     *         .addModule(new HeaderModule(new PlainTextElement("This is header", false)))
     *         .addModule(new SectionModule(new PlainTextElement("This is body"), null, null))
     *         .newCard() // 现在，一个新的有 2 个模块的卡片将被保存，然后主题、大小、模块列表将重置。
     *         .setTheme(Theme.DANGER)
     *         .setSize(Size.LG)
     *         .addModule(new HeaderModule(new PlainTextElement("This is header of the second card", false)))
     *         .addModule(new SectionModule(new PlainTextElement("This is body of the second card"), null, null))
     *         .build(); // 你将得到一个由 2 个卡片组成的复合卡片对象
     * </pre></blockquote>
     */
    public CardBuilder newCard() {
        Validate.notNull(size, "Size is not defined yet!");
        Validate.notNull(theme, "Theme is not defined yet!");
        cards.add(new CardComponent(modules, size, theme, color));
        // create a new one instead of clear() to make sure the added component won't be empty.
        modules = new LinkedList<>();
        theme = null;
        size = null;
        return this;
    }

    /**
     * 构造并返回最终的卡片对象。
     */
    public MultipleCardComponent build() {
        if (!modules.isEmpty()) {
            newCard();
        }
        return new MultipleCardComponent(cards);
    }
}
