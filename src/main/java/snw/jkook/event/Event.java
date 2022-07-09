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

package snw.jkook.event;

/**
 * The basic Event representation. <p>
 * If you want the child of this class be listenable,
 * make a static method called "getHandlers()" and it should return an instance of {@link HandlerList}.
 */
public abstract class Event {
    protected final long timeStamp;

    /* This class should not be constructed. Construct its subclass instead. */
    protected Event(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Get the time stamp of this event.
     */
    public long getTimeStamp() {
        return timeStamp;
    }
}
