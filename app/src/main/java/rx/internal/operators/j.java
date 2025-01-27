package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.a;

/* loaded from: classes5.dex */
public final class j<T> implements a.m0<T> {

    /* renamed from: a */
    static final AtomicIntegerFieldUpdater<j> f36137a = AtomicIntegerFieldUpdater.newUpdater(j.class, "d");

    /* renamed from: b */
    protected final rx.a<? extends T> f36138b;

    /* renamed from: c */
    protected final rx.o.f<? super T, ? extends T> f36139c;

    /* renamed from: d */
    volatile int f36140d;

    public j(rx.a<? extends T> aVar) {
        this(aVar, rx.o.d.G5());
    }

    public j(rx.a<? extends T> aVar, int i2) {
        this(aVar, rx.o.d.H5(i2));
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        if (f36137a.compareAndSet(this, 0, 1)) {
            this.f36138b.J3(this.f36139c);
        }
        this.f36139c.T4(gVar);
    }

    j(rx.a<? extends T> aVar, rx.o.f<? super T, ? extends T> fVar) {
        this.f36138b = aVar;
        this.f36139c = fVar;
    }
}
