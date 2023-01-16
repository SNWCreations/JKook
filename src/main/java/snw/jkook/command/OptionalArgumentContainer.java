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

package snw.jkook.command;

import snw.jkook.util.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个可选参数容器。<br>
 * 此类的实例用于为 {@link JKookCommand} 存放可选参数的 {@link Class} 对象以及默认值。
 */
public final class OptionalArgumentContainer {
    private final List<Class<?>> keys = new ArrayList<>();
    private final List<Object> values = new ArrayList<>();

    OptionalArgumentContainer() {
    }

    /**
     * 向此容器添加一个可选参数。
     *
     * @param cls   可选参数的 {@link Class} 对象
     * @param value 可选参数的默认值
     */
    <T> void add(Class<T> cls, T value) {
        Validate.notNull(cls);
        Validate.notNull(value);
        Validate.isFalse(cls == Object.class, "The java.lang.Object (excluding its subclasses) is not allowed to be an optional argument.");
        keys.add(cls);
        values.add(value);
    }

    /**
     * 使用给定的索引获取参数 {@link Class} 对象。
     *
     * @param index 索引
     */
    public Class<?> getKey(int index) {
        return keys.get(index);
    }

    /**
     * 使用给定的索引获取参数的默认值。
     *
     * @param index 索引
     */
    public Object getValue(int index) {
        return values.get(index);
    }

    /**
     * 获取此容器中所有参数的 {@link Class} 对象。
     */
    public List<Class<?>> getKeys() {
        return Collections.unmodifiableList(keys);
    }

    /**
     * 获取此容器中所有参数的默认值。
     */
    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }

    /**
     * 获取此容器的大小。
     */
    public int size() {
        return keys.size();
    }

    /**
     * 当此容器为空时，返回 {@code true}。
     */
    public boolean isEmpty() {
        return keys.isEmpty();
    }
}
