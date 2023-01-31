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

package snw.jkook.message.component.card.module;

import snw.jkook.message.component.card.element.ImageElement;
import snw.jkook.util.Validate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 表示一个用于存放图像元素的组模块。 <br>
 * 这不同于 {@link ImageGroupModule}，它的图像元素会被"切割"为正方形再展示，而这个模块不会这么做。<br>
 * 多个图像将垂直排列。
 */
public class ContainerModule extends BaseModule {
    private final List<ImageElement> images;

    public ContainerModule(List<ImageElement> images) {
        Validate.isTrue(images.size() >= 1, "Unexpected image module count, expected >= 1, got " + images.size());
        Validate.isTrue(images.size() <= 9, "Unexpected image module count, expected <= 9, got " + images.size());
        this.images = Collections.unmodifiableList(new LinkedList<>(images));
    }

    /**
     * 获取此模块中已存储的图像元素。
     */
    public List<ImageElement> getImages() {
        return images;
    }

    /**
     * 一个用于构造 {@link ContainerModule} 的建造器。
     */
    public static class Builder {
        private final List<ImageElement> modules = new LinkedList<>();

        public Builder add(ImageElement module) {
            modules.add(module);
            return this;
        }

        public ContainerModule build() {
            return new ContainerModule(modules);
        }
    }
}
