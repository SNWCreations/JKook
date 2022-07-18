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
import snw.jkook.message.component.FileComponent;

/**
 * Represents the module that contains a file. Only normal files are supported.
 */
public class FileModule extends BaseModule {
    private final FileComponent component;

    public FileModule(FileComponent component) {
        Validate.isTrue((component.getType() == FileComponent.Type.FILE), "File module only support files. (not video or audio, use VideoModule or AudioModule instead.)");
        this.component = component;
    }

    /**
     * Get the component that stored by this module.
     */
    public FileComponent getComponent() {
        return component;
    }
}
