package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class e {

    static class a<T> extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ CountDownLatch f35987f;

        /* renamed from: g */
        final /* synthetic */ AtomicReference f35988g;

        /* renamed from: h */
        final /* synthetic */ AtomicReference f35989h;

        a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f35987f = countDownLatch;
            this.f35988g = atomicReference;
            this.f35989h = atomicReference2;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35987f.countDown();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35988g.compareAndSet(null, th);
            this.f35987f.countDown();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35989h.set(t);
        }
    }

    private e() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> a(rx.a<? extends T> aVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        return new b(countDownLatch, aVar.l3().K3(new a(countDownLatch, atomicReference2, atomicReference)), atomicReference2, atomicReference);
    }

    static class b<T> implements Future<T> {

        /* renamed from: a */
        private volatile boolean f35990a = false;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f35991b;

        /* renamed from: c */
        final /* synthetic */ rx.h f35992c;

        /* renamed from: d */
        final /* synthetic */ AtomicReference f35993d;

        /* renamed from: e */
        final /* synthetic */ AtomicReference f35994e;

        b(CountDownLatch countDownLatch, rx.h hVar, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f35991b = countDownLatch;
            this.f35992c = hVar;
            this.f35993d = atomicReference;
            this.f35994e = atomicReference2;
        }

        private T a() throws ExecutionException {
            if (this.f35993d.get() != null) {
                throw new ExecutionException("Observable onError", (Throwable) this.f35993d.get());
            }
            if (this.f35990a) {
                throw new CancellationException("Subscription unsubscribed");
            }
            return (T) this.f35994e.get();
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (this.f35991b.getCount() <= 0) {
                return false;
            }
            this.f35990a = true;
            this.f35992c.unsubscribe();
            this.f35991b.countDown();
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            this.f35991b.await();
            return a();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f35990a;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f35991b.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            if (this.f35991b.await(j2, timeUnit)) {
                return a();
            }
            throw new TimeoutException("Timed out after " + timeUnit.toMillis(j2) + "ms waiting for underlying Observable.");
        }
    }
}
