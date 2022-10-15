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

package snw.jkook.event.item;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;

/**
 * Represents an event that means an item was consumed by somebody, and it affects someone else.
 */
public class ItemConsumedEvent extends ItemEvent {
    private static final HandlerList handlers = new HandlerList();
    private final User consumer;
    private final User affected;
    private final int itemId;

    public ItemConsumedEvent(long timestamp, User consumer, User affected, int itemId) {
        super(timestamp);
        this.consumer = consumer;
        this.affected = affected;
        this.itemId = itemId;
    }

    public User getConsumer() {
        return consumer;
    }

    public User getWhoBeAffected() {
        return affected;
    }

    public int getItemId() {
        return itemId;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
