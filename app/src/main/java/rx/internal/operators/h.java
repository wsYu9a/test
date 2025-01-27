package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.a;

/* loaded from: classes5.dex */
public final class h<T> implements a.m0<T> {

    /* renamed from: a */
    final Iterable<? extends rx.a<? extends T>> f36078a;

    /* renamed from: b */
    final d<T> f36079b;

    /* renamed from: c */
    final AtomicReference<c<T>> f36080c;

    class a implements rx.k.a {
        a() {
        }

        @Override // rx.k.a
        public void call() {
            c<T> cVar = h.this.f36080c.get();
            if (cVar != null) {
                cVar.unsubscribe();
            }
            h.k(h.this.f36079b.f36087b);
        }
    }

    class b implements rx.c {
        b() {
        }

        @Override // rx.c
        public void request(long j2) {
            c<T> cVar = h.this.f36080c.get();
            if (cVar != null) {
                cVar.i(j2);
                return;
            }
            for (c<T> cVar2 : h.this.f36079b.f36087b) {
                if (!cVar2.isUnsubscribed()) {
                    if (h.this.f36080c.get() == cVar2) {
                        cVar2.i(j2);
                        return;
                    }
                    cVar2.i(j2);
                }
            }
        }
    }

    private static final class c<T> extends rx.g<T> {

        /* renamed from: f */
        private final rx.g<? super T> f36083f;

        /* renamed from: g */
        private final d<T> f36084g;

        /* renamed from: h */
        private boolean f36085h;

        /* synthetic */ c(long j2, rx.g gVar, d dVar, a aVar) {
            this(j2, gVar, dVar);
        }

        private boolean h() {
            if (this.f36085h) {
                return true;
            }
            if (this.f36084g.f36086a.get() == this) {
                this.f36085h = true;
                return true;
            }
            if (!this.f36084g.f36086a.compareAndSet(null, this)) {
                this.f36084g.a();
                return false;
            }
            this.f36084g.b(this);
            this.f36085h = true;
            return true;
        }

        public final void i(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            if (h()) {
                this.f36083f.onCompleted();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (h()) {
                this.f36083f.onError(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (h()) {
                this.f36083f.onNext(t);
            }
        }

        private c(long j2, rx.g<? super T> gVar, d<T> dVar) {
            this.f36083f = gVar;
            this.f36084g = dVar;
            e(j2);
        }
    }

    private h(Iterable<? extends rx.a<? extends T>> iterable) {
        d<T> dVar = new d<>(null);
        this.f36079b = dVar;
        this.f36080c = dVar.f36086a;
        this.f36078a = iterable;
    }

    public static <T> a.m0<T> b(Iterable<? extends rx.a<? extends T>> iterable) {
        return new h(iterable);
    }

    public static <T> a.m0<T> c(rx.a<? extends T> aVar, rx.a<? extends T> aVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        return b(arrayList);
    }

    public static <T> a.m0<T> d(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        return b(arrayList);
    }

    public static <T> a.m0<T> e(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        return b(arrayList);
    }

    public static <T> a.m0<T> f(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4, rx.a<? extends T> aVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        return b(arrayList);
    }

    public static <T> a.m0<T> g(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4, rx.a<? extends T> aVar5, rx.a<? extends T> aVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        return b(arrayList);
    }

    public static <T> a.m0<T> h(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4, rx.a<? extends T> aVar5, rx.a<? extends T> aVar6, rx.a<? extends T> aVar7) {
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

    public static <T> a.m0<T> i(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4, rx.a<? extends T> aVar5, rx.a<? extends T> aVar6, rx.a<? extends T> aVar7, rx.a<? extends T> aVar8) {
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

    public static <T> a.m0<T> j(rx.a<? extends T> aVar, rx.a<? extends T> aVar2, rx.a<? extends T> aVar3, rx.a<? extends T> aVar4, rx.a<? extends T> aVar5, rx.a<? extends T> aVar6, rx.a<? extends T> aVar7, rx.a<? extends T> aVar8, rx.a<? extends T> aVar9) {
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

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        gVar.b(rx.p.f.a(new a()));
        for (rx.a<? extends T> aVar : this.f36078a) {
            if (gVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar = new c<>(0L, gVar, this.f36079b, null);
            this.f36079b.f36087b.add(cVar);
            c<T> cVar2 = this.f36080c.get();
            if (cVar2 != null) {
                this.f36079b.b(cVar2);
                return;
            }
            aVar.T4(cVar);
        }
        if (gVar.isUnsubscribed()) {
            k(this.f36079b.f36087b);
        }
        gVar.f(new b());
    }

    private static class d<T> {

        /* renamed from: a */
        final AtomicReference<c<T>> f36086a;

        /* renamed from: b */
        final Collection<c<T>> f36087b;

        private d() {
            this.f36086a = new AtomicReference<>();
            this.f36087b = new ConcurrentLinkedQueue();
        }

        public void a() {
            c<T> cVar = this.f36086a.get();
            if (cVar != null) {
                b(cVar);
            }
        }

        public void b(c<T> cVar) {
            for (c<T> cVar2 : this.f36087b) {
                if (cVar2 != cVar) {
                    cVar2.unsubscribe();
                }
            }
            this.f36087b.clear();
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
