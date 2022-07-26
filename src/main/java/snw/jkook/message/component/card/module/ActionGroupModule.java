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

import snw.jkook.util.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a group of something can cause some actions. (e.g. {@link ActionModule})
 */
public class ActionGroupModule extends BaseModule {
    private final List<ActionModule> buttons;

    public ActionGroupModule(List<ActionModule> buttons) {
        Validate.isTrue(buttons.size() >= 1, "Unexpected image module count, expected >= 1, got " + buttons.size());
        Validate.isTrue(buttons.size() <= 4, "Unexpected image module count, expected <= 4, got " + buttons.size());
        this.buttons = Collections.unmodifiableList(new LinkedList<>(buttons));
    }

    /**
     * Get the images that already stored in this module.
     */
    public List<ActionModule> getButtons() {
        return buttons;
    }
}
