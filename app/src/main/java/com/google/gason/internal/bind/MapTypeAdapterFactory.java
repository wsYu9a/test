package com.google.gason.internal.bind;

import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.JsonElement;
import com.google.gason.JsonPrimitive;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.ObjectConstructor;
import com.google.gason.internal.Streams;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes7.dex */
public final class MapTypeAdapterFactory implements TypeAdapter.Factory {
    private final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: short */
        private static final short[] f79short;
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(4592474)}[0]).intValue() ^ 4592457];
            sArr[0] = 2936;
            sArr[1] = 2915;
            sArr[2] = 2938;
            sArr[3] = 2938;
            sArr[4] = 3087;
            sArr[5] = 3102;
            sArr[6] = 3099;
            sArr[7] = 3079;
            sArr[8] = 3074;
            sArr[9] = 3080;
            sArr[10] = 3082;
            sArr[11] = 3103;
            sArr[12] = 3086;
            sArr[13] = 3147;
            sArr[14] = 3072;
            sArr[15] = 3086;
            sArr[16] = 3090;
            sArr[17] = 3153;
            sArr[18] = 3147;
            f79short = sArr;
        }

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, MiniGson miniGson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.this$0 = mapTypeAdapterFactory;
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(miniGson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(miniGson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        private String keyToString(JsonElement jsonElement) {
            if (!jsonElement.isJsonPrimitive()) {
                if (!jsonElement.isJsonNull()) {
                    throw new AssertionError();
                }
                return C0007.m23(f79short, 1748609 ^ C0008.m27((Object) "ۡ۟۟"), 1751782 ^ C0008.m27((Object) "ۤۨۦ"), C0008.m27((Object) "ۧۧۦ") ^ 1756432);
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

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> construct = this.constructor.construct();
            JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
            String m19 = C0006.m19(f79short, 1752492 ^ C0008.m27((Object) "ۥۣ۠"), 1754638 ^ C0008.m27((Object) "ۧۧۡ"), C0008.m27((Object) "ۡۧ۟") ^ 1745682);
            if (peek != jsonToken) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    K fromJsonElement = this.keyTypeAdapter.fromJsonElement(new JsonPrimitive(jsonReader.nextName()));
                    if (construct.put(fromJsonElement, this.valueTypeAdapter.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(m19 + fromJsonElement);
                    }
                }
                jsonReader.endObject();
                return construct;
            }
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                K read = this.keyTypeAdapter.read(jsonReader);
                if (construct.put(read, this.valueTypeAdapter.read(jsonReader)) != null) {
                    throw new JsonSyntaxException(m19 + read);
                }
                jsonReader.endArray();
            }
            jsonReader.endArray();
            return construct;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            int i2 = 0;
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (this.this$0.complexMapKeySerialization) {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    JsonElement jsonElement = this.keyTypeAdapter.toJsonElement(entry.getKey());
                    arrayList.add(jsonElement);
                    arrayList2.add(entry.getValue());
                    z = (jsonElement.isJsonArray() || jsonElement.isJsonObject()) | z;
                }
                if (z) {
                    jsonWriter.beginArray();
                    while (i2 < arrayList.size()) {
                        jsonWriter.beginArray();
                        Streams.write((JsonElement) arrayList.get(i2), jsonWriter);
                        this.valueTypeAdapter.write(jsonWriter, (JsonWriter) arrayList2.get(i2));
                        jsonWriter.endArray();
                        i2++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                while (i2 < arrayList.size()) {
                    jsonWriter.name(keyToString((JsonElement) arrayList.get(i2)));
                    this.valueTypeAdapter.write(jsonWriter, (JsonWriter) arrayList2.get(i2));
                    i2++;
                }
            } else {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry2.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, (JsonWriter) entry2.getValue());
                }
            }
            jsonWriter.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z;
    }

    private TypeAdapter<?> getKeyAdapter(MiniGson miniGson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : miniGson.getAdapter(TypeToken.get(type));
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Integer num = new Integer(4002319);
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        TypeAdapter<?> keyAdapter = getKeyAdapter(miniGson, mapKeyAndValueTypes[0]);
        int intValue = 4002318 ^ ((Integer) new Object[]{num}[0]).intValue();
        return new Adapter(this, miniGson, mapKeyAndValueTypes[0], keyAdapter, mapKeyAndValueTypes[intValue], miniGson.getAdapter(TypeToken.get(mapKeyAndValueTypes[intValue])), this.constructorConstructor.getConstructor(typeToken));
    }
}
