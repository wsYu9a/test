package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: a */
    public static final TypeAdapterFactory f8079a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type i2 = C$Gson$Types.i(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(com.google.gson.b.a.c(i2)), C$Gson$Types.m(i2));
        }
    };

    /* renamed from: b */
    private final Class<E> f8080b;

    /* renamed from: c */
    private final TypeAdapter<E> f8081c;

    /* renamed from: com.google.gson.internal.bind.ArrayTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapterFactory {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type i2 = C$Gson$Types.i(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(com.google.gson.b.a.c(i2)), C$Gson$Types.m(i2));
        }
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f8081c = new c(gson, typeAdapter, cls);
        this.f8080b = cls;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Object read2(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.C() == JsonToken.NULL) {
            aVar.y();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.f();
        while (aVar.p()) {
            arrayList.add(this.f8081c.read2(aVar));
        }
        aVar.k();
        Object newInstance = Array.newInstance((Class<?>) this.f8080b, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.m();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f8081c.write(cVar, Array.get(obj, i2));
        }
        cVar.f();
    }
}
