package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class j0<T> implements a.n0<T, T> {

    /* renamed from: a */
    final long f36141a;

    /* renamed from: b */
    final TimeUnit f36142b;

    /* renamed from: c */
    final rx.d f36143c;

    class a extends rx.g<T> {

        /* renamed from: f */
        final b<T> f36144f;

        /* renamed from: g */
        final rx.g<?> f36145g;

        /* renamed from: h */
        final /* synthetic */ rx.p.e f36146h;

        /* renamed from: i */
        final /* synthetic */ d.a f36147i;

        /* renamed from: j */
        final /* synthetic */ rx.l.d f36148j;

        /* renamed from: rx.internal.operators.j0$a$a */
        class C0859a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ int f36149a;

            C0859a(int i2) {
                this.f36149a = i2;
            }

            @Override // rx.k.a
            public void call() {
                a aVar = a.this;
                aVar.f36144f.b(this.f36149a, aVar.f36148j, aVar.f36145g);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.p.e eVar, d.a aVar, rx.l.d dVar) {
            super(gVar);
            this.f36146h = eVar;
            this.f36147i = aVar;
            this.f36148j = dVar;
            this.f36144f = new b<>();
            this.f36145g = this;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36144f.c(this.f36148j, this);
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36148j.onError(th);
            unsubscribe();
            this.f36144f.a();
        }

        @Override // rx.b
        public void onNext(T t) {
            int d2 = this.f36144f.d(t);
            rx.p.e eVar = this.f36146h;
            d.a aVar = this.f36147i;
            C0859a c0859a = new C0859a(d2);
            j0 j0Var = j0.this;
            eVar.b(aVar.e(c0859a, j0Var.f36141a, j0Var.f36142b));
        }
    }

    static final class b<T> {

        /* renamed from: a */
        int f36151a;

        /* renamed from: b */
        T f36152b;

        /* renamed from: c */
        boolean f36153c;

        /* renamed from: d */
        boolean f36154d;

        /* renamed from: e */
        boolean f36155e;

        b() {
        }

        public synchronized void a() {
            this.f36151a++;
            this.f36152b = null;
            this.f36153c = false;
        }

        public void b(int i2, rx.g<T> gVar, rx.g<?> gVar2) {
            synchronized (this) {
                if (!this.f36155e && this.f36153c && i2 == this.f36151a) {
                    T t = this.f36152b;
                    this.f36152b = null;
                    this.f36153c = false;
                    this.f36155e = true;
                    try {
                        gVar.onNext(t);
                        synchronized (this) {
                            if (this.f36154d) {
                                gVar.onCompleted();
                            } else {
                                this.f36155e = false;
                            }
                        }
                    } catch (Throwable th) {
                        gVar2.onError(th);
                    }
                }
            }
        }

        public void c(rx.g<T> gVar, rx.g<?> gVar2) {
            synchronized (this) {
                if (this.f36155e) {
                    this.f36154d = true;
                    return;
                }
                T t = this.f36152b;
                boolean z = this.f36153c;
                this.f36152b = null;
                this.f36153c = false;
                this.f36155e = true;
                if (z) {
                    try {
                        gVar.onNext(t);
                    } catch (Throwable th) {
                        gVar2.onError(th);
                        return;
                    }
                }
                gVar.onCompleted();
            }
        }

        public synchronized int d(T t) {
            int i2;
            this.f36152b = t;
            this.f36153c = true;
            i2 = this.f36151a + 1;
            this.f36151a = i2;
            return i2;
        }
    }

    public j0(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36141a = j2;
        this.f36142b = timeUnit;
        this.f36143c = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36143c.a();
        rx.l.d dVar = new rx.l.d(gVar);
        rx.p.e eVar = new rx.p.e();
        dVar.b(a2);
        dVar.b(eVar);
        return new a(gVar, eVar, a2, dVar);
    }
}
