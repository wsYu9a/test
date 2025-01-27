package xj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class y2<T> implements a.n0<qj.a<T>, T> {

    /* renamed from: g */
    public static final Object f32869g = new Object();

    /* renamed from: h */
    public static final NotificationLite<Object> f32870h = NotificationLite.f();

    /* renamed from: b */
    public final long f32871b;

    /* renamed from: c */
    public final long f32872c;

    /* renamed from: d */
    public final TimeUnit f32873d;

    /* renamed from: e */
    public final qj.d f32874e;

    /* renamed from: f */
    public final int f32875f;

    public static final class a<T> {

        /* renamed from: a */
        public final qj.b<T> f32876a;

        /* renamed from: b */
        public final qj.a<T> f32877b;

        /* renamed from: c */
        public int f32878c;

        public a(qj.b<T> bVar, qj.a<T> aVar) {
            this.f32876a = new ek.c(bVar);
            this.f32877b = aVar;
        }
    }

    public final class b extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32879g;

        /* renamed from: h */
        public final d.a f32880h;

        /* renamed from: j */
        public List<Object> f32882j;

        /* renamed from: k */
        public boolean f32883k;

        /* renamed from: i */
        public final Object f32881i = new Object();

        /* renamed from: l */
        public volatile d<T> f32884l = d.c();

        public class a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ y2 f32886b;

            public a(y2 y2Var) {
                this.f32886b = y2Var;
            }

            @Override // wj.a
            public void call() {
                if (b.this.f32884l.f32899a == null) {
                    b.this.unsubscribe();
                }
            }
        }

        /* renamed from: xj.y2$b$b */
        public class C0844b implements wj.a {
            public C0844b() {
            }

            @Override // wj.a
            public void call() {
                b.this.k();
            }
        }

        public b(qj.g<? super qj.a<T>> gVar, d.a aVar) {
            this.f32879g = new ek.d(gVar);
            this.f32880h = aVar;
            gVar.b(ik.f.a(new a(y2.this)));
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public void g() {
            qj.b<T> bVar = this.f32884l.f32899a;
            this.f32884l = this.f32884l.a();
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f32879g.onCompleted();
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
        public boolean h(java.util.List<java.lang.Object> r6) {
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
                java.lang.Object r2 = xj.y2.f32869g
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r5.l()
                if (r1 != 0) goto L8
                return r3
            L1e:
                rx.internal.operators.NotificationLite<java.lang.Object> r2 = xj.y2.f32870h
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
            throw new UnsupportedOperationException("Method not decompiled: xj.y2.b.h(java.util.List):boolean");
        }

        public boolean i(T t10) {
            d<T> d10;
            d<T> dVar = this.f32884l;
            if (dVar.f32899a == null) {
                if (!l()) {
                    return false;
                }
                dVar = this.f32884l;
            }
            dVar.f32899a.onNext(t10);
            if (dVar.f32901c == y2.this.f32875f - 1) {
                dVar.f32899a.onCompleted();
                d10 = dVar.a();
            } else {
                d10 = dVar.d();
            }
            this.f32884l = d10;
            return true;
        }

        public void j(Throwable th2) {
            qj.b<T> bVar = this.f32884l.f32899a;
            this.f32884l = this.f32884l.a();
            if (bVar != null) {
                bVar.onError(th2);
            }
            this.f32879g.onError(th2);
            unsubscribe();
        }

        public void k() {
            boolean z10;
            List<Object> list;
            synchronized (this.f32881i) {
                try {
                    if (this.f32883k) {
                        if (this.f32882j == null) {
                            this.f32882j = new ArrayList();
                        }
                        this.f32882j.add(y2.f32869g);
                        return;
                    }
                    boolean z11 = true;
                    this.f32883k = true;
                    try {
                        if (!l()) {
                            synchronized (this.f32881i) {
                                this.f32883k = false;
                            }
                            return;
                        }
                        do {
                            try {
                                synchronized (this.f32881i) {
                                    try {
                                        list = this.f32882j;
                                        if (list == null) {
                                            this.f32883k = false;
                                            return;
                                        }
                                        this.f32882j = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                z10 = z11;
                                th = th4;
                                if (z10) {
                                    throw th;
                                }
                                synchronized (this.f32881i) {
                                    this.f32883k = false;
                                }
                                throw th;
                            }
                        } while (h(list));
                        synchronized (this.f32881i) {
                            this.f32883k = false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z10 = false;
                    }
                } finally {
                }
            }
        }

        public boolean l() {
            qj.b<T> bVar = this.f32884l.f32899a;
            if (bVar != null) {
                bVar.onCompleted();
            }
            if (this.f32879g.isUnsubscribed()) {
                this.f32884l = this.f32884l.a();
                unsubscribe();
                return false;
            }
            g G5 = g.G5();
            this.f32884l = this.f32884l.b(G5, G5);
            this.f32879g.onNext(G5);
            return true;
        }

        public void m() {
            d.a aVar = this.f32880h;
            C0844b c0844b = new C0844b();
            y2 y2Var = y2.this;
            aVar.d(c0844b, 0L, y2Var.f32871b, y2Var.f32873d);
        }

        @Override // qj.b
        public void onCompleted() {
            synchronized (this.f32881i) {
                try {
                    if (this.f32883k) {
                        if (this.f32882j == null) {
                            this.f32882j = new ArrayList();
                        }
                        this.f32882j.add(y2.f32870h.b());
                        return;
                    }
                    List<Object> list = this.f32882j;
                    this.f32882j = null;
                    this.f32883k = true;
                    try {
                        h(list);
                        g();
                    } catch (Throwable th2) {
                        j(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this.f32881i) {
                try {
                    if (this.f32883k) {
                        this.f32882j = Collections.singletonList(y2.f32870h.c(th2));
                        return;
                    }
                    this.f32882j = null;
                    this.f32883k = true;
                    j(th2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            List<Object> list;
            synchronized (this.f32881i) {
                try {
                    if (this.f32883k) {
                        if (this.f32882j == null) {
                            this.f32882j = new ArrayList();
                        }
                        this.f32882j.add(t10);
                        return;
                    }
                    boolean z10 = true;
                    this.f32883k = true;
                    try {
                        if (!i(t10)) {
                            synchronized (this.f32881i) {
                                this.f32883k = false;
                            }
                            return;
                        }
                        do {
                            try {
                                synchronized (this.f32881i) {
                                    try {
                                        list = this.f32882j;
                                        if (list == null) {
                                            this.f32883k = false;
                                            return;
                                        }
                                        this.f32882j = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z10 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (!z10) {
                                                synchronized (this.f32881i) {
                                                    this.f32883k = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } while (h(list));
                        synchronized (this.f32881i) {
                            this.f32883k = false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z10 = false;
                    }
                } finally {
                }
            }
        }
    }

    public final class c extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32889g;

        /* renamed from: h */
        public final d.a f32890h;

        /* renamed from: i */
        public final Object f32891i;

        /* renamed from: j */
        public final List<a<T>> f32892j;

        /* renamed from: k */
        public boolean f32893k;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                c.this.i();
            }
        }

        public class b implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ a f32896b;

            public b(a aVar) {
                this.f32896b = aVar;
            }

            @Override // wj.a
            public void call() {
                c.this.j(this.f32896b);
            }
        }

        public c(qj.g<? super qj.a<T>> gVar, d.a aVar) {
            super(gVar);
            this.f32889g = gVar;
            this.f32890h = aVar;
            this.f32891i = new Object();
            this.f32892j = new LinkedList();
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public a<T> g() {
            g G5 = g.G5();
            return new a<>(G5, G5);
        }

        public void h() {
            d.a aVar = this.f32890h;
            a aVar2 = new a();
            y2 y2Var = y2.this;
            long j10 = y2Var.f32872c;
            aVar.d(aVar2, j10, j10, y2Var.f32873d);
        }

        public void i() {
            a<T> g10 = g();
            synchronized (this.f32891i) {
                try {
                    if (this.f32893k) {
                        return;
                    }
                    this.f32892j.add(g10);
                    try {
                        this.f32889g.onNext(g10.f32877b);
                        d.a aVar = this.f32890h;
                        b bVar = new b(g10);
                        y2 y2Var = y2.this;
                        aVar.c(bVar, y2Var.f32871b, y2Var.f32873d);
                    } catch (Throwable th2) {
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public void j(a<T> aVar) {
            boolean z10;
            synchronized (this.f32891i) {
                try {
                    if (this.f32893k) {
                        return;
                    }
                    Iterator<a<T>> it = this.f32892j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = false;
                            break;
                        } else if (it.next() == aVar) {
                            it.remove();
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        aVar.f32876a.onCompleted();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            synchronized (this.f32891i) {
                try {
                    if (this.f32893k) {
                        return;
                    }
                    this.f32893k = true;
                    ArrayList arrayList = new ArrayList(this.f32892j);
                    this.f32892j.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).f32876a.onCompleted();
                    }
                    this.f32889g.onCompleted();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this.f32891i) {
                try {
                    if (this.f32893k) {
                        return;
                    }
                    this.f32893k = true;
                    ArrayList arrayList = new ArrayList(this.f32892j);
                    this.f32892j.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).f32876a.onError(th2);
                    }
                    this.f32889g.onError(th2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            synchronized (this.f32891i) {
                try {
                    if (this.f32893k) {
                        return;
                    }
                    ArrayList<a> arrayList = new ArrayList(this.f32892j);
                    Iterator<a<T>> it = this.f32892j.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i10 = next.f32878c + 1;
                        next.f32878c = i10;
                        if (i10 == y2.this.f32875f) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.f32876a.onNext(t10);
                        if (aVar.f32878c == y2.this.f32875f) {
                            aVar.f32876a.onCompleted();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static final class d<T> {

        /* renamed from: d */
        public static final d<Object> f32898d = new d<>(null, null, 0);

        /* renamed from: a */
        public final qj.b<T> f32899a;

        /* renamed from: b */
        public final qj.a<T> f32900b;

        /* renamed from: c */
        public final int f32901c;

        public d(qj.b<T> bVar, qj.a<T> aVar, int i10) {
            this.f32899a = bVar;
            this.f32900b = aVar;
            this.f32901c = i10;
        }

        public static <T> d<T> c() {
            return (d<T>) f32898d;
        }

        public d<T> a() {
            return c();
        }

        public d<T> b(qj.b<T> bVar, qj.a<T> aVar) {
            return new d<>(bVar, aVar, 0);
        }

        public d<T> d() {
            return new d<>(this.f32899a, this.f32900b, this.f32901c + 1);
        }
    }

    public y2(long j10, long j11, TimeUnit timeUnit, int i10, qj.d dVar) {
        this.f32871b = j10;
        this.f32872c = j11;
        this.f32873d = timeUnit;
        this.f32875f = i10;
        this.f32874e = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<T>> gVar) {
        d.a a10 = this.f32874e.a();
        if (this.f32871b == this.f32872c) {
            b bVar = new b(gVar, a10);
            bVar.b(a10);
            bVar.m();
            return bVar;
        }
        c cVar = new c(gVar, a10);
        cVar.b(a10);
        cVar.i();
        cVar.h();
        return cVar;
    }
}
