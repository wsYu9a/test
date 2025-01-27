package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class y2<T> implements a.n0<rx.a<T>, T> {

    /* renamed from: a */
    static final Object f36656a = new Object();

    /* renamed from: b */
    static final NotificationLite<Object> f36657b = NotificationLite.f();

    /* renamed from: c */
    final long f36658c;

    /* renamed from: d */
    final long f36659d;

    /* renamed from: e */
    final TimeUnit f36660e;

    /* renamed from: f */
    final rx.d f36661f;

    /* renamed from: g */
    final int f36662g;

    static final class a<T> {

        /* renamed from: a */
        final rx.b<T> f36663a;

        /* renamed from: b */
        final rx.a<T> f36664b;

        /* renamed from: c */
        int f36665c;

        public a(rx.b<T> bVar, rx.a<T> aVar) {
            this.f36663a = new rx.l.c(bVar);
            this.f36664b = aVar;
        }
    }

    final class b extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36666f;

        /* renamed from: g */
        final d.a f36667g;

        /* renamed from: i */
        List<Object> f36669i;

        /* renamed from: j */
        boolean f36670j;

        /* renamed from: h */
        final Object f36668h = new Object();
        volatile d<T> k = d.c();

        class a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ y2 f36671a;

            a(y2 y2Var) {
                this.f36671a = y2Var;
            }

            @Override // rx.k.a
            public void call() {
                if (b.this.k.f36683b == null) {
                    b.this.unsubscribe();
                }
            }
        }

        /* renamed from: rx.internal.operators.y2$b$b */
        class C0880b implements rx.k.a {
            C0880b() {
            }

            @Override // rx.k.a
            public void call() {
                b.this.k();
            }
        }

        public b(rx.g<? super rx.a<T>> gVar, d.a aVar) {
            this.f36666f = new rx.l.d(gVar);
            this.f36667g = aVar;
            gVar.b(rx.p.f.a(new a(y2.this)));
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        void g() {
            rx.b<T> bVar = this.k.f36683b;
            this.k = this.k.a();
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f36666f.onCompleted();
            unsubscribe();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
        
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean h(java.util.List<java.lang.Object> r6) {
            /*
                r5 = this;
                r0 = 1
                if (r6 != 0) goto L4
                return r0
            L4:
                java.util.Iterator r6 = r6.iterator()
            L8:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L3f
                java.lang.Object r1 = r6.next()
                java.lang.Object r2 = rx.internal.operators.y2.f36656a
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r5.l()
                if (r1 != 0) goto L8
                return r3
            L1e:
                rx.internal.operators.NotificationLite<java.lang.Object> r2 = rx.internal.operators.y2.f36657b
                boolean r4 = r2.h(r1)
                if (r4 == 0) goto L2e
                java.lang.Throwable r6 = r2.d(r1)
                r5.j(r6)
                goto L3f
            L2e:
                boolean r2 = r2.g(r1)
                if (r2 == 0) goto L38
                r5.g()
                goto L3f
            L38:
                boolean r1 = r5.i(r1)
                if (r1 != 0) goto L8
                return r3
            L3f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.y2.b.h(java.util.List):boolean");
        }

        boolean i(T t) {
            d<T> d2;
            d<T> dVar = this.k;
            if (dVar.f36683b == null) {
                if (!l()) {
                    return false;
                }
                dVar = this.k;
            }
            dVar.f36683b.onNext(t);
            if (dVar.f36685d == y2.this.f36662g - 1) {
                dVar.f36683b.onCompleted();
                d2 = dVar.a();
            } else {
                d2 = dVar.d();
            }
            this.k = d2;
            return true;
        }

        void j(Throwable th) {
            rx.b<T> bVar = this.k.f36683b;
            this.k = this.k.a();
            if (bVar != null) {
                bVar.onError(th);
            }
            this.f36666f.onError(th);
            unsubscribe();
        }

        void k() {
            boolean z;
            List<Object> list;
            synchronized (this.f36668h) {
                if (this.f36670j) {
                    if (this.f36669i == null) {
                        this.f36669i = new ArrayList();
                    }
                    this.f36669i.add(y2.f36656a);
                    return;
                }
                boolean z2 = true;
                this.f36670j = true;
                try {
                    if (!l()) {
                        synchronized (this.f36668h) {
                            this.f36670j = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f36668h) {
                                try {
                                    list = this.f36669i;
                                    if (list == null) {
                                        this.f36670j = false;
                                        return;
                                    }
                                    this.f36669i = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        z = z2;
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f36668h) {
                                                this.f36670j = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (h(list));
                    synchronized (this.f36668h) {
                        this.f36670j = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }

        boolean l() {
            rx.b<T> bVar = this.k.f36683b;
            if (bVar != null) {
                bVar.onCompleted();
            }
            if (this.f36666f.isUnsubscribed()) {
                this.k = this.k.a();
                unsubscribe();
                return false;
            }
            g G5 = g.G5();
            this.k = this.k.b(G5, G5);
            this.f36666f.onNext(G5);
            return true;
        }

        void m() {
            d.a aVar = this.f36667g;
            C0880b c0880b = new C0880b();
            y2 y2Var = y2.this;
            aVar.f(c0880b, 0L, y2Var.f36658c, y2Var.f36660e);
        }

        @Override // rx.b
        public void onCompleted() {
            synchronized (this.f36668h) {
                if (this.f36670j) {
                    if (this.f36669i == null) {
                        this.f36669i = new ArrayList();
                    }
                    this.f36669i.add(y2.f36657b.b());
                    return;
                }
                List<Object> list = this.f36669i;
                this.f36669i = null;
                this.f36670j = true;
                try {
                    h(list);
                    g();
                } catch (Throwable th) {
                    j(th);
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this.f36668h) {
                if (this.f36670j) {
                    this.f36669i = Collections.singletonList(y2.f36657b.c(th));
                    return;
                }
                this.f36669i = null;
                this.f36670j = true;
                j(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            List<Object> list;
            synchronized (this.f36668h) {
                if (this.f36670j) {
                    if (this.f36669i == null) {
                        this.f36669i = new ArrayList();
                    }
                    this.f36669i.add(t);
                    return;
                }
                boolean z = true;
                this.f36670j = true;
                try {
                    if (!i(t)) {
                        synchronized (this.f36668h) {
                            this.f36670j = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f36668h) {
                                try {
                                    list = this.f36669i;
                                    if (list == null) {
                                        this.f36670j = false;
                                        return;
                                    }
                                    this.f36669i = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f36668h) {
                                                this.f36670j = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (h(list));
                    synchronized (this.f36668h) {
                        this.f36670j = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }
    }

    final class c extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36674f;

        /* renamed from: g */
        final d.a f36675g;

        /* renamed from: h */
        final Object f36676h;

        /* renamed from: i */
        final List<a<T>> f36677i;

        /* renamed from: j */
        boolean f36678j;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                c.this.i();
            }
        }

        class b implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ a f36680a;

            b(a aVar) {
                this.f36680a = aVar;
            }

            @Override // rx.k.a
            public void call() {
                c.this.j(this.f36680a);
            }
        }

        public c(rx.g<? super rx.a<T>> gVar, d.a aVar) {
            super(gVar);
            this.f36674f = gVar;
            this.f36675g = aVar;
            this.f36676h = new Object();
            this.f36677i = new LinkedList();
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        a<T> g() {
            g G5 = g.G5();
            return new a<>(G5, G5);
        }

        void h() {
            d.a aVar = this.f36675g;
            a aVar2 = new a();
            y2 y2Var = y2.this;
            long j2 = y2Var.f36659d;
            aVar.f(aVar2, j2, j2, y2Var.f36660e);
        }

        void i() {
            a<T> g2 = g();
            synchronized (this.f36676h) {
                if (this.f36678j) {
                    return;
                }
                this.f36677i.add(g2);
                try {
                    this.f36674f.onNext(g2.f36664b);
                    d.a aVar = this.f36675g;
                    b bVar = new b(g2);
                    y2 y2Var = y2.this;
                    aVar.e(bVar, y2Var.f36658c, y2Var.f36660e);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        void j(a<T> aVar) {
            boolean z;
            synchronized (this.f36676h) {
                if (this.f36678j) {
                    return;
                }
                Iterator<a<T>> it = this.f36677i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == aVar) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    aVar.f36663a.onCompleted();
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            synchronized (this.f36676h) {
                if (this.f36678j) {
                    return;
                }
                this.f36678j = true;
                ArrayList arrayList = new ArrayList(this.f36677i);
                this.f36677i.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).f36663a.onCompleted();
                }
                this.f36674f.onCompleted();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this.f36676h) {
                if (this.f36678j) {
                    return;
                }
                this.f36678j = true;
                ArrayList arrayList = new ArrayList(this.f36677i);
                this.f36677i.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).f36663a.onError(th);
                }
                this.f36674f.onError(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this.f36676h) {
                if (this.f36678j) {
                    return;
                }
                ArrayList<a> arrayList = new ArrayList(this.f36677i);
                Iterator<a<T>> it = this.f36677i.iterator();
                while (it.hasNext()) {
                    a<T> next = it.next();
                    int i2 = next.f36665c + 1;
                    next.f36665c = i2;
                    if (i2 == y2.this.f36662g) {
                        it.remove();
                    }
                }
                for (a aVar : arrayList) {
                    aVar.f36663a.onNext(t);
                    if (aVar.f36665c == y2.this.f36662g) {
                        aVar.f36663a.onCompleted();
                    }
                }
            }
        }
    }

    static final class d<T> {

        /* renamed from: a */
        static final d<Object> f36682a = new d<>(null, null, 0);

        /* renamed from: b */
        final rx.b<T> f36683b;

        /* renamed from: c */
        final rx.a<T> f36684c;

        /* renamed from: d */
        final int f36685d;

        public d(rx.b<T> bVar, rx.a<T> aVar, int i2) {
            this.f36683b = bVar;
            this.f36684c = aVar;
            this.f36685d = i2;
        }

        public static <T> d<T> c() {
            return (d<T>) f36682a;
        }

        public d<T> a() {
            return c();
        }

        public d<T> b(rx.b<T> bVar, rx.a<T> aVar) {
            return new d<>(bVar, aVar, 0);
        }

        public d<T> d() {
            return new d<>(this.f36683b, this.f36684c, this.f36685d + 1);
        }
    }

    public y2(long j2, long j3, TimeUnit timeUnit, int i2, rx.d dVar) {
        this.f36658c = j2;
        this.f36659d = j3;
        this.f36660e = timeUnit;
        this.f36662g = i2;
        this.f36661f = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<T>> gVar) {
        d.a a2 = this.f36661f.a();
        if (this.f36658c == this.f36659d) {
            b bVar = new b(gVar, a2);
            bVar.b(a2);
            bVar.m();
            return bVar;
        }
        c cVar = new c(gVar, a2);
        cVar.b(a2);
        cVar.i();
        cVar.h();
        return cVar;
    }
}
