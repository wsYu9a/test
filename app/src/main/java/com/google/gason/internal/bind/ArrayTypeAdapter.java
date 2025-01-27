package com.google.gason.internal.bind;

import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.ArrayTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(miniGson, miniGson.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    /* renamed from: com.google.gason.internal.bind.ArrayTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapter.Factory {
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(miniGson, miniGson.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
        }
    }

    public ArrayTypeAdapter(MiniGson miniGson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(miniGson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        Integer num = new Integer(5133913);
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        Object newInstance = Array.newInstance((Class<?>) this.componentType, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5133912) + i2) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Integer num = new Integer(2006621);
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2006620) + i2) {
            this.componentTypeAdapter.write(jsonWriter, (JsonWriter) Array.get(obj, i2));
        }
        jsonWriter.endArray();
    }
}
