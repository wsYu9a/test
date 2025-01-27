package xj;

import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public class t2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.d f32678b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32679g;

        public a(qj.g gVar) {
            this.f32679g = gVar;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32679g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32679g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32679g.onNext(t10);
        }
    }

    public class b implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ qj.g f32681b;

        public class a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ d.a f32683b;

            public a(d.a aVar) {
                this.f32683b = aVar;
            }

            @Override // wj.a
            public void call() {
                b.this.f32681b.unsubscribe();
                this.f32683b.unsubscribe();
            }
        }

        public b(qj.g gVar) {
            this.f32681b = gVar;
        }

        @Override // wj.a
        public void call() {
            d.a a10 = t2.this.f32678b.a();
            a10.b(new a(a10));
        }
    }

    public t2(qj.d dVar) {
        this.f32678b = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(ik.f.a(new b(aVar)));
        return aVar;
    }
}
