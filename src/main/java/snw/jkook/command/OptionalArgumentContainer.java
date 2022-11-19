/*
 * Copyright 2022 JKook contributors
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import snw.jkook.util.Validate;

/**
 * The container for optional arguments.
 */
public final class OptionalArgumentContainer {
    private final List<Class<?>> keys = new ArrayList<>();
    private final List<Object> values = new ArrayList<>();

    OptionalArgumentContainer() {}

    /**
     * Add an optional argument with its default value.
     * 
     * @param cls The type of the optional argument
     * @param value The default value of this argument
     */
    <T> void add(Class<T> cls, T value) {
        Validate.notNull(cls);
        Validate.notNull(value);
        Validate.isFalse(cls == Object.class, "The java.lang.Object (excluding its subclasses) is not allowed to be an optional argument.");
        keys.add(cls);
        values.add(value);
    }

    /**
     * Get the type of the argument with index.
     * 
     * @param index The index
     */
    public Class<?> getKey(int index) {
        return keys.get(index);
    }

    /**
     * Get the default value of an argument with index.
     * 
     * @param index The index
     */
    public Object getValue(int index) {
        return values.get(index);
    }

    /**
     * Get the keys.
     */
    public List<Class<?>> getKeys() {
        return Collections.unmodifiableList(keys);
    }

    /**
     * Get the values.
     */
    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }

    /**
     * Get the size of this container.
     */
    public int size() {
        return keys.size();
    }

    /**
     * Return true if this container is empty.
     */
    public boolean isEmpty() {
        return keys.isEmpty();
    }
}
