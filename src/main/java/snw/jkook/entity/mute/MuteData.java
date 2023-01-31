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

package snw.jkook.entity.mute;

import snw.jkook.entity.User;

/**
 * 表示一个用户在某个服务器中的闭麦/静音情况。<br>
 * 这是一个快照，你不应该保存它。
 */
public interface MuteData {

    /**
     * 获取与此记录关联的用户。
     */
    User getUser();

    /**
     * 若此用户禁用了 TA 的麦克风，则此方法返回 {@code true} 。
     */
    boolean isInputDisabled();

    /**
     * 若此用户已经静音，则此方法返回 {@code true} 。
     */
    boolean isOutputDisabled();
}
