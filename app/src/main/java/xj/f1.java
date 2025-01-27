package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class f1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<OnErrorThrowable, ? extends qj.a<? extends T>> f32219b;

    public f1(wj.o<OnErrorThrowable, ? extends qj.a<? extends T>> oVar) {
        this.f32219b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32220g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32220g = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32220g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                fk.d.b().a().a(th2);
                ((qj.a) f1.this.f32219b.call(OnErrorThrowable.from(th2))).T4(new C0818a());
            } catch (Throwable th3) {
                this.f32220g.onError(th3);
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32220g.onNext(t10);
        }

        /* renamed from: xj.f1$a$a */
        public class C0818a extends qj.g<T> {
            public C0818a() {
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                a.this.f32220g.onError(th2);
            }

            @Override // qj.b
            public void onNext(T t10) {
                a.this.f32220g.onNext(t10);
            }

            @Override // qj.b
            public void onCompleted() {
            }
        }
    }
}
