package com.google.gason.internal.bind;

import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes7.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.ObjectTypeAdapter.1
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(miniGson);
            }
            return null;
        }
    };
    private final MiniGson miniGson;

    /* renamed from: com.google.gason.internal.bind.ObjectTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapter.Factory {
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(miniGson);
            }
            return null;
        }
    }

    /* renamed from: com.google.gason.internal.bind.ObjectTypeAdapter$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final int[] $SwitchMap$com$gaagle$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$gaagle$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private ObjectTypeAdapter(MiniGson miniGson) {
        this.miniGson = miniGson;
    }

    /* synthetic */ ObjectTypeAdapter(MiniGson miniGson, AnonymousClass1 anonymousClass1) {
        this(miniGson);
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        switch (AnonymousClass2.$SwitchMap$com$gaagle$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedHashMap.put(jsonReader.nextName(), read(jsonReader));
                }
                jsonReader.endObject();
                return linkedHashMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.miniGson.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(jsonWriter, (JsonWriter) obj);
        } else {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
    }
}
