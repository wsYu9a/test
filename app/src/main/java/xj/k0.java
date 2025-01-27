package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class k0<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.a<? extends T> f32375b;

    /* renamed from: c */
    public final long f32376c;

    /* renamed from: d */
    public final TimeUnit f32377d;

    /* renamed from: e */
    public final qj.d f32378e;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public boolean f32379g;

        /* renamed from: h */
        public final /* synthetic */ d.a f32380h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32381i;

        /* renamed from: xj.k0$a$a */
        public class C0825a implements wj.a {
            public C0825a() {
            }

            @Override // wj.a
            public void call() {
                a aVar = a.this;
                if (aVar.f32379g) {
                    return;
                }
                aVar.f32379g = true;
                aVar.f32381i.onCompleted();
            }
        }

        public class b implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ Throwable f32384b;

            public b(Throwable th2) {
                this.f32384b = th2;
            }

            @Override // wj.a
            public void call() {
                a aVar = a.this;
                if (aVar.f32379g) {
                    return;
                }
                aVar.f32379g = true;
                aVar.f32381i.onError(this.f32384b);
                a.this.f32380h.unsubscribe();
            }
        }

        public class c implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ Object f32386b;

            public c(Object obj) {
                this.f32386b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // wj.a
            public void call() {
                a aVar = a.this;
                if (aVar.f32379g) {
                    return;
                }
                aVar.f32381i.onNext(this.f32386b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, d.a aVar, qj.g gVar2) {
            super(gVar);
            this.f32380h = aVar;
            this.f32381i = gVar2;
        }

        @Override // qj.b
        public void onCompleted() {
            d.a aVar = this.f32380h;
            C0825a c0825a = new C0825a();
            k0 k0Var = k0.this;
            aVar.c(c0825a, k0Var.f32376c, k0Var.f32377d);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32380h.b(new b(th2));
        }

        @Override // qj.b
        public void onNext(T t10) {
            d.a aVar = this.f32380h;
            c cVar = new c(t10);
            k0 k0Var = k0.this;
            aVar.c(cVar, k0Var.f32376c, k0Var.f32377d);
        }
    }

    public k0(qj.a<? extends T> aVar, long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32375b = aVar;
        this.f32376c = j10;
        this.f32377d = timeUnit;
        this.f32378e = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32378e.a();
        gVar.b(a10);
        return new a(gVar, a10, gVar);
    }
}
