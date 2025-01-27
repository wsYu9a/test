package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.a;

/* loaded from: classes5.dex */
public final class m1<T, U> implements a.n0<T, T> {

    /* renamed from: a */
    static final Object f36250a = new Object();

    /* renamed from: b */
    final rx.a<U> f36251b;

    class a extends rx.g<U> {

        /* renamed from: f */
        final /* synthetic */ AtomicReference f36252f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36253g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, AtomicReference atomicReference, rx.l.d dVar) {
            super(gVar);
            this.f36252f = atomicReference;
            this.f36253g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36253g.onCompleted();
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36253g.onError(th);
            unsubscribe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(U u) {
            AtomicReference atomicReference = this.f36252f;
            Object obj = m1.f36250a;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                this.f36253g.onNext(andSet);
            }
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ AtomicReference f36255f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36256g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, AtomicReference atomicReference, rx.l.d dVar) {
            super(gVar);
            this.f36255f = atomicReference;
            this.f36256g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36256g.onCompleted();
            unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36256g.onError(th);
            unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36255f.set(t);
        }
    }

    public m1(rx.a<U> aVar) {
        this.f36251b = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        rx.l.d dVar = new rx.l.d(gVar);
        AtomicReference atomicReference = new AtomicReference(f36250a);
        a aVar = new a(gVar, atomicReference, dVar);
        b bVar = new b(gVar, atomicReference, dVar);
        this.f36251b.T4(aVar);
        return bVar;
    }
}
