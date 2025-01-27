package com.google.gason;

import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
