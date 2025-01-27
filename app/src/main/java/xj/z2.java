package xj;

import java.util.concurrent.atomic.AtomicReference;
import qj.a;

/* loaded from: classes5.dex */
public final class z2<T, U, R> implements a.n0<R, T> {

    /* renamed from: d */
    public static final Object f32928d = new Object();

    /* renamed from: b */
    public final wj.p<? super T, ? super U, ? extends R> f32929b;

    /* renamed from: c */
    public final qj.a<? extends U> f32930c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ AtomicReference f32931g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32932h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, boolean z10, AtomicReference atomicReference, ek.d dVar) {
            super(gVar, z10);
            this.f32931g = atomicReference;
            this.f32932h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32932h.onCompleted();
            this.f32932h.unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32932h.onError(th2);
            this.f32932h.unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            Object obj = this.f32931g.get();
            if (obj != z2.f32928d) {
                try {
                    this.f32932h.onNext(z2.this.f32929b.call(t10, obj));
                } catch (Throwable th2) {
                    onError(th2);
                }
            }
        }
    }

    public class b extends qj.g<U> {

        /* renamed from: g */
        public final /* synthetic */ AtomicReference f32934g;

        /* renamed from: h */
        public final /* synthetic */ ek.d f32935h;

        public b(AtomicReference atomicReference, ek.d dVar) {
            this.f32934g = atomicReference;
            this.f32935h = dVar;
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32934g.get() == z2.f32928d) {
                this.f32935h.onCompleted();
                this.f32935h.unsubscribe();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32935h.onError(th2);
            this.f32935h.unsubscribe();
        }

        @Override // qj.b
        public void onNext(U u10) {
            this.f32934g.set(u10);
        }
    }

    public z2(qj.a<? extends U> aVar, wj.p<? super T, ? super U, ? extends R> pVar) {
        this.f32930c = aVar;
        this.f32929b = pVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super R> gVar) {
        ek.d dVar = new ek.d(gVar, false);
        gVar.b(dVar);
        AtomicReference atomicReference = new AtomicReference(f32928d);
        a aVar = new a(dVar, true, atomicReference, dVar);
        b bVar = new b(atomicReference, dVar);
        dVar.b(aVar);
        dVar.b(bVar);
        this.f32930c.T4(bVar);
        return aVar;
    }
}
