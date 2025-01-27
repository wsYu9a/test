package xj;

import java.util.HashSet;
import java.util.Set;
import qj.a;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class n0<T, U> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<? super T, ? extends U> f32462b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public Set<U> f32463g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32464h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32464h = gVar2;
            this.f32463g = new HashSet();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32463g = null;
            this.f32464h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32463g = null;
            this.f32464h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32463g.add(n0.this.f32462b.call(t10))) {
                this.f32464h.onNext(t10);
            } else {
                e(1L);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public static final n0<?, ?> f32466a = new n0<>(UtilityFunctions.c());
    }

    public n0(wj.o<? super T, ? extends U> oVar) {
        this.f32462b = oVar;
    }

    public static <T> n0<T, T> a() {
        return (n0<T, T>) b.f32466a;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
