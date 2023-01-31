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

package snw.jkook.event.item;

import snw.jkook.entity.User;

/**
 * 此事件在某位用户使用了一个道具，并对另一个用户产生了影响时触发。
 */
public class ItemConsumedEvent extends ItemEvent {
    private final User consumer;
    private final User affected;
    private final int itemId;

    public ItemConsumedEvent(long timestamp, User consumer, User affected, int itemId) {
        super(timestamp);
        this.consumer = consumer;
        this.affected = affected;
        this.itemId = itemId;
    }

    /**
     * 获取使用了道具的用户。
     */
    public User getConsumer() {
        return consumer;
    }

    /**
     * 获取受影响的用户。
     */
    public User getWhoBeAffected() {
        return affected;
    }

    /**
     * 获取道具的 ID 。
     */
    public int getItemId() {
        return itemId;
    }

}
