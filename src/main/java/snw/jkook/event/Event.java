package snw.jkook.event;

/**
 * The basic Event representation. <p>
 * If you want the child of this class be listenable,
 * make a static method called "getHandlers()" and it should return an instance of {@link HandlerList}.
 */
public abstract class Event {
    protected final long timeStamp;

    /* This class should not be constructed. Construct its subclass instead. */
    protected Event(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Get the time stamp of this event.
     */
    public long getTimeStamp() {
        return timeStamp;
    }
}
