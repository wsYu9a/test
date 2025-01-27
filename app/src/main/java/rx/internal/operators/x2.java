package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class x2<T, U, V> implements a.n0<rx.a<T>, T> {

    /* renamed from: a */
    final rx.a<? extends U> f36619a;

    /* renamed from: b */
    final rx.k.o<? super U, ? extends rx.a<? extends V>> f36620b;

    class a extends rx.g<U> {

        /* renamed from: f */
        final /* synthetic */ c f36621f;

        a(c cVar) {
            this.f36621f = cVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36621f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36621f.onError(th);
        }

        @Override // rx.b
        public void onNext(U u) {
            this.f36621f.g(u);
        }
    }

    static final class b<T> {

        /* renamed from: a */
        final rx.b<T> f36623a;

        /* renamed from: b */
        final rx.a<T> f36624b;

        public b(rx.b<T> bVar, rx.a<T> aVar) {
            this.f36623a = new rx.l.c(bVar);
            this.f36624b = aVar;
        }
    }

    final class c extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36625f;

        /* renamed from: g */
        final rx.p.b f36626g;

        /* renamed from: h */
        final Object f36627h = new Object();

        /* renamed from: i */
        final List<b<T>> f36628i = new LinkedList();

        /* renamed from: j */
        boolean f36629j;

        class a extends rx.g<V> {

            /* renamed from: f */
            boolean f36630f = true;

            /* renamed from: g */
            final /* synthetic */ b f36631g;

            a(b bVar) {
                this.f36631g = bVar;
            }

            @Override // rx.b
            public void onCompleted() {
                if (this.f36630f) {
                    this.f36630f = false;
                    c.this.i(this.f36631g);
                    c.this.f36626g.d(this);
                }
            }

            @Override // rx.b
            public void onError(Throwable th) {
            }

            @Override // rx.b
            public void onNext(V v) {
                onCompleted();
            }
        }

        public c(rx.g<? super rx.a<T>> gVar, rx.p.b bVar) {
            this.f36625f = new rx.l.d(gVar);
            this.f36626g = bVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        void g(U u) {
            b<T> h2 = h();
            synchronized (this.f36627h) {
                if (this.f36629j) {
                    return;
                }
                this.f36628i.add(h2);
                this.f36625f.onNext(h2.f36624b);
                try {
                    rx.a<? extends V> call = x2.this.f36620b.call(u);
                    a aVar = new a(h2);
                    this.f36626g.a(aVar);
                    call.T4(aVar);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        b<T> h() {
            g G5 = g.G5();
            return new b<>(G5, G5);
        }

        void i(b<T> bVar) {
            boolean z;
            synchronized (this.f36627h) {
                if (this.f36629j) {
                    return;
                }
                Iterator<b<T>> it = this.f36628i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == bVar) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    bVar.f36623a.onCompleted();
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                synchronized (this.f36627h) {
                    if (this.f36629j) {
                        return;
                    }
                    this.f36629j = true;
                    ArrayList arrayList = new ArrayList(this.f36628i);
                    this.f36628i.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f36623a.onCompleted();
                    }
                    this.f36625f.onCompleted();
                }
            } finally {
                this.f36626g.unsubscribe();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            try {
                synchronized (this.f36627h) {
                    if (this.f36629j) {
                        return;
                    }
                    this.f36629j = true;
                    ArrayList arrayList = new ArrayList(this.f36628i);
                    this.f36628i.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f36623a.onError(th);
                    }
                    this.f36625f.onError(th);
                }
            } finally {
                this.f36626g.unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this.f36627h) {
                if (this.f36629j) {
                    return;
                }
                Iterator it = new ArrayList(this.f36628i).iterator();
                while (it.hasNext()) {
                    ((b) it.next()).f36623a.onNext(t);
                }
            }
        }
    }

    public x2(rx.a<? extends U> aVar, rx.k.o<? super U, ? extends rx.a<? extends V>> oVar) {
        this.f36619a = aVar;
        this.f36620b = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<T>> gVar) {
        rx.p.b bVar = new rx.p.b();
        gVar.b(bVar);
        c cVar = new c(gVar, bVar);
        a aVar = new a(cVar);
        bVar.a(cVar);
        bVar.a(aVar);
        this.f36619a.T4(aVar);
        return cVar;
    }
}
