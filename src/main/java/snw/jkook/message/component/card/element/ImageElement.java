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

package snw.jkook.message.component.card.element;

import snw.jkook.entity.abilities.Accessory;
import snw.jkook.message.component.card.Size;

/**
 * 表示一个图片元素。
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
     * 获取此图片元素的图片链接。
     */
    public String getSource() {
        return src;
    }

    /**
     * 获取此图片元素的 "alt" 值，其值在用户的 KOOK 客户端无法获取到图片时显示。<br>
     * Tips: 这个属性的名称取自 HTML 规范。
     */
    public String getAlt() {
        return alt;
    }

    /**
     * 获取此图片元素的渲染大小（注：不是图像大小）。
     *
     * @see Size
     */
    public Size getSize() {
        return size;
    }

    /**
     * 若此图片元素在 KOOK 客户端渲染时使用圆形蒙版，返回 {@code true}。
     */
    public boolean isCircled() {
        return circle;
    }
}
