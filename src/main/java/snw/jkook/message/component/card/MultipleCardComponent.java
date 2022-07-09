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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents the component with multiple cards.
 */
public class MultipleCardComponent extends BaseComponent {
    private final List<CardComponent> components;

    public MultipleCardComponent(List<CardComponent> components) {
        if (components.size() > 5) { // Kook Official limit!
            throw new IllegalStateException("Unexpected card count. Expected <= 5, got " + components.size());
        }
        AtomicInteger totalModules = new AtomicInteger();
        for (CardComponent component : components) {
            totalModules.addAndGet(component.moduleCount());
        }
        if (totalModules.get() > 50) {
            throw new IllegalStateException("The card module count is out of allowed range! Expected <= 50, got " + totalModules);
        }
        this.components = Collections.unmodifiableList(new LinkedList<>(components));
    }

    /**
     * Get the components stored by this component.
     */
    public List<CardComponent> getComponents() {
        return components;
    }
}
