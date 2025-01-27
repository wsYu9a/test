package xj;

import qj.d;
import xj.m2;

/* loaded from: classes5.dex */
public class n2<T, U, V> extends m2<T> {

    public class a implements m2.b<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.n f32474b;

        /* renamed from: xj.n2$a$a */
        public class C0830a extends qj.g<U> {

            /* renamed from: g */
            public final /* synthetic */ m2.d f32475g;

            /* renamed from: h */
            public final /* synthetic */ Long f32476h;

            public C0830a(m2.d dVar, Long l10) {
                this.f32475g = dVar;
                this.f32476h = l10;
            }

            @Override // qj.b
            public void onCompleted() {
                this.f32475g.g(this.f32476h.longValue());
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                this.f32475g.onError(th2);
            }

            @Override // qj.b
            public void onNext(U u10) {
                this.f32475g.g(this.f32476h.longValue());
            }
        }

        public a(wj.n nVar) {
            this.f32474b = nVar;
        }

        @Override // wj.q
        public qj.h call(m2.d<T> dVar, Long l10, d.a aVar) {
            wj.n nVar = this.f32474b;
            if (nVar == null) {
                return ik.f.e();
            }
            try {
                return ((qj.a) nVar.call()).T4(new C0830a(dVar, l10));
            } catch (Throwable th2) {
                vj.a.e(th2);
                dVar.onError(th2);
                return ik.f.e();
            }
        }
    }

    public class b implements m2.c<T> {

        /* renamed from: b */
        public final /* synthetic */ wj.o f32478b;

        public class a extends qj.g<V> {

            /* renamed from: g */
            public final /* synthetic */ m2.d f32479g;

            /* renamed from: h */
            public final /* synthetic */ Long f32480h;

            public a(m2.d dVar, Long l10) {
                this.f32479g = dVar;
                this.f32480h = l10;
            }

            @Override // qj.b
            public void onCompleted() {
                this.f32479g.g(this.f32480h.longValue());
            }

            @Override // qj.b
            public void onError(Throwable th2) {
                this.f32479g.onError(th2);
            }

            @Override // qj.b
            public void onNext(V v10) {
                this.f32479g.g(this.f32480h.longValue());
            }
        }

        public b(wj.o oVar) {
            this.f32478b = oVar;
        }

        @Override // wj.r
        public /* bridge */ /* synthetic */ qj.h call(Object obj, Long l10, Object obj2, d.a aVar) {
            return call((m2.d<Long>) obj, l10, (Long) obj2, aVar);
        }

        public qj.h call(m2.d<T> dVar, Long l10, T t10, d.a aVar) {
            try {
                return ((qj.a) this.f32478b.call(t10)).T4(new a(dVar, l10));
            } catch (Throwable th2) {
                vj.a.e(th2);
                dVar.onError(th2);
                return ik.f.e();
            }
        }
    }

    public n2(wj.n<? extends qj.a<U>> nVar, wj.o<? super T, ? extends qj.a<V>> oVar, qj.a<? extends T> aVar) {
        super(new a(nVar), new b(oVar), aVar, gk.f.c());
    }

    @Override // xj.m2
    public /* bridge */ /* synthetic */ qj.g call(qj.g gVar) {
        return super.call(gVar);
    }
}
