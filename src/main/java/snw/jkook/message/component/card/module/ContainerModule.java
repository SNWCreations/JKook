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
 * Represents a group of image components. <p>
 * But it is different from {@link ImageGroupModule}, the image is not cropped to a square. Multiple images are arranged vertically.
 */
public class ContainerModule extends BaseModule {
    private final List<ImageModule> images;

    public ContainerModule(List<ImageModule> images) {
        Validate.isTrue(images.size() >= 1, "Unexpected image module count, expected >= 1, got " + images.size());
        Validate.isTrue(images.size() <= 9, "Unexpected image module count, expected <= 9, got " + images.size());
        this.images = Collections.unmodifiableList(new LinkedList<>(images));
    }

    /**
     * Get the images that already stored in this module.
     */
    public List<ImageModule> getImages() {
        return images;
    }
}
