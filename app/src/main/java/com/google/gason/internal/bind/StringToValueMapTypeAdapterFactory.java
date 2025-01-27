package com.google.gason.internal.bind;

import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.ObjectConstructor;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes7.dex */
public final class StringToValueMapTypeAdapterFactory implements TypeAdapter.Factory {
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<V> extends TypeAdapter<Map<String, V>> {
        private final ObjectConstructor<? extends Map<String, V>> constructor;
        final StringToValueMapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(StringToValueMapTypeAdapterFactory stringToValueMapTypeAdapterFactory, TypeAdapter<V> typeAdapter, ObjectConstructor<? extends Map<String, V>> objectConstructor) {
            this.this$0 = stringToValueMapTypeAdapterFactory;
            this.valueTypeAdapter = typeAdapter;
            this.constructor = objectConstructor;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Map<String, V> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<String, V> construct = this.constructor.construct();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                construct.put(jsonReader.nextName(), this.valueTypeAdapter.read(jsonReader));
            }
            jsonReader.endObject();
            return construct;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Map<String, V> map) throws IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            for (Map.Entry<String, V> entry : map.entrySet()) {
                jsonWriter.name(entry.getKey());
                this.valueTypeAdapter.write(jsonWriter, (JsonWriter) entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    public StringToValueMapTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Integer num = new Integer(78273);
        Type type = typeToken.getType();
        if (type instanceof ParameterizedType) {
            Class<? super T> rawType = typeToken.getRawType();
            if (Map.class.isAssignableFrom(rawType)) {
                Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, rawType);
                if (mapKeyAndValueTypes[0] == String.class) {
                    return new Adapter(this, miniGson.getAdapter(TypeToken.get(mapKeyAndValueTypes[((Integer) new Object[]{num}[0]).intValue() ^ 78272])), this.constructorConstructor.getConstructor(typeToken));
                }
            }
        }
        return null;
    }
}
