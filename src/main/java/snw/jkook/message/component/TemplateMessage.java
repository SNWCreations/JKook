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

package snw.jkook.message.component;

/**
 * Represents a template message.
 */
public class TemplateMessage extends BaseComponent {
    private final long id;
    private final String content;
    private final int type;

    /**
     * @param id      template id
     * @param content input content
     * @param type    message type
     */
    public TemplateMessage(long id, String content, int type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    /**
     * @return Get Template ID
     */
    public long getId() {
        return id;
    }

    /**
     * @return Get template input content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return Get template type
     */
    public int getType() {
        return type;
    }

    public static TemplateMessage markdown(long templateId, String content) {
        return new TemplateMessage(templateId, content, 9);
    }

    public static TemplateMessage card(long templateId, String content) {
        return new TemplateMessage(templateId, content, 10);
    }
}
