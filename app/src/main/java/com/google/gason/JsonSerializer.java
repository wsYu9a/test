package com.google.gason;

import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
