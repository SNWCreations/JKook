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

package snw.jkook.event.user;

import snw.jkook.entity.User;

/**
 * 此事件在一个用户的信息被更新时触发。<br>
 * 当你拿到此事件时，对应用户的信息就已经被更新了。<br>
 * <b>此事件需要以下前提中的任意一个成立才会提供给你:</b>
 * <ul>
 * <li>此用户与你的机器人有私信会话。</li>
 * <li>此用户与你的机器人有好友关系。<b>(严格意义上，这一条不可能成立，因为官方未公布机器人处理好友请求的相关接口。)</b></li>
 * </ul>
 */
public class UserInfoUpdateEvent extends UserEvent {

    public UserInfoUpdateEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

}
