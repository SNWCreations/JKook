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

import org.jetbrains.annotations.Nullable;
import snw.jkook.message.component.FileComponent;
import snw.jkook.util.Validate;

/**
 * 表示一个文件模块。不支持图片。
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
     * 获取此模块中文件的类型。
     */
    public FileComponent.Type getType() {
        return type;
    }

    /**
     * 获取此模块中文件的 URL 地址。
     */
    public String getSource() {
        return src;
    }

    /**
     * 获取此模块中文件的标题。
     */
    public String getTitle() {
        return title;
    }

    /**
     * 获取此模块中封面文件的 URL 地址。<br>
     * 封面属性仅对音频文件有效，所以此方法有时返回 {@code null} 。
     */
    @Nullable
    public String getCover() {
        return cover;
    }
}
