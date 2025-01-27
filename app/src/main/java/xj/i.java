package xj;

import java.util.concurrent.atomic.AtomicInteger;
import qj.a;

/* loaded from: classes5.dex */
public final class i<T> implements a.m0<T> {

    /* renamed from: b */
    public final dk.b<? extends T> f32293b;

    /* renamed from: c */
    public final int f32294c;

    /* renamed from: d */
    public final wj.b<? super qj.h> f32295d;

    /* renamed from: e */
    public final AtomicInteger f32296e;

    public i(dk.b<? extends T> bVar, int i10, wj.b<? super qj.h> bVar2) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.f32293b = bVar;
        this.f32294c = i10;
        this.f32295d = bVar2;
        this.f32296e = new AtomicInteger();
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        this.f32293b.T4(ek.e.f(gVar));
        if (this.f32296e.incrementAndGet() == this.f32294c) {
            this.f32293b.A5(this.f32295d);
        }
    }
}
