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

package snw.jkook.message.component.card.module;

import snw.jkook.entity.abilities.Accessory;
import snw.jkook.entity.abilities.AccessoryHolder;
import snw.jkook.message.component.card.CardScopeElement;
import snw.jkook.message.component.card.element.MarkdownElement;
import snw.jkook.message.component.card.element.PlainTextElement;
import snw.jkook.message.component.card.structure.Paragraph;
import snw.jkook.util.Validate;

/**
 * Represents a section module.
 */
public class SectionModule extends BaseModule implements AccessoryHolder {
    private final CardScopeElement text;
    private final Accessory accessory;
    private final Accessory.Mode mode;

    /**
     * @param text <b>KMarkdown</b> text.
     *             If you want to use plain text, use the constructor
     *             with arguments {@code (String, boolean)} instead.
     */
    public SectionModule(String text) {
        this(text, true);
    }

    public SectionModule(String text, boolean isKMD) {
        this(text, isKMD, false);
    }

    public SectionModule(String text, boolean isKMD, boolean emojiIfPlain) {
        this(isKMD ? new MarkdownElement(text) : new PlainTextElement(text, emojiIfPlain), null, null);
    }

    public SectionModule(CardScopeElement text) {
        this(text, null, null);
    }

    public SectionModule(CardScopeElement text, Accessory accessory, Accessory.Mode mode) {
        Validate.isTrue(
                text instanceof PlainTextElement ||
               text instanceof MarkdownElement ||
               text instanceof Paragraph,
                "Section module only accepts plain-text, kmarkdown and paragraph."
        );
        this.text = text;
        this.accessory = accessory;
        this.mode = mode;
    }

    /**
     * Get the text that stored by this module.
     */
    public CardScopeElement getText() {
        return text;
    }

    @Override
    public Accessory getAccessory() {
        return accessory;
    }

    @Override
    public Accessory.Mode getMode() {
        return mode;
    }

    @Override
    public String toString() {
        return "SectionModule{" +
                "text=" + text +
                ", accessory=" + accessory +
                ", mode=" + mode +
                '}';
    }
}
