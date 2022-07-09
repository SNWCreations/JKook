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

package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;
import snw.jkook.entity.abilities.Accessory;
import snw.jkook.entity.abilities.AccessoryHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the module with columns.
 */
public class ParagraphModule extends BaseModule implements AccessoryHolder {
    private final List<PlainTextModule> modules;
    private final int cols;
    private final Accessory accessory;

    public ParagraphModule(int cols, List<PlainTextModule> modules, Accessory accessory) {
        this.modules = Collections.unmodifiableList(new LinkedList<>(modules));
        Validate.isTrue(cols > 0, "Columns cannot be negative.");
        Validate.isTrue(cols <= 3, "Columns cannot be greater than 3."); // Kook Official limit!
        this.cols = cols;
        this.accessory = accessory;
    }

    /**
     * Get the columns of this module.
     */
    public int getColumns() {
        return cols;
    }

    @Override
    public Accessory getAccessory() {
        return accessory;
    }

    /**
     * Get the modules stored by this module.
     */
    public List<PlainTextModule> getModules() {
        return modules;
    }
}
