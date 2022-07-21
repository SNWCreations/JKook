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

package snw.jkook.message;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.ReactionHolder;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.message.component.BaseComponent;
import snw.jkook.util.RequirePermission;

/**
 * Represents a message.
 */
public interface Message extends Receivable, ReactionHolder {

    /**
     * Get the component in this message.
     */
    BaseComponent getComponent();

    /**
     * Get the ID of this message.
     */
    String getId();

    /**
     * Delete this message .
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
