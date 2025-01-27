package rx.internal.operators;

import rx.a;

/* loaded from: classes5.dex */
public final class x1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final rx.k.p<? super T, Integer, Boolean> f36613a;

    class a extends rx.g<T> {

        /* renamed from: f */
        boolean f36614f;

        /* renamed from: g */
        int f36615g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36616h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36616h = gVar2;
            this.f36614f = true;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36616h.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36616h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (!this.f36614f) {
                this.f36616h.onNext(t);
                return;
            }
            rx.k.p pVar = x1.this.f36613a;
            int i2 = this.f36615g;
            this.f36615g = i2 + 1;
            if (((Boolean) pVar.call(t, Integer.valueOf(i2))).booleanValue()) {
                e(1L);
            } else {
                this.f36614f = false;
                this.f36616h.onNext(t);
            }
        }
    }

    static class b implements rx.k.p<T, Integer, Boolean> {

        /* renamed from: a */
        final /* synthetic */ rx.k.o f36618a;

        b(rx.k.o oVar) {
            this.f36618a = oVar;
        }

        @Override // rx.k.p
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((b) obj, num);
        }

        /* renamed from: call */
        public Boolean call2(T t, Integer num) {
            return (Boolean) this.f36618a.call(t);
        }
    }

    public x1(rx.k.p<? super T, Integer, Boolean> pVar) {
        this.f36613a = pVar;
    }

    public static <T> rx.k.p<T, Integer, Boolean> b(rx.k.o<? super T, Boolean> oVar) {
        return new b(oVar);
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
