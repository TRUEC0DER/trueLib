package me.truec0der.truelib.config.base.serializer;

import me.truec0der.truelib.config.base.node.EntryNode;

@FunctionalInterface
public interface TypeSerializer<T> {
    T deserialize(EntryNode node, String path, SerializerRegistry registry, Class<?> fieldType);
}