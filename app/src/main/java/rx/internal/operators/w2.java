package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class w2<T> implements a.n0<rx.a<T>, T> {

    /* renamed from: a */
    final int f36583a;

    /* renamed from: b */
    final int f36584b;

    static final class a<T> {

        /* renamed from: a */
        final rx.b<T> f36585a;

        /* renamed from: b */
        final rx.a<T> f36586b;

        /* renamed from: c */
        int f36587c;

        public a(rx.b<T> bVar, rx.a<T> aVar) {
            this.f36585a = bVar;
            this.f36586b = aVar;
        }
    }

    final class b extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36588f;

        /* renamed from: g */
        int f36589g;

        /* renamed from: h */
        g<T> f36590h;

        /* renamed from: i */
        volatile boolean f36591i = true;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                if (b.this.f36591i) {
                    b.this.unsubscribe();
                }
            }
        }

        /* renamed from: rx.internal.operators.w2$b$b */
        class C0874b implements rx.c {
            C0874b() {
            }

            @Override // rx.c
            public void request(long j2) {
                if (j2 > 0) {
                    b bVar = b.this;
                    int i2 = w2.this.f36583a;
                    long j3 = i2 * j2;
                    if ((j3 >>> 31) != 0 && j3 / j2 != i2) {
                        j3 = Long.MAX_VALUE;
                    }
                    bVar.h(j3);
                }
            }
        }

        public b(rx.g<? super rx.a<T>> gVar) {
            this.f36588f = gVar;
        }

        void g() {
            this.f36588f.b(rx.p.f.a(new a()));
            this.f36588f.f(new C0874b());
        }

        void h(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            g<T> gVar = this.f36590h;
            if (gVar != null) {
                gVar.onCompleted();
            }
            this.f36588f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            g<T> gVar = this.f36590h;
            if (gVar != null) {
                gVar.onError(th);
            }
            this.f36588f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36590h == null) {
                this.f36591i = false;
                g<T> G5 = g.G5();
                this.f36590h = G5;
                this.f36588f.onNext(G5);
            }
            this.f36590h.onNext(t);
            int i2 = this.f36589g + 1;
            this.f36589g = i2;
            if (i2 % w2.this.f36583a == 0) {
                this.f36590h.onCompleted();
                this.f36590h = null;
                this.f36591i = true;
                if (this.f36588f.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }
    }

    final class c extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36595f;

        /* renamed from: g */
        int f36596g;

        /* renamed from: h */
        final List<a<T>> f36597h = new LinkedList();

        /* renamed from: i */
        volatile boolean f36598i = true;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                if (c.this.f36598i) {
                    c.this.unsubscribe();
                }
            }
        }

        class b implements rx.c {
            b() {
            }

            @Override // rx.c
            public void request(long j2) {
                if (j2 > 0) {
                    c cVar = c.this;
                    int i2 = w2.this.f36583a;
                    long j3 = i2 * j2;
                    if ((j3 >>> 31) != 0 && j3 / j2 != i2) {
                        j3 = Long.MAX_VALUE;
                    }
                    cVar.i(j3);
                }
            }
        }

        public c(rx.g<? super rx.a<T>> gVar) {
            this.f36595f = gVar;
        }

        a<T> g() {
            g G5 = g.G5();
            return new a<>(G5, G5);
        }

        void h() {
            this.f36595f.b(rx.p.f.a(new a()));
            this.f36595f.f(new b());
        }

        void i(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            ArrayList arrayList = new ArrayList(this.f36597h);
            this.f36597h.clear();
            this.f36598i = true;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).f36585a.onCompleted();
            }
            this.f36595f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f36597h);
            this.f36597h.clear();
            this.f36598i = true;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).f36585a.onError(th);
            }
            this.f36595f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            int i2 = this.f36596g;
            this.f36596g = i2 + 1;
            if (i2 % w2.this.f36584b == 0 && !this.f36595f.isUnsubscribed()) {
                if (this.f36597h.isEmpty()) {
                    this.f36598i = false;
                }
                a<T> g2 = g();
                this.f36597h.add(g2);
                this.f36595f.onNext(g2.f36586b);
            }
            Iterator<a<T>> it = this.f36597h.iterator();
            while (it.hasNext()) {
                a<T> next = it.next();
                next.f36585a.onNext(t);
                int i3 = next.f36587c + 1;
                next.f36587c = i3;
                if (i3 == w2.this.f36583a) {
                    it.remove();
                    next.f36585a.onCompleted();
                }
            }
            if (this.f36597h.isEmpty()) {
                this.f36598i = true;
                if (this.f36595f.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }
    }

    public w2(int i2, int i3) {
        this.f36583a = i2;
        this.f36584b = i3;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<T>> gVar) {
        if (this.f36584b == this.f36583a) {
            b bVar = new b(gVar);
            bVar.g();
            return bVar;
        }
        c cVar = new c(gVar);
        cVar.h();
        return cVar;
    }
}
