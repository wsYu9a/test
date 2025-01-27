package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.internal.C$Gson$Types;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public final class g implements r {

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.t.b f32312a;

    /* renamed from: b */
    public final boolean f32313b;

    public g(com.wbl.ad.yzz.gson.t.b bVar, boolean z) {
        this.f32312a = bVar;
        this.f32313b = z;
    }

    @Override // com.wbl.ad.yzz.gson.r
    public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b2 = C$Gson$Types.b(type, C$Gson$Types.e(type));
        return new a(eVar, b2[0], a(eVar, b2[0]), b2[1], eVar.a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(b2[1])), this.f32312a.a(aVar));
    }

    public final class a<K, V> extends q<Map<K, V>> {

        /* renamed from: a */
        public final q<K> f32314a;

        /* renamed from: b */
        public final q<V> f32315b;

        /* renamed from: c */
        public final com.wbl.ad.yzz.gson.t.f<? extends Map<K, V>> f32316c;

        public a(com.wbl.ad.yzz.gson.e eVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.wbl.ad.yzz.gson.t.f<? extends Map<K, V>> fVar) {
            this.f32314a = new m(eVar, qVar, type);
            this.f32315b = new m(eVar, qVar2, type2);
            this.f32316c = fVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Map<K, V> a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            JsonToken t = aVar.t();
            if (t == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            Map<K, V> a2 = this.f32316c.a();
            if (t == JsonToken.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.i()) {
                    aVar.a();
                    K a3 = this.f32314a.a(aVar);
                    if (a2.put(a3, this.f32315b.a(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + a3);
                    }
                    aVar.f();
                }
                aVar.f();
            } else {
                aVar.b();
                while (aVar.i()) {
                    com.wbl.ad.yzz.gson.t.e.f32293a.a(aVar);
                    K a4 = this.f32314a.a(aVar);
                    if (a2.put(a4, this.f32315b.a(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + a4);
                    }
                }
                aVar.g();
            }
            return a2;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Map<K, V> map) throws IOException {
            if (map == null) {
                bVar.k();
                return;
            }
            if (!g.this.f32313b) {
                bVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.a(String.valueOf(entry.getKey()));
                    this.f32315b.a(bVar, entry.getValue());
                }
                bVar.f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.wbl.ad.yzz.gson.k a2 = this.f32314a.a((q<K>) entry2.getKey());
                arrayList.add(a2);
                arrayList2.add(entry2.getValue());
                z |= a2.d() || a2.f();
            }
            if (z) {
                bVar.c();
                int size = arrayList.size();
                while (i2 < size) {
                    bVar.c();
                    com.wbl.ad.yzz.gson.t.i.a((com.wbl.ad.yzz.gson.k) arrayList.get(i2), bVar);
                    this.f32315b.a(bVar, arrayList2.get(i2));
                    bVar.e();
                    i2++;
                }
                bVar.e();
                return;
            }
            bVar.d();
            int size2 = arrayList.size();
            while (i2 < size2) {
                bVar.a(a((com.wbl.ad.yzz.gson.k) arrayList.get(i2)));
                this.f32315b.a(bVar, arrayList2.get(i2));
                i2++;
            }
            bVar.f();
        }

        public final String a(com.wbl.ad.yzz.gson.k kVar) {
            if (kVar.g()) {
                com.wbl.ad.yzz.gson.n c2 = kVar.c();
                if (c2.p()) {
                    return String.valueOf(c2.m());
                }
                if (c2.o()) {
                    return Boolean.toString(c2.h());
                }
                if (c2.q()) {
                    return c2.n();
                }
                throw new AssertionError();
            }
            if (kVar.e()) {
                return "null";
            }
            throw new AssertionError();
        }
    }

    public final q<?> a(com.wbl.ad.yzz.gson.e eVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return eVar.a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(type));
        }
        return n.f32356f;
    }
}
