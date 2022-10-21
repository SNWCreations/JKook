/*
 * Copyright 2022 JKook contributors
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
 * Represents an executor for a command, but only for Kook users.
 *
 * @see JKookCommand
 */
public interface UserCommandExecutor {

    /**
     * Execute this command with given information.
     *
     * @param sender    The sender
     * @param arguments The arguments
     * @param message   The message related to this execution (Maybe null if the console executed this command)
     */
    void onCommand(User sender, Object[] arguments, @Nullable Message message);
}
