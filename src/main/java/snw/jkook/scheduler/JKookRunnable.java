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

import org.apache.commons.lang.Validate;
import snw.jkook.JKook;

/**
 * This class provides an easy way to schedule tasks to JKook scheduler.
 */
public abstract class JKookRunnable implements Runnable {
    private Task task = null;

    /**
     * Schedule the runnable to be executed after the delay.
     *
     * @param delay    The delay time
     * @return The task object
     */
    public synchronized Task runTaskLater(long delay) {
        Validate.isTrue(task == null, "This runnable has already scheduled.");
        return ((task) = JKook.getScheduler().runTaskLater(this, delay));
    }

    /**
     * Execute the runnable again and again.
     *
     * @param delay    The time before first run
     * @param period   The time between two execution
     * @return The task object
     */
    public synchronized Task runTaskTimer(long delay, long period) {
        Validate.isTrue(task == null, "This runnable has already scheduled.");
        return ((task) = JKook.getScheduler().runTaskTimer(this, delay, period));
    }

    /**
     * Attempts to cancel this task.
     *
     * @throws IllegalStateException Thrown if this task has already cancelled
     */
    public synchronized void cancel() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        task.cancel();
        task = null;
    }

    /**
     * Return true if this task has already cancelled.
     */
    public synchronized boolean isCancelled() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        return task.isCancelled();
    }

    /**
     * Return true if this runnable is scheduled.
     */
    public synchronized boolean isScheduled() {
        return task != null;
    }

    /**
     * Return the task ID of this runnable.
     */
    public synchronized int getTaskId() {
        Validate.notNull(task, "This runnable is not scheduled yet.");
        return task.getTaskId();
    }
}
