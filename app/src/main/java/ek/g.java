package ek;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.CompositeException;

/* loaded from: classes5.dex */
public class g<T> extends qj.g<T> {

    /* renamed from: k */
    public static final qj.b<Object> f25946k = new a();

    /* renamed from: g */
    public final f<T> f25947g;

    /* renamed from: h */
    public final CountDownLatch f25948h;

    /* renamed from: i */
    public volatile Thread f25949i;

    /* renamed from: j */
    public final long f25950j;

    @uj.b
    public g(long j10) {
        this(f25946k, j10);
    }

    @uj.b
    public static <T> g<T> A(qj.g<T> gVar) {
        return new g<>((qj.g) gVar);
    }

    @uj.b
    public static <T> g<T> w() {
        return new g<>();
    }

    @uj.b
    public static <T> g<T> x(long j10) {
        return new g<>(j10);
    }

    @uj.b
    public static <T> g<T> y(qj.b<T> bVar) {
        return new g<>(bVar);
    }

    @uj.b
    public static <T> g<T> z(qj.b<T> bVar, long j10) {
        return new g<>(bVar, j10);
    }

    public Thread B() {
        return this.f25949i;
    }

    public List<Notification<T>> C() {
        return this.f25947g.d();
    }

    public List<Throwable> D() {
        return this.f25947g.e();
    }

    public List<T> E() {
        return this.f25947g.f();
    }

    public void F(long j10) {
        e(j10);
    }

    @Override // qj.g
    public void d() {
        long j10 = this.f25950j;
        if (j10 >= 0) {
            F(j10);
        }
    }

    @uj.b
    public void g() {
        int size = this.f25947g.d().size();
        if (size == 0) {
            throw new AssertionError("Not completed!");
        }
        if (size <= 1) {
            return;
        }
        throw new AssertionError("Completed multiple times: " + size);
    }

    @uj.b
    public void h(Class<? extends Throwable> cls) {
        List<Throwable> e10 = this.f25947g.e();
        if (e10.size() == 0) {
            throw new AssertionError("No errors");
        }
        if (e10.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + e10.size());
            assertionError.initCause(new CompositeException(e10));
            throw assertionError;
        }
        if (cls.isInstance(e10.get(0))) {
            return;
        }
        AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + e10.get(0));
        assertionError2.initCause(e10.get(0));
        throw assertionError2;
    }

    @uj.b
    public void i(Throwable th2) {
        List<Throwable> e10 = this.f25947g.e();
        if (e10.size() == 0) {
            throw new AssertionError("No errors");
        }
        if (e10.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + e10.size());
            assertionError.initCause(new CompositeException(e10));
            throw assertionError;
        }
        if (th2.equals(e10.get(0))) {
            return;
        }
        AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + th2 + ", actual: " + e10.get(0));
        assertionError2.initCause(e10.get(0));
        throw assertionError2;
    }

    public void j() {
        if (D().size() <= 0) {
            return;
        }
        throw new RuntimeException("Unexpected onError events: " + D().size(), D().get(0));
    }

    @uj.b
    public void k() {
        List<Throwable> e10 = this.f25947g.e();
        int size = this.f25947g.d().size();
        if (e10.size() > 0 || size > 0) {
            if (e10.isEmpty()) {
                throw new AssertionError("Found " + e10.size() + " errors and " + size + " completion events instead of none");
            }
            if (e10.size() == 1) {
                AssertionError assertionError = new AssertionError("Found " + e10.size() + " errors and " + size + " completion events instead of none");
                assertionError.initCause(e10.get(0));
                throw assertionError;
            }
            AssertionError assertionError2 = new AssertionError("Found " + e10.size() + " errors and " + size + " completion events instead of none");
            assertionError2.initCause(new CompositeException(e10));
            throw assertionError2;
        }
    }

    @uj.b
    public void l() {
        int size = this.f25947g.f().size();
        if (size <= 0) {
            return;
        }
        throw new AssertionError("No onNext events expected yet some received: " + size);
    }

    @uj.b
    public void m() {
        int size = this.f25947g.d().size();
        if (size == 1) {
            throw new AssertionError("Completed!");
        }
        if (size <= 1) {
            return;
        }
        throw new AssertionError("Completed multiple times: " + size);
    }

    public void n(List<T> list) {
        this.f25947g.a(list);
    }

    public void o() {
        this.f25947g.b();
    }

    @Override // qj.b
    public void onCompleted() {
        try {
            this.f25949i = Thread.currentThread();
            this.f25947g.onCompleted();
        } finally {
            this.f25948h.countDown();
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        try {
            this.f25949i = Thread.currentThread();
            this.f25947g.onError(th2);
        } finally {
            this.f25948h.countDown();
        }
    }

    @Override // qj.b
    public void onNext(T t10) {
        this.f25949i = Thread.currentThread();
        this.f25947g.onNext(t10);
    }

    public void p() {
        if (!isUnsubscribed()) {
            throw new AssertionError("Not unsubscribed.");
        }
    }

    @uj.b
    public void q(T t10) {
        n(Collections.singletonList(t10));
    }

    @uj.b
    public void r(int i10) {
        int size = this.f25947g.f().size();
        if (size == i10) {
            return;
        }
        throw new AssertionError("Number of onNext events differ; expected: " + i10 + ", actual: " + size);
    }

    @uj.b
    public void s(T... tArr) {
        n(Arrays.asList(tArr));
    }

    public void t() {
        try {
            this.f25948h.await();
        } catch (InterruptedException e10) {
            throw new RuntimeException("Interrupted", e10);
        }
    }

    public void u(long j10, TimeUnit timeUnit) {
        try {
            this.f25948h.await(j10, timeUnit);
        } catch (InterruptedException e10) {
            throw new RuntimeException("Interrupted", e10);
        }
    }

    public void v(long j10, TimeUnit timeUnit) {
        try {
            if (this.f25948h.await(j10, timeUnit)) {
                return;
            }
            unsubscribe();
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    @uj.b
    public g(qj.b<T> bVar, long j10) {
        this.f25948h = new CountDownLatch(1);
        bVar.getClass();
        this.f25947g = new f<>(bVar);
        this.f25950j = j10;
    }

    public g(qj.g<T> gVar) {
        this(gVar, -1L);
    }

    public g(qj.b<T> bVar) {
        this(bVar, -1L);
    }

    public g() {
        this(-1L);
    }

    public static class a implements qj.b<Object> {
        @Override // qj.b
        public void onCompleted() {
        }

        @Override // qj.b
        public void onError(Throwable th2) {
        }

        @Override // qj.b
        public void onNext(Object obj) {
        }
    }
}
