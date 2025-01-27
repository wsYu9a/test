package com.google.gason.internal.bind;

import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0006;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.ObjectConstructor;
import com.google.gason.internal.Primitives;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ReflectiveTypeAdapterFactory implements TypeAdapter.Factory {

    /* renamed from: short */
    private static final short[] f81short;
    private final ConstructorConstructor constructorConstructor;

    /* renamed from: com.google.gason.internal.bind.ReflectiveTypeAdapterFactory$1 */
    class AnonymousClass1 extends BoundField {
        final ReflectiveTypeAdapterFactory this$0;
        final TypeAdapter<?> typeAdapter;
        final MiniGson val$context;
        final Field val$field;
        final TypeToken val$fieldType;
        final boolean val$isPrimitive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, MiniGson miniGson, TypeToken typeToken, Field field, boolean z3) throws IOException, IllegalAccessException {
            super(str, z, z2);
            this.this$0 = reflectiveTypeAdapterFactory;
            this.val$context = miniGson;
            this.val$fieldType = typeToken;
            this.val$field = field;
            this.val$isPrimitive = z3;
            this.typeAdapter = miniGson.getAdapter(typeToken);
        }

        @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            Object read = this.typeAdapter.read(jsonReader);
            if (read == null && this.val$isPrimitive) {
                return;
            }
            this.val$field.set(obj, read);
        }

        @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
            new TypeAdapterRuntimeTypeWrapper(this.val$context, this.typeAdapter, this.val$fieldType.getType()).write(jsonWriter, (JsonWriter) this.val$field.get(obj));
        }
    }

    public final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;
        final ReflectiveTypeAdapterFactory this$0;

        private Adapter(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.this$0 = reflectiveTypeAdapterFactory;
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        /* synthetic */ Adapter(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, ObjectConstructor objectConstructor, Map map, AnonymousClass1 anonymousClass1) {
            this(reflectiveTypeAdapterFactory, objectConstructor, map);
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.serialized) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }

        abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6549610)}[0]).intValue() ^ 6549583];
        sArr[0] = 2720;
        sArr[1] = 2788;
        sArr[2] = 2789;
        sArr[3] = 2787;
        sArr[4] = 2796;
        sArr[5] = 2785;
        sArr[6] = 2802;
        sArr[7] = 2789;
        sArr[8] = 2803;
        sArr[9] = 2720;
        sArr[10] = 2797;
        sArr[11] = 2805;
        sArr[12] = 2796;
        sArr[13] = 2804;
        sArr[14] = 2793;
        sArr[15] = 2800;
        sArr[16] = 2796;
        sArr[17] = 2789;
        sArr[18] = 2720;
        sArr[19] = 2762;
        sArr[20] = 2771;
        sArr[21] = 2767;
        sArr[22] = 2766;
        sArr[23] = 2720;
        sArr[24] = 2790;
        sArr[25] = 2793;
        sArr[26] = 2789;
        sArr[27] = 2796;
        sArr[28] = 2788;
        sArr[29] = 2803;
        sArr[30] = 2720;
        sArr[31] = 2798;
        sArr[32] = 2785;
        sArr[33] = 2797;
        sArr[34] = 2789;
        sArr[35] = 2788;
        sArr[36] = 2720;
        f81short = sArr;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    private BoundField createBoundField(MiniGson miniGson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        return new BoundField(this, str, z, z2, miniGson, typeToken, field, Primitives.isPrimitive(typeToken.getRawType())) { // from class: com.google.gason.internal.bind.ReflectiveTypeAdapterFactory.1
            final ReflectiveTypeAdapterFactory this$0;
            final TypeAdapter<?> typeAdapter;
            final MiniGson val$context;
            final Field val$field;
            final TypeToken val$fieldType;
            final boolean val$isPrimitive;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ReflectiveTypeAdapterFactory this, String str2, boolean z3, boolean z22, MiniGson miniGson2, TypeToken typeToken2, Field field2, boolean z32) throws IOException, IllegalAccessException {
                super(str2, z3, z22);
                this.this$0 = this;
                this.val$context = miniGson2;
                this.val$fieldType = typeToken2;
                this.val$field = field2;
                this.val$isPrimitive = z32;
                this.typeAdapter = miniGson2.getAdapter(typeToken2);
            }

            @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = this.typeAdapter.read(jsonReader);
                if (read == null && this.val$isPrimitive) {
                    return;
                }
                this.val$field.set(obj, read);
            }

            @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                new TypeAdapterRuntimeTypeWrapper(this.val$context, this.typeAdapter, this.val$fieldType.getType()).write(jsonWriter, (JsonWriter) this.val$field.get(obj));
            }
        };
    }

    private Map<String, BoundField> getBoundFields(MiniGson miniGson, TypeToken<?> typeToken, Class<?> cls) {
        Integer num = new Integer(2478961);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type type = typeToken.getType();
            while (cls != Object.class) {
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                int length = declaredFields.length;
                for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2478960) + i2) {
                    Field field = declaredFields[i2];
                    boolean serializeField = serializeField(cls, field, type);
                    boolean deserializeField = deserializeField(cls, field, type);
                    if (serializeField || deserializeField) {
                        BoundField createBoundField = createBoundField(miniGson, field, getFieldName(cls, field, type), TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, field.getGenericType())), serializeField, deserializeField);
                        BoundField boundField = (BoundField) linkedHashMap.put(createBoundField.name, createBoundField);
                        if (boundField != null) {
                            throw new IllegalArgumentException(type + C0006.m19(f81short, 1747928 ^ C0008.m27((Object) "۠ۨ۠"), 1754592 ^ C0008.m27((Object) "ۧۥۣ"), C0008.m27((Object) "ۣۡۤ") ^ 1746336) + boundField.name);
                        }
                    }
                }
                typeToken = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, cls.getGenericSuperclass()));
                cls = typeToken.getRawType();
            }
        }
        return linkedHashMap;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.getConstructor(typeToken), getBoundFields(miniGson, typeToken, rawType));
        }
        return null;
    }

    protected boolean deserializeField(Class<?> cls, Field field, Type type) {
        return !field.isSynthetic();
    }

    protected String getFieldName(Class<?> cls, Field field, Type type) {
        return field.getName();
    }

    protected boolean serializeField(Class<?> cls, Field field, Type type) {
        return !field.isSynthetic();
    }
}
