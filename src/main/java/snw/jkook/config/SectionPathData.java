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

package snw.jkook.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

final class SectionPathData {

    private Object data;
    private List<String> comments;
    private List<String> inlineComments;

    public SectionPathData(@Nullable Object data) {
        this.data = data;
        comments = Collections.emptyList();
        inlineComments = Collections.emptyList();
    }

    @Nullable
    public Object getData() {
        return data;
    }

    public void setData(@Nullable final Object data) {
        this.data = data;
    }

    /**
     * If no comments exist, an empty list will be returned. A null entry in the
     * list represents an empty line and an empty String represents an empty
     * comment line.
     *
     * @return A unmodifiable list of the requested comments, every entry
     * represents one line.
     */
    @NotNull
    public List<String> getComments() {
        return comments;
    }

    /**
     * Represents the comments on a {@link ConfigurationSection} entry.
     * <p>
     * A null entry in the List is an empty line and an empty String entry is an
     * empty comment line. Any existing comments will be replaced, regardless of
     * what the new comments are.
     *
     * @param comments New comments to set every entry represents one line.
     */
    public void setComments(@Nullable final List<String> comments) {
        this.comments = (comments == null) ? Collections.emptyList() : Collections.unmodifiableList(comments);
    }

    /**
     * If no comments exist, an empty list will be returned. A null entry in the
     * list represents an empty line and an empty String represents an empty
     * comment line.
     *
     * @return A unmodifiable list of the requested comments, every entry
     * represents one line.
     */
    @NotNull
    public List<String> getInlineComments() {
        return inlineComments;
    }

    /**
     * Represents the comments on a {@link ConfigurationSection} entry.
     * <p>
     * A null entry in the List is an empty line and an empty String entry is an
     * empty comment line. Any existing comments will be replaced, regardless of
     * what the new comments are.
     *
     * @param inlineComments New comments to set every entry represents one
     *                       line.
     */
    public void setInlineComments(@Nullable final List<String> inlineComments) {
        this.inlineComments = (inlineComments == null) ? Collections.emptyList() : Collections.unmodifiableList(inlineComments);
    }
}
