package xj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;

/* loaded from: classes5.dex */
public final class h<T> implements a.m0<T> {

    /* renamed from: b */
    public final Iterable<? extends qj.a<? extends T>> f32253b;

    /* renamed from: c */
    public final d<T> f32254c;

    /* renamed from: d */
    public final AtomicReference<c<T>> f32255d;

    public class a implements wj.a {
        public a() {
        }

        @Override // wj.a
        public void call() {
            c<T> cVar = h.this.f32255d.get();
            if (cVar != null) {
                cVar.unsubscribe();
            }
            h.k(h.this.f32254c.f32262b);
        }
    }

    public class b implements qj.c {
        public b() {
        }

        @Override // qj.c
        public void request(long j10) {
            c<T> cVar = h.this.f32255d.get();
            if (cVar != null) {
                cVar.i(j10);
                return;
            }
            for (c<T> cVar2 : h.this.f32254c.f32262b) {
                if (!cVar2.isUnsubscribed()) {
                    if (h.this.f32255d.get() == cVar2) {
                        cVar2.i(j10);
                        return;
                    }
                    cVar2.i(j10);
                }
            }
        }
    }

    public static final class c<T> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super T> f32258g;

        /* renamed from: h */
        public final d<T> f32259h;

        /* renamed from: i */
        public boolean f32260i;

        public /* synthetic */ c(long j10, qj.g gVar, d dVar, a aVar) {
            this(j10, gVar, dVar);
        }

        public final void i(long j10) {
            e(j10);
        }

        public final boolean h() {
            if (this.f32260i) {
                return true;
            }
            if (this.f32259h.f32261a.get() == this) {
                this.f32260i = true;
                return true;
            }
            if (!k0.e.a(this.f32259h.f32261a, null, this)) {
                this.f32259h.a();
                return false;
            }
            this.f32259h.b(this);
            this.f32260i = true;
            return true;
        }

        @Override // qj.b
        public void onCompleted() {
            if (h()) {
                this.f32258g.onCompleted();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (h()) {
                this.f32258g.onError(th2);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (h()) {
                this.f32258g.onNext(t10);
            }
        }

        public c(long j10, qj.g<? super T> gVar, d<T> dVar) {
            this.f32258g = gVar;
            this.f32259h = dVar;
            e(j10);
        }
    }

    public h(Iterable<? extends qj.a<? extends T>> iterable) {
        d<T> dVar = new d<>(null);
        this.f32254c = dVar;
        this.f32255d = dVar.f32261a;
        this.f32253b = iterable;
    }

    public static <T> a.m0<T> b(Iterable<? extends qj.a<? extends T>> iterable) {
        return new h(iterable);
    }

    public static <T> a.m0<T> c(qj.a<? extends T> aVar, qj.a<? extends T> aVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        return b(arrayList);
    }

    public static <T> a.m0<T> d(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        return b(arrayList);
    }

    public static <T> a.m0<T> e(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        return b(arrayList);
    }

    public static <T> a.m0<T> f(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4, qj.a<? extends T> aVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        return b(arrayList);
    }

    public static <T> a.m0<T> g(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4, qj.a<? extends T> aVar5, qj.a<? extends T> aVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        return b(arrayList);
    }

    public static <T> a.m0<T> h(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4, qj.a<? extends T> aVar5, qj.a<? extends T> aVar6, qj.a<? extends T> aVar7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        arrayList.add(aVar7);
        return b(arrayList);
    }

    public static <T> a.m0<T> i(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4, qj.a<? extends T> aVar5, qj.a<? extends T> aVar6, qj.a<? extends T> aVar7, qj.a<? extends T> aVar8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        arrayList.add(aVar7);
        arrayList.add(aVar8);
        return b(arrayList);
    }

    public static <T> a.m0<T> j(qj.a<? extends T> aVar, qj.a<? extends T> aVar2, qj.a<? extends T> aVar3, qj.a<? extends T> aVar4, qj.a<? extends T> aVar5, qj.a<? extends T> aVar6, qj.a<? extends T> aVar7, qj.a<? extends T> aVar8, qj.a<? extends T> aVar9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        arrayList.add(aVar7);
        arrayList.add(aVar8);
        arrayList.add(aVar9);
        return b(arrayList);
    }

    public static <T> void k(Collection<c<T>> collection) {
        if (collection.isEmpty()) {
            return;
        }
        Iterator<c<T>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().unsubscribe();
        }
        collection.clear();
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        gVar.b(ik.f.a(new a()));
        for (qj.a<? extends T> aVar : this.f32253b) {
            if (gVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar = new c<>(0L, gVar, this.f32254c, null);
            this.f32254c.f32262b.add(cVar);
            c<T> cVar2 = this.f32255d.get();
            if (cVar2 != null) {
                this.f32254c.b(cVar2);
                return;
            }
            aVar.T4(cVar);
        }
        if (gVar.isUnsubscribed()) {
            k(this.f32254c.f32262b);
        }
        gVar.f(new b());
    }

    public static class d<T> {

        /* renamed from: a */
        public final AtomicReference<c<T>> f32261a;

        /* renamed from: b */
        public final Collection<c<T>> f32262b;

        public d() {
            this.f32261a = new AtomicReference<>();
            this.f32262b = new ConcurrentLinkedQueue();
        }

        public void a() {
            c<T> cVar = this.f32261a.get();
            if (cVar != null) {
                b(cVar);
            }
        }

        public void b(c<T> cVar) {
            for (c<T> cVar2 : this.f32262b) {
                if (cVar2 != cVar) {
                    cVar2.unsubscribe();
                }
            }
            this.f32262b.clear();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
