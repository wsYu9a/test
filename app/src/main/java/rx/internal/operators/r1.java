package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;

/* loaded from: classes5.dex */
public final class r1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final boolean f36401a;

    /* renamed from: b */
    private final T f36402b;

    class a implements rx.c {

        /* renamed from: a */
        private final AtomicBoolean f36403a = new AtomicBoolean(false);

        /* renamed from: b */
        final /* synthetic */ c f36404b;

        a(c cVar) {
            this.f36404b = cVar;
        }

        @Override // rx.c
        public void request(long j2) {
            if (j2 <= 0 || !this.f36403a.compareAndSet(false, true)) {
                return;
            }
            this.f36404b.g(2L);
        }
    }

    private static class b {

        /* renamed from: a */
        static final r1<?> f36406a = new r1<>((a) null);

        private b() {
        }
    }

    private static final class c<T> extends rx.g<T> {

        /* renamed from: f */
        private final rx.g<? super T> f36407f;

        /* renamed from: g */
        private final boolean f36408g;

        /* renamed from: h */
        private final T f36409h;

        /* renamed from: i */
        private T f36410i;

        /* renamed from: j */
        private boolean f36411j = false;
        private boolean k = false;

        c(rx.g<? super T> gVar, boolean z, T t) {
            this.f36407f = gVar;
            this.f36408g = z;
            this.f36409h = t;
        }

        void g(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.k) {
                return;
            }
            if (this.f36411j) {
                this.f36407f.onNext(this.f36410i);
                this.f36407f.onCompleted();
            } else if (!this.f36408g) {
                this.f36407f.onError(new NoSuchElementException("Sequence contains no elements"));
            } else {
                this.f36407f.onNext(this.f36409h);
                this.f36407f.onCompleted();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36407f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (!this.f36411j) {
                this.f36410i = t;
                this.f36411j = true;
            } else {
                this.k = true;
                this.f36407f.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    /* synthetic */ r1(a aVar) {
        this();
    }

    public static <T> r1<T> a() {
        return (r1<T>) b.f36406a;
    }

    private r1() {
        this(false, null);
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        c cVar = new c(gVar, this.f36401a, this.f36402b);
        gVar.f(new a(cVar));
        gVar.b(cVar);
        return cVar;
    }

    public r1(T t) {
        this(true, t);
    }

    private r1(boolean z, T t) {
        this.f36401a = z;
        this.f36402b = t;
    }
}
