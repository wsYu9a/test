package xj;

import qj.a;

/* loaded from: classes5.dex */
public class q0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final wj.b<Long> f32573b;

    public class a implements qj.c {

        /* renamed from: b */
        public final /* synthetic */ b f32574b;

        public a(b bVar) {
            this.f32574b = bVar;
        }

        @Override // qj.c
        public void request(long j10) {
            q0.this.f32573b.call(Long.valueOf(j10));
            this.f32574b.h(j10);
        }
    }

    public static final class b<T> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super T> f32576g;

        public /* synthetic */ b(qj.g gVar, a aVar) {
            this(gVar);
        }

        public void h(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32576g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32576g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32576g.onNext(t10);
        }

        public b(qj.g<? super T> gVar) {
            this.f32576g = gVar;
        }
    }

    public q0(wj.b<Long> bVar) {
        this.f32573b = bVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        b bVar = new b(gVar, null);
        gVar.f(new a(bVar));
        gVar.b(bVar);
        return bVar;
    }
}
