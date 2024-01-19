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

import snw.jkook.message.component.card.element.BaseElement;
import snw.jkook.message.component.card.element.ImageElement;
import snw.jkook.message.component.card.element.MarkdownElement;
import snw.jkook.message.component.card.element.PlainTextElement;
import snw.jkook.util.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ContextModule extends BaseModule {
    private final List<BaseElement> modules;

    public ContextModule(List<BaseElement> modules) {
        Validate.isTrue(modules.stream().allMatch(IT -> ((IT instanceof PlainTextElement) || (IT instanceof MarkdownElement) || (IT instanceof ImageElement))), "Context module only accepts plain-text, kmarkdown or image modules.");
        this.modules = Collections.unmodifiableList(modules);
    }

    /**
     * Get the modules that stored in this module.
     */
    public List<BaseElement> getModules() {
        return modules;
    }

    /**
     * A simple builder for building {@link ContextModule}.
     */
    public static class Builder {
        private final List<BaseElement> modules = new LinkedList<>();

        public Builder add(PlainTextElement module) {
            modules.add(module);
            return this;
        }

        public Builder add(MarkdownElement module) {
            modules.add(module);
            return this;
        }

        public Builder add(ImageElement module) {
            modules.add(module);
            return this;
        }

        public ContextModule build() {
            return new ContextModule(modules);
        }
    }

    @Override
    public String toString() {
        return "ContextModule{" +
                "modules=" + modules +
                '}';
    }
}
