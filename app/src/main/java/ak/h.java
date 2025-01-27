package ak;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.h;
import wj.o;

/* loaded from: classes5.dex */
public final class h<T extends qj.h> implements qj.h {

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater<h> f268d = AtomicIntegerFieldUpdater.newUpdater(h.class, "c");

    /* renamed from: e */
    public static final o<qj.h, Boolean> f269e = new a();

    /* renamed from: b */
    public volatile b<T> f270b = b.i();

    /* renamed from: c */
    public volatile int f271c = 0;

    public static class a implements o<qj.h, Boolean> {
        @Override // wj.o
        public Boolean call(qj.h hVar) {
            hVar.unsubscribe();
            return Boolean.TRUE;
        }
    }

    public static void f(b<? extends qj.h> bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b(f269e);
    }

    public synchronized int a(T t10) {
        if (this.f271c != 1 && this.f270b != null) {
            int a10 = this.f270b.a(t10);
            if (this.f271c == 1) {
                t10.unsubscribe();
            }
            return a10;
        }
        t10.unsubscribe();
        return -1;
    }

    public int b(o<T, Boolean> oVar) {
        return c(oVar, 0);
    }

    public synchronized int c(o<T, Boolean> oVar, int i10) {
        if (this.f271c != 1 && this.f270b != null) {
            return this.f270b.c(oVar, i10);
        }
        return 0;
    }

    public void d(int i10) {
        T l10;
        if (this.f271c == 1 || this.f270b == null || i10 < 0 || (l10 = this.f270b.l(i10)) == null) {
            return;
        }
        l10.unsubscribe();
    }

    public void e(int i10) {
        if (this.f271c == 1 || this.f270b == null || i10 < 0) {
            return;
        }
        this.f270b.l(i10);
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f271c == 1;
    }

    @Override // qj.h
    public void unsubscribe() {
        if (!f268d.compareAndSet(this, 0, 1) || this.f270b == null) {
            return;
        }
        f(this.f270b);
        b<T> bVar = this.f270b;
        this.f270b = null;
        bVar.unsubscribe();
    }
}
