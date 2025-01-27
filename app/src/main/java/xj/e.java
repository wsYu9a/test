package xj;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class e {

    public static class a<T> extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ CountDownLatch f32161g;

        /* renamed from: h */
        public final /* synthetic */ AtomicReference f32162h;

        /* renamed from: i */
        public final /* synthetic */ AtomicReference f32163i;

        public a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f32161g = countDownLatch;
            this.f32162h = atomicReference;
            this.f32163i = atomicReference2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32161g.countDown();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            k0.e.a(this.f32162h, null, th2);
            this.f32161g.countDown();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32163i.set(t10);
        }
    }

    public e() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> a(qj.a<? extends T> aVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        return new b(countDownLatch, aVar.l3().K3(new a(countDownLatch, atomicReference2, atomicReference)), atomicReference2, atomicReference);
    }

    public static class b<T> implements Future<T> {

        /* renamed from: b */
        public volatile boolean f32164b = false;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f32165c;

        /* renamed from: d */
        public final /* synthetic */ qj.h f32166d;

        /* renamed from: e */
        public final /* synthetic */ AtomicReference f32167e;

        /* renamed from: f */
        public final /* synthetic */ AtomicReference f32168f;

        public b(CountDownLatch countDownLatch, qj.h hVar, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f32165c = countDownLatch;
            this.f32166d = hVar;
            this.f32167e = atomicReference;
            this.f32168f = atomicReference2;
        }

        public final T a() throws ExecutionException {
            if (this.f32167e.get() != null) {
                throw new ExecutionException("Observable onError", (Throwable) this.f32167e.get());
            }
            if (this.f32164b) {
                throw new CancellationException("Subscription unsubscribed");
            }
            return (T) this.f32168f.get();
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (this.f32165c.getCount() <= 0) {
                return false;
            }
            this.f32164b = true;
            this.f32166d.unsubscribe();
            this.f32165c.countDown();
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            this.f32165c.await();
            return a();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f32164b;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f32165c.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            if (this.f32165c.await(j10, timeUnit)) {
                return a();
            }
            throw new TimeoutException("Timed out after " + timeUnit.toMillis(j10) + "ms waiting for underlying Observable.");
        }
    }
}
