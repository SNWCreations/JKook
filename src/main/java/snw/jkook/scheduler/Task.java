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

package snw.jkook.scheduler;

import snw.jkook.plugin.Plugin;

/**
 * 表示一个已计划的任务。
 */
public interface Task {

    /**
     * 获取拥有此计划任务的插件对象。
     */
    Plugin getPlugin();

    /**
     * 尝试取消此计划任务。
     *
     * @throws IllegalStateException 当此任务已被取消时抛出
     */
    void cancel() throws IllegalStateException;

    /**
     * 当此任务已被取消时返回 {@code true} 。
     */
    boolean isCancelled();

    /**
     * 当此任务已被执行时返回 {@code true} 。无论此任务是否被成功执行。
     */
    boolean isExecuted();

    /**
     * 获取此任务的 ID 。
     */
    int getTaskId();
}
