package snw.jkook.util;

import org.jetbrains.annotations.Range;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Represents the iterator of something can have pages. <p>
 * Requests won't be started until {@link #next()} got call.
 * Default page size is <code>50</code>, you can change it by using {@link #setPageSize(int)}.
 *
 * @param <E> The type of thing will be provided
 */
public interface PageIterator<E> extends Iterator<E> {

    /**
     * Get current size of the pages that iterator provides.
     */
    int getPageSize();

    /**
     * Set the size of the pages that this iterator provides.
     * @param size The size to set
     */
    void setPageSize(@Range(from = 50, to = 100) int size);

    // Unsupported operations are following:

    // Use the methods related to the "E" objects instead.
    @Override
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    // We can't support this, it also costs so many resources!
    @Override
    default void forEachRemaining(Consumer<? super E> action) {
        throw new UnsupportedOperationException("forEachRemaining");
    }
}
