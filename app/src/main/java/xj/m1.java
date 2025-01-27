package xj;

import java.util.concurrent.atomic.AtomicReference;
import qj.a;

/* loaded from: classes5.dex */
public final class m1<T, U> implements a.n0<T, T> {

    /* renamed from: c */
    public static final Object f32436c = new Object();

    /* renamed from: b */
    public final qj.a<U> f32437b;

    public class a extends qj.g<U> {

        /* renamed from: g */
        public final /* synthetic */ AtomicReference f32438g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32439h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, AtomicReference atomicReference, ek.d dVar) {
            super(gVar);
            this.f32438g = atomicReference;
            this.f32439h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32439h.onCompleted();
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32439h.onError(th2);
            unsubscribe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(U u10) {
            AtomicReference atomicReference = this.f32438g;
            Object obj = m1.f32436c;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                this.f32439h.onNext(andSet);
            }
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ AtomicReference f32441g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32442h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, AtomicReference atomicReference, ek.d dVar) {
            super(gVar);
            this.f32441g = atomicReference;
            this.f32442h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32442h.onCompleted();
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32442h.onError(th2);
            unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32441g.set(t10);
        }
    }

    public m1(qj.a<U> aVar) {
        this.f32437b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        AtomicReference atomicReference = new AtomicReference(f32436c);
        a aVar = new a(gVar, atomicReference, dVar);
        b bVar = new b(gVar, atomicReference, dVar);
        this.f32437b.T4(aVar);
        return bVar;
    }
}
