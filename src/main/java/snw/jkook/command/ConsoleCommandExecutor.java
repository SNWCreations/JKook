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

/**
 * 表示一个只为控制台服务的命令执行器。
 *
 * @see JKookCommand
 */
public interface ConsoleCommandExecutor {

    /**
     * 使用给定的信息执行此命令
     *
     * @param sender    命令执行者
     * @param arguments 参数
     */
    void onCommand(ConsoleCommandSender sender, Object[] arguments);
}
