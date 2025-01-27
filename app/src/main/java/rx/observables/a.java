package rx.observables;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.h;
import rx.internal.operators.d;
import rx.internal.operators.e;
import rx.internal.operators.f;
import rx.internal.util.UtilityFunctions;
import rx.k.o;

/* loaded from: classes5.dex */
public final class a<T> {

    /* renamed from: a */
    private final rx.a<? extends T> f37083a;

    /* renamed from: rx.observables.a$a */
    class C0893a extends g<T> {

        /* renamed from: f */
        final /* synthetic */ CountDownLatch f37084f;

        /* renamed from: g */
        final /* synthetic */ AtomicReference f37085g;

        /* renamed from: h */
        final /* synthetic */ rx.k.b f37086h;

        C0893a(CountDownLatch countDownLatch, AtomicReference atomicReference, rx.k.b bVar) {
            this.f37084f = countDownLatch;
            this.f37085g = atomicReference;
            this.f37086h = bVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f37084f.countDown();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f37085g.set(th);
            this.f37084f.countDown();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f37086h.call(t);
        }
    }

    class b implements Iterable<T> {
        b() {
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return a.this.h();
        }
    }

    class c extends g<T> {

        /* renamed from: f */
        final /* synthetic */ CountDownLatch f37089f;

        /* renamed from: g */
        final /* synthetic */ AtomicReference f37090g;

        /* renamed from: h */
        final /* synthetic */ AtomicReference f37091h;

        c(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f37089f = countDownLatch;
            this.f37090g = atomicReference;
            this.f37091h = atomicReference2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f37089f.countDown();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f37090g.set(th);
            this.f37089f.countDown();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f37091h.set(t);
        }
    }

    private a(rx.a<? extends T> aVar) {
        this.f37083a = aVar;
    }

    private T a(rx.a<? extends T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        h K3 = aVar.K3(new c(countDownLatch, atomicReference2, atomicReference));
        try {
            countDownLatch.await();
            if (atomicReference2.get() == null) {
                return (T) atomicReference.get();
            }
            if (atomicReference2.get() instanceof RuntimeException) {
                throw ((RuntimeException) atomicReference2.get());
            }
            throw new RuntimeException((Throwable) atomicReference2.get());
        } catch (InterruptedException e2) {
            K3.unsubscribe();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public static <T> a<T> g(rx.a<? extends T> aVar) {
        return new a<>(aVar);
    }

    public T b() {
        return a(this.f37083a.J0());
    }

    public T c(o<? super T, Boolean> oVar) {
        return a(this.f37083a.K0(oVar));
    }

    public T d(T t) {
        return a(this.f37083a.D1(UtilityFunctions.c()).L0(t));
    }

    public T e(T t, o<? super T, Boolean> oVar) {
        return a(this.f37083a.H0(oVar).D1(UtilityFunctions.c()).L0(t));
    }

    public void f(rx.k.b<? super T> bVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        h K3 = this.f37083a.K3(new C0893a(countDownLatch, atomicReference, bVar));
        try {
            countDownLatch.await();
            if (atomicReference.get() != null) {
                if (!(atomicReference.get() instanceof RuntimeException)) {
                    throw new RuntimeException((Throwable) atomicReference.get());
                }
                throw ((RuntimeException) atomicReference.get());
            }
        } catch (InterruptedException e2) {
            K3.unsubscribe();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public Iterator<T> h() {
        return f.a(this.f37083a);
    }

    public T i() {
        return a(this.f37083a.x1());
    }

    public T j(o<? super T, Boolean> oVar) {
        return a(this.f37083a.y1(oVar));
    }

    public T k(T t) {
        return a(this.f37083a.D1(UtilityFunctions.c()).z1(t));
    }

    public T l(T t, o<? super T, Boolean> oVar) {
        return a(this.f37083a.H0(oVar).D1(UtilityFunctions.c()).z1(t));
    }

    public Iterable<T> m() {
        return rx.internal.operators.b.a(this.f37083a);
    }

    public Iterable<T> n(T t) {
        return rx.internal.operators.c.a(this.f37083a, t);
    }

    public Iterable<T> o() {
        return d.a(this.f37083a);
    }

    public T p() {
        return a(this.f37083a.l3());
    }

    public T q(o<? super T, Boolean> oVar) {
        return a(this.f37083a.m3(oVar));
    }

    public T r(T t) {
        return a(this.f37083a.D1(UtilityFunctions.c()).n3(t));
    }

    public T s(T t, o<? super T, Boolean> oVar) {
        return a(this.f37083a.H0(oVar).D1(UtilityFunctions.c()).n3(t));
    }

    public Future<T> t() {
        return e.a(this.f37083a);
    }

    public Iterable<T> u() {
        return new b();
    }
}
