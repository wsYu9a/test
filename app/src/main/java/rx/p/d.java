package rx.p;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.h;

/* loaded from: classes5.dex */
public final class d implements h {

    /* renamed from: a */
    static final b f37106a = new b(false, 0);

    /* renamed from: b */
    static final AtomicReferenceFieldUpdater<d, b> f37107b = AtomicReferenceFieldUpdater.newUpdater(d.class, b.class, "d");

    /* renamed from: c */
    private final h f37108c;

    /* renamed from: d */
    volatile b f37109d = f37106a;

    private static final class a implements h {

        /* renamed from: a */
        static final AtomicIntegerFieldUpdater<a> f37110a = AtomicIntegerFieldUpdater.newUpdater(a.class, "c");

        /* renamed from: b */
        final d f37111b;

        /* renamed from: c */
        volatile int f37112c;

        public a(d dVar) {
            this.f37111b = dVar;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f37112c != 0;
        }

        @Override // rx.h
        public void unsubscribe() {
            if (f37110a.compareAndSet(this, 0, 1)) {
                this.f37111b.b();
            }
        }
    }

    private static final class b {

        /* renamed from: a */
        final boolean f37113a;

        /* renamed from: b */
        final int f37114b;

        b(boolean z, int i2) {
            this.f37113a = z;
            this.f37114b = i2;
        }

        b a() {
            return new b(this.f37113a, this.f37114b + 1);
        }

        b b() {
            return new b(this.f37113a, this.f37114b - 1);
        }

        b c() {
            return new b(true, this.f37114b);
        }
    }

    public d(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.f37108c = hVar;
    }

    private void c(b bVar) {
        if (bVar.f37113a && bVar.f37114b == 0) {
            this.f37108c.unsubscribe();
        }
    }

    public h a() {
        b bVar;
        do {
            bVar = this.f37109d;
            if (bVar.f37113a) {
                return f.e();
            }
        } while (!f37107b.compareAndSet(this, bVar, bVar.a()));
        return new a(this);
    }

    void b() {
        b bVar;
        b b2;
        do {
            bVar = this.f37109d;
            b2 = bVar.b();
        } while (!f37107b.compareAndSet(this, bVar, b2));
        c(b2);
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f37109d.f37113a;
    }

    @Override // rx.h
    public void unsubscribe() {
        b bVar;
        b c2;
        do {
            bVar = this.f37109d;
            if (bVar.f37113a) {
                return;
            } else {
                c2 = bVar.c();
            }
        } while (!f37107b.compareAndSet(this, bVar, c2));
        c(c2);
    }
}
