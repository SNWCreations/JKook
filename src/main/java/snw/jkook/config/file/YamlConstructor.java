/*
 * Copyright 2022 - 2024 JKook contributors
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

package snw.jkook.config.file;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import snw.jkook.config.serialization.ConfigurationSerialization;

import java.util.LinkedHashMap;
import java.util.Map;

public class YamlConstructor extends SafeConstructor {

    public YamlConstructor() {
        super(new LoaderOptions());
        this.yamlConstructors.put(Tag.MAP, new ConstructCustomObject());
    }

    @Override
    public void flattenMapping(@NotNull final MappingNode node) {
        super.flattenMapping(node);
    }

    @Nullable
    public Object construct(@NotNull Node node) {
        return constructObject(node);
    }

    private class ConstructCustomObject extends ConstructYamlMap {

        @Nullable
        @Override
        public Object construct(@NotNull Node node) {
            if (node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
            }

            Map<?, ?> raw = (Map<?, ?>) super.construct(node);

            if (raw.containsKey(ConfigurationSerialization.SERIALIZED_TYPE_KEY)) {
                Map<String, Object> typed = new LinkedHashMap<>(raw.size());
                for (Map.Entry<?, ?> entry : raw.entrySet()) {
                    typed.put(entry.getKey().toString(), entry.getValue());
                }

                try {
                    return ConfigurationSerialization.deserializeObject(typed);
                } catch (IllegalArgumentException ex) {
                    throw new YAMLException("Could not deserialize object", ex);
                }
            }

            return raw;
        }

        @Override
        public void construct2ndStep(@NotNull Node node, @NotNull Object object) {
            throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
        }
    }
}
