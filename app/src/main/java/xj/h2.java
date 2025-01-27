package xj;

import qj.a;
import rx.exceptions.OnErrorThrowable;

@uj.b
/* loaded from: classes5.dex */
public final class h2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.o<? super T, Boolean> f32287b;

    public class a implements qj.c {

        /* renamed from: b */
        public final /* synthetic */ b f32288b;

        public a(b bVar) {
            this.f32288b = bVar;
        }

        @Override // qj.c
        public void request(long j10) {
            this.f32288b.g(j10);
        }
    }

    public final class b extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super T> f32290g;

        /* renamed from: h */
        public boolean f32291h;

        public /* synthetic */ b(h2 h2Var, qj.g gVar, a aVar) {
            this(gVar);
        }

        public void g(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32291h) {
                return;
            }
            this.f32290g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32291h) {
                return;
            }
            this.f32290g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32290g.onNext(t10);
            try {
                if (((Boolean) h2.this.f32287b.call(t10)).booleanValue()) {
                    this.f32291h = true;
                    this.f32290g.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th2) {
                this.f32291h = true;
                vj.a.e(th2);
                this.f32290g.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
                unsubscribe();
            }
        }

        public b(qj.g<? super T> gVar) {
            this.f32291h = false;
            this.f32290g = gVar;
        }
    }

    public h2(wj.o<? super T, Boolean> oVar) {
        this.f32287b = oVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        b bVar = new b(this, gVar, null);
        gVar.b(bVar);
        gVar.f(new a(bVar));
        return bVar;
    }
}
