package xj;

import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;

/* loaded from: classes5.dex */
public final class w1<T, U> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<U> f32788b;

    public class a extends qj.g<U> {

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f32789g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32790h;

        public a(AtomicBoolean atomicBoolean, ek.d dVar) {
            this.f32789g = atomicBoolean;
            this.f32790h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32790h.onError(th2);
            this.f32790h.unsubscribe();
        }

        @Override // qj.b
        public void onNext(U u10) {
            this.f32789g.set(true);
            unsubscribe();
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ AtomicBoolean f32792g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32793h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, AtomicBoolean atomicBoolean, ek.d dVar) {
            super(gVar);
            this.f32792g = atomicBoolean;
            this.f32793h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32793h.onCompleted();
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32793h.onError(th2);
            unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32792g.get()) {
                this.f32793h.onNext(t10);
            } else {
                e(1L);
            }
        }
    }

    public w1(qj.a<U> aVar) {
        this.f32788b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar = new a(atomicBoolean, dVar);
        gVar.b(aVar);
        this.f32788b.T4(aVar);
        return new b(gVar, atomicBoolean, dVar);
    }
}
