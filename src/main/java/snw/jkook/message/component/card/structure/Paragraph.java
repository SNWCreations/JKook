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

package snw.jkook.message.component.card.structure;

import snw.jkook.message.component.card.element.BaseElement;
import snw.jkook.message.component.card.element.MarkdownElement;
import snw.jkook.message.component.card.element.PlainTextElement;
import snw.jkook.util.Validate;

import java.util.Collection;
import java.util.Collections;

/**
 * Represents a "paragraph" module.
 */
public class Paragraph extends BaseStructure {
    private final int columns;
    private final Collection<BaseElement> fields;

    public Paragraph(int columns, Collection<BaseElement> fields) {
        Validate.isTrue(
                fields.stream().allMatch(IT -> (IT instanceof PlainTextElement || IT instanceof MarkdownElement)),
                "Paragraph only accepts plain-text and kmarkdown."
        );
        this.columns = columns;
        this.fields = Collections.unmodifiableCollection(fields);
    }

    /**
     * Get the columns of this module.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Get the fields that stored by this structure.
     */
    public Collection<BaseElement> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "columns=" + columns +
                ", fields=" + fields +
                '}';
    }
}
