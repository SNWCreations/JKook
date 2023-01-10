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

package snw.jkook.plugin;

/**
 * 此异常在 {@link PluginManager} 尝试启用一个插件，而插件指定的硬依赖找不到时抛出。
 */
public class UnknownDependencyException extends RuntimeException {

    public UnknownDependencyException() {
    }

    public UnknownDependencyException(String message) {
        super(message);
    }

    public UnknownDependencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownDependencyException(Throwable cause) {
        super(cause);
    }
}
