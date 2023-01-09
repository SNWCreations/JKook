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
import snw.jkook.util.Validate;

/**
 * 此类提供了一种更方便的 JKook 计划任务的抽象实现。基于 {@link Runnable} 。<br>
 * 一个示例:
 * <blockquote><pre>
 * {@code
 *     new JKookRunnable() {
 *         public void run() {
 *             // Your task code here
 *         }
 *     }.runTaskLater(plugin, 2000L); // Run the task after 2000 milliseconds
 * }
 * </pre></blockquote>
 */
public abstract class JKookRunnable implements Runnable {
    private Task task = null;

    /**
     * 在指定的毫秒后执行此任务。
     *
     * @param delay    执行目标任务之前等待的毫秒数
     * @return 计划任务对象
     */
    public synchronized Task runTaskLater(Plugin plugin, long delay) {
        Validate.isTrue(task == null, "This runnable has already scheduled.");
        return ((task) = plugin.getCore().getScheduler().runTaskLater(plugin, this, delay));
    }

    /**
     * 反复执行此任务。
     *
     * @param delay    第一次执行此任务之前等待的毫秒数
     * @param period   两次执行之间间隔的毫秒数
     * @return 计划任务对象
     */
    public synchronized Task runTaskTimer(Plugin plugin, long delay, long period) {
        Validate.isTrue(task == null, "This runnable has already scheduled.");
        return ((task) = plugin.getCore().getScheduler().runTaskTimer(plugin, this, delay, period));
    }

    /**
     * 尝试取消此计划任务。
     *
     * @throws IllegalStateException 当此任务已被取消时抛出
     */
    public synchronized void cancel() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        task.cancel();
        task = null;
    }

    /**
     * 当此计划任务已被取消时返回 {@code true} 。
     *
     * @throws IllegalStateException 当此任务已被取消时抛出
     */
    public synchronized boolean isCancelled() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        return task.isCancelled();
    }

    /**
     * 当此计划任务将被计划执行时返回 {@code true} 。
     */
    public synchronized boolean isScheduled() {
        return task != null;
    }

    /**
     * 返回此计划任务的任务 ID 。
     *
     * @throws IllegalStateException 当此任务已被取消时抛出
     */
    public synchronized int getTaskId() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        return task.getTaskId();
    }
}
