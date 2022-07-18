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
 * Represents a module that contains an audio.
 */
public class AudioModule extends BaseModule {
    private final String title;
    private final String src;
    private final String cover;

    public AudioModule(String title, String src, String cover) {
        this.title = title;
        this.src = src;
        this.cover = cover;
    }

    /**
     * Get the title of this module.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the source URL of this module.
     */
    public String getSource() {
        return src;
    }

    /**
     * Get the cover picture URL that will be used for this module.
     */
    public String getCover() {
        return cover;
    }
}
