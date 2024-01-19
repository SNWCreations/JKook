/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.message.component.card.element;

import snw.jkook.entity.abilities.Accessory;
import snw.jkook.message.component.card.Size;

/**
 * Represents the image element.
 */
public class ImageElement extends BaseElement implements Accessory {
    private final String src;
    private final String alt;
    private final Size size;
    private final boolean circle;

    public ImageElement(String src, String alt, boolean circle) {
        this(src, alt, Size.LG, circle);
    }

    public ImageElement(String src, String alt, Size size, boolean circle) {
        this.src = src;
        this.alt = alt;
        this.size = size;
        this.circle = circle;
    }

    /**
     * Get the source URL of the image that represented by this element.
     */
    public String getSource() {
        return src;
    }

    /**
     * Get the "alt" value of this element, it will be shown if Kook client cannot load the image from the source.
     */
    public String getAlt() {
        return alt;
    }

    /**
     * Get the size type of this image.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Return true if this image element was marked as circled.
     */
    public boolean isCircled() {
        return circle;
    }

    @Override
    public String toString() {
        return "ImageElement{" +
                "src='" + src + '\'' +
                ", alt='" + alt + '\'' +
                ", size=" + size +
                ", circle=" + circle +
                '}';
    }
}
