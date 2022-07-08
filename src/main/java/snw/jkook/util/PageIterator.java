package snw.jkook.util;

import java.util.Iterator;

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
    void setPageSize(int size);
}
