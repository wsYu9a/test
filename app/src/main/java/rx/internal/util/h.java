package rx.internal.util;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.h;
import rx.k.o;

/* loaded from: classes5.dex */
public final class h<T extends rx.h> implements rx.h {

    /* renamed from: a */
    private static final AtomicIntegerFieldUpdater<h> f36806a = AtomicIntegerFieldUpdater.newUpdater(h.class, "d");

    /* renamed from: b */
    private static final o<rx.h, Boolean> f36807b = new a();

    /* renamed from: c */
    private volatile b<T> f36808c = b.i();

    /* renamed from: d */
    private volatile int f36809d = 0;

    static class a implements o<rx.h, Boolean> {
        a() {
        }

        @Override // rx.k.o
        public Boolean call(rx.h hVar) {
            hVar.unsubscribe();
            return Boolean.TRUE;
        }
    }

    private static void f(b<? extends rx.h> bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b(f36807b);
    }

    public synchronized int a(T t) {
        if (this.f36809d != 1 && this.f36808c != null) {
            int a2 = this.f36808c.a(t);
            if (this.f36809d == 1) {
                t.unsubscribe();
            }
            return a2;
        }
        t.unsubscribe();
        return -1;
    }

    public int b(o<T, Boolean> oVar) {
        return c(oVar, 0);
    }

    public synchronized int c(o<T, Boolean> oVar, int i2) {
        if (this.f36809d != 1 && this.f36808c != null) {
            return this.f36808c.c(oVar, i2);
        }
        return 0;
    }

    public void d(int i2) {
        T l;
        if (this.f36809d == 1 || this.f36808c == null || i2 < 0 || (l = this.f36808c.l(i2)) == null) {
            return;
        }
        l.unsubscribe();
    }

    public void e(int i2) {
        if (this.f36809d == 1 || this.f36808c == null || i2 < 0) {
            return;
        }
        this.f36808c.l(i2);
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f36809d == 1;
    }

    @Override // rx.h
    public void unsubscribe() {
        if (!f36806a.compareAndSet(this, 0, 1) || this.f36808c == null) {
            return;
        }
        f(this.f36808c);
        b<T> bVar = this.f36808c;
        this.f36808c = null;
        bVar.unsubscribe();
    }
}
