package com.google.gason.internal.bind;

import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import com.google.gason.C0107;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class MiniGson {

    /* renamed from: short */
    private static final short[] f80short;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    private final List<TypeAdapter.Factory> factories;

    /* renamed from: com.google.gason.internal.bind.MiniGson$1 */
    class AnonymousClass1 extends ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> {
        final MiniGson this$0;

        AnonymousClass1(MiniGson miniGson) {
            this.this$0 = miniGson;
        }

        @Override // java.lang.ThreadLocal
        public Map<TypeToken<?>, FutureTypeAdapter<?>> initialValue() {
            return new HashMap();
        }
    }

    public static final class Builder {
        private final List<TypeAdapter.Factory> factories = new ArrayList();
        boolean addDefaultFactories = true;

        public MiniGson build() {
            return new MiniGson(this);
        }

        public Builder factory(TypeAdapter.Factory factory) {
            this.factories.add(factory);
            return this;
        }

        public <T> Builder typeAdapter(TypeToken<T> typeToken, TypeAdapter<T> typeAdapter) {
            this.factories.add(TypeAdapters.newFactory(typeToken, typeAdapter));
            return this;
        }

        public <T> Builder typeAdapter(Class<T> cls, TypeAdapter<T> typeAdapter) {
            this.factories.add(TypeAdapters.newFactory(cls, typeAdapter));
            return this;
        }

        public <T> Builder typeHierarchyAdapter(Class<T> cls, TypeAdapter<T> typeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls, typeAdapter));
            return this;
        }

        public Builder withoutDefaultFactories() {
            this.addDefaultFactories = false;
            return this;
        }
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(jsonWriter, (JsonWriter) t);
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4828509)}[0]).intValue() ^ 4828518];
        sArr[0] = 2334;
        sArr[1] = 2338;
        sArr[2] = 2339;
        sArr[3] = 2361;
        sArr[4] = 2410;
        sArr[5] = 2311;
        sArr[6] = 2339;
        sArr[7] = 2340;
        sArr[8] = 2339;
        sArr[9] = 2317;
        sArr[10] = 2329;
        sArr[11] = 2309;
        sArr[12] = 2308;
        sArr[13] = 2410;
        sArr[14] = 2345;
        sArr[15] = 2347;
        sArr[16] = 2340;
        sArr[17] = 2340;
        sArr[18] = 2341;
        sArr[19] = 2366;
        sArr[20] = 2410;
        sArr[21] = 2338;
        sArr[22] = 2347;
        sArr[23] = 2340;
        sArr[24] = 2350;
        sArr[25] = 2342;
        sArr[26] = 2351;
        sArr[27] = 2410;
        sArr[28] = 1982;
        sArr[29] = 1922;
        sArr[30] = 1923;
        sArr[31] = 1945;
        sArr[32] = 1994;
        sArr[33] = 1959;
        sArr[34] = 1923;
        sArr[35] = 1924;
        sArr[36] = 1923;
        sArr[37] = 1965;
        sArr[38] = 1977;
        sArr[39] = 1957;
        sArr[40] = 1956;
        sArr[41] = 1994;
        sArr[42] = 1929;
        sArr[43] = 1931;
        sArr[44] = 1924;
        sArr[45] = 1924;
        sArr[46] = 1925;
        sArr[47] = 1950;
        sArr[48] = 1994;
        sArr[49] = 1945;
        sArr[50] = 1935;
        sArr[51] = 1944;
        sArr[52] = 1923;
        sArr[53] = 1931;
        sArr[54] = 1926;
        sArr[55] = 1923;
        sArr[56] = 1936;
        sArr[57] = 1935;
        sArr[58] = 1994;
        f80short = sArr;
    }

    private MiniGson(Builder builder) {
        this.calls = new ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>>(this) { // from class: com.google.gason.internal.bind.MiniGson.1
            final MiniGson this$0;

            AnonymousClass1(MiniGson this) {
                this.this$0 = this;
            }

            @Override // java.lang.ThreadLocal
            public Map<TypeToken<?>, FutureTypeAdapter<?>> initialValue() {
                return new HashMap();
            }
        };
        ConstructorConstructor constructorConstructor = new ConstructorConstructor();
        ArrayList arrayList = new ArrayList();
        if (builder.addDefaultFactories) {
            arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
            arrayList.add(TypeAdapters.INTEGER_FACTORY);
            arrayList.add(TypeAdapters.DOUBLE_FACTORY);
            arrayList.add(TypeAdapters.FLOAT_FACTORY);
            arrayList.add(TypeAdapters.LONG_FACTORY);
            arrayList.add(TypeAdapters.STRING_FACTORY);
        }
        arrayList.addAll(builder.factories);
        if (builder.addDefaultFactories) {
            arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
            arrayList.add(new StringToValueMapTypeAdapterFactory(constructorConstructor));
            arrayList.add(ArrayTypeAdapter.FACTORY);
            arrayList.add(ObjectTypeAdapter.FACTORY);
            arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor));
        }
        this.factories = Collections.unmodifiableList(arrayList);
    }

    /* synthetic */ MiniGson(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        Map map = this.calls.get();
        TypeAdapter<T> typeAdapter = (FutureTypeAdapter) map.get(typeToken);
        if (typeAdapter == null) {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            try {
                Iterator<TypeAdapter.Factory> it = this.factories.iterator();
                while (it.hasNext()) {
                    typeAdapter = it.next().create(this, typeToken);
                    if (typeAdapter != null) {
                        futureTypeAdapter.setDelegate(typeAdapter);
                    }
                }
                throw new IllegalArgumentException(C0107.m50(f80short, 1746850 ^ C0008.m27((Object) "۟ۤۧ"), 56346 ^ C0008.m27((Object) "۠ۦ"), C0008.m27((Object) "ۤۢۤ") ^ 1749868) + typeToken);
            } finally {
                map.remove(typeToken);
            }
        }
        return typeAdapter;
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public List<TypeAdapter.Factory> getFactories() {
        return this.factories;
    }

    public <T> TypeAdapter<T> getNextAdapter(TypeAdapter.Factory factory, TypeToken<T> typeToken) {
        boolean z = false;
        for (TypeAdapter.Factory factory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = factory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (factory2 == factory) {
                z = true;
            }
        }
        throw new IllegalArgumentException(C0000.m1(f80short, 1751512 ^ C0008.m27((Object) "ۤ۟۟"), 1754552 ^ C0008.m27((Object) "ۧۤۤ"), C0008.m27((Object) "ۦۣۡ") ^ 1754722) + typeToken);
    }
}
