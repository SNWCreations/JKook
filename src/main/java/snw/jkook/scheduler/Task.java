package snw.jkook.scheduler;

/**
 * Represents a scheduled task.
 */
public interface Task {

    /**
     * Attempts to cancel this task.
     *
     * @throws IllegalStateException Thrown if this task has already cancelled
     */
    void cancel() throws IllegalStateException;

    /**
     * Return true if this task has already cancelled.
     */
    boolean isCancelled();

    /**
     * Return true if this task has been executed (whether success or fail).
     */
    boolean isExecuted();

    /**
     * Get the ID of this task.
     */
    int getTaskId();
}
