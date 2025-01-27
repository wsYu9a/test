package rx.internal.operators;

import java.util.Arrays;
import rx.a;
import rx.exceptions.CompositeException;

/* loaded from: classes5.dex */
public final class i1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.k.o<Throwable, ? extends T> f36125a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private boolean f36126f = false;

        /* renamed from: g */
        final /* synthetic */ rx.g f36127g;

        /* renamed from: rx.internal.operators.i1$a$a */
        class C0858a implements rx.c {

            /* renamed from: a */
            final /* synthetic */ rx.c f36129a;

            C0858a(rx.c cVar) {
                this.f36129a = cVar;
            }

            @Override // rx.c
            public void request(long j2) {
                this.f36129a.request(j2);
            }
        }

        a(rx.g gVar) {
            this.f36127g = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            this.f36127g.f(new C0858a(cVar));
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36126f) {
                return;
            }
            this.f36126f = true;
            this.f36127g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36126f) {
                rx.exceptions.a.e(th);
                return;
            }
            this.f36126f = true;
            try {
                rx.m.d.b().a().a(th);
                unsubscribe();
                this.f36127g.onNext(i1.this.f36125a.call(th));
                this.f36127g.onCompleted();
            } catch (Throwable th2) {
                this.f36127g.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36126f) {
                return;
            }
            this.f36127g.onNext(t);
        }
    }

    public i1(rx.k.o<Throwable, ? extends T> oVar) {
        this.f36125a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
