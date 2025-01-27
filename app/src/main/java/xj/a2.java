package xj;

import qj.a;

/* loaded from: classes5.dex */
public final class a2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32031b;

    public static final class a<T> extends qj.g<T> {

        /* renamed from: g */
        public final yj.a f32032g;

        /* renamed from: h */
        public final qj.g<? super T> f32033h;

        public a(qj.g<? super T> gVar, yj.a aVar) {
            this.f32033h = gVar;
            this.f32032g = aVar;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32032g.c(cVar);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32033h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32033h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32033h.onNext(t10);
            this.f32032g.b(1L);
        }
    }

    public static final class b<T> extends qj.g<T> {

        /* renamed from: g */
        public boolean f32034g = true;

        /* renamed from: h */
        public final qj.g<? super T> f32035h;

        /* renamed from: i */
        public final ik.e f32036i;

        /* renamed from: j */
        public final yj.a f32037j;

        /* renamed from: k */
        public final qj.a<? extends T> f32038k;

        public b(qj.g<? super T> gVar, ik.e eVar, yj.a aVar, qj.a<? extends T> aVar2) {
            this.f32035h = gVar;
            this.f32036i = eVar;
            this.f32037j = aVar;
            this.f32038k = aVar2;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32037j.c(cVar);
        }

        public final void g() {
            a aVar = new a(this.f32035h, this.f32037j);
            this.f32036i.b(aVar);
            this.f32038k.T4(aVar);
        }

        @Override // qj.b
        public void onCompleted() {
            if (!this.f32034g) {
                this.f32035h.onCompleted();
            } else {
                if (this.f32035h.isUnsubscribed()) {
                    return;
                }
                g();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32035h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32034g = false;
            this.f32035h.onNext(t10);
            this.f32037j.b(1L);
        }
    }

    public a2(qj.a<? extends T> aVar) {
        this.f32031b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ik.e eVar = new ik.e();
        yj.a aVar = new yj.a();
        b bVar = new b(gVar, eVar, aVar, this.f32031b);
        eVar.b(bVar);
        gVar.b(eVar);
        gVar.f(aVar);
        return bVar;
    }
}
