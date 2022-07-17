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

/**
 * Represents the module with Markdown text.
 */
public class MarkdownModule extends BaseModule {
    private final String value;
    private final Accessory accessory;

    public MarkdownModule(String value, Accessory accessory) {
        Validate.notNull(value, "The value cannot be null");
        Validate.isTrue(value.length() <= 5000, "Unexpected content length, expected <= 5000, got " + value.length());
        this.value = value;
        this.accessory = accessory;
    }

    /**
     * Get the value of this module.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the accessory that bound to this module.
     */
    public Accessory getAccessory() {
        return accessory;
    }
}
