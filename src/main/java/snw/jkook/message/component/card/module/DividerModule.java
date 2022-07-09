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

package snw.jkook.message.component.card.module;

/**
 * Represents a divider module.
 */
public class DividerModule extends BaseModule {

    /** Only one the instance of this module. One per VM. */
    public static final DividerModule INSTANCE = new DividerModule();

    /*
       Because this class does not provide more operations,
       so I think it is not necessary to make the constructor public.
    */
    protected DividerModule() {}
}
