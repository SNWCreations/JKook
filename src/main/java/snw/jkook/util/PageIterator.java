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

package snw.jkook.util;

import org.jetbrains.annotations.Range;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 表示一个分页遍历器。<br>
 * 此遍历器是基于 KOOK HTTP API 中的标准分页格式设计的。<br>
 * 具体的信息在调用 {@link #hasNext()} 之前不会请求。<br>
 * 默认的分页大小 {@code 50} ，你可以使用 {@link #setPageSize(int)} 方法修改。<br>
 * <b>但必须在第一次调用 {@link #hasNext()} 方法前调用。</b>
 *
 * @param <E> 具体的数据类型
 */
public interface PageIterator<E> extends Iterator<E> {

    /**
     * 获取当前遍历器的分页大小。
     */
    int getPageSize();

    /**
     * 设置当前遍历器的分页大小。
     *
     * @param size 新的分页大小
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
