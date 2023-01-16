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

package snw.jkook.command;

import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.message.Message;

/**
 * 表示一个只为 KOOK 用户服务的命令执行器。
 *
 * @see JKookCommand
 */
public interface UserCommandExecutor {

    /**
     * Execute this command with given information.
     *
     * @param sender    命令执行者
     * @param arguments 参数
     * @param message   导致此命令被执行的消息对象（当控制台执行此命令时，值为 {@code null}）
     */
    void onCommand(User sender, Object[] arguments, @Nullable Message message);
}
