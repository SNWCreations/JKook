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

package snw.jkook.entity.abilities;

/**
 * Represents the modules that can include other modules.
 */
public interface AccessoryHolder {

    /**
     * Get the accessory that this object currently holds.
     */
    Accessory getAccessory();

    /**
     * Get the current mode of the accessory that holds by this object.
     */
    Accessory.Mode getMode();

}
