package com.google.gson;

import com.google.gson.b.a;

/* loaded from: classes.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, a<T> aVar);
}
