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

/**
 * A utility class for building KMarkdown-specific content.
 *
 * @author NatholDallas
 */

public final class KMarkdownHelper {

    private KMarkdownHelper() {
    } // Cannot call constructor.

    /**
     * Bold text.
     *
     * @param bold Text Content
     */
    public static @NotNull String bold(@NotNull String bold) {
        return "**" +
                bold.replace("*", "\\*") +
                "**";
    }

    /**
     * Italic text.
     *
     * @param italic Text Content
     */
    public static @NotNull String italic(@NotNull String italic) {
        return "*" +
                italic.replace("*", "\\*") +
                "*";
    }

    /**
     * Bold italic text.
     *
     * @param boldItalics Text Content
     */
    public static @NotNull String boldItalics(@NotNull String boldItalics) {
        return "***" +
                boldItalics.replace("*", "\\*") +
                "***";
    }

    /**
     * Strikethrough.
     *
     * @param strikeThrough Text Content
     */
    public static @NotNull String strikeThrough(@NotNull String strikeThrough) {
        return "~~" +
                strikeThrough.replace("~", "\\~") +
                "~~";
    }

    /**
     * Links, only http/https links are allowed.
     *
     * @param text Content
     * @param url  URL
     */
    public static @NotNull String hyperLink(@NotNull String text, @NotNull String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("must be http or https link");
        }
        return "[" +
                text.replace("[", "\\[").replace("]", "\\]") +
                "]" +
                "(" +
                url.replace("(", "\\(").replace(")", "\\)") +
                ")";
    }

    /**
     * Divider line
     */
    public static @NotNull String line() {
        return "---";
    }

    /**
     * Reference.
     *
     * @param references Content
     */
    public static @NotNull String references(@NotNull String references) {
        return "> " +
                references.replace("\r\n", "\n").replace("\r", "\n").replace("\n", "\n\\u200d") +
                "\n\n";
    }

    /**
     * Underline.
     *
     * @param underLine Content
     */
    public static @NotNull String underLine(@NotNull String underLine) {
        return "(ins)" +
                underLine.replace("(", "\\(").replace(")", "\\)") +
                "(ins)";
    }

    /**
     * Spoiler.
     *
     * @param spoiler Content
     */
    public static @NotNull String spoiler(@NotNull String spoiler) {
        return "(spl)" +
                spoiler.replace("(", "\\(").replace(")", "\\)") +
                "(spl)";
    }

    /**
     * Emoji. <br>
     * Reference: <a href="https://img.kookapp.cn/assets/emoji.json">KOOK Emoji JSON</a>.
     *
     * @param emoji Emoji
     */
    public static @NotNull String emoji(@NotNull String emoji) {
        if (emoji.contains(":")) {
            throw new IllegalArgumentException("can't input a ':' in content!");
        }
        return ":" +
                emoji +
                ":";
    }

    /**
     * Guild emoji, you need to have the permission for using the guild emoji.
     *
     * @param name Emoji name
     * @param id   Emoji ID
     */
    public static @NotNull String guildEmoji(@NotNull String name, @NotNull String id) {
        return "(emj)" +
                name.replace("(", "\\(").replace(")", "\\)") +
                "(emj)" +
                "[" +
                id.replace("[", "\\[").replace("]", "\\]") +
                "]";
    }

    /**
     * Mention Channel.
     *
     * @param id Channel ID
     */
    public static @NotNull String metChannel(String id) {
        return "(chn)" +
                id +
                "(chn)";
    }

    /**
     * Mention. <br>
     * Mention all user used by "all", <br>
     * Mention all online user used by "here". <br>
     * Mention somebody used by user ID.
     *
     * @param target Mention target (user ID, "here", "all")
     */
    public static @NotNull String met(@NotNull String target) {
        return "(met)" +
                target +
                "(met)";
    }

    /**
     * Mention all users who have the provided role.
     *
     * @param id Role id
     */
    public static @NotNull String metRole(int id) {
        return "(rol)" +
                id +
                "(rol)";
    }

    /**
     * Inline code.
     *
     * @param inLineCode Content
     */
    public static @NotNull String inLineCode(@NotNull String inLineCode) {
        return "`" +
                inLineCode.replace("`", "\\`") +
                "`";
    }

    /**
     * Code block.
     *
     * @param codeLanguage Code language, such as "java"
     * @param code         Content
     */
    public static @NotNull String codeBlock(@NotNull String codeLanguage, @NotNull String code) {
        return "```" +
                codeLanguage +
                "\n" +
                code.replace("`", "\\`") +
                "\n" +
                "```";
    }

    /**
     * Color text. <br>
     * The possible values of "theme" parameter is following:
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
     *
     * @param content  Text Content
     * @param theme Theme, such as "success", all possible values are provided above
     */
    public static @NotNull String colorText(@NotNull String content, @NotNull String theme) {
        if (theme.contains("[") || theme.contains("]")) {
            throw new IllegalArgumentException("Theme cannot contain '[' or ']'.");
        }
        return "(font)" +
                content.replace("(", "\\(").replace(")", "\\)") +
                "(font)" +
                "[" +
                theme +
                "]";
    }
}
