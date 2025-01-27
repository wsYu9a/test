package xj;

import qj.a;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class o0<T, U> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends U> f32487b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public U f32488g;

        /* renamed from: h */
        public boolean f32489h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32490i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32490i = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32490i.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32490i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            U u10 = this.f32488g;
            U call = o0.this.f32487b.call(t10);
            this.f32488g = call;
            if (!this.f32489h) {
                this.f32489h = true;
                this.f32490i.onNext(t10);
            } else if (u10 == call || (call != null && call.equals(u10))) {
                e(1L);
            } else {
                this.f32490i.onNext(t10);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public static final o0<?, ?> f32492a = new o0<>(UtilityFunctions.c());
    }

    public o0(wj.o<? super T, ? extends U> oVar) {
        this.f32487b = oVar;
    }

    public static <T> o0<T, T> a() {
        return (o0<T, T>) b.f32492a;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
