package rx;

import rx.internal.util.i;

@rx.j.b
/* loaded from: classes5.dex */
public abstract class f<T> implements h {

    /* renamed from: a */
    private final i f35762a = new i();

    public final void a(h hVar) {
        this.f35762a.a(hVar);
    }

    public abstract void b(Throwable th);

    public abstract void c(T t);

    @Override // rx.h
    public final boolean isUnsubscribed() {
        return this.f35762a.isUnsubscribed();
    }

    @Override // rx.h
    public final void unsubscribe() {
        this.f35762a.unsubscribe();
    }
}
