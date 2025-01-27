package xj;

import java.util.NoSuchElementException;
import qj.e;

/* loaded from: classes5.dex */
public class v<T> implements e.j<T> {

    /* renamed from: b */
    public final qj.a<T> f32715b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32716g = false;

        /* renamed from: h */
        public boolean f32717h = false;

        /* renamed from: i */
        public T f32718i = null;

        /* renamed from: j */
        public final /* synthetic */ qj.f f32719j;

        public a(qj.f fVar) {
            this.f32719j = fVar;
        }

        @Override // qj.g
        public void d() {
            e(2L);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32716g) {
                return;
            }
            if (this.f32717h) {
                this.f32719j.c(this.f32718i);
            } else {
                this.f32719j.b(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32719j.b(th2);
            unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (!this.f32717h) {
                this.f32717h = true;
                this.f32718i = t10;
            } else {
                this.f32716g = true;
                this.f32719j.b(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
            }
        }
    }

    public v(qj.a<T> aVar) {
        this.f32715b = aVar;
    }

    public static <T> v<T> a(qj.a<T> aVar) {
        return new v<>(aVar);
    }

    @Override // wj.b
    public void call(qj.f<? super T> fVar) {
        a aVar = new a(fVar);
        fVar.a(aVar);
        this.f32715b.T4(aVar);
    }
}
