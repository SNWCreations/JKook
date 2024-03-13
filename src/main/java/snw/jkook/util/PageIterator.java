/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.util;

import org.jetbrains.annotations.Range;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Represents the iterator of something can have pages. <p>
 * Requests won't be started until {@link #hasNext()} got call.
 * Default page size is <code>50</code>, you can change it by using {@link #setPageSize(int)}. <p>
 * But <b>DO NOT</b> use {@link #setPageSize(int)} after you called {@link #hasNext()}, or unexpected thing may be happened. (e.g. Throwing an exception)
 *
 * @param <E> The type of thing that will be provided
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

    /**
     * Get the meta returned in api.
     */
    Optional<Meta> getMeta();

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
