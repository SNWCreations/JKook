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

package snw.jkook.entity.abilities;

import snw.jkook.Permission;
import snw.jkook.entity.Invitation;
import snw.jkook.util.PageIterator;
import snw.jkook.util.RequirePermission;

import java.util.Set;

/**
 * 表示一种可以创建邀请的对象。
 *
 * @see Invitation
 */
public interface InviteHolder {

    /**
     * 获取所有指向此对象的邀请。
     */
    PageIterator<Set<Invitation>> getInvitations();

    /**
     * 对此对象创建邀请。
     *
     * @param validSeconds 邀请链接有效时长（秒），
     *                     可选值：
     *                     0 => 永不过期；
     *                     1800 => 0.5 小时；
     *                     3600 => 1 小时；
     *                     21600 => 6 小时；
     *                     43200 => 12 小时；
     *                     86400 => 1 天；
     *                     604800 => 7 天
     * @param validTimes   邀请链接可以使用的次数，
     *                     可选值：
     *                     -1 => 无限制；
     *                     1 => 1 次使用；
     *                     5 => 5 次使用；
     *                     10 => 10 次使用；
     *                     25 => 25 次使用；
     *                     50 => 50 次使用；
     *                     100 => 100 次使用
     * @return 邀请链接 URL 字符串
     */
    @RequirePermission(Permission.INVITE)
    String createInvite(int validSeconds, int validTimes);

}
