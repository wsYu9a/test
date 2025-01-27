package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.q;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes5.dex */
public final class m<T> extends q<T> {

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.e f32348a;

    /* renamed from: b */
    public final q<T> f32349b;

    /* renamed from: c */
    public final Type f32350c;

    public m(com.wbl.ad.yzz.gson.e eVar, q<T> qVar, Type type) {
        this.f32348a = eVar;
        this.f32349b = qVar;
        this.f32350c = type;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        return this.f32349b.a(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if ((r1 instanceof com.wbl.ad.yzz.gson.t.k.i.b) == false) goto L24;
     */
    @Override // com.wbl.ad.yzz.gson.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.wbl.ad.yzz.gson.v.b r4, T r5) throws java.io.IOException {
        /*
            r3 = this;
            com.wbl.ad.yzz.gson.q<T> r0 = r3.f32349b
            java.lang.reflect.Type r1 = r3.f32350c
            java.lang.reflect.Type r1 = r3.a(r1, r5)
            java.lang.reflect.Type r2 = r3.f32350c
            if (r1 == r2) goto L22
            com.wbl.ad.yzz.gson.e r0 = r3.f32348a
            com.wbl.ad.yzz.gson.u.a r1 = com.wbl.ad.yzz.gson.u.a.a(r1)
            com.wbl.ad.yzz.gson.q r0 = r0.a(r1)
            boolean r1 = r0 instanceof com.wbl.ad.yzz.gson.t.k.i.b
            if (r1 != 0) goto L1b
            goto L22
        L1b:
            com.wbl.ad.yzz.gson.q<T> r1 = r3.f32349b
            boolean r2 = r1 instanceof com.wbl.ad.yzz.gson.t.k.i.b
            if (r2 != 0) goto L22
            goto L23
        L22:
            r1 = r0
        L23:
            r1.a(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.t.k.m.a(com.wbl.ad.yzz.gson.v.b, java.lang.Object):void");
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
