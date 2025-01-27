package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.internal.C$Gson$Types;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class a<E> extends q<Object> {

    /* renamed from: c */
    public static final r f32303c = new C0726a();

    /* renamed from: a */
    public final Class<E> f32304a;

    /* renamed from: b */
    public final q<E> f32305b;

    /* renamed from: com.wbl.ad.yzz.gson.t.k.a$a */
    public static class C0726a implements r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type d2 = C$Gson$Types.d(type);
            return new a(eVar, eVar.a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(d2)), C$Gson$Types.e(d2));
        }
    }

    public a(com.wbl.ad.yzz.gson.e eVar, q<E> qVar, Class<E> cls) {
        this.f32305b = new m(eVar, qVar, cls);
        this.f32304a = cls;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public Object a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (aVar.t() == JsonToken.NULL) {
            aVar.q();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.i()) {
            arrayList.add(this.f32305b.a(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f32304a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public void a(com.wbl.ad.yzz.gson.v.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.k();
            return;
        }
        bVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f32305b.a(bVar, Array.get(obj, i2));
        }
        bVar.e();
    }
}
