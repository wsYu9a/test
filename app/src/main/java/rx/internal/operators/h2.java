package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

@rx.j.b
/* loaded from: classes5.dex */
public final class h2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, Boolean> f36107a;

    class a implements rx.c {

        /* renamed from: a */
        final /* synthetic */ b f36108a;

        a(b bVar) {
            this.f36108a = bVar;
        }

        @Override // rx.c
        public void request(long j2) {
            this.f36108a.g(j2);
        }
    }

    private final class b extends rx.g<T> {

        /* renamed from: f */
        private final rx.g<? super T> f36110f;

        /* renamed from: g */
        private boolean f36111g;

        /* synthetic */ b(h2 h2Var, rx.g gVar, a aVar) {
            this(gVar);
        }

        void g(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36111g) {
                return;
            }
            this.f36110f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36111g) {
                return;
            }
            this.f36110f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36110f.onNext(t);
            try {
                if (((Boolean) h2.this.f36107a.call(t)).booleanValue()) {
                    this.f36111g = true;
                    this.f36110f.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f36111g = true;
                rx.exceptions.a.e(th);
                this.f36110f.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                unsubscribe();
            }
        }

        private b(rx.g<? super T> gVar) {
            this.f36111g = false;
            this.f36110f = gVar;
        }
    }

    public h2(rx.k.o<? super T, Boolean> oVar) {
        this.f36107a = oVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        b bVar = new b(this, gVar, null);
        gVar.b(bVar);
        gVar.f(new a(bVar));
        return bVar;
    }
}
