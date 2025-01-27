package xj;

import java.util.concurrent.TimeUnit;
import qj.d;
import xj.m2;

/* loaded from: classes5.dex */
public final class l2<T> extends m2<T> {

    public class a implements m2.b<T> {

        /* renamed from: b */
        public final /* synthetic */ long f32415b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f32416c;

        /* renamed from: xj.l2$a$a */
        public class C0829a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ m2.d f32417b;

            /* renamed from: c */
            public final /* synthetic */ Long f32418c;

            public C0829a(m2.d dVar, Long l10) {
                this.f32417b = dVar;
                this.f32418c = l10;
            }

            @Override // wj.a
            public void call() {
                this.f32417b.g(this.f32418c.longValue());
            }
        }

        public a(long j10, TimeUnit timeUnit) {
            this.f32415b = j10;
            this.f32416c = timeUnit;
        }

        @Override // wj.q
        public qj.h call(m2.d<T> dVar, Long l10, d.a aVar) {
            return aVar.c(new C0829a(dVar, l10), this.f32415b, this.f32416c);
        }
    }

    public class b implements m2.c<T> {

        /* renamed from: b */
        public final /* synthetic */ long f32420b;

        /* renamed from: c */
        public final /* synthetic */ TimeUnit f32421c;

        public class a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ m2.d f32422b;

            /* renamed from: c */
            public final /* synthetic */ Long f32423c;

            public a(m2.d dVar, Long l10) {
                this.f32422b = dVar;
                this.f32423c = l10;
            }

            @Override // wj.a
            public void call() {
                this.f32422b.g(this.f32423c.longValue());
            }
        }

        public b(long j10, TimeUnit timeUnit) {
            this.f32420b = j10;
            this.f32421c = timeUnit;
        }

        @Override // wj.r
        public /* bridge */ /* synthetic */ qj.h call(Object obj, Long l10, Object obj2, d.a aVar) {
            return call((m2.d<Long>) obj, l10, (Long) obj2, aVar);
        }

        public qj.h call(m2.d<T> dVar, Long l10, T t10, d.a aVar) {
            return aVar.c(new a(dVar, l10), this.f32420b, this.f32421c);
        }
    }

    public l2(long j10, TimeUnit timeUnit, qj.a<? extends T> aVar, qj.d dVar) {
        super(new a(j10, timeUnit), new b(j10, timeUnit), aVar, dVar);
    }

    @Override // xj.m2
    public /* bridge */ /* synthetic */ qj.g call(qj.g gVar) {
        return super.call(gVar);
    }
}
