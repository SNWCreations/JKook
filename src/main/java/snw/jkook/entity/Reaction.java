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

package snw.jkook.entity;

import snw.jkook.Permission;
import snw.jkook.entity.abilities.Receivable;
import snw.jkook.util.RequirePermission;

/**
 * 表示一个回应。
 */
public interface Reaction extends Receivable {

    /**
     * 获取此回应所在的消息的 ID 。
     */
    String getMessageId();

    /**
     * 获取此回应使用的表情对象。
     */
    CustomEmoji getEmoji();

    /**
     * 获取此回应发生时的时间戳。<br>
     * 若此回应已被删除，而我们第一次提供此回应对象，此方法将返回 -1 。因此，这个方法是<b>不安全</b>的。<br>
     * 但如果此回应在被删除前就已被 API 实现储存了，此方法仍然能返回正确的值。
     */
    @Override
    long getTimeStamp();

    /**
     * 删除此回应。<br>
     * 若此回应不是由你的机器人发送的，则需要 {@link Permission#MESSAGE_MANAGE} 权限。
     */
    @RequirePermission(Permission.MESSAGE_MANAGE)
    void delete();
}
