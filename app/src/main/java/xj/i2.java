package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class i2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.p<? super T, ? super Integer, Boolean> f32311b;

    public class a implements wj.p<T, Integer, Boolean> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f32312b;

        public a(wj.o oVar) {
            this.f32312b = oVar;
        }

        @Override // wj.p
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((a) obj, num);
        }

        /* renamed from: call */
        public Boolean call2(T t10, Integer num) {
            return (Boolean) this.f32312b.call(t10);
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public int f32313g;

        /* renamed from: h */
        public boolean f32314h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32315i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, boolean z10, qj.g gVar2) {
            super(gVar, z10);
            this.f32315i = gVar2;
            this.f32313g = 0;
            this.f32314h = false;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32314h) {
                return;
            }
            this.f32315i.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32314h) {
                return;
            }
            this.f32315i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                wj.p pVar = i2.this.f32311b;
                int i10 = this.f32313g;
                this.f32313g = i10 + 1;
                if (((Boolean) pVar.call(t10, Integer.valueOf(i10))).booleanValue()) {
                    this.f32315i.onNext(t10);
                    return;
                }
                this.f32314h = true;
                this.f32315i.onCompleted();
                unsubscribe();
            } catch (Throwable th2) {
                this.f32314h = true;
                vj.a.e(th2);
                this.f32315i.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
                unsubscribe();
            }
        }
    }

    public i2(wj.o<? super T, Boolean> oVar) {
        this(new a(oVar));
    }

    public i2(wj.p<? super T, ? super Integer, Boolean> pVar) {
        this.f32311b = pVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        b bVar = new b(gVar, false, gVar);
        gVar.b(bVar);
        return bVar;
    }
}
