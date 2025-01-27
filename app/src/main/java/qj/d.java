package qj;

import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class d {

    public static abstract class a implements h {

        /* renamed from: qj.d$a$a */
        public class C0777a implements wj.a {

            /* renamed from: b */
            public long f30168b = 0;

            /* renamed from: c */
            public final /* synthetic */ ik.c f30169c;

            /* renamed from: d */
            public final /* synthetic */ wj.a f30170d;

            /* renamed from: e */
            public final /* synthetic */ long f30171e;

            /* renamed from: f */
            public final /* synthetic */ long f30172f;

            public C0777a(ik.c cVar, wj.a aVar, long j10, long j11) {
                this.f30169c = cVar;
                this.f30170d = aVar;
                this.f30171e = j10;
                this.f30172f = j11;
            }

            @Override // wj.a
            public void call() {
                if (this.f30169c.isUnsubscribed()) {
                    return;
                }
                this.f30170d.call();
                long j10 = this.f30171e;
                long j11 = this.f30168b + 1;
                this.f30168b = j11;
                long j12 = j10 + (j11 * this.f30172f);
                ik.c cVar = this.f30169c;
                a aVar = a.this;
                cVar.b(aVar.c(this, j12 - TimeUnit.MILLISECONDS.toNanos(aVar.a()), TimeUnit.NANOSECONDS));
            }
        }

        public long a() {
            return System.currentTimeMillis();
        }

        public abstract h b(wj.a aVar);

        public abstract h c(wj.a aVar, long j10, TimeUnit timeUnit);

        public h d(wj.a aVar, long j10, long j11, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j11);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(a()) + timeUnit.toNanos(j10);
            ik.c cVar = new ik.c();
            C0777a c0777a = new C0777a(cVar, aVar, nanos2, nanos);
            ik.c cVar2 = new ik.c();
            cVar.b(cVar2);
            cVar2.b(c(c0777a, j10, timeUnit));
            return cVar;
        }
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }
}
