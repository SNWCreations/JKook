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

package snw.jkook.message.component.card.module;

import snw.jkook.message.component.card.element.BaseElement;
import snw.jkook.message.component.card.element.ImageElement;
import snw.jkook.message.component.card.element.MarkdownElement;
import snw.jkook.message.component.card.element.PlainTextElement;
import snw.jkook.util.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 表示一个备注模块。
 */
public class ContextModule extends BaseModule {
    private final List<BaseElement> modules;

    public ContextModule(List<BaseElement> modules) {
        Validate.isTrue(modules.stream().allMatch(IT -> ((IT instanceof PlainTextElement) || (IT instanceof MarkdownElement) || (IT instanceof ImageElement))), "Context module only accepts plain-text, kmarkdown or image modules.");
        this.modules = Collections.unmodifiableList(modules);
    }

    /**
     * 获取已在此模块中存储的元素。
     */
    public List<BaseElement> getModules() {
        return modules;
    }

    /**
     * 一个用于构造 {@link ContextModule} 的建造器。
     */
    public static class Builder {
        private final List<BaseElement> modules = new LinkedList<>();

        public Builder add(PlainTextElement module) {
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
}
