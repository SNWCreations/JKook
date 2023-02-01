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

import org.jetbrains.annotations.Nullable;

/**
 * 表示一种可以嵌入 {@link Accessory} 的模块。
 */
public interface AccessoryHolder {

    /**
     * 获取已嵌入此模块的模块。<br>
     * 若此模块没有嵌入任何其他模块，则此方法返回 {@code null} 。
     */
    @Nullable
    Accessory getAccessory();

    /**
     * 获取应用到已嵌入的模块的模式。<br>
     * 若此模块没有嵌入任何其他模块，则此方法返回 {@code null} 。
     */
    @Nullable
    Accessory.Mode getMode();

}
