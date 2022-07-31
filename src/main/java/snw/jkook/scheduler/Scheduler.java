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

package snw.jkook.scheduler;

import snw.jkook.plugin.Plugin;

/**
 * Represents a scheduler, you can schedule tasks to run.
 */
public interface Scheduler {

    /**
     * Execute the provided runnable right now.
     *
     * @param runnable The runnable to execute
     */
    void runTask(Runnable runnable);

    /**
     * Schedule the runnable to be executed after the delay.
     *
     * @param plugin The plugin as the task owner
     * @param runnable The runnable to execute
     * @param delay    The delay time
     * @return The task object
     */
    Task runTaskLater(Plugin plugin, Runnable runnable, long delay); // note: delay is millisecond.

    /**
     * Execute the runnable again and again.
     *
     * @param plugin The plugin as the task owner
     * @param runnable The runnable to execute
     * @param delay    The time before first run
     * @param period   The time between two execution
     * @return The task object
     */
    Task runTaskTimer(Plugin plugin, Runnable runnable, long delay, long period); // note: both period and delay are in millisecond.

    /**
     * Return true if the task that represented by the ID is scheduled.
     *
     * @param taskId The ID to check
     */
    boolean isScheduled(int taskId);

    /**
     * Cancel the specified task. <p>
     * If the provided ID is not matching any task, this will fail silently.
     *
     * @param taskId The ID for finding the task
     */
    void cancelTask(int taskId);

    /**
     * Cancel all the tasks that related to the provided plugin.
     * @param plugin The plugin as the task owner
     */
    void cancelTasks(Plugin plugin);
}
