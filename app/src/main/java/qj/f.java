package qj;

import ak.i;

@uj.b
/* loaded from: classes4.dex */
public abstract class f<T> implements h {

    /* renamed from: b */
    public final i f30196b = new i();

    public final void a(h hVar) {
        this.f30196b.a(hVar);
    }

    public abstract void b(Throwable th2);

    public abstract void c(T t10);

    @Override // qj.h
    public final boolean isUnsubscribed() {
        return this.f30196b.isUnsubscribed();
    }

    @Override // qj.h
    public final void unsubscribe() {
        this.f30196b.unsubscribe();
    }
}
