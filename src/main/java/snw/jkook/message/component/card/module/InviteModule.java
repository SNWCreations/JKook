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

/**
 * Represents a module that contains an invitation link (or code).
 */
public class InviteModule extends BaseModule {
    private final String code;

    public InviteModule(String code) {
        this.code = code;
    }

    /**
     * Get the link/code that stored by this module.
     */
    public String getCode() {
        return code;
    }
}
