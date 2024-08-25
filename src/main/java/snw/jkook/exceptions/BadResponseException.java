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

package snw.jkook.exceptions;

/**
 * This exception will be thrown by the API implementation when HTTP request fails.
 */
public class BadResponseException extends RuntimeException {
    private final int code;
    private final String rawMessage;

    public BadResponseException(int code, String message) {
        super("Response code: " + code + ", message: " + message);
        this.code = code;
        this.rawMessage = message;
    }

    /**
     * Get the error code provided by KOOK API. (maybe not HTTP standard error code!)
     */
    public int getCode() {
        return code;
    }

    /**
     * Get the original error message provided by KOOK API.
     */
    public String getRawMessage() {
        return rawMessage;
    }
}