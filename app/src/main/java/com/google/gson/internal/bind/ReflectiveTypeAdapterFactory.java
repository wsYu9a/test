package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.d;
import com.google.gson.internal.e;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final com.google.gson.internal.b f8099a;

    /* renamed from: b */
    private final FieldNamingStrategy f8100b;

    /* renamed from: c */
    private final Excluder f8101c;

    class a extends c {

        /* renamed from: d */
        final TypeAdapter<?> f8102d;

        /* renamed from: e */
        final /* synthetic */ Gson f8103e;

        /* renamed from: f */
        final /* synthetic */ Field f8104f;

        /* renamed from: g */
        final /* synthetic */ com.google.gson.b.a f8105g;

        /* renamed from: h */
        final /* synthetic */ boolean f8106h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Gson gson, Field field, com.google.gson.b.a aVar, boolean z3) {
            super(str, z, z2);
            this.f8103e = gson;
            this.f8104f = field;
            this.f8105g = aVar;
            this.f8106h = z3;
            this.f8102d = ReflectiveTypeAdapterFactory.this.e(gson, field, aVar);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object read2 = this.f8102d.read2(aVar);
            if (read2 == null && this.f8106h) {
                return;
            }
            this.f8104f.set(obj, read2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException {
            new com.google.gson.internal.bind.c(this.f8103e, this.f8102d, this.f8105g.getType()).write(cVar, this.f8104f.get(obj));
        }
    }

    public static final class b<T> extends TypeAdapter<T> {

        /* renamed from: a */
        private final d<T> f8108a;

        /* renamed from: b */
        private final Map<String, c> f8109b;

        /* synthetic */ b(d dVar, Map map, a aVar) {
            this(dVar, map);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            T a2 = this.f8108a.a();
            try {
                aVar.g();
                while (aVar.p()) {
                    c cVar = this.f8109b.get(aVar.w());
                    if (cVar != null && cVar.f8112c) {
                        cVar.a(aVar, a2);
                    }
                    aVar.M();
                }
                aVar.l();
                return a2;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.m();
                return;
            }
            cVar.d();
            try {
                for (c cVar2 : this.f8109b.values()) {
                    if (cVar2.f8111b) {
                        cVar.k(cVar2.f8110a);
                        cVar2.b(cVar, t);
                    }
                }
                cVar.g();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        private b(d<T> dVar, Map<String, c> map) {
            this.f8108a = dVar;
            this.f8109b = map;
        }
    }

    static abstract class c {

        /* renamed from: a */
        final String f8110a;

        /* renamed from: b */
        final boolean f8111b;

        /* renamed from: c */
        final boolean f8112c;

        protected c(String str, boolean z, boolean z2) {
            this.f8110a = str;
            this.f8111b = z;
            this.f8112c = z2;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.b bVar, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.f8099a = bVar;
        this.f8100b = fieldNamingStrategy;
        this.f8101c = excluder;
    }

    private c b(Gson gson, Field field, String str, com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        return new a(str, z, z2, gson, field, aVar, e.b(aVar.d()));
    }

    private Map<String, c> d(Gson gson, com.google.gson.b.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.b.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean c2 = c(field, true);
                boolean c3 = c(field, false);
                if (c2 || c3) {
                    field.setAccessible(true);
                    c b2 = b(gson, field, f(field), com.google.gson.b.a.c(C$Gson$Types.r(aVar2.getType(), cls2, field.getGenericType())), c2, c3);
                    c cVar = (c) linkedHashMap.put(b2.f8110a, b2);
                    if (cVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar.f8110a);
                    }
                }
            }
            aVar2 = com.google.gson.b.a.c(C$Gson$Types.r(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.d();
        }
        return linkedHashMap;
    }

    public TypeAdapter<?> e(Gson gson, Field field, com.google.gson.b.a<?> aVar) {
        TypeAdapter<?> a2;
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        return (bVar == null || (a2 = JsonAdapterAnnotationTypeAdapterFactory.a(this.f8099a, gson, aVar, bVar)) == null) ? gson.getAdapter(aVar) : a2;
    }

    private String f(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        return cVar == null ? this.f8100b.translateName(field) : cVar.value();
    }

    public boolean c(Field field, boolean z) {
        return (this.f8101c.c(field.getType(), z) || this.f8101c.d(field, z)) ? false : true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Class<? super T> d2 = aVar.d();
        if (Object.class.isAssignableFrom(d2)) {
            return new b(this.f8099a.a(aVar), d(gson, aVar, d2), null);
        }
        return null;
    }
}
