package com.google.gson;

import com.google.gson.b.a;
import com.google.gson.internal.f;
import com.google.gson.stream.c;
import java.io.IOException;

/* loaded from: classes.dex */
final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    private final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final a<T> typeToken;

    private static class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final a<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        /* synthetic */ SingleTypeFactory(Object obj, a aVar, boolean z, Class cls, AnonymousClass1 anonymousClass1) {
            this(obj, aVar, z, cls);
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
            a<?> aVar2 = this.exactType;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.matchRawType && this.exactType.getType() == aVar.d()) : this.hierarchyType.isAssignableFrom(aVar.d())) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, aVar, this);
            }
            return null;
        }

        private SingleTypeFactory(Object obj, a<?> aVar, boolean z, Class<?> cls) {
            JsonSerializer<?> jsonSerializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.serializer = jsonSerializer;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.deserializer = jsonDeserializer;
            com.google.gson.internal.a.a((jsonSerializer == null && jsonDeserializer == null) ? false : true);
            this.exactType = aVar;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }
    }

    /* synthetic */ TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, a aVar, TypeAdapterFactory typeAdapterFactory, AnonymousClass1 anonymousClass1) {
        this(jsonSerializer, jsonDeserializer, gson, aVar, typeAdapterFactory);
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.d(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(com.google.gson.stream.a aVar) throws IOException {
        if (this.deserializer == null) {
            return delegate().read2(aVar);
        }
        JsonElement a2 = f.a(aVar);
        if (a2.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(a2, this.typeToken.getType(), this.gson.deserializationContext);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(c cVar, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(cVar, t);
        } else if (t == null) {
            cVar.m();
        } else {
            f.b(jsonSerializer.serialize(t, this.typeToken.getType(), this.gson.serializationContext), cVar);
        }
    }

    private TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = aVar;
        this.skipPast = typeAdapterFactory;
    }
}
