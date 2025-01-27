package rx.internal.operators;

import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public class t2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.d f36485a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36486f;

        a(rx.g gVar) {
            this.f36486f = gVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36486f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36486f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36486f.onNext(t);
        }
    }

    class b implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.g f36488a;

        class a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ d.a f36490a;

            a(d.a aVar) {
                this.f36490a = aVar;
            }

            @Override // rx.k.a
            public void call() {
                b.this.f36488a.unsubscribe();
                this.f36490a.unsubscribe();
            }
        }

        b(rx.g gVar) {
            this.f36488a = gVar;
        }

        @Override // rx.k.a
        public void call() {
            d.a a2 = t2.this.f36485a.a();
            a2.d(new a(a2));
        }
    }

    public t2(rx.d dVar) {
        this.f36485a = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(rx.p.f.a(new b(aVar)));
        return aVar;
    }
}
