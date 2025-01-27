package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class g2<T, E> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends E> f32248b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32249g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, boolean z10, qj.g gVar2) {
            super(gVar, z10);
            this.f32249g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                this.f32249g.onCompleted();
            } finally {
                this.f32249g.unsubscribe();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                this.f32249g.onError(th2);
            } finally {
                this.f32249g.unsubscribe();
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32249g.onNext(t10);
        }
    }

    public class b extends qj.g<E> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32251g;

        public b(qj.g gVar) {
            this.f32251g = gVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32251g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32251g.onError(th2);
        }

        @Override // qj.b
        public void onNext(E e10) {
            onCompleted();
        }
    }

    public g2(qj.a<? extends E> aVar) {
        this.f32248b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar, false);
        a aVar = new a(dVar, false, dVar);
        b bVar = new b(aVar);
        dVar.b(aVar);
        dVar.b(bVar);
        gVar.b(dVar);
        this.f32248b.T4(bVar);
        return aVar;
    }
}
