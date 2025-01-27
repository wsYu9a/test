package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class f2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32223b;

    /* renamed from: c */
    public final TimeUnit f32224c;

    /* renamed from: d */
    public final qj.d f32225d;

    public static final class a<T> extends qj.g<T> implements wj.a {

        /* renamed from: g */
        public final qj.g<? super T> f32226g;

        public a(qj.g<? super T> gVar) {
            super(gVar);
            this.f32226g = gVar;
        }

        @Override // wj.a
        public void call() {
            onCompleted();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32226g.onCompleted();
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32226g.onError(th2);
            unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32226g.onNext(t10);
        }
    }

    public f2(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32223b = j10;
        this.f32224c = timeUnit;
        this.f32225d = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32225d.a();
        gVar.b(a10);
        a aVar = new a(new ek.d(gVar));
        a10.c(aVar, this.f32223b, this.f32224c);
        return aVar;
    }
}
