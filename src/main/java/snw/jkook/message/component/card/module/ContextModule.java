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

import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.List;

public class ContextModule extends BaseModule {
    private final List<BaseModule> modules;

    public ContextModule(List<BaseModule> modules) {
        Validate.isTrue(modules.stream().allMatch(IT -> ((IT instanceof PlainTextModule) || (IT instanceof ImageModule))), "Context module only accepts plain-text, kmarkdown or image modules.");
        this.modules = Collections.unmodifiableList(modules);
    }

    /**
     * Get the modules that stored in this module.
     */
    public List<BaseModule> getModules() {
        return modules;
    }
}
