package rx;

import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class d {

    public static abstract class a implements h {

        /* renamed from: rx.d$a$a */
        class C0843a implements rx.k.a {

            /* renamed from: a */
            long f35730a = 0;

            /* renamed from: b */
            final /* synthetic */ rx.p.c f35731b;

            /* renamed from: c */
            final /* synthetic */ rx.k.a f35732c;

            /* renamed from: d */
            final /* synthetic */ long f35733d;

            /* renamed from: e */
            final /* synthetic */ long f35734e;

            C0843a(rx.p.c cVar, rx.k.a aVar, long j2, long j3) {
                this.f35731b = cVar;
                this.f35732c = aVar;
                this.f35733d = j2;
                this.f35734e = j3;
            }

            @Override // rx.k.a
            public void call() {
                if (this.f35731b.isUnsubscribed()) {
                    return;
                }
                this.f35732c.call();
                long j2 = this.f35733d;
                long j3 = this.f35730a + 1;
                this.f35730a = j3;
                long j4 = j2 + (j3 * this.f35734e);
                rx.p.c cVar = this.f35731b;
                a aVar = a.this;
                cVar.b(aVar.e(this, j4 - TimeUnit.MILLISECONDS.toNanos(aVar.c()), TimeUnit.NANOSECONDS));
            }
        }

        public long c() {
            return System.currentTimeMillis();
        }

        public abstract h d(rx.k.a aVar);

        public abstract h e(rx.k.a aVar, long j2, TimeUnit timeUnit);

        public h f(rx.k.a aVar, long j2, long j3, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j3);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(c()) + timeUnit.toNanos(j2);
            rx.p.c cVar = new rx.p.c();
            C0843a c0843a = new C0843a(cVar, aVar, nanos2, nanos);
            rx.p.c cVar2 = new rx.p.c();
            cVar.b(cVar2);
            cVar2.b(e(c0843a, j2, timeUnit));
            return cVar;
        }
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }
}
