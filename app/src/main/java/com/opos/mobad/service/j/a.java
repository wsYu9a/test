package com.opos.mobad.service.j;

import com.opos.mobad.service.j.c;

/* loaded from: classes4.dex */
public class a<T, F extends c<T>> implements b<T> {

    /* renamed from: a */
    private F f23710a;

    /* renamed from: b */
    private d<F> f23711b;

    /* renamed from: c */
    private b<F> f23712c;

    public a(F f2, d<F> dVar, b<F> bVar) {
        this.f23710a = f2;
        this.f23711b = dVar;
        this.f23712c = bVar;
    }

    private void a(F f2) {
        this.f23712c.a(f2);
        f2.a();
    }

    @Override // com.opos.mobad.service.j.b
    public void a(T t) {
        this.f23710a.a(t);
        if (this.f23711b.a(this.f23710a)) {
            a((a<T, F>) this.f23710a);
        }
    }
}
