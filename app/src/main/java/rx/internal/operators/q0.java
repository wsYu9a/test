package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public class q0<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.b<Long> f36381a;

    class a implements rx.c {

        /* renamed from: a */
        final /* synthetic */ b f36382a;

        a(b bVar) {
            this.f36382a = bVar;
        }

        @Override // rx.c
        public void request(long j2) {
            q0.this.f36381a.call(Long.valueOf(j2));
            this.f36382a.h(j2);
        }
    }

    private static final class b<T> extends rx.g<T> {

        /* renamed from: f */
        private final rx.g<? super T> f36384f;

        /* synthetic */ b(rx.g gVar, a aVar) {
            this(gVar);
        }

        public void h(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36384f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36384f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36384f.onNext(t);
        }

        private b(rx.g<? super T> gVar) {
            this.f36384f = gVar;
        }
    }

    public q0(rx.k.b<Long> bVar) {
        this.f36381a = bVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        b bVar = new b(gVar, null);
        gVar.f(new a(bVar));
        gVar.b(bVar);
        return bVar;
    }
}
