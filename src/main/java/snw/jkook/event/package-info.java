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

/**
 * 此包提供与 JKook 事件系统有关的类。<br>
 * 抽象事件类<b>不可以</b>被监听。
 *
 * @see snw.jkook.event.Event
 * @see snw.jkook.event.EventManager#registerHandlers(snw.jkook.plugin.Plugin, snw.jkook.event.Listener)
 * @see snw.jkook.event.Listener
 */

package snw.jkook.event;