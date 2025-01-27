package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.a;

/* loaded from: classes5.dex */
public final class a1<T, R> extends rx.observables.b<R> {

    /* renamed from: c */
    final rx.a<? extends T> f35856c;

    /* renamed from: d */
    final Object f35857d;

    /* renamed from: e */
    final rx.k.n<? extends rx.o.f<? super T, ? extends R>> f35858e;

    /* renamed from: f */
    final AtomicReference<rx.o.f<? super T, ? extends R>> f35859f;

    /* renamed from: g */
    final List<rx.g<? super R>> f35860g;

    /* renamed from: h */
    private rx.g<T> f35861h;

    /* renamed from: i */
    private rx.h f35862i;

    class a implements a.m0<R> {

        /* renamed from: a */
        final /* synthetic */ Object f35863a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f35864b;

        /* renamed from: c */
        final /* synthetic */ List f35865c;

        a(Object obj, AtomicReference atomicReference, List list) {
            this.f35863a = obj;
            this.f35864b = atomicReference;
            this.f35865c = list;
        }

        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            synchronized (this.f35863a) {
                if (this.f35864b.get() == null) {
                    this.f35865c.add(gVar);
                } else {
                    ((rx.o.f) this.f35864b.get()).T4(gVar);
                }
            }
        }
    }

    class b implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f35866a;

        b(AtomicReference atomicReference) {
            this.f35866a = atomicReference;
        }

        @Override // rx.k.a
        public void call() {
            synchronized (a1.this.f35857d) {
                if (a1.this.f35862i == this.f35866a.get()) {
                    rx.g gVar = a1.this.f35861h;
                    a1.this.f35861h = null;
                    a1.this.f35862i = null;
                    a1.this.f35859f.set(null);
                    if (gVar != null) {
                        gVar.unsubscribe();
                    }
                }
            }
        }
    }

    class c extends rx.g<R> {

        /* renamed from: f */
        final /* synthetic */ rx.g f35868f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f35868f = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35868f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35868f.onError(th);
        }

        @Override // rx.b
        public void onNext(R r) {
            this.f35868f.onNext(r);
        }
    }

    public a1(rx.a<? extends T> aVar, rx.k.n<? extends rx.o.f<? super T, ? extends R>> nVar) {
        this(new Object(), new AtomicReference(), new ArrayList(), aVar, nVar);
    }

    @Override // rx.observables.b
    public void A5(rx.k.b<? super rx.h> bVar) {
        rx.g<T> gVar;
        synchronized (this.f35857d) {
            if (this.f35861h != null) {
                bVar.call(this.f35862i);
                return;
            }
            rx.o.f<? super T, ? extends R> call = this.f35858e.call();
            this.f35861h = rx.l.e.e(call);
            AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(rx.p.f.a(new b(atomicReference)));
            this.f35862i = (rx.h) atomicReference.get();
            for (rx.g<? super R> gVar2 : this.f35860g) {
                call.T4(new c(gVar2, gVar2));
            }
            this.f35860g.clear();
            this.f35859f.set(call);
            bVar.call(this.f35862i);
            synchronized (this.f35857d) {
                gVar = this.f35861h;
            }
            if (gVar != null) {
                this.f35856c.K3(gVar);
            }
        }
    }

    private a1(Object obj, AtomicReference<rx.o.f<? super T, ? extends R>> atomicReference, List<rx.g<? super R>> list, rx.a<? extends T> aVar, rx.k.n<? extends rx.o.f<? super T, ? extends R>> nVar) {
        super(new a(obj, atomicReference, list));
        this.f35857d = obj;
        this.f35859f = atomicReference;
        this.f35860g = list;
        this.f35856c = aVar;
        this.f35858e = nVar;
    }
}
