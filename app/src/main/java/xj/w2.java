package xj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qj.a;

/* loaded from: classes5.dex */
public final class w2<T> implements a.n0<qj.a<T>, T> {

    /* renamed from: b */
    public final int f32795b;

    /* renamed from: c */
    public final int f32796c;

    public static final class a<T> {

        /* renamed from: a */
        public final qj.b<T> f32797a;

        /* renamed from: b */
        public final qj.a<T> f32798b;

        /* renamed from: c */
        public int f32799c;

        public a(qj.b<T> bVar, qj.a<T> aVar) {
            this.f32797a = bVar;
            this.f32798b = aVar;
        }
    }

    public final class b extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32800g;

        /* renamed from: h */
        public int f32801h;

        /* renamed from: i */
        public g<T> f32802i;

        /* renamed from: j */
        public volatile boolean f32803j = true;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                if (b.this.f32803j) {
                    b.this.unsubscribe();
                }
            }
        }

        /* renamed from: xj.w2$b$b */
        public class C0838b implements qj.c {
            public C0838b() {
            }

            @Override // qj.c
            public void request(long j10) {
                if (j10 > 0) {
                    b bVar = b.this;
                    int i10 = w2.this.f32795b;
                    long j11 = i10 * j10;
                    if ((j11 >>> 31) != 0 && j11 / j10 != i10) {
                        j11 = Long.MAX_VALUE;
                    }
                    bVar.h(j11);
                }
            }
        }

        public b(qj.g<? super qj.a<T>> gVar) {
            this.f32800g = gVar;
        }

        public void g() {
            this.f32800g.b(ik.f.a(new a()));
            this.f32800g.f(new C0838b());
        }

        public void h(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            g<T> gVar = this.f32802i;
            if (gVar != null) {
                gVar.onCompleted();
            }
            this.f32800g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            g<T> gVar = this.f32802i;
            if (gVar != null) {
                gVar.onError(th2);
            }
            this.f32800g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32802i == null) {
                this.f32803j = false;
                g<T> G5 = g.G5();
                this.f32802i = G5;
                this.f32800g.onNext(G5);
            }
            this.f32802i.onNext(t10);
            int i10 = this.f32801h + 1;
            this.f32801h = i10;
            if (i10 % w2.this.f32795b == 0) {
                this.f32802i.onCompleted();
                this.f32802i = null;
                this.f32803j = true;
                if (this.f32800g.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }
    }

    public final class c extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32807g;

        /* renamed from: h */
        public int f32808h;

        /* renamed from: i */
        public final List<a<T>> f32809i = new LinkedList();

        /* renamed from: j */
        public volatile boolean f32810j = true;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                if (c.this.f32810j) {
                    c.this.unsubscribe();
                }
            }
        }

        public class b implements qj.c {
            public b() {
            }

            @Override // qj.c
            public void request(long j10) {
                if (j10 > 0) {
                    c cVar = c.this;
                    int i10 = w2.this.f32795b;
                    long j11 = i10 * j10;
                    if ((j11 >>> 31) != 0 && j11 / j10 != i10) {
                        j11 = Long.MAX_VALUE;
                    }
                    cVar.i(j11);
                }
            }
        }

        public c(qj.g<? super qj.a<T>> gVar) {
            this.f32807g = gVar;
        }

        public a<T> g() {
            g G5 = g.G5();
            return new a<>(G5, G5);
        }

        public void h() {
            this.f32807g.b(ik.f.a(new a()));
            this.f32807g.f(new b());
        }

        public void i(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            ArrayList arrayList = new ArrayList(this.f32809i);
            this.f32809i.clear();
            this.f32810j = true;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).f32797a.onCompleted();
            }
            this.f32807g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            ArrayList arrayList = new ArrayList(this.f32809i);
            this.f32809i.clear();
            this.f32810j = true;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).f32797a.onError(th2);
            }
            this.f32807g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            int i10 = this.f32808h;
            this.f32808h = i10 + 1;
            if (i10 % w2.this.f32796c == 0 && !this.f32807g.isUnsubscribed()) {
                if (this.f32809i.isEmpty()) {
                    this.f32810j = false;
                }
                a<T> g10 = g();
                this.f32809i.add(g10);
                this.f32807g.onNext(g10.f32798b);
            }
            Iterator<a<T>> it = this.f32809i.iterator();
            while (it.hasNext()) {
                a<T> next = it.next();
                next.f32797a.onNext(t10);
                int i11 = next.f32799c + 1;
                next.f32799c = i11;
                if (i11 == w2.this.f32795b) {
                    it.remove();
                    next.f32797a.onCompleted();
                }
            }
            if (this.f32809i.isEmpty()) {
                this.f32810j = true;
                if (this.f32807g.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }
    }

    public w2(int i10, int i11) {
        this.f32795b = i10;
        this.f32796c = i11;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<T>> gVar) {
        if (this.f32796c == this.f32795b) {
            b bVar = new b(gVar);
            bVar.g();
            return bVar;
        }
        c cVar = new c(gVar);
        cVar.h();
        return cVar;
    }
}
