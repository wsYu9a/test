package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.internal.C$Gson$Types;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class i implements r {

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.t.b f32321a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.gson.d f32322b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.gson.t.c f32323c;

    /* renamed from: d */
    public final d f32324d;

    /* renamed from: e */
    public final com.wbl.ad.yzz.gson.t.l.b f32325e = com.wbl.ad.yzz.gson.t.l.b.a();

    public static abstract class c {

        /* renamed from: a */
        public final String f32334a;

        /* renamed from: b */
        public final boolean f32335b;

        /* renamed from: c */
        public final boolean f32336c;

        public c(String str, boolean z, boolean z2) {
            this.f32334a = str;
            this.f32335b = z;
            this.f32336c = z2;
        }

        public abstract void a(com.wbl.ad.yzz.gson.v.a aVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void a(com.wbl.ad.yzz.gson.v.b bVar, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.wbl.ad.yzz.gson.t.b bVar, com.wbl.ad.yzz.gson.d dVar, com.wbl.ad.yzz.gson.t.c cVar, d dVar2) {
        this.f32321a = bVar;
        this.f32322b = dVar;
        this.f32323c = cVar;
        this.f32324d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f32323c);
    }

    public static boolean a(Field field, boolean z, com.wbl.ad.yzz.gson.t.c cVar) {
        return (cVar.a(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    public final List<String> a(Field field) {
        com.wbl.ad.yzz.gson.s.c cVar = (com.wbl.ad.yzz.gson.s.c) field.getAnnotation(com.wbl.ad.yzz.gson.s.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f32322b.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public class a extends c {

        /* renamed from: d */
        public final /* synthetic */ Field f32326d;

        /* renamed from: e */
        public final /* synthetic */ boolean f32327e;

        /* renamed from: f */
        public final /* synthetic */ q f32328f;

        /* renamed from: g */
        public final /* synthetic */ com.wbl.ad.yzz.gson.e f32329g;

        /* renamed from: h */
        public final /* synthetic */ com.wbl.ad.yzz.gson.u.a f32330h;

        /* renamed from: i */
        public final /* synthetic */ boolean f32331i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, String str, boolean z, boolean z2, Field field, boolean z3, q qVar, com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a aVar, boolean z4) {
            super(str, z, z2);
            this.f32326d = field;
            this.f32327e = z3;
            this.f32328f = qVar;
            this.f32329g = eVar;
            this.f32330h = aVar;
            this.f32331i = z4;
        }

        @Override // com.wbl.ad.yzz.gson.t.k.i.c
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Object obj) throws IOException, IllegalAccessException {
            (this.f32327e ? this.f32328f : new m(this.f32329g, this.f32328f, this.f32330h.getType())).a(bVar, this.f32326d.get(obj));
        }

        @Override // com.wbl.ad.yzz.gson.t.k.i.c
        public void a(com.wbl.ad.yzz.gson.v.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object a2 = this.f32328f.a(aVar);
            if (a2 == null && this.f32331i) {
                return;
            }
            this.f32326d.set(obj, a2);
        }

        @Override // com.wbl.ad.yzz.gson.t.k.i.c
        public boolean a(Object obj) throws IOException, IllegalAccessException {
            return this.f32335b && this.f32326d.get(obj) != obj;
        }
    }

    public static final class b<T> extends q<T> {

        /* renamed from: a */
        public final com.wbl.ad.yzz.gson.t.f<T> f32332a;

        /* renamed from: b */
        public final Map<String, c> f32333b;

        public b(com.wbl.ad.yzz.gson.t.f<T> fVar, Map<String, c> map) {
            this.f32332a = fVar;
            this.f32333b = map;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            T a2 = this.f32332a.a();
            try {
                aVar.b();
                while (aVar.i()) {
                    c cVar = this.f32333b.get(aVar.p());
                    if (cVar != null && cVar.f32336c) {
                        cVar.a(aVar, a2);
                    }
                    aVar.z();
                }
                aVar.g();
                return a2;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.k();
                return;
            }
            bVar.d();
            try {
                for (c cVar : this.f32333b.values()) {
                    if (cVar.a(t)) {
                        bVar.a(cVar.f32334a);
                        cVar.a(bVar, t);
                    }
                }
                bVar.f();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // com.wbl.ad.yzz.gson.r
    public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new b(this.f32321a.a(aVar), a(eVar, (com.wbl.ad.yzz.gson.u.a<?>) aVar, (Class<?>) a2));
        }
        return null;
    }

    public final c a(com.wbl.ad.yzz.gson.e eVar, Field field, String str, com.wbl.ad.yzz.gson.u.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = com.wbl.ad.yzz.gson.t.h.a((Type) aVar.a());
        com.wbl.ad.yzz.gson.s.b bVar = (com.wbl.ad.yzz.gson.s.b) field.getAnnotation(com.wbl.ad.yzz.gson.s.b.class);
        q<?> a3 = bVar != null ? this.f32324d.a(this.f32321a, eVar, aVar, bVar) : null;
        boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = eVar.a((com.wbl.ad.yzz.gson.u.a) aVar);
        }
        return new a(this, str, z, z2, field, z3, a3, eVar, aVar, a2);
    }

    public final Map<String, c> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.wbl.ad.yzz.gson.u.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    this.f32325e.a(field);
                    Type a4 = C$Gson$Types.a(aVar2.getType(), cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    c cVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = a5.get(i3);
                        boolean z2 = i3 != 0 ? false : a2;
                        int i4 = i3;
                        c cVar2 = cVar;
                        int i5 = size;
                        List<String> list = a5;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, a(eVar, field, str, com.wbl.ad.yzz.gson.u.a.a(a4), z2, a3)) : cVar2;
                        i3 = i4 + 1;
                        a2 = z2;
                        a5 = list;
                        size = i5;
                        field = field2;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar3.f32334a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.wbl.ad.yzz.gson.u.a.a(C$Gson$Types.a(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }
}
