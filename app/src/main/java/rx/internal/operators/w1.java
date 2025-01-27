package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;

/* loaded from: classes5.dex */
public final class w1<T, U> implements a.n0<T, T> {

    /* renamed from: a */
    final rx.a<U> f36576a;

    class a extends rx.g<U> {

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f36577f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36578g;

        a(AtomicBoolean atomicBoolean, rx.l.d dVar) {
            this.f36577f = atomicBoolean;
            this.f36578g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36578g.onError(th);
            this.f36578g.unsubscribe();
        }

        @Override // rx.b
        public void onNext(U u) {
            this.f36577f.set(true);
            unsubscribe();
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f36580f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36581g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, AtomicBoolean atomicBoolean, rx.l.d dVar) {
            super(gVar);
            this.f36580f = atomicBoolean;
            this.f36581g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36581g.onCompleted();
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36581g.onError(th);
            unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36580f.get()) {
                this.f36581g.onNext(t);
            } else {
                e(1L);
            }
        }
    }

    public w1(rx.a<U> aVar) {
        this.f36576a = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar = new a(atomicBoolean, dVar);
        gVar.b(aVar);
        this.f36576a.T4(aVar);
        return new b(gVar, atomicBoolean, dVar);
    }
}
