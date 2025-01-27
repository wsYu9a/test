package ik;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.h;

/* loaded from: classes5.dex */
public final class d implements h {

    /* renamed from: d */
    public static final b f27035d = new b(false, 0);

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater<d, b> f27036e = AtomicReferenceFieldUpdater.newUpdater(d.class, b.class, "c");

    /* renamed from: b */
    public final h f27037b;

    /* renamed from: c */
    public volatile b f27038c = f27035d;

    public static final class a implements h {

        /* renamed from: d */
        public static final AtomicIntegerFieldUpdater<a> f27039d = AtomicIntegerFieldUpdater.newUpdater(a.class, "c");

        /* renamed from: b */
        public final d f27040b;

        /* renamed from: c */
        public volatile int f27041c;

        public a(d dVar) {
            this.f27040b = dVar;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f27041c != 0;
        }

        @Override // qj.h
        public void unsubscribe() {
            if (f27039d.compareAndSet(this, 0, 1)) {
                this.f27040b.b();
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        public final boolean f27042a;

        /* renamed from: b */
        public final int f27043b;

        public b(boolean z10, int i10) {
            this.f27042a = z10;
            this.f27043b = i10;
        }

        public b a() {
            return new b(this.f27042a, this.f27043b + 1);
        }

        public b b() {
            return new b(this.f27042a, this.f27043b - 1);
        }

        public b c() {
            return new b(true, this.f27043b);
        }
    }

    public d(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("s");
        }
        this.f27037b = hVar;
    }

    public h a() {
        b bVar;
        do {
            bVar = this.f27038c;
            if (bVar.f27042a) {
                return f.e();
            }
        } while (!k.a.a(f27036e, this, bVar, bVar.a()));
        return new a(this);
    }

    public void b() {
        b bVar;
        b b10;
        do {
            bVar = this.f27038c;
            b10 = bVar.b();
        } while (!k.a.a(f27036e, this, bVar, b10));
        c(b10);
    }

    public final void c(b bVar) {
        if (bVar.f27042a && bVar.f27043b == 0) {
            this.f27037b.unsubscribe();
        }
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f27038c.f27042a;
    }

    @Override // qj.h
    public void unsubscribe() {
        b bVar;
        b c10;
        do {
            bVar = this.f27038c;
            if (bVar.f27042a) {
                return;
            } else {
                c10 = bVar.c();
            }
        } while (!k.a.a(f27036e, this, bVar, c10));
        c(c10);
    }
}
