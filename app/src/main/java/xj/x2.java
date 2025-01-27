package xj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qj.a;

/* loaded from: classes5.dex */
public final class x2<T, U, V> implements a.n0<qj.a<T>, T> {

    /* renamed from: b */
    public final qj.a<? extends U> f32831b;

    /* renamed from: c */
    public final wj.o<? super U, ? extends qj.a<? extends V>> f32832c;

    public class a extends qj.g<U> {

        /* renamed from: g */
        public final /* synthetic */ c f32833g;

        public a(c cVar) {
            this.f32833g = cVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32833g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32833g.onError(th2);
        }

        @Override // qj.b
        public void onNext(U u10) {
            this.f32833g.g(u10);
        }
    }

    public static final class b<T> {

        /* renamed from: a */
        public final qj.b<T> f32835a;

        /* renamed from: b */
        public final qj.a<T> f32836b;

        public b(qj.b<T> bVar, qj.a<T> aVar) {
            this.f32835a = new ek.c(bVar);
            this.f32836b = aVar;
        }
    }

    public x2(qj.a<? extends U> aVar, wj.o<? super U, ? extends qj.a<? extends V>> oVar) {
        this.f32831b = aVar;
        this.f32832c = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<T>> gVar) {
        ik.b bVar = new ik.b();
        gVar.b(bVar);
        c cVar = new c(gVar, bVar);
        a aVar = new a(cVar);
        bVar.a(cVar);
        bVar.a(aVar);
        this.f32831b.T4(aVar);
        return cVar;
    }

    public final class c extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32837g;

        /* renamed from: h */
        public final ik.b f32838h;

        /* renamed from: i */
        public final Object f32839i = new Object();

        /* renamed from: j */
        public final List<b<T>> f32840j = new LinkedList();

        /* renamed from: k */
        public boolean f32841k;

        public c(qj.g<? super qj.a<T>> gVar, ik.b bVar) {
            this.f32837g = new ek.d(gVar);
            this.f32838h = bVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public void g(U u10) {
            b<T> h10 = h();
            synchronized (this.f32839i) {
                try {
                    if (this.f32841k) {
                        return;
                    }
                    this.f32840j.add(h10);
                    this.f32837g.onNext(h10.f32836b);
                    try {
                        qj.a<? extends V> call = x2.this.f32832c.call(u10);
                        a aVar = new a(h10);
                        this.f32838h.a(aVar);
                        call.T4(aVar);
                    } catch (Throwable th2) {
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        public b<T> h() {
            g G5 = g.G5();
            return new b<>(G5, G5);
        }

        public void i(b<T> bVar) {
            boolean z10;
            synchronized (this.f32839i) {
                try {
                    if (this.f32841k) {
                        return;
                    }
                    Iterator<b<T>> it = this.f32840j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = false;
                            break;
                        } else if (it.next() == bVar) {
                            it.remove();
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        bVar.f32835a.onCompleted();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                synchronized (this.f32839i) {
                    if (this.f32841k) {
                        this.f32838h.unsubscribe();
                        return;
                    }
                    this.f32841k = true;
                    ArrayList arrayList = new ArrayList(this.f32840j);
                    this.f32840j.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f32835a.onCompleted();
                    }
                    this.f32837g.onCompleted();
                    this.f32838h.unsubscribe();
                }
            } catch (Throwable th2) {
                this.f32838h.unsubscribe();
                throw th2;
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                synchronized (this.f32839i) {
                    if (this.f32841k) {
                        this.f32838h.unsubscribe();
                        return;
                    }
                    this.f32841k = true;
                    ArrayList arrayList = new ArrayList(this.f32840j);
                    this.f32840j.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f32835a.onError(th2);
                    }
                    this.f32837g.onError(th2);
                    this.f32838h.unsubscribe();
                }
            } catch (Throwable th3) {
                this.f32838h.unsubscribe();
                throw th3;
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            synchronized (this.f32839i) {
                try {
                    if (this.f32841k) {
                        return;
                    }
                    Iterator it = new ArrayList(this.f32840j).iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f32835a.onNext(t10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public class a extends qj.g<V> {

            /* renamed from: g */
            public boolean f32843g = true;

            /* renamed from: h */
            public final /* synthetic */ b f32844h;

            public a(b bVar) {
                this.f32844h = bVar;
            }

            @Override // qj.b
            public void onCompleted() {
                if (this.f32843g) {
                    this.f32843g = false;
                    c.this.i(this.f32844h);
                    c.this.f32838h.d(this);
                }
            }

            @Override // qj.b
            public void onNext(V v10) {
                onCompleted();
            }

            @Override // qj.b
            public void onError(Throwable th2) {
            }
        }
    }
}
