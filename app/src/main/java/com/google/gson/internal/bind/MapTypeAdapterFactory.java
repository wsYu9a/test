package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.d;
import com.google.gson.internal.f;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final com.google.gson.internal.b f8090a;

    /* renamed from: b */
    private final boolean f8091b;

    private final class a<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a */
        private final TypeAdapter<K> f8092a;

        /* renamed from: b */
        private final TypeAdapter<V> f8093b;

        /* renamed from: c */
        private final d<? extends Map<K, V>> f8094c;

        public a(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, d<? extends Map<K, V>> dVar) {
            this.f8092a = new c(gson, typeAdapter, type);
            this.f8093b = new c(gson, typeAdapter2, type2);
            this.f8094c = dVar;
        }

        private String a(JsonElement jsonElement) {
            if (!jsonElement.isJsonPrimitive()) {
                if (jsonElement.isJsonNull()) {
                    return "null";
                }
                throw new AssertionError();
            }
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return String.valueOf(asJsonPrimitive.getAsNumber());
            }
            if (asJsonPrimitive.isBoolean()) {
                return Boolean.toString(asJsonPrimitive.getAsBoolean());
            }
            if (asJsonPrimitive.isString()) {
                return asJsonPrimitive.getAsString();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Map<K, V> read2(com.google.gson.stream.a aVar) throws IOException {
            JsonToken C = aVar.C();
            if (C == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            Map<K, V> a2 = this.f8094c.a();
            if (C == JsonToken.BEGIN_ARRAY) {
                aVar.f();
                while (aVar.p()) {
                    aVar.f();
                    K read2 = this.f8092a.read2(aVar);
                    if (a2.put(read2, this.f8093b.read2(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                    aVar.k();
                }
                aVar.k();
            } else {
                aVar.g();
                while (aVar.p()) {
                    com.google.gson.internal.c.f8153a.a(aVar);
                    K read22 = this.f8092a.read2(aVar);
                    if (a2.put(read22, this.f8093b.read2(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read22);
                    }
                }
                aVar.l();
            }
            return a2;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public void write(com.google.gson.stream.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.m();
                return;
            }
            if (!MapTypeAdapterFactory.this.f8091b) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.k(String.valueOf(entry.getKey()));
                    this.f8093b.write(cVar, entry.getValue());
                }
                cVar.g();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f8092a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z) {
                cVar.d();
                while (i2 < arrayList.size()) {
                    cVar.k(a((JsonElement) arrayList.get(i2)));
                    this.f8093b.write(cVar, arrayList2.get(i2));
                    i2++;
                }
                cVar.g();
                return;
            }
            cVar.c();
            while (i2 < arrayList.size()) {
                cVar.c();
                f.b((JsonElement) arrayList.get(i2), cVar);
                this.f8093b.write(cVar, arrayList2.get(i2));
                cVar.f();
                i2++;
            }
            cVar.f();
        }
    }

    public MapTypeAdapterFactory(com.google.gson.internal.b bVar, boolean z) {
        this.f8090a = bVar;
        this.f8091b = z;
    }

    private TypeAdapter<?> b(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f8122f : gson.getAdapter(com.google.gson.b.a.c(type));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.d())) {
            return null;
        }
        Type[] l = C$Gson$Types.l(type, C$Gson$Types.m(type));
        return new a(gson, l[0], b(gson, l[0]), l[1], gson.getAdapter(com.google.gson.b.a.c(l[1])), this.f8090a.a(aVar));
    }
}
