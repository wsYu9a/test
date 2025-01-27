package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;

/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final com.google.gson.internal.b f8089a;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.b bVar) {
        this.f8089a = bVar;
    }

    static TypeAdapter<?> a(com.google.gson.internal.b bVar, Gson gson, com.google.gson.b.a<?> aVar, com.google.gson.a.b bVar2) {
        Class<?> value = bVar2.value();
        if (TypeAdapter.class.isAssignableFrom(value)) {
            return (TypeAdapter) bVar.a(com.google.gson.b.a.b(value)).a();
        }
        if (TypeAdapterFactory.class.isAssignableFrom(value)) {
            return ((TypeAdapterFactory) bVar.a(com.google.gson.b.a.b(value)).a()).create(gson, aVar);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.d().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.f8089a, gson, aVar, bVar);
    }
}
