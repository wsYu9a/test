package com.google.gson;

import com.google.gson.b.a;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.b;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.e;
import com.google.gson.internal.f;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Gson {
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal<Map<a<?>, FutureTypeAdapter<?>>> calls;
    private final b constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List<TypeAdapterFactory> factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map<a<?>, TypeAdapter<?>> typeTokenCache;

    /* renamed from: com.google.gson.Gson$1 */
    class AnonymousClass1 implements JsonDeserializationContext {
        AnonymousClass1() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (T) Gson.this.fromJson(jsonElement, type);
        }
    }

    /* renamed from: com.google.gson.Gson$2 */
    class AnonymousClass2 implements JsonSerializationContext {
        AnonymousClass2() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return Gson.this.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return Gson.this.toJsonTree(obj, type);
        }
    }

    /* renamed from: com.google.gson.Gson$3 */
    class AnonymousClass3 extends TypeAdapter<Number> {
        AnonymousClass3() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Double.valueOf(aVar.t());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.m();
                return;
            }
            Gson.this.checkValidFloatingPoint(number.doubleValue());
            cVar.y(number);
        }
    }

    /* renamed from: com.google.gson.Gson$4 */
    class AnonymousClass4 extends TypeAdapter<Number> {
        AnonymousClass4() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.t());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.m();
                return;
            }
            Gson.this.checkValidFloatingPoint(number.floatValue());
            cVar.y(number);
        }
    }

    /* renamed from: com.google.gson.Gson$5 */
    class AnonymousClass5 extends TypeAdapter<Number> {
        AnonymousClass5() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Long.valueOf(aVar.v());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.m();
            } else {
                cVar.z(number.toString());
            }
        }
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.a aVar) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read2(aVar);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(c cVar, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(cVar, t);
        }
    }

    public Gson() {
        this(Excluder.f8006b, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    private static void assertFullConsumption(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.C() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public void checkValidFloatingPoint(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        return z ? TypeAdapters.p : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            AnonymousClass3() {
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.C() != JsonToken.NULL) {
                    return Double.valueOf(aVar.t());
                }
                aVar.y();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.m();
                    return;
                }
                Gson.this.checkValidFloatingPoint(number.doubleValue());
                cVar.y(number);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        return z ? TypeAdapters.o : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.4
            AnonymousClass4() {
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.C() != JsonToken.NULL) {
                    return Float.valueOf((float) aVar.t());
                }
                aVar.y();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.m();
                    return;
                }
                Gson.this.checkValidFloatingPoint(number.floatValue());
                cVar.y(number);
            }
        };
    }

    private TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.n : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.5
            AnonymousClass5() {
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.C() != JsonToken.NULL) {
                    return Long.valueOf(aVar.v());
                }
                aVar.y();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.m();
                } else {
                    cVar.z(number.toString());
                }
            }
        };
    }

    private c newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        c cVar = new c(writer);
        if (this.prettyPrinting) {
            cVar.s("  ");
        }
        cVar.u(this.serializeNulls);
        return cVar;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) e.e(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> TypeAdapter<T> getAdapter(a<T> aVar) {
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.typeTokenCache.get(aVar);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<a<?>, FutureTypeAdapter<?>> map = this.calls.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.calls.set(map);
            z = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(aVar);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(aVar, futureTypeAdapter2);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> create = it.next().create(this, aVar);
                if (create != null) {
                    futureTypeAdapter2.setDelegate(create);
                    this.typeTokenCache.put(aVar, create);
                    return create;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.calls.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, a<T> aVar) {
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((JsonElement) JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
        toJson(obj, type, bVar);
        return bVar.C();
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.calls = new ThreadLocal<>();
        this.typeTokenCache = Collections.synchronizedMap(new HashMap());
        this.deserializationContext = new JsonDeserializationContext() { // from class: com.google.gson.Gson.1
            AnonymousClass1() {
            }

            @Override // com.google.gson.JsonDeserializationContext
            public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
                return (T) Gson.this.fromJson(jsonElement, type);
            }
        };
        this.serializationContext = new JsonSerializationContext() { // from class: com.google.gson.Gson.2
            AnonymousClass2() {
            }

            @Override // com.google.gson.JsonSerializationContext
            public JsonElement serialize(Object obj) {
                return Gson.this.toJsonTree(obj);
            }

            @Override // com.google.gson.JsonSerializationContext
            public JsonElement serialize(Object obj, Type type) {
                return Gson.this.toJsonTree(obj, type);
            }
        };
        b bVar = new b(map);
        this.constructorConstructor = bVar;
        this.serializeNulls = z;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.Q);
        arrayList.add(ObjectTypeAdapter.f8096a);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.f8123g);
        arrayList.add(TypeAdapters.f8125i);
        arrayList.add(TypeAdapters.k);
        arrayList.add(TypeAdapters.d(Long.TYPE, Long.class, longAdapter(longSerializationPolicy)));
        arrayList.add(TypeAdapters.d(Double.TYPE, Double.class, doubleAdapter(z6)));
        arrayList.add(TypeAdapters.d(Float.TYPE, Float.class, floatAdapter(z6)));
        arrayList.add(TypeAdapters.r);
        arrayList.add(TypeAdapters.t);
        arrayList.add(TypeAdapters.z);
        arrayList.add(TypeAdapters.B);
        arrayList.add(TypeAdapters.c(BigDecimal.class, TypeAdapters.v));
        arrayList.add(TypeAdapters.c(BigInteger.class, TypeAdapters.w));
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.J);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.H);
        arrayList.add(TypeAdapters.f8120d);
        arrayList.add(DateTypeAdapter.f8085a);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TimeTypeAdapter.f8115a);
        arrayList.add(SqlDateTypeAdapter.f8113a);
        arrayList.add(TypeAdapters.K);
        arrayList.add(ArrayTypeAdapter.f8079a);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.f8118b);
        arrayList.add(new CollectionTypeAdapterFactory(bVar));
        arrayList.add(new MapTypeAdapterFactory(bVar, z2));
        arrayList.add(new JsonAdapterAnnotationTypeAdapterFactory(bVar));
        arrayList.add(new ReflectiveTypeAdapterFactory(bVar, fieldNamingStrategy, excluder));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        Object fromJson = fromJson(aVar, cls);
        assertFullConsumption(fromJson, aVar);
        return (T) e.e(cls).cast(fromJson);
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(f.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        T t = (T) fromJson(aVar, type);
        assertFullConsumption(t, aVar);
        return t;
    }

    public void toJson(Object obj, Type type, c cVar) throws JsonIOException {
        TypeAdapter adapter = getAdapter(a.c(type));
        boolean j2 = cVar.j();
        cVar.t(true);
        boolean i2 = cVar.i();
        cVar.r(this.htmlSafe);
        boolean h2 = cVar.h();
        cVar.u(this.serializeNulls);
        try {
            try {
                adapter.write(cVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            cVar.t(j2);
            cVar.r(i2);
            cVar.u(h2);
        }
    }

    public <T> T fromJson(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean q = aVar.q();
        boolean z = true;
        aVar.H(true);
        try {
            try {
                try {
                    aVar.C();
                    z = false;
                    T read2 = getAdapter(a.c(type)).read2(aVar);
                    aVar.H(q);
                    return read2;
                } catch (EOFException e2) {
                    if (z) {
                        aVar.H(q);
                        return null;
                    }
                    throw new JsonSyntaxException(e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (IOException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (Throwable th) {
            aVar.H(q);
            throw th;
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(a.b(cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) e.e(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new com.google.gson.internal.bind.a(jsonElement), type);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(f.c(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void toJson(JsonElement jsonElement, c cVar) throws JsonIOException {
        boolean j2 = cVar.j();
        cVar.t(true);
        boolean i2 = cVar.i();
        cVar.r(this.htmlSafe);
        boolean h2 = cVar.h();
        cVar.u(this.serializeNulls);
        try {
            try {
                f.b(jsonElement, cVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            cVar.t(j2);
            cVar.r(i2);
            cVar.u(h2);
        }
    }
}
