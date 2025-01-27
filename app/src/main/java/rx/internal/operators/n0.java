package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.a;
import rx.internal.util.UtilityFunctions;

/* loaded from: classes5.dex */
public final class n0<T, U> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.k.o<? super T, ? extends U> f36271a;

    class a extends rx.g<T> {

        /* renamed from: f */
        Set<U> f36272f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36273g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36273g = gVar2;
            this.f36272f = new HashSet();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36272f = null;
            this.f36273g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36272f = null;
            this.f36273g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36272f.add(n0.this.f36271a.call(t))) {
                this.f36273g.onNext(t);
            } else {
                e(1L);
            }
        }
    }

    private static class b {

        /* renamed from: a */
        static final n0<?, ?> f36275a = new n0<>(UtilityFunctions.c());

        private b() {
        }
    }

    public n0(rx.k.o<? super T, ? extends U> oVar) {
        this.f36271a = oVar;
    }

    public static <T> n0<T, T> a() {
        return (n0<T, T>) b.f36275a;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
