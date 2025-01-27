package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class x1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.p<? super T, Integer, Boolean> f32825b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32826g;

        /* renamed from: h */
        public int f32827h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32828i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32828i = gVar2;
            this.f32826g = true;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32828i.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32828i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (!this.f32826g) {
                this.f32828i.onNext(t10);
                return;
            }
            wj.p pVar = x1.this.f32825b;
            int i10 = this.f32827h;
            this.f32827h = i10 + 1;
            if (((Boolean) pVar.call(t10, Integer.valueOf(i10))).booleanValue()) {
                e(1L);
            } else {
                this.f32826g = false;
                this.f32828i.onNext(t10);
            }
        }
    }

    public static class b implements wj.p<T, Integer, Boolean> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f32830b;

        public b(wj.o oVar) {
            this.f32830b = oVar;
        }

        @Override // wj.p
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((b) obj, num);
        }

        /* renamed from: call */
        public Boolean call2(T t10, Integer num) {
            return (Boolean) this.f32830b.call(t10);
        }
    }

    public x1(wj.p<? super T, Integer, Boolean> pVar) {
        this.f32825b = pVar;
    }

    public static <T> wj.p<T, Integer, Boolean> b(wj.o<? super T, Boolean> oVar) {
        return new b(oVar);
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
