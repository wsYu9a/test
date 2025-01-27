package com.google.gason;

import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
