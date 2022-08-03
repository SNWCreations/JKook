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

import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a card component.
 */
public class CardComponent extends BaseComponent {
    private final List<CardScopeElement> modules;
    private final Size size;
    private final Theme theme;

    public CardComponent(List<CardScopeElement> modules, Size size, Theme theme) {
        Validate.isTrue(
                size == Size.LG || size == Size.SM,
                "Card object only accepts LG and SM size."
        );
        this.modules = Collections.unmodifiableList(new LinkedList<>(modules));
        this.size = size;
        this.theme = theme;
    }

    /**
     * Get the "size" of this component.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Get the modules that stored in this component.
     */
    public List<CardScopeElement> getModules() {
        return modules;
    }

    /**
     * Get the total module count of this component.
     */
    public int moduleCount() {
        return modules.size();
    }

    /**
     * Get theme of this component.
     */
    public Theme getTheme() {
        return theme;
    }
}
