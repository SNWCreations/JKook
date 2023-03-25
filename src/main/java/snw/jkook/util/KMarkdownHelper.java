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

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("uncheck")
public class KMarkdownHelper {

    /**
     * Bold text.
     *
     * @param bold Content.
     */
    public static String bold(@NotNull String bold) {
        return String.format(
                "**%s**",
                bold.replace("*", "\\*")
        );
    }

    /**
     * Italic text.
     *
     * @param italic Content.
     */
    public static String italic(@NotNull String italic) {
        return String.format(
                "*%s*",
                italic.replace("*", "\\*")
        );
    }

    /**
     * Bold italic text.
     *
     * @param boldItalics Content.
     */
    public static String boldItalics(@NotNull String boldItalics) {
        return String.format(
                "***%s***",
                boldItalics.replace("*", "\\*")
        );
    }

    /**
     * Strikethrough.
     *
     * @param strikeThrough Strikethrough.
     */
    public static String strikeThrough(@NotNull String strikeThrough) {
        return String.format(
                "~~%s~~",
                strikeThrough.replace("~", "\\~")
        );
    }

    /**
     * Links, only http/https allowed <br>
     *
     * @param text Content.
     * @param url Url.
     */
    public static String hyperLink(@NotNull String text, @NotNull String url) {
        if(!url.startsWith("http://") || !url.startsWith("https://")){
            throw new IllegalArgumentException("must be http or https link");
        }
        return String.format(
                "[%s](%s)",
                text.replace("[", "\\[").replace("]", "\\]"),
                url.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * Cut-off line.
     */
    @Contract(pure = true)
    public static @NotNull String line() {
        return "---";
    }

    /**
     * Reference
     *
     * @param references Content.
     */
    public static String references(@NotNull String references) {
        return String.format(
                "> %s",
                references.replace(">", "\\>").replace("\n\n", "\n\\200d\n") + "\n\n"
        );
    }

    /**
     * Underline.
     *
     * @param underLine Content.
     */
    public static String underLine(@NotNull String underLine) {
        return String.format(
                "(ins)%s(ins)",
                underLine.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * Spoiler.
     *
     * @param spoiler Content
     */
    public static String spoiler(@NotNull String spoiler) {
        return String.format(
                "(spl)%s(spl)",
                spoiler.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * Emoji. <br>
     * Reference: <a href="https://img.kookapp.cn/assets/emoji.json">Kook emoji json</a>.
     *
     * @param emoji Emoji.
     */
    public static String emoji(@NotNull String emoji){
        if (emoji.contains(":")) {
            throw new IllegalArgumentException("");
        }
        return String.format(
                ":%s:",
                emoji
        );
    }

    /**
     * Server emoji, you need permission from server.
     *
     * @param emojiName Server emoji name.
     * @param emojiID Server emoji id.
     */
    public static String serverEmoji(@NotNull String emojiName, @NotNull String emojiID) {
        return String.format(
                "(emj)%s(emj)[%s]",
                emojiName.replace("(", "\\(").replace(")", "\\)"),
                emojiID.replace("[", "\\[").replace("]", "\\]")
        );
    }

    /**
     * Eit Channel.
     *
     * @param channelID Channel id.
     */
    public static String eitChannel(int channelID) {
        return String.format(
                "(chn)%s(chn)",
                channelID
        );
    }

    /**
     * Eit all user used by "all",
     * Eit all online user used by "here"
     * Eit somebody used by "userId"
     *
     * @param eit Parameter(userId/here/all)
     */
    public static String met(@NotNull String eit) {
        return String.format(
                "(met)%s(met)",
                eit.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * This parameter is used for all users of a role.
     *
     * @param eitRole Role id.
     */
    public static String metRole(int eitRole) {
        return String.format(
                "(rol)%s(rol)",
                eitRole
        );
    }

    /**
     * Inline code.
     *
     * @param inLineCode Content.
     */
    public static String inLineCode(@NotNull String inLineCode) {
        return String.format(
                "`%s`",
                inLineCode.replace("`", "\\`")
        );
    }

    /**
     * CodeBlock.
     *
     * @param codeLanguage CodeLanguage, such as "java", but not sure about "java" language can activate in "KooK".
     * @param code Content.
     */
    public static String codeBlock(@NotNull String codeLanguage, @NotNull String code) {
        return String.format(
                "```%s\n%s```",
                codeLanguage,
                code.replace("`", "\\`")
        );
    }
}