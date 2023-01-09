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

package snw.jkook.entity.channel;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.abilities.Nameable;

import java.util.Collection;

/**
 * Represents a group of channel.
 */
public interface Category extends Channel, Nameable {

    @Contract("_, _-> fail")
    @Override
    default String createInvite(int validSeconds, int validTimes) {
        throw new UnsupportedOperationException("Kook does not support the users inviting other users to a category.");
    }

    @Contract("-> fail")
    @Override
    @Nullable
    default Category getParent() {
        throw new UnsupportedOperationException("No parent-related methods available for Category!");
    }

    @Contract("_ -> fail")
    @Override
    default void setParent(@Nullable Category parent) {
        throw new UnsupportedOperationException("No parent-related methods available for Category!");
    }

    /**
     * Return the channels in this group.
     */
    Collection<Channel> getChannels();
}
