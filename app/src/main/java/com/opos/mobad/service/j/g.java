package com.opos.mobad.service.j;

/* loaded from: classes4.dex */
public class g<T> implements d<T> {

    /* renamed from: a */
    private d<T> f23715a;

    /* renamed from: b */
    private boolean f23716b = false;

    public g(d<T> dVar) {
        this.f23715a = dVar;
    }

    @Override // com.opos.mobad.service.j.d
    public boolean a(T t) {
        if (this.f23716b) {
            return false;
        }
        boolean a2 = this.f23715a.a(t);
        this.f23716b = a2;
        return a2;
    }
}
