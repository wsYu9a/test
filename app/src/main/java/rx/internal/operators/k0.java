package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class k0<T> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.a<? extends T> f36190a;

    /* renamed from: b */
    final long f36191b;

    /* renamed from: c */
    final TimeUnit f36192c;

    /* renamed from: d */
    final rx.d f36193d;

    class a extends rx.g<T> {

        /* renamed from: f */
        boolean f36194f;

        /* renamed from: g */
        final /* synthetic */ d.a f36195g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36196h;

        /* renamed from: rx.internal.operators.k0$a$a */
        class C0861a implements rx.k.a {
            C0861a() {
            }

            @Override // rx.k.a
            public void call() {
                a aVar = a.this;
                if (aVar.f36194f) {
                    return;
                }
                aVar.f36194f = true;
                aVar.f36196h.onCompleted();
            }
        }

        class b implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ Throwable f36199a;

            b(Throwable th) {
                this.f36199a = th;
            }

            @Override // rx.k.a
            public void call() {
                a aVar = a.this;
                if (aVar.f36194f) {
                    return;
                }
                aVar.f36194f = true;
                aVar.f36196h.onError(this.f36199a);
                a.this.f36195g.unsubscribe();
            }
        }

        class c implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ Object f36201a;

            c(Object obj) {
                this.f36201a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.k.a
            public void call() {
                a aVar = a.this;
                if (aVar.f36194f) {
                    return;
                }
                aVar.f36196h.onNext(this.f36201a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, d.a aVar, rx.g gVar2) {
            super(gVar);
            this.f36195g = aVar;
            this.f36196h = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            d.a aVar = this.f36195g;
            C0861a c0861a = new C0861a();
            k0 k0Var = k0.this;
            aVar.e(c0861a, k0Var.f36191b, k0Var.f36192c);
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36195g.d(new b(th));
        }

        @Override // rx.b
        public void onNext(T t) {
            d.a aVar = this.f36195g;
            c cVar = new c(t);
            k0 k0Var = k0.this;
            aVar.e(cVar, k0Var.f36191b, k0Var.f36192c);
        }
    }

    public k0(rx.a<? extends T> aVar, long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36190a = aVar;
        this.f36191b = j2;
        this.f36192c = timeUnit;
        this.f36193d = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36193d.a();
        gVar.b(a2);
        return new a(gVar, a2, gVar);
    }
}
