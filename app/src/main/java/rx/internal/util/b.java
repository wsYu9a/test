package rx.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.k.o;

/* loaded from: classes5.dex */
public final class b<E> implements rx.h {

    /* renamed from: a */
    private static final rx.internal.util.c<b<?>> f36764a = new a();

    /* renamed from: b */
    static int f36765b;

    /* renamed from: c */
    static final int f36766c;

    /* renamed from: d */
    private final C0884b<E> f36767d;

    /* renamed from: e */
    private final c f36768e;

    /* renamed from: f */
    final AtomicInteger f36769f;

    /* renamed from: g */
    final AtomicInteger f36770g;

    static class a extends rx.internal.util.c<b<?>> {
        a() {
        }

        @Override // rx.internal.util.c
        /* renamed from: g */
        public b<?> c() {
            return new b<>(null);
        }
    }

    static {
        f36765b = 256;
        if (d.b()) {
            f36765b = 8;
        }
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                f36765b = Integer.parseInt(property);
            } catch (Exception e2) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f36766c = f36765b;
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    private int d(o<? super E, Boolean> oVar, int i2, int i3) {
        C0884b<E> c0884b;
        int i4;
        int i5 = this.f36769f.get();
        C0884b<E> c0884b2 = this.f36767d;
        int i6 = f36766c;
        if (i2 >= i6) {
            C0884b<E> e2 = e(i2);
            i4 = i2;
            i2 %= i6;
            c0884b = e2;
        } else {
            c0884b = c0884b2;
            i4 = i2;
        }
        loop0: while (c0884b != null) {
            while (i2 < f36766c) {
                if (i4 >= i5 || i4 >= i3) {
                    break loop0;
                }
                a.a aVar = (Object) ((C0884b) c0884b).f36771a.get(i2);
                if (aVar != null && !oVar.call(aVar).booleanValue()) {
                    return i4;
                }
                i2++;
                i4++;
            }
            c0884b = (C0884b) ((C0884b) c0884b).f36772b.get();
            i2 = 0;
        }
        return i4;
    }

    private C0884b<E> e(int i2) {
        int i3 = f36766c;
        if (i2 < i3) {
            return this.f36767d;
        }
        int i4 = i2 / i3;
        C0884b<E> c0884b = this.f36767d;
        for (int i5 = 0; i5 < i4; i5++) {
            c0884b = c0884b.c();
        }
        return c0884b;
    }

    private synchronized int f() {
        int andIncrement;
        int g2 = g();
        if (g2 >= 0) {
            int i2 = f36766c;
            if (g2 < i2) {
                andIncrement = this.f36768e.a(g2, -1);
            } else {
                andIncrement = h(g2).a(g2 % i2, -1);
            }
            if (andIncrement == this.f36769f.get()) {
                this.f36769f.getAndIncrement();
            }
        } else {
            andIncrement = this.f36769f.getAndIncrement();
        }
        return andIncrement;
    }

    private synchronized int g() {
        int i2;
        int i3;
        do {
            i2 = this.f36770g.get();
            if (i2 <= 0) {
                return -1;
            }
            i3 = i2 - 1;
        } while (!this.f36770g.compareAndSet(i2, i3));
        return i3;
    }

    private c h(int i2) {
        int i3 = f36766c;
        if (i2 < i3) {
            return this.f36768e;
        }
        int i4 = i2 / i3;
        c cVar = this.f36768e;
        for (int i5 = 0; i5 < i4; i5++) {
            cVar = cVar.b();
        }
        return cVar;
    }

    public static final <T> b<T> i() {
        return (b) f36764a.b();
    }

    private synchronized void j(int i2) {
        int andIncrement = this.f36770g.getAndIncrement();
        int i3 = f36766c;
        if (andIncrement < i3) {
            this.f36768e.c(andIncrement, i2);
        } else {
            h(andIncrement).c(andIncrement % i3, i2);
        }
    }

    public int a(E e2) {
        int f2 = f();
        int i2 = f36766c;
        if (f2 < i2) {
            ((C0884b) this.f36767d).f36771a.set(f2, e2);
            return f2;
        }
        ((C0884b) e(f2)).f36771a.set(f2 % i2, e2);
        return f2;
    }

    public int b(o<? super E, Boolean> oVar) {
        return c(oVar, 0);
    }

    public int c(o<? super E, Boolean> oVar, int i2) {
        int d2 = d(oVar, i2, this.f36769f.get());
        if (i2 > 0 && d2 == this.f36769f.get()) {
            return d(oVar, 0, i2);
        }
        if (d2 == this.f36769f.get()) {
            return 0;
        }
        return d2;
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return false;
    }

    public void k() {
        int i2 = this.f36769f.get();
        int i3 = 0;
        loop0: for (C0884b<E> c0884b = this.f36767d; c0884b != null; c0884b = (C0884b) ((C0884b) c0884b).f36772b.get()) {
            int i4 = 0;
            while (i4 < f36766c) {
                if (i3 >= i2) {
                    break loop0;
                }
                ((C0884b) c0884b).f36771a.set(i4, null);
                i4++;
                i3++;
            }
        }
        this.f36769f.set(0);
        this.f36770g.set(0);
        f36764a.e(this);
    }

    public E l(int i2) {
        E e2;
        int i3 = f36766c;
        if (i2 < i3) {
            e2 = (E) ((C0884b) this.f36767d).f36771a.getAndSet(i2, null);
        } else {
            e2 = (E) ((C0884b) e(i2)).f36771a.getAndSet(i2 % i3, null);
        }
        j(i2);
        return e2;
    }

    @Override // rx.h
    public void unsubscribe() {
        k();
    }

    private b() {
        this.f36767d = new C0884b<>(null);
        this.f36768e = new c(null);
        this.f36769f = new AtomicInteger();
        this.f36770g = new AtomicInteger();
    }

    /* renamed from: rx.internal.util.b$b */
    private static class C0884b<E> {

        /* renamed from: a */
        private final AtomicReferenceArray<E> f36771a;

        /* renamed from: b */
        private final AtomicReference<C0884b<E>> f36772b;

        private C0884b() {
            this.f36771a = new AtomicReferenceArray<>(b.f36766c);
            this.f36772b = new AtomicReference<>();
        }

        C0884b<E> c() {
            if (this.f36772b.get() != null) {
                return this.f36772b.get();
            }
            C0884b<E> c0884b = new C0884b<>();
            return this.f36772b.compareAndSet(null, c0884b) ? c0884b : this.f36772b.get();
        }

        /* synthetic */ C0884b(a aVar) {
            this();
        }
    }

    private static class c {

        /* renamed from: a */
        private final AtomicIntegerArray f36773a;

        /* renamed from: b */
        private final AtomicReference<c> f36774b;

        private c() {
            this.f36773a = new AtomicIntegerArray(b.f36766c);
            this.f36774b = new AtomicReference<>();
        }

        public int a(int i2, int i3) {
            return this.f36773a.getAndSet(i2, i3);
        }

        c b() {
            if (this.f36774b.get() != null) {
                return this.f36774b.get();
            }
            c cVar = new c();
            return this.f36774b.compareAndSet(null, cVar) ? cVar : this.f36774b.get();
        }

        public void c(int i2, int i3) {
            this.f36773a.set(i2, i3);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }
}
