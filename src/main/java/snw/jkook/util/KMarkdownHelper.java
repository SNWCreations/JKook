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
     * bold font.
     *
     * @param bold Fill in the bold font you want to set.
     */
    public static String bold(@NotNull String bold) {
        return String.format(
                "**%s**",
                bold.replace("*", "\\*")
        );
    }

    /**
     * italic font.
     *
     * @param italic Fill in the italic font you want to set.
     */
    public static String italic(@NotNull String italic) {
        return String.format(
                "*%s*",
                italic.replace("*", "\\*")
        );
    }

    /**
     * bold italic font.
     *
     * @param boldItalics Fill int the bold italic font you want to set.
     */
    public static String boldItalics(@NotNull String boldItalics) {
        return String.format(
                "***%s***",
                boldItalics.replace("*", "\\*")
        );
    }

    /**
     * strikethrough.
     *
     * @param strikeThrough Fill in the strikeThrough style you want to set.
     */
    public static String strikeThrough(@NotNull String strikeThrough) {
        return String.format(
                "~~%s~~",
                strikeThrough.replace("~", "\\~")
        );
    }

    /**
     * links, only http/https are allowed <br>
     * if we hope show Sketch(link parsing) under the link <br>
     * you should make text equals url
     *
     * @param text link text.
     * @param url link url.
     */
    public static String hyperLink(@NotNull String text, @NotNull String url) {
        if(!url.startsWith("http")){
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
     * Reference: Line breaks work until (\n\n) <br>
     * these two "\n" do not actually show a new line <br>
     *
     * @param references reference text.
     */
    public static String references(@NotNull String references) {
        return String.format(
                ">%s",
                references.replace(">", "\\>") + "\n\n"
        );
    }

    /**
     * underline.
     *
     * @param underLine Fill in the underline style you want to set.
     */
    public static String underLine(@NotNull String underLine) {
        return String.format(
                "(ins)%s(ins)",
                underLine.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * Reveal the plot <br>
     * the content is covered by default <br>
     * only the user click will be displayed.
     *
     * @param spoiler The occluded part.
     */
    public static String spoiler(@NotNull String spoiler) {
        return String.format(
                "(spl)%s(spl)",
                spoiler.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * emoji. <br>
     * Basic for <a href="https://www.webfx.com/tools/emoji-cheat-sheet/">shortcode</a> same as.
     * <a href="https://img.kookapp.cn/assets/emoji.json">KookEmojiJson</a>.
     *
     * @param emoji emoji.
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
     * Server emoticon, you need to have the permission for the server to send server emoticon.
     *
     * @param emojiName server emoji name.
     * @param emojiID server emoji id.
     */
    public static String serverEmoji(@NotNull String emojiName, @NotNull String emojiID) {
        return String.format(
                "(emj)%s(emj)[%s]",
                emojiName.replace("(", "\\(").replace(")", "\\)"),
                emojiID.replace("[", "\\[").replace("]", "\\]")
        );
    }

    /**
     * channel, eit Channel.
     *
     * @param channelID channel id.
     */
    public static String eitChannel(int channelID) {
        return String.format(
                "(chn)%s(chn)",
                channelID
        );
    }

    /**
     * all-@all user. <br>
     * here-@all online user.
     *
     * @param eit @parameter.
     */
    public static String mention(@NotNull String eit) {
        return String.format(
                "(met)%s(met)",
                eit.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * For @users, all indicates all @users, and here indicates all @online users.
     *
     * @param eit userId.
     */
    public static String mention(int eit) {
        return String.format(
                "(met)%s(met)",
                eit
        );
    }

    /**
     * This parameter is used for all users of a role.
     *
     * @param eitRole roleId.
     */
    public static String mentionRole(int eitRole) {
        return String.format(
                "(rol)%s(rol)",
                eitRole
        );
    }

    /**
     * inLineCode.
     *
     * @param inLineCode content.
     */
    public static String inLineCode(@NotNull String inLineCode) {
        return String.format(
                "`%s`",
                inLineCode.replace("`", "\\`")
        );
    }

    /**
     * codeBlock.
     *
     * @param codeLanguage codeLanguage, such as Java.
     * @param code content.
     */
    public static String codeBlock(@NotNull String codeLanguage, @NotNull String code) {
        return String.format(
                "```%s\n%s```"
                , codeLanguage
                , code.replace("`", "\\`")
        );
    }
}