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

/**
 * 表示一种有图标的对象。
 */
public interface AvatarHolder {

    /**
     * 获取此对象的图标 URL 地址。
     *
     * @param vip 是否获取此对象在有 KOOK 相关加持时的图标 (如服务器有 KOOK 助力时可以有动态图标)
     * @return 图标 URL 地址
     */
    String getAvatarUrl(boolean vip);
}
