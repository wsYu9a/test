package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes.dex */
final class c<T> extends TypeAdapter<T> {

    /* renamed from: a */
    private final Gson f8150a;

    /* renamed from: b */
    private final TypeAdapter<T> f8151b;

    /* renamed from: c */
    private final Type f8152c;

    c(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f8150a = gson;
        this.f8151b = typeAdapter;
        this.f8152c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(com.google.gson.stream.a aVar) throws IOException {
        return this.f8151b.read2(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.c cVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f8151b;
        Type a2 = a(this.f8152c, t);
        if (a2 != this.f8152c) {
            typeAdapter = this.f8150a.getAdapter(com.google.gson.b.a.c(a2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.b) {
                TypeAdapter<T> typeAdapter2 = this.f8151b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.b)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(cVar, t);
    }
}
