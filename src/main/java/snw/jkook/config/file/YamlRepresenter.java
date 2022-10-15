package snw.jkook.config.file;

import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.representer.Representer;
import snw.jkook.config.ConfigurationSection;
import snw.jkook.config.serialization.ConfigurationSerializable;
import snw.jkook.config.serialization.ConfigurationSerialization;

import java.util.LinkedHashMap;
import java.util.Map;

public class YamlRepresenter extends Representer {

    public YamlRepresenter() {
        this.multiRepresenters.put(ConfigurationSection.class, new RepresentConfigurationSection());
        this.multiRepresenters.put(ConfigurationSerializable.class, new RepresentConfigurationSerializable());
        this.multiRepresenters.remove(Enum.class);
    }

    private class RepresentConfigurationSection extends RepresentMap {

        @NotNull
        @Override
        public Node representData(@NotNull Object data) {
            return super.representData(((ConfigurationSection) data).getValues(false));
        }
    }

    private class RepresentConfigurationSerializable extends RepresentMap {

        @NotNull
        @Override
        public Node representData(@NotNull Object data) {
            ConfigurationSerializable serializable = (ConfigurationSerializable) data;
            Map<String, Object> values = new LinkedHashMap<>();
            values.put(ConfigurationSerialization.SERIALIZED_TYPE_KEY, ConfigurationSerialization.getAlias(serializable.getClass()));
            values.putAll(serializable.serialize());

            return super.representData(values);
        }
    }
}
