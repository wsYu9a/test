package dk;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import qj.g;
import qj.h;
import rx.internal.util.UtilityFunctions;
import wj.o;
import xj.d;
import xj.e;
import xj.f;

/* loaded from: classes5.dex */
public final class a<T> {

    /* renamed from: a */
    public final qj.a<? extends T> f25562a;

    /* renamed from: dk.a$a */
    public class C0690a extends g<T> {

        /* renamed from: g */
        public final /* synthetic */ CountDownLatch f25563g;

        /* renamed from: h */
        public final /* synthetic */ AtomicReference f25564h;

        /* renamed from: i */
        public final /* synthetic */ wj.b f25565i;

        public C0690a(CountDownLatch countDownLatch, AtomicReference atomicReference, wj.b bVar) {
            this.f25563g = countDownLatch;
            this.f25564h = atomicReference;
            this.f25565i = bVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f25563g.countDown();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f25564h.set(th2);
            this.f25563g.countDown();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f25565i.call(t10);
        }
    }

    public class b implements Iterable<T> {
        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return a.this.h();
        }
    }

    public class c extends g<T> {

        /* renamed from: g */
        public final /* synthetic */ CountDownLatch f25568g;

        /* renamed from: h */
        public final /* synthetic */ AtomicReference f25569h;

        /* renamed from: i */
        public final /* synthetic */ AtomicReference f25570i;

        public c(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f25568g = countDownLatch;
            this.f25569h = atomicReference;
            this.f25570i = atomicReference2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f25568g.countDown();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f25569h.set(th2);
            this.f25568g.countDown();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f25570i.set(t10);
        }
    }

    public a(qj.a<? extends T> aVar) {
        this.f25562a = aVar;
    }

    public static <T> a<T> g(qj.a<? extends T> aVar) {
        return new a<>(aVar);
    }

    public final T a(qj.a<? extends T> aVar) {
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
        } catch (InterruptedException e10) {
            K3.unsubscribe();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for subscription to complete.", e10);
        }
    }

    public T b() {
        return a(this.f25562a.J0());
    }

    public T c(o<? super T, Boolean> oVar) {
        return a(this.f25562a.K0(oVar));
    }

    public T d(T t10) {
        return a(this.f25562a.D1(UtilityFunctions.c()).L0(t10));
    }

    public T e(T t10, o<? super T, Boolean> oVar) {
        return a(this.f25562a.H0(oVar).D1(UtilityFunctions.c()).L0(t10));
    }

    public void f(wj.b<? super T> bVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        h K3 = this.f25562a.K3(new C0690a(countDownLatch, atomicReference, bVar));
        try {
            countDownLatch.await();
            if (atomicReference.get() != null) {
                if (!(atomicReference.get() instanceof RuntimeException)) {
                    throw new RuntimeException((Throwable) atomicReference.get());
                }
                throw ((RuntimeException) atomicReference.get());
            }
        } catch (InterruptedException e10) {
            K3.unsubscribe();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for subscription to complete.", e10);
        }
    }

    public Iterator<T> h() {
        return f.a(this.f25562a);
    }

    public T i() {
        return a(this.f25562a.x1());
    }

    public T j(o<? super T, Boolean> oVar) {
        return a(this.f25562a.y1(oVar));
    }

    public T k(T t10) {
        return a(this.f25562a.D1(UtilityFunctions.c()).z1(t10));
    }

    public T l(T t10, o<? super T, Boolean> oVar) {
        return a(this.f25562a.H0(oVar).D1(UtilityFunctions.c()).z1(t10));
    }

    public Iterable<T> m() {
        return xj.b.a(this.f25562a);
    }

    public Iterable<T> n(T t10) {
        return xj.c.a(this.f25562a, t10);
    }

    public Iterable<T> o() {
        return d.a(this.f25562a);
    }

    public T p() {
        return a(this.f25562a.l3());
    }

    public T q(o<? super T, Boolean> oVar) {
        return a(this.f25562a.m3(oVar));
    }

    public T r(T t10) {
        return a(this.f25562a.D1(UtilityFunctions.c()).n3(t10));
    }

    public T s(T t10, o<? super T, Boolean> oVar) {
        return a(this.f25562a.H0(oVar).D1(UtilityFunctions.c()).n3(t10));
    }

    public Future<T> t() {
        return e.a(this.f25562a);
    }

    public Iterable<T> u() {
        return new b();
    }
}
