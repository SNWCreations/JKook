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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class KMarkdownHelper {

    /**
     * 加粗
     * @param bold 填写你要设置的加粗字体
     */
    public static String bold(@NotNull String bold) {
        return String.format(
                "**%s**",
                bold.replace("*", "\\*")
        );
    }

    /**
     * 斜体
     * @param italic 填写你要设置的斜体字体
     */
    public static String italic(@NotNull String italic) {
        return String.format(
                "*%s*",
                italic.replace("*", "\\*")
        );
    }

    /**
     * 斜体
     * @param boldItalics 填写你要设置的加粗斜体字体
     */
    public static String boldItalics(@NotNull String boldItalics) {
        return String.format(
                "***%s***",
                boldItalics.replace("*", "\\*")
        );
    }

    /**
     * 删除线
     * @param strikeThrough 填写你要设置的删除线样式
     */
    public static String strikeThrough(@NotNull String strikeThrough) {
        return String.format(
                "~~%s~~",
                strikeThrough.replace("~", "\\~")
        );
    }

    /**
     * 链接,仅允许 http , https 的链接 <br>
     * 如果我们希望链接在下面显示缩略图(即链接解析) <br>
     * 需要保证链接文字与链接地址完全一致才可以
     * @param text 链接文字
     * @param url 链接地址
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
     * 分割线
     */
    @Contract(pure = true)
    public static @NotNull String line() {
        return "---";
    }

    /**
     * 引用: 换行会一直作用, 直到遇见两个换行(\n\n) <br>
     * 这两个换行实际不会显示换行
     * @param references 填写引用文本
     */
    public static String references(@NotNull String references) {
        return String.format(
                ">%s",
                references.replace(">", "\\>") + "\n\n"
        );
    }

    /**
     * 下划线
     * @param underLine 填写你要设置的下划线样式
     * @return
     */
    public static String underLine(@NotNull String underLine) {
        return String.format(
                "(ins)%s(ins)",
                underLine.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * 剧透, 内容默认是遮住的, 只有用户点击才会显示
     * @param spoiler 遮挡住的部分
     * @return
     */
    public static String spoiler(@NotNull String spoiler) {
        return String.format(
                "(spl)%s(spl)",
                spoiler.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * emoji表情
     * 基本与emoji的
     * <a href="https://www.webfx.com/tools/emoji-cheat-sheet/">shortcode</a>
     * 写法保持一致
     * <a href="https://img.kookapp.cn/assets/emoji.json">KOOK表情json文件</a>
     * @param emoji 表情
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
     * 服务器表情, 需要有服务器发送服务器表情的权限
     * @param emojiName 服务器表情名
     * @param emojiID 服务器表情 ID
     */
    public static String serverEmoji(@NotNull String emojiName, @NotNull String emojiID) {
        return String.format(
                "(emj)%s(emj)[%s]",
                emojiName.replace("(", "\\(").replace(")", "\\)"),
                emojiID.replace("[", "\\[").replace("]", "\\]")
        );
    }

    /**
     * 频道, 提及频道
     * @param channelID 频道 ID
     */
    public static String eitChannel(int channelID) {
        return String.format(
                "(chn)%s(chn)",
                channelID
        );
    }

    /**
     * all-@所有用户 <br>
     * here-@所有在线用户
     * @param eit @参数
     */
    public static String mention(@NotNull String eit) {
        return String.format(
                "(met)%s(met)",
                eit.replace("(", "\\(").replace(")", "\\)")
        );
    }

    /**
     * 用于@用户, all代表@所有用户, here代表@所有在线用户
     * @param eit 用户 ID
     */
    public static String mention(int eit) {
        return String.format(
                "(met)%s(met)",
                eit
        );
    }

    /**
     * 用于@某角色所有用户
     * @param eitRole 角色 ID
     */
    public static String mentionRole(int eitRole) {
        return String.format(
                "(rol)%s(rol)",
                eitRole
        );
    }

    /**
     * 行内代码
     * @param inLineCode 内容
     */
    public static String inLineCode(@NotNull String inLineCode) {
        return String.format(
                "`%s`",
                inLineCode.replace("`", "\\`")
        );
    }

    /**
     * 代码块
     * @param codeLanguage 定义语言
     * @param code 内容
     */
    public static String codeBlock(@NotNull String codeLanguage, @NotNull String code) {
        return String.format(
                "```%s\n%s```"
                , codeLanguage
                , code.replace("`", "\\`")
        );
    }
}