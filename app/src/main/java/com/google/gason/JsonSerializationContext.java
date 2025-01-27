package com.google.gason;

import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
