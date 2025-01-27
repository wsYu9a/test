package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.a;

/* loaded from: classes5.dex */
public final class i<T> implements a.m0<T> {

    /* renamed from: a */
    final rx.observables.b<? extends T> f36113a;

    /* renamed from: b */
    final int f36114b;

    /* renamed from: c */
    final rx.k.b<? super rx.h> f36115c;

    /* renamed from: d */
    final AtomicInteger f36116d;

    public i(rx.observables.b<? extends T> bVar, int i2, rx.k.b<? super rx.h> bVar2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.f36113a = bVar;
        this.f36114b = i2;
        this.f36115c = bVar2;
        this.f36116d = new AtomicInteger();
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        this.f36113a.T4(rx.l.e.f(gVar));
        if (this.f36116d.incrementAndGet() == this.f36114b) {
            this.f36113a.A5(this.f36115c);
        }
    }
}
