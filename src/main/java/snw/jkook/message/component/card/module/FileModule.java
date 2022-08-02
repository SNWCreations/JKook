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

import org.jetbrains.annotations.Nullable;
import snw.jkook.message.component.FileComponent;
import snw.jkook.util.Validate;

/**
 * Represents the module that contains a file. Only normal files are supported.
 */
public class FileModule extends BaseModule {
    private final FileComponent.Type type;
    private final String src;
    private final String title;
    private final String cover;

    public FileModule(FileComponent.Type type, String src, String title, String cover) {
        Validate.isFalse(type == FileComponent.Type.IMAGE, "Image files does not supported by FileModule.");
        this.type = type;
        this.src = src;
        this.title = title;
        this.cover = cover;
    }

    /**
     * Get the type of the file that represented by this module.
     */
    public FileComponent.Type getType() {
        return type;
    }

    /**
     * Get the source URL of the file that represented by this module.
     */
    public String getSource() {
        return src;
    }

    /**
     * Get the title of the file.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the cover of the file that represented by this module. <p>
     * Null is returned if this module does not represent an audio file.
     */
    @Nullable
    public String getCover() {
        return cover;
    }
}
