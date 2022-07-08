package snw.jkook.util;

import java.util.Iterator;

/**
 * Represents the iterator of something can have pages.
 *
 * @param <T> The type of thing will be provided
 */
public interface PageIterator<T> extends Iterator<T> {

    // we don't know, and we don't want to know if this object has more page, because it costs too many resources (e.g. Network resource)
    // so we won't support this
    /**
     * This method always fail.
     * @return Nothing will be returned
     */
    @Override
    default boolean hasNext() {
        throw new UnsupportedOperationException("hasNext");
    }
}
