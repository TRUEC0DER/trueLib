package me.truec0der.truelib.config.base.serializer.standard;

import me.truec0der.truelib.config.base.node.EntryNode;
import me.truec0der.truelib.config.base.serializer.SerializerRegistry;
import me.truec0der.truelib.config.base.serializer.TypeSerializer;

public class IntegerSerializer implements TypeSerializer<Integer> {
    @Override
    public Integer deserialize(EntryNode node, String path, SerializerRegistry registry, Class<?> fieldType) {
        Object raw = node.get(path);
        return raw instanceof Number ? ((Number) raw).intValue() : null;
    }
}
