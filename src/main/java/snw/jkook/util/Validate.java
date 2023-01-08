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

/**
 * 一个存放了一些用于检查参数的方法的类。
 */
public class Validate {

    private Validate() {}

    /**
     * 检查 {@code expression} 是否为 {@code true} ，若不是则抛出 {@link IllegalArgumentException} 。
     *
     * @param expression 待检查的表达式
     * @param message 异常信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 检查 {@code expression} 是否为 {@code true} ，若不是则抛出 {@link IllegalArgumentException} 。
     *
     * @param expression 待检查的表达式
     */
    public static void isTrue(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    /**
     * 检查 {@code expression} 是否为 {@code false} ，若不是则抛出 {@link IllegalArgumentException} 。
     *
     * @param expression 待检查的表达式
     */
    public static void isFalse(boolean expression) {
        isFalse(expression, "The validated expression is true");
    }

    /**
     * 检查 {@code expression} 是否为 {@code false} ，若不是则抛出 {@link IllegalArgumentException} 。
     *
     * @param expression 待检查的表达式
     * @param message 异常信息
     */
    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    /**
     * 检查 {@code object} 是否为 {@code null} ，若是则抛出 {@link IllegalArgumentException} 。
     *
     * @param object 待检查的对象
     */
    public static void notNull(Object object) {
        notNull(object, "The validated object is null");
    }

    /**
     * 检查 {@code object} 是否为 {@code null} ，若是则抛出 {@link IllegalArgumentException} 。
     *
     * @param object 待检查的对象
     * @param message 异常信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 检查 {@code string} 是否为空，若是则抛出 {@link IllegalArgumentException} 。
     *
     * @param string 待检查的字符串
     * @param message 异常信息
     */
    public static void notEmpty(String string, String message) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 检查 {@code string} 是否为空，若是则抛出 {@link IllegalArgumentException} 。
     *
     * @param string 待检查的字符串
     */
    public static void notEmpty(String string) {
        notEmpty(string, "The validated string is empty");
    }

}
