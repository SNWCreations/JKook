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

package snw.jkook.message.component.card.element;

import snw.jkook.util.Validate;

/**
 * Represents the KMarkdown element.
 */
public class MarkdownElement extends BaseElement {
    private final String content;

    public MarkdownElement(String content) {
        Validate.isTrue(content.length() <= 5000, "Too long content for markdown element is not allowed.");
        this.content = content;
    }

    /**
     * Get the content that stored by this element.
     */
    public String getContent() {
        return content;
    }
}
