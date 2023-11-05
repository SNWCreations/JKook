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
 * This class provides an easy way to schedule tasks to JKook scheduler.
 */
public abstract class JKookRunnable implements Runnable {
    private Task task = null;

    /**
     * Schedule the runnable to be executed after the delay.
     *
     * @param delay    The delay time
     * @return The task object
     * @throws IllegalStateException Thrown if this task has already scheduled
     */
    public synchronized Task runTaskLater(Plugin plugin, long delay) throws IllegalStateException {
        this.ensureNotScheduled();
        return ((task) = plugin.getCore().getScheduler().runTaskLater(plugin, this, delay));
    }

    /**
     * Execute the runnable again and again.
     *
     * @param delay    The time before first run
     * @param period   The time between two execution
     * @return The task object
     * @throws IllegalStateException Thrown if this task has already scheduled
     */
    public synchronized Task runTaskTimer(Plugin plugin, long delay, long period) throws IllegalStateException {
        ensureNotScheduled();
        return ((task) = plugin.getCore().getScheduler().runTaskTimer(plugin, this, delay, period));
    }

    /**
     * Attempts to cancel this task.
     *
     * @throws IllegalStateException Thrown if this task has already cancelled, or this task is not scheduled yet
     */
    public synchronized void cancel() throws IllegalStateException {
        ensureScheduled();
        task.cancel();
        task = null;
    }

    /**
     * Return true if this task has already cancelled.
     */
    public synchronized boolean isCancelled() {
        ensureScheduled();
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
    public synchronized int getTaskId() throws IllegalStateException {
        ensureScheduled();
        return task.getTaskId();
    }

    private void ensureScheduled() {
        if (!isScheduled()) {
            throw new IllegalStateException("This runnable is not scheduled yet.");
        }
    }

    private void ensureNotScheduled() {
        if (isScheduled()) {
            throw new IllegalStateException("This runnable has already scheduled.");
        }
    }
}
