package com.google.gason.internal.bind;

import com.google.gason.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final MiniGson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(MiniGson miniGson, TypeAdapter<T> typeAdapter, Type type) {
        this.context = miniGson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        return this.delegate.read(jsonReader);
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.delegate;
        Type runtimeTypeIfMoreSpecific = Reflection.getRuntimeTypeIfMoreSpecific(this.type, t);
        if (runtimeTypeIfMoreSpecific != this.type) {
            typeAdapter = this.context.getAdapter(TypeToken.get(runtimeTypeIfMoreSpecific));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.delegate;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(jsonWriter, (JsonWriter) t);
    }
}
