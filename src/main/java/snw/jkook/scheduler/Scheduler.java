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
 * 表示一个任务调度器。<br>
 * <b>注: 此接口下的所有 {@code delay} 和 {@code period} 均以毫秒为单位。</b>
 */
public interface Scheduler {

    /**
     * 立刻执行指定的 {@code runnable} 。
     *
     * @param plugin 拥有目标任务的插件对象
     * @param runnable 将被执行的具体任务
     * @return 任务对象
     */
    Task runTask(Plugin plugin, Runnable runnable);

    /**
     * 在指定的毫秒后执行指定的 {@code runnable} 。
     *
     * @param plugin 拥有目标任务的插件对象
     * @param runnable 将被执行的具体任务
     * @param delay    执行目标任务之前等待的毫秒数
     * @return 计划任务对象
     */
    Task runTaskLater(Plugin plugin, Runnable runnable, long delay); // note: delay is millisecond.

    /**
     * 反复执行目标 {@code runnable} 。
     *
     * @param plugin 拥有目标任务的插件对象
     * @param runnable 将被执行的具体任务
     * @param delay    第一次执行目标任务之前等待的毫秒数
     * @param period   两次执行之间间隔的毫秒数
     * @return 计划任务对象
     */
    Task runTaskTimer(Plugin plugin, Runnable runnable, long delay, long period); // note: both period and delay are in millisecond.

    /**
     * 当存在一个与 {@code taskId} 对应的待执行的任务时返回 {@code true} 。
     *
     * @param taskId 任务 ID
     */
    boolean isScheduled(int taskId);

    /**
     * 取消与提供的 {@code taskId} 对应的任务。<p>
     * 当没有任何任务与 {@code taskId} 对应时，此方法将静默地失败。
     *
     * @param taskId 任务 ID
     */
    void cancelTask(int taskId);

    /**
     * 取消所有由 {@code plugin} 预定的计划任务。
     *
     * @param plugin 插件对象
     */
    void cancelTasks(Plugin plugin);
}
