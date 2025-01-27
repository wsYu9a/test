package rx.internal.operators;

import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class i2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.p<? super T, ? super Integer, Boolean> f36131a;

    class a implements rx.k.p<T, Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f36132a;

        a(rx.k.o oVar) {
            this.f36132a = oVar;
        }

        @Override // rx.k.p
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((a) obj, num);
        }

        /* renamed from: call */
        public Boolean call2(T t, Integer num) {
            return (Boolean) this.f36132a.call(t);
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        private int f36133f;

        /* renamed from: g */
        private boolean f36134g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36135h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, boolean z, rx.g gVar2) {
            super(gVar, z);
            this.f36135h = gVar2;
            this.f36133f = 0;
            this.f36134g = false;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36134g) {
                return;
            }
            this.f36135h.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36134g) {
                return;
            }
            this.f36135h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                rx.k.p pVar = i2.this.f36131a;
                int i2 = this.f36133f;
                this.f36133f = i2 + 1;
                if (((Boolean) pVar.call(t, Integer.valueOf(i2))).booleanValue()) {
                    this.f36135h.onNext(t);
                    return;
                }
                this.f36134g = true;
                this.f36135h.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f36134g = true;
                rx.exceptions.a.e(th);
                this.f36135h.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                unsubscribe();
            }
        }
    }

    public i2(rx.k.o<? super T, Boolean> oVar) {
        this(new a(oVar));
    }

    public i2(rx.k.p<? super T, ? super Integer, Boolean> pVar) {
        this.f36131a = pVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        b bVar = new b(gVar, false, gVar);
        gVar.b(bVar);
        return bVar;
    }
}
