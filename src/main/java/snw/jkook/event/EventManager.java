package snw.jkook.event;

/**
 * Represents an event manager.
 */
public interface EventManager {

    /**
     * Call an event. The listeners of the provided event type will be called. <p>
     * It is a sync method.
     *
     * @param event The event to call
     */
    void callEvent(Event event);

    /**
     * Register a handler that can process events.
     *
     * @param listener The listener to register
     */
    void registerHandlers(Listener listener);
}
