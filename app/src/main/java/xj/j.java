package xj;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.a;

/* loaded from: classes5.dex */
public final class j<T> implements a.m0<T> {

    /* renamed from: e */
    public static final AtomicIntegerFieldUpdater<j> f32317e = AtomicIntegerFieldUpdater.newUpdater(j.class, "d");

    /* renamed from: b */
    public final qj.a<? extends T> f32318b;

    /* renamed from: c */
    public final hk.f<? super T, ? extends T> f32319c;

    /* renamed from: d */
    public volatile int f32320d;

    public j(qj.a<? extends T> aVar) {
        this(aVar, hk.d.G5());
    }

    public j(qj.a<? extends T> aVar, int i10) {
        this(aVar, hk.d.H5(i10));
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        if (f32317e.compareAndSet(this, 0, 1)) {
            this.f32318b.J3(this.f32319c);
        }
        this.f32319c.T4(gVar);
    }

    public j(qj.a<? extends T> aVar, hk.f<? super T, ? extends T> fVar) {
        this.f32318b = aVar;
        this.f32319c = fVar;
    }
}
