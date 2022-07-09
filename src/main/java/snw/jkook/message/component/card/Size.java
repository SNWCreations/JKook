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

/**
 * Represents the available sizes of the cards.
 */
public enum Size {

    /**
     * The default card size. <p>
     * This parameter is valid only on the PC. (Mobile will render the LG cards using SM size.)
     */
    LG("lg"),

    SM("sm"),

    // The unsupported size for card (not its module) is following:

    XS("xs"),

    MD("md");

    private final String value;

    Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
