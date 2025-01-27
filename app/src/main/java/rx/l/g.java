package rx.l;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.CompositeException;

/* loaded from: classes5.dex */
public class g<T> extends rx.g<T> {

    /* renamed from: f */
    private static final rx.b<Object> f36908f = new a();

    /* renamed from: g */
    private final f<T> f36909g;

    /* renamed from: h */
    private final CountDownLatch f36910h;

    /* renamed from: i */
    private volatile Thread f36911i;

    /* renamed from: j */
    private final long f36912j;

    static class a implements rx.b<Object> {
        a() {
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
        }

        @Override // rx.b
        public void onNext(Object obj) {
        }
    }

    @rx.j.b
    public g(long j2) {
        this(f36908f, j2);
    }

    @rx.j.b
    public static <T> g<T> A(rx.g<T> gVar) {
        return new g<>((rx.g) gVar);
    }

    @rx.j.b
    public static <T> g<T> w() {
        return new g<>();
    }

    @rx.j.b
    public static <T> g<T> x(long j2) {
        return new g<>(j2);
    }

    @rx.j.b
    public static <T> g<T> y(rx.b<T> bVar) {
        return new g<>(bVar);
    }

    @rx.j.b
    public static <T> g<T> z(rx.b<T> bVar, long j2) {
        return new g<>(bVar, j2);
    }

    public Thread B() {
        return this.f36911i;
    }

    public List<Notification<T>> C() {
        return this.f36909g.d();
    }

    public List<Throwable> D() {
        return this.f36909g.e();
    }

    public List<T> E() {
        return this.f36909g.f();
    }

    public void F(long j2) {
        e(j2);
    }

    @Override // rx.g
    public void d() {
        long j2 = this.f36912j;
        if (j2 >= 0) {
            F(j2);
        }
    }

    @rx.j.b
    public void g() {
        int size = this.f36909g.d().size();
        if (size == 0) {
            throw new AssertionError("Not completed!");
        }
        if (size <= 1) {
            return;
        }
        throw new AssertionError("Completed multiple times: " + size);
    }

    @rx.j.b
    public void h(Class<? extends Throwable> cls) {
        List<Throwable> e2 = this.f36909g.e();
        if (e2.size() == 0) {
            throw new AssertionError("No errors");
        }
        if (e2.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + e2.size());
            assertionError.initCause(new CompositeException(e2));
            throw assertionError;
        }
        if (cls.isInstance(e2.get(0))) {
            return;
        }
        AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + e2.get(0));
        assertionError2.initCause(e2.get(0));
        throw assertionError2;
    }

    @rx.j.b
    public void i(Throwable th) {
        List<Throwable> e2 = this.f36909g.e();
        if (e2.size() == 0) {
            throw new AssertionError("No errors");
        }
        if (e2.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + e2.size());
            assertionError.initCause(new CompositeException(e2));
            throw assertionError;
        }
        if (th.equals(e2.get(0))) {
            return;
        }
        AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + th + ", actual: " + e2.get(0));
        assertionError2.initCause(e2.get(0));
        throw assertionError2;
    }

    public void j() {
        if (D().size() <= 0) {
            return;
        }
        throw new RuntimeException("Unexpected onError events: " + D().size(), D().get(0));
    }

    @rx.j.b
    public void k() {
        List<Throwable> e2 = this.f36909g.e();
        int size = this.f36909g.d().size();
        if (e2.size() > 0 || size > 0) {
            if (e2.isEmpty()) {
                throw new AssertionError("Found " + e2.size() + " errors and " + size + " completion events instead of none");
            }
            if (e2.size() == 1) {
                AssertionError assertionError = new AssertionError("Found " + e2.size() + " errors and " + size + " completion events instead of none");
                assertionError.initCause(e2.get(0));
                throw assertionError;
            }
            AssertionError assertionError2 = new AssertionError("Found " + e2.size() + " errors and " + size + " completion events instead of none");
            assertionError2.initCause(new CompositeException(e2));
            throw assertionError2;
        }
    }

    @rx.j.b
    public void l() {
        int size = this.f36909g.f().size();
        if (size <= 0) {
            return;
        }
        throw new AssertionError("No onNext events expected yet some received: " + size);
    }

    @rx.j.b
    public void m() {
        int size = this.f36909g.d().size();
        if (size == 1) {
            throw new AssertionError("Completed!");
        }
        if (size <= 1) {
            return;
        }
        throw new AssertionError("Completed multiple times: " + size);
    }

    public void n(List<T> list) {
        this.f36909g.a(list);
    }

    public void o() {
        this.f36909g.b();
    }

    @Override // rx.b
    public void onCompleted() {
        try {
            this.f36911i = Thread.currentThread();
            this.f36909g.onCompleted();
        } finally {
            this.f36910h.countDown();
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        try {
            this.f36911i = Thread.currentThread();
            this.f36909g.onError(th);
        } finally {
            this.f36910h.countDown();
        }
    }

    @Override // rx.b
    public void onNext(T t) {
        this.f36911i = Thread.currentThread();
        this.f36909g.onNext(t);
    }

    public void p() {
        if (!isUnsubscribed()) {
            throw new AssertionError("Not unsubscribed.");
        }
    }

    @rx.j.b
    public void q(T t) {
        n(Collections.singletonList(t));
    }

    @rx.j.b
    public void r(int i2) {
        int size = this.f36909g.f().size();
        if (size == i2) {
            return;
        }
        throw new AssertionError("Number of onNext events differ; expected: " + i2 + ", actual: " + size);
    }

    @rx.j.b
    public void s(T... tArr) {
        n(Arrays.asList(tArr));
    }

    public void t() {
        try {
            this.f36910h.await();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted", e2);
        }
    }

    public void u(long j2, TimeUnit timeUnit) {
        try {
            this.f36910h.await(j2, timeUnit);
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted", e2);
        }
    }

    public void v(long j2, TimeUnit timeUnit) {
        try {
            if (this.f36910h.await(j2, timeUnit)) {
                return;
            }
            unsubscribe();
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    @rx.j.b
    public g(rx.b<T> bVar, long j2) {
        this.f36910h = new CountDownLatch(1);
        bVar.getClass();
        this.f36909g = new f<>(bVar);
        this.f36912j = j2;
    }

    public g(rx.g<T> gVar) {
        this(gVar, -1L);
    }

    public g(rx.b<T> bVar) {
        this(bVar, -1L);
    }

    public g() {
        this(-1L);
    }
}
