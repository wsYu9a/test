package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.internal.operators.m2;

/* loaded from: classes5.dex */
public final class l2<T> extends m2<T> {

    class a implements m2.b<T> {

        /* renamed from: a */
        final /* synthetic */ long f36229a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f36230b;

        /* renamed from: rx.internal.operators.l2$a$a */
        class C0865a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ m2.d f36231a;

            /* renamed from: b */
            final /* synthetic */ Long f36232b;

            C0865a(m2.d dVar, Long l) {
                this.f36231a = dVar;
                this.f36232b = l;
            }

            @Override // rx.k.a
            public void call() {
                this.f36231a.g(this.f36232b.longValue());
            }
        }

        a(long j2, TimeUnit timeUnit) {
            this.f36229a = j2;
            this.f36230b = timeUnit;
        }

        @Override // rx.k.q
        public rx.h call(m2.d<T> dVar, Long l, d.a aVar) {
            return aVar.e(new C0865a(dVar, l), this.f36229a, this.f36230b);
        }
    }

    class b implements m2.c<T> {

        /* renamed from: a */
        final /* synthetic */ long f36234a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f36235b;

        class a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ m2.d f36236a;

            /* renamed from: b */
            final /* synthetic */ Long f36237b;

            a(m2.d dVar, Long l) {
                this.f36236a = dVar;
                this.f36237b = l;
            }

            @Override // rx.k.a
            public void call() {
                this.f36236a.g(this.f36237b.longValue());
            }
        }

        b(long j2, TimeUnit timeUnit) {
            this.f36234a = j2;
            this.f36235b = timeUnit;
        }

        @Override // rx.k.r
        public /* bridge */ /* synthetic */ rx.h call(Object obj, Long l, Object obj2, d.a aVar) {
            return call((m2.d<Long>) obj, l, (Long) obj2, aVar);
        }

        public rx.h call(m2.d<T> dVar, Long l, T t, d.a aVar) {
            return aVar.e(new a(dVar, l), this.f36234a, this.f36235b);
        }
    }

    public l2(long j2, TimeUnit timeUnit, rx.a<? extends T> aVar, rx.d dVar) {
        super(new a(j2, timeUnit), new b(j2, timeUnit), aVar, dVar);
    }

    @Override // rx.internal.operators.m2
    public /* bridge */ /* synthetic */ rx.g call(rx.g gVar) {
        return super.call(gVar);
    }
}
