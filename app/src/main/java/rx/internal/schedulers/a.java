package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.h;
import rx.internal.util.f;
import rx.internal.util.i;

/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: a */
    private static final String f36733a = "RxComputationThreadPool-";

    /* renamed from: b */
    private static final f f36734b = new f(f36733a);

    /* renamed from: c */
    static final String f36735c = "rx.scheduler.max-computation-threads";

    /* renamed from: d */
    static final int f36736d;

    /* renamed from: e */
    final b f36737e = new b();

    /* renamed from: rx.internal.schedulers.a$a */
    private static class C0882a extends d.a {

        /* renamed from: a */
        private final i f36738a;

        /* renamed from: b */
        private final rx.p.b f36739b;

        /* renamed from: c */
        private final i f36740c;

        /* renamed from: d */
        private final c f36741d;

        C0882a(c cVar) {
            i iVar = new i();
            this.f36738a = iVar;
            rx.p.b bVar = new rx.p.b();
            this.f36739b = bVar;
            this.f36740c = new i(iVar, bVar);
            this.f36741d = cVar;
        }

        @Override // rx.d.a
        public h d(rx.k.a aVar) {
            return isUnsubscribed() ? rx.p.f.e() : this.f36741d.k(aVar, 0L, null, this.f36738a);
        }

        @Override // rx.d.a
        public h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.p.f.e() : this.f36741d.l(aVar, j2, timeUnit, this.f36739b);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36740c.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36740c.unsubscribe();
        }
    }

    static final class b {

        /* renamed from: a */
        final int f36742a;

        /* renamed from: b */
        final c[] f36743b;

        /* renamed from: c */
        long f36744c;

        b() {
            int i2 = a.f36736d;
            this.f36742a = i2;
            this.f36743b = new c[i2];
            for (int i3 = 0; i3 < this.f36742a; i3++) {
                this.f36743b[i3] = new c(a.f36734b);
            }
        }

        public c a() {
            c[] cVarArr = this.f36743b;
            long j2 = this.f36744c;
            this.f36744c = 1 + j2;
            return cVarArr[(int) (j2 % this.f36742a)];
        }
    }

    private static final class c extends rx.internal.schedulers.b {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger(f36735c, 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f36736d = intValue;
    }

    @Override // rx.d
    public d.a a() {
        return new C0882a(this.f36737e.a());
    }

    public h d(rx.k.a aVar) {
        return this.f36737e.a().j(aVar, -1L, TimeUnit.NANOSECONDS);
    }
}
