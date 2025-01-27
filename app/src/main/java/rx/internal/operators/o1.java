package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class o1<R, T> implements a.n0<R, T> {

    /* renamed from: a */
    private static final Object f36302a = new Object();

    /* renamed from: b */
    private final rx.k.n<R> f36303b;

    /* renamed from: c */
    private final rx.k.p<R, ? super T, R> f36304c;

    class a implements rx.k.n<R> {

        /* renamed from: a */
        final /* synthetic */ Object f36305a;

        a(Object obj) {
            this.f36305a = obj;
        }

        @Override // rx.k.n, java.util.concurrent.Callable
        public R call() {
            return (R) this.f36305a;
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        private final R f36306f;

        /* renamed from: g */
        private R f36307g;

        /* renamed from: h */
        boolean f36308h;

        /* renamed from: i */
        final /* synthetic */ rx.g f36309i;

        class a implements rx.c {

            /* renamed from: a */
            final AtomicBoolean f36311a = new AtomicBoolean();

            /* renamed from: b */
            final AtomicBoolean f36312b = new AtomicBoolean();

            /* renamed from: c */
            final /* synthetic */ rx.c f36313c;

            a(rx.c cVar) {
                this.f36313c = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                if (!this.f36311a.compareAndSet(false, true)) {
                    if (j2 <= 1 || !this.f36312b.compareAndSet(true, false) || j2 == Long.MAX_VALUE) {
                        this.f36313c.request(j2);
                        return;
                    } else {
                        this.f36313c.request(j2 - 1);
                        return;
                    }
                }
                if (b.this.f36306f == o1.f36302a || j2 == Long.MAX_VALUE) {
                    this.f36313c.request(j2);
                } else if (j2 != 1) {
                    this.f36313c.request(j2 - 1);
                } else {
                    this.f36312b.set(true);
                    this.f36313c.request(1L);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36309i = gVar2;
            R r = (R) o1.this.f36303b.call();
            this.f36306f = r;
            this.f36307g = r;
            this.f36308h = false;
        }

        private void h(rx.g<? super R> gVar) {
            if (this.f36308h) {
                return;
            }
            this.f36308h = true;
            if (this.f36306f != o1.f36302a) {
                gVar.onNext(this.f36306f);
            }
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36309i.f(new a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            h(this.f36309i);
            this.f36309i.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36309i.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            h(this.f36309i);
            if (this.f36307g == o1.f36302a) {
                this.f36307g = t;
            } else {
                try {
                    this.f36307g = (R) o1.this.f36304c.call(this.f36307g, t);
                } catch (Throwable th) {
                    rx.exceptions.a.e(th);
                    this.f36309i.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                    return;
                }
            }
            this.f36309i.onNext(this.f36307g);
        }
    }

    public o1(R r, rx.k.p<R, ? super T, R> pVar) {
        this((rx.k.n) new a(r), (rx.k.p) pVar);
    }

    public o1(rx.k.n<R> nVar, rx.k.p<R, ? super T, R> pVar) {
        this.f36303b = nVar;
        this.f36304c = pVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super R> gVar) {
        return new b(gVar, gVar);
    }

    public o1(rx.k.p<R, ? super T, R> pVar) {
        this(f36302a, pVar);
    }
}
