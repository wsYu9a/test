package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.o;
import com.wbl.ad.yzz.gson.p;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class l<T> extends q<T> {

    /* renamed from: a */
    public final p<T> f32341a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.gson.j<T> f32342b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.gson.e f32343c;

    /* renamed from: d */
    public final com.wbl.ad.yzz.gson.u.a<T> f32344d;

    /* renamed from: e */
    public final r f32345e;

    /* renamed from: f */
    public final l<T>.b f32346f = new b();

    /* renamed from: g */
    public q<T> f32347g;

    public final class b implements o, com.wbl.ad.yzz.gson.i {
        public b(l lVar) {
        }

        public /* synthetic */ b(l lVar, a aVar) {
            this(lVar);
        }
    }

    public l(p<T> pVar, com.wbl.ad.yzz.gson.j<T> jVar, com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar, r rVar) {
        this.f32341a = pVar;
        this.f32342b = jVar;
        this.f32343c = eVar;
        this.f32344d = aVar;
        this.f32345e = rVar;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
        if (this.f32342b == null) {
            return b().a(aVar);
        }
        com.wbl.ad.yzz.gson.k a2 = com.wbl.ad.yzz.gson.t.i.a(aVar);
        if (a2.e()) {
            return null;
        }
        return this.f32342b.a(a2, this.f32344d.getType(), this.f32346f);
    }

    public final q<T> b() {
        q<T> qVar = this.f32347g;
        if (qVar != null) {
            return qVar;
        }
        q<T> a2 = this.f32343c.a(this.f32345e, this.f32344d);
        this.f32347g = a2;
        return a2;
    }

    @Override // com.wbl.ad.yzz.gson.q
    public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
        p<T> pVar = this.f32341a;
        if (pVar == null) {
            b().a(bVar, t);
        } else if (t == null) {
            bVar.k();
        } else {
            com.wbl.ad.yzz.gson.t.i.a(pVar.a(t, this.f32344d.getType(), this.f32346f), bVar);
        }
    }
}
