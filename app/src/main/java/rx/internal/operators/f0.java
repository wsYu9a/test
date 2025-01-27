package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class f0<T> implements a.n0<List<T>, T> {

    /* renamed from: a */
    final long f36025a;

    /* renamed from: b */
    final long f36026b;

    /* renamed from: c */
    final TimeUnit f36027c;

    /* renamed from: d */
    final int f36028d;

    /* renamed from: e */
    final rx.d f36029e;

    final class a extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super List<T>> f36030f;

        /* renamed from: g */
        final d.a f36031g;

        /* renamed from: h */
        List<T> f36032h = new ArrayList();

        /* renamed from: i */
        boolean f36033i;

        /* renamed from: rx.internal.operators.f0$a$a */
        class C0852a implements rx.k.a {
            C0852a() {
            }

            @Override // rx.k.a
            public void call() {
                a.this.g();
            }
        }

        public a(rx.g<? super List<T>> gVar, d.a aVar) {
            this.f36030f = gVar;
            this.f36031g = aVar;
        }

        void g() {
            synchronized (this) {
                if (this.f36033i) {
                    return;
                }
                List<T> list = this.f36032h;
                this.f36032h = new ArrayList();
                try {
                    this.f36030f.onNext(list);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        void h() {
            d.a aVar = this.f36031g;
            C0852a c0852a = new C0852a();
            f0 f0Var = f0.this;
            long j2 = f0Var.f36025a;
            aVar.f(c0852a, j2, j2, f0Var.f36027c);
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                this.f36031g.unsubscribe();
                synchronized (this) {
                    if (this.f36033i) {
                        return;
                    }
                    this.f36033i = true;
                    List<T> list = this.f36032h;
                    this.f36032h = null;
                    this.f36030f.onNext(list);
                    this.f36030f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f36030f.onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f36033i) {
                    return;
                }
                this.f36033i = true;
                this.f36032h = null;
                this.f36030f.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (this.f36033i) {
                    return;
                }
                this.f36032h.add(t);
                if (this.f36032h.size() == f0.this.f36028d) {
                    list = this.f36032h;
                    this.f36032h = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.f36030f.onNext(list);
                }
            }
        }
    }

    final class b extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super List<T>> f36036f;

        /* renamed from: g */
        final d.a f36037g;

        /* renamed from: h */
        final List<List<T>> f36038h = new LinkedList();

        /* renamed from: i */
        boolean f36039i;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                b.this.i();
            }
        }

        /* renamed from: rx.internal.operators.f0$b$b */
        class C0853b implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ List f36042a;

            C0853b(List list) {
                this.f36042a = list;
            }

            @Override // rx.k.a
            public void call() {
                b.this.g(this.f36042a);
            }
        }

        public b(rx.g<? super List<T>> gVar, d.a aVar) {
            this.f36036f = gVar;
            this.f36037g = aVar;
        }

        void g(List<T> list) {
            boolean z;
            synchronized (this) {
                if (this.f36039i) {
                    return;
                }
                Iterator<List<T>> it = this.f36038h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == list) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    try {
                        this.f36036f.onNext(list);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        void h() {
            d.a aVar = this.f36037g;
            a aVar2 = new a();
            f0 f0Var = f0.this;
            long j2 = f0Var.f36026b;
            aVar.f(aVar2, j2, j2, f0Var.f36027c);
        }

        void i() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f36039i) {
                    return;
                }
                this.f36038h.add(arrayList);
                d.a aVar = this.f36037g;
                C0853b c0853b = new C0853b(arrayList);
                f0 f0Var = f0.this;
                aVar.e(c0853b, f0Var.f36025a, f0Var.f36027c);
            }
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f36039i) {
                        return;
                    }
                    this.f36039i = true;
                    LinkedList linkedList = new LinkedList(this.f36038h);
                    this.f36038h.clear();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.f36036f.onNext((List) it.next());
                    }
                    this.f36036f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f36036f.onError(th);
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f36039i) {
                    return;
                }
                this.f36039i = true;
                this.f36038h.clear();
                this.f36036f.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this) {
                if (this.f36039i) {
                    return;
                }
                Iterator<List<T>> it = this.f36038h.iterator();
                LinkedList linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t);
                    if (next.size() == f0.this.f36028d) {
                        it.remove();
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(next);
                    }
                }
                if (linkedList != null) {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        this.f36036f.onNext((List) it2.next());
                    }
                }
            }
        }
    }

    public f0(long j2, long j3, TimeUnit timeUnit, int i2, rx.d dVar) {
        this.f36025a = j2;
        this.f36026b = j3;
        this.f36027c = timeUnit;
        this.f36028d = i2;
        this.f36029e = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super List<T>> gVar) {
        d.a a2 = this.f36029e.a();
        rx.l.d dVar = new rx.l.d(gVar);
        if (this.f36025a == this.f36026b) {
            a aVar = new a(dVar, a2);
            aVar.b(a2);
            gVar.b(aVar);
            aVar.h();
            return aVar;
        }
        b bVar = new b(dVar, a2);
        bVar.b(a2);
        gVar.b(bVar);
        bVar.i();
        bVar.h();
        return bVar;
    }
}
