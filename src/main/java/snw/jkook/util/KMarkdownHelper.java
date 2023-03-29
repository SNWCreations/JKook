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

package snw.jkook.util;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("uncheck")
public class KMarkdownHelper {

    /**
     * Bold text.
     *
     * @param bold Content.
     */
    public static @NotNull String bold(@NotNull String bold) {
        return new StringBuilder()
                .append("**")
                .append(bold.replace("*", "\\*"))
                .append("**")
                .toString();
    }

    /**
     * Italic text.
     *
     * @param italic Content.
     */
    public static @NotNull String italic(@NotNull String italic) {
        return new StringBuilder()
                .append("*")
                .append(italic.replace("*", "\\*"))
                .append("*")
                .toString();
    }

    /**
     * Bold italic text.
     *
     * @param boldItalics Content.
     */
    public static @NotNull String boldItalics(@NotNull String boldItalics) {
        return new StringBuilder()
                .append("***")
                .append(boldItalics.replace("*", "\\*"))
                .append("***")
                .toString();
    }

    /**
     * Strikethrough.
     *
     * @param strikeThrough Strikethrough.
     */
    public static @NotNull String strikeThrough(@NotNull String strikeThrough) {
        return new StringBuilder()
                .append("~~")
                .append(strikeThrough.replace("~", "\\~"))
                .append("~~")
                .toString();
    }

    /**
     * Links, only http/https allowed <br>
     *
     * @param text Content.
     * @param url  Url.
     */
    public static @NotNull String hyperLink(@NotNull String text, @NotNull String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("must be http or https link");
        }
        return new StringBuilder()
                .append("[")
                .append(text.replace("[", "\\[").replace("]", "\\]"))
                .append("]")
                .append("(")
                .append(url.replace("(", "\\(").replace(")", "\\)"))
                .append(")")
                .toString();
    }

    /**
     * Cut-off line.
     */
    public static @NotNull String line() {
        return "---";
    }

    /**
     * Reference.
     *
     * @param references Content.
     */
    public static @NotNull String references(@NotNull String references) {
        return new StringBuilder()
                .append("> ")
                .append(references.replace("\r\n", "\n").replace("\r", "\n").replace("\n", "\n\\u200d"))
                .append("\n\n")
                .toString();
    }

    /**
     * Underline.
     *
     * @param underLine Content.
     */
    public static @NotNull String underLine(@NotNull String underLine) {
        return new StringBuilder()
                .append("(ins)")
                .append(underLine.replace("(", "\\(").replace(")", "\\)"))
                .append("(ins)")
                .toString();
    }

    /**
     * Spoiler.
     *
     * @param spoiler Content
     */
    public static @NotNull String spoiler(@NotNull String spoiler) {
        return new StringBuilder()
                .append("(spl)")
                .append(spoiler.replace("(", "\\(").replace(")", "\\)"))
                .append("(spl)")
                .toString();
    }

    /**
     * Emoji. <br>
     * Reference: <a href="https://img.kookapp.cn/assets/emoji.json">Kook emoji json</a>.
     *
     * @param emoji Emoji.
     */
    public static @NotNull String emoji(@NotNull String emoji) {
        if (emoji.contains(":")) {
            throw new IllegalArgumentException("can't input a ':' in content !");
        }
        return new StringBuilder()
                .append(":")
                .append(emoji)
                .append(":")
                .toString();
    }

    /**
     * Server emoji, you need permission from server.
     *
     * @param emojiName Server emoji name.
     * @param emojiId   Server emoji id.
     */
    public static @NotNull String serverEmoji(@NotNull String emojiName, @NotNull String emojiId) {
        return new StringBuilder()
                .append("(emj)")
                .append(emojiName.replace("(", "\\(").replace(")", "\\)"))
                .append("(emj)")
                .append("[")
                .append(emojiId.replace("[", "\\[").replace("]", "\\]"))
                .append("]")
                .toString();
    }

    /**
     * Mention Channel.
     *
     * @param channelID Channel id.
     */
    public static @NotNull String metChannel(String id) {
        return new StringBuilder()
                .append("(chn)")
                .append(id)
                .append("(chn)")
                .toString();
    }

    /**
     * Mention. <br>
     * Mention all user used by "all", <br>
     * Mention all online user used by "here" <br>
     * Mention somebody used by user id
     *
     * @param target Mention target (user id, "here", "all")
     */
    public static @NotNull String met(@NotNull String target) {
        return new StringBuilder()
                .append("(met)")
                .append(target)
                .append("(met)")
                .toString();
    }

    /**
     * This parameter is used for all users of a role.
     *
     * @param id Role id.
     */
    public static @NotNull String metRole(int id) {
        String.format(
                "(rol)%s(rol)",
                id);
        return new StringBuilder()
                .append("(rol)")
                .append(id)
                .append("(rol)")
                .toString();
    }

    /**
     * Inline code.
     *
     * @param inLineCode Content.
     */
    public static @NotNull String inLineCode(@NotNull String inLineCode) {
        return new StringBuilder()
                .append("`")
                .append(inLineCode.replace("`", "\\`"))
                .append("`")
                .toString();
    }

    /**
     * CodeBlock.
     *
     * @param codeLanguage CodeLanguage, such as "java".
     * @param code         Content.
     */
    public static @NotNull String codeBlock(@NotNull String codeLanguage, @NotNull String code) {
        return new StringBuilder()
                .append("```")
                .append(codeLanguage)
                .append("\n")
                .append(code.replace("`", "\\`"))
                .append("\n")
                .append("```")
                .toString();
    }

    /**
     * Color Content
     * @param text content
     * @param theme Theme, such as "success", but you should reference <a href="https://www.kookapp.cn/tools/message-builder.html#/card">Kook card message</a>.
     *
     * <ul>
     *      <li>primary</li>
     *      <li>success</li>
     *      <li>danger</li>
     *      <li>warning</li>
     *      <li>info</li>
     *      <li>secondary</li>
     *      <li>body</li>
     *      <li>tips</li>
     *      <li>pink</li>
     *      <li>purple</li>
     * </ul>
     */
    public static @NotNull String colorContent(@NotNull String text, @NotNull String theme) {
        if (theme.contains("[") || theme.contains("]")) {
            throw new IllegalArgumentException("can not be '[' or ']'.");
        }
        return new StringBuilder()
                .append("(font)")
                .append(text.replace("(", "\\(").replace(")", "\\)"))
                .append("(font)")
                .append("[")
                .append(theme)
                .append("]")
                .toString();
    }
}
