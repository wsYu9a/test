package ak;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import wj.o;

/* loaded from: classes5.dex */
public final class b<E> implements qj.h {

    /* renamed from: f */
    public static final ak.c<b<?>> f226f = new a();

    /* renamed from: g */
    public static int f227g;

    /* renamed from: h */
    public static final int f228h;

    /* renamed from: b */
    public final C0004b<E> f229b;

    /* renamed from: c */
    public final c f230c;

    /* renamed from: d */
    public final AtomicInteger f231d;

    /* renamed from: e */
    public final AtomicInteger f232e;

    public static class a extends ak.c<b<?>> {
        @Override // ak.c
        /* renamed from: g */
        public b<?> c() {
            return new b<>(null);
        }
    }

    static {
        f227g = 256;
        if (d.b()) {
            f227g = 8;
        }
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                f227g = Integer.parseInt(property);
            } catch (Exception e10) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e10.getMessage());
            }
        }
        f228h = f227g;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static final <T> b<T> i() {
        return (b) f226f.b();
    }

    public int a(E e10) {
        int f10 = f();
        int i10 = f228h;
        if (f10 < i10) {
            this.f229b.f233a.set(f10, e10);
            return f10;
        }
        e(f10).f233a.set(f10 % i10, e10);
        return f10;
    }

    public int b(o<? super E, Boolean> oVar) {
        return c(oVar, 0);
    }

    public int c(o<? super E, Boolean> oVar, int i10) {
        int d10 = d(oVar, i10, this.f231d.get());
        if (i10 > 0 && d10 == this.f231d.get()) {
            return d(oVar, 0, i10);
        }
        if (d10 == this.f231d.get()) {
            return 0;
        }
        return d10;
    }

    public final int d(o<? super E, Boolean> oVar, int i10, int i11) {
        C0004b<E> c0004b;
        int i12;
        int i13 = this.f231d.get();
        C0004b<E> c0004b2 = this.f229b;
        int i14 = f228h;
        if (i10 >= i14) {
            C0004b<E> e10 = e(i10);
            i12 = i10;
            i10 %= i14;
            c0004b = e10;
        } else {
            c0004b = c0004b2;
            i12 = i10;
        }
        loop0: while (c0004b != null) {
            while (i10 < f228h) {
                if (i12 >= i13 || i12 >= i11) {
                    break loop0;
                }
                defpackage.a aVar = (Object) c0004b.f233a.get(i10);
                if (aVar != null && !oVar.call(aVar).booleanValue()) {
                    return i12;
                }
                i10++;
                i12++;
            }
            c0004b = (C0004b) c0004b.f234b.get();
            i10 = 0;
        }
        return i12;
    }

    public final C0004b<E> e(int i10) {
        int i11 = f228h;
        if (i10 < i11) {
            return this.f229b;
        }
        int i12 = i10 / i11;
        C0004b<E> c0004b = this.f229b;
        for (int i13 = 0; i13 < i12; i13++) {
            c0004b = c0004b.c();
        }
        return c0004b;
    }

    public final synchronized int f() {
        int andIncrement;
        try {
            int g10 = g();
            if (g10 >= 0) {
                int i10 = f228h;
                if (g10 < i10) {
                    andIncrement = this.f230c.a(g10, -1);
                } else {
                    andIncrement = h(g10).a(g10 % i10, -1);
                }
                if (andIncrement == this.f231d.get()) {
                    this.f231d.getAndIncrement();
                }
            } else {
                andIncrement = this.f231d.getAndIncrement();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return andIncrement;
    }

    public final synchronized int g() {
        int i10;
        int i11;
        do {
            i10 = this.f232e.get();
            if (i10 <= 0) {
                return -1;
            }
            i11 = i10 - 1;
        } while (!this.f232e.compareAndSet(i10, i11));
        return i11;
    }

    public final c h(int i10) {
        int i11 = f228h;
        if (i10 < i11) {
            return this.f230c;
        }
        int i12 = i10 / i11;
        c cVar = this.f230c;
        for (int i13 = 0; i13 < i12; i13++) {
            cVar = cVar.b();
        }
        return cVar;
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return false;
    }

    public final synchronized void j(int i10) {
        try {
            int andIncrement = this.f232e.getAndIncrement();
            int i11 = f228h;
            if (andIncrement < i11) {
                this.f230c.c(andIncrement, i10);
            } else {
                h(andIncrement).c(andIncrement % i11, i10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void k() {
        int i10 = this.f231d.get();
        int i11 = 0;
        loop0: for (C0004b<E> c0004b = this.f229b; c0004b != null; c0004b = (C0004b) c0004b.f234b.get()) {
            int i12 = 0;
            while (i12 < f228h) {
                if (i11 >= i10) {
                    break loop0;
                }
                c0004b.f233a.set(i12, null);
                i12++;
                i11++;
            }
        }
        this.f231d.set(0);
        this.f232e.set(0);
        f226f.e(this);
    }

    public E l(int i10) {
        E e10;
        int i11 = f228h;
        if (i10 < i11) {
            e10 = (E) this.f229b.f233a.getAndSet(i10, null);
        } else {
            e10 = (E) e(i10).f233a.getAndSet(i10 % i11, null);
        }
        j(i10);
        return e10;
    }

    @Override // qj.h
    public void unsubscribe() {
        k();
    }

    public b() {
        this.f229b = new C0004b<>(null);
        this.f230c = new c(null);
        this.f231d = new AtomicInteger();
        this.f232e = new AtomicInteger();
    }

    /* renamed from: ak.b$b */
    public static class C0004b<E> {

        /* renamed from: a */
        public final AtomicReferenceArray<E> f233a;

        /* renamed from: b */
        public final AtomicReference<C0004b<E>> f234b;

        public C0004b() {
            this.f233a = new AtomicReferenceArray<>(b.f228h);
            this.f234b = new AtomicReference<>();
        }

        public C0004b<E> c() {
            if (this.f234b.get() != null) {
                return this.f234b.get();
            }
            C0004b<E> c0004b = new C0004b<>();
            return k0.e.a(this.f234b, null, c0004b) ? c0004b : this.f234b.get();
        }

        public /* synthetic */ C0004b(a aVar) {
            this();
        }
    }

    public static class c {

        /* renamed from: a */
        public final AtomicIntegerArray f235a;

        /* renamed from: b */
        public final AtomicReference<c> f236b;

        public c() {
            this.f235a = new AtomicIntegerArray(b.f228h);
            this.f236b = new AtomicReference<>();
        }

        public int a(int i10, int i11) {
            return this.f235a.getAndSet(i10, i11);
        }

        public c b() {
            if (this.f236b.get() != null) {
                return this.f236b.get();
            }
            c cVar = new c();
            return k0.e.a(this.f236b, null, cVar) ? cVar : this.f236b.get();
        }

        public void c(int i10, int i11) {
            this.f235a.set(i10, i11);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
