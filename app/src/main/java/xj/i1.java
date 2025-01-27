package xj;

import java.util.Arrays;
import qj.a;
import rx.exceptions.CompositeException;

/* loaded from: classes5.dex */
public final class i1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<Throwable, ? extends T> f32305b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32306g = false;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32307h;

        /* renamed from: xj.i1$a$a */
        public class C0822a implements qj.c {

            /* renamed from: b */
            public final /* synthetic */ qj.c f32309b;

            public C0822a(qj.c cVar) {
                this.f32309b = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                this.f32309b.request(j10);
            }
        }

        public a(qj.g gVar) {
            this.f32307h = gVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32307h.f(new C0822a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32306g) {
                return;
            }
            this.f32306g = true;
            this.f32307h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32306g) {
                vj.a.e(th2);
                return;
            }
            this.f32306g = true;
            try {
                fk.d.b().a().a(th2);
                unsubscribe();
                this.f32307h.onNext(i1.this.f32305b.call(th2));
                this.f32307h.onCompleted();
            } catch (Throwable th3) {
                this.f32307h.onError(new CompositeException(Arrays.asList(th2, th3)));
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32306g) {
                return;
            }
            this.f32307h.onNext(t10);
        }
    }

    public i1(wj.o<Throwable, ? extends T> oVar) {
        this.f32305b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
