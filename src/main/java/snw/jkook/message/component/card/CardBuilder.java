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

package snw.jkook.message.component.card;

import snw.jkook.message.component.card.module.BaseModule;
import snw.jkook.util.Validate;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a card builder. Support multiple card.
 */
public class CardBuilder {
    private Theme theme;
    private Size size;
    private List<CardScopeElement> modules = new LinkedList<>();
    private final List<CardComponent> cards = new LinkedList<>();

    /**
     * Set theme of current card.
     * @param theme The theme
     */
    public CardBuilder setTheme(Theme theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Set the size of current card.
     * @param size The size
     */
    public CardBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    /**
     * Add a module to current card.
     * @param module The module
     */
    public CardBuilder addModule(BaseModule module) {
        this.modules.add(module);
        return this;
    }

    /**
     * Create a new card using the data that saved by this builder and reset the data in this builder. <p>
     * After that, you can create new card! <p>
     * Example:
     * <blockquote><pre>
     *     new CardBuilder()
     *         .setTheme(Theme.PRIMARY)
     *         .setSize(Size.LG)
     *         .addModule(new HeaderModule(new PlainTextElement("This is header", false))) // now the builder have a header
     *         .addModule(new SectionModule(new PlainTextElement("This is body"), null, null)) // now the builder have a body
     *         .newCard() // now a card will be built, and the data will be reset
     *         .setTheme(Theme.DANGER)
     *         .setSize(Size.LG)
     *         .addModule(new HeaderModule(new PlainTextElement("This is header of the second card", false))) // the header of the second card
     *         .addModule(new SectionModule(new PlainTextElement("This is body of the second card"), null, null)) // the body of the second card
     *         .build(); // you will got a multiple card, and two cards inside it.
     * </pre></blockquote>
     */
    public CardBuilder newCard() {
        Validate.notNull(size, "Size is not defined yet!");
        Validate.notNull(theme, "Theme is not defined yet!");
        cards.add(new CardComponent(modules, size, theme));
        // create a new one instead of clear() to make sure the added component won't be empty.
        modules = new LinkedList<>();
        theme = null;
        size = null;
        return this;
    }

    /**
     * Build the multiple card.
     */
    public MultipleCardComponent build() {
        if (!modules.isEmpty()) {
            newCard();
        }
        return new MultipleCardComponent(cards);
    }
}
