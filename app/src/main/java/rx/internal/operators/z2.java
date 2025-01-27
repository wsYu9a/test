package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.a;

/* loaded from: classes5.dex */
public final class z2<T, U, R> implements a.n0<R, T> {

    /* renamed from: a */
    static final Object f36705a = new Object();

    /* renamed from: b */
    final rx.k.p<? super T, ? super U, ? extends R> f36706b;

    /* renamed from: c */
    final rx.a<? extends U> f36707c;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ AtomicReference f36708f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36709g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, boolean z, AtomicReference atomicReference, rx.l.d dVar) {
            super(gVar, z);
            this.f36708f = atomicReference;
            this.f36709g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36709g.onCompleted();
            this.f36709g.unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36709g.onError(th);
            this.f36709g.unsubscribe();
        }

        @Override // rx.b
        public void onNext(T t) {
            Object obj = this.f36708f.get();
            if (obj != z2.f36705a) {
                try {
                    this.f36709g.onNext(z2.this.f36706b.call(t, obj));
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }
    }

    class b extends rx.g<U> {

        /* renamed from: f */
        final /* synthetic */ AtomicReference f36711f;

        /* renamed from: g */
        final /* synthetic */ rx.l.d f36712g;

        b(AtomicReference atomicReference, rx.l.d dVar) {
            this.f36711f = atomicReference;
            this.f36712g = dVar;
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36711f.get() == z2.f36705a) {
                this.f36712g.onCompleted();
                this.f36712g.unsubscribe();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36712g.onError(th);
            this.f36712g.unsubscribe();
        }

        @Override // rx.b
        public void onNext(U u) {
            this.f36711f.set(u);
        }
    }

    public z2(rx.a<? extends U> aVar, rx.k.p<? super T, ? super U, ? extends R> pVar) {
        this.f36707c = aVar;
        this.f36706b = pVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super R> gVar) {
        rx.l.d dVar = new rx.l.d(gVar, false);
        gVar.b(dVar);
        AtomicReference atomicReference = new AtomicReference(f36705a);
        a aVar = new a(dVar, true, atomicReference, dVar);
        b bVar = new b(atomicReference, dVar);
        dVar.b(aVar);
        dVar.b(bVar);
        this.f36707c.T4(bVar);
        return aVar;
    }
}
