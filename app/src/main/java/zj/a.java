package zj;

import ak.f;
import ak.i;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import qj.d;
import qj.h;

/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: b */
    public static final String f33847b = "RxComputationThreadPool-";

    /* renamed from: c */
    public static final f f33848c = new f(f33847b);

    /* renamed from: d */
    public static final String f33849d = "rx.scheduler.max-computation-threads";

    /* renamed from: e */
    public static final int f33850e;

    /* renamed from: a */
    public final b f33851a = new b();

    /* renamed from: zj.a$a */
    public static class C0855a extends d.a {

        /* renamed from: b */
        public final i f33852b;

        /* renamed from: c */
        public final ik.b f33853c;

        /* renamed from: d */
        public final i f33854d;

        /* renamed from: e */
        public final c f33855e;

        public C0855a(c cVar) {
            i iVar = new i();
            this.f33852b = iVar;
            ik.b bVar = new ik.b();
            this.f33853c = bVar;
            this.f33854d = new i(iVar, bVar);
            this.f33855e = cVar;
        }

        @Override // qj.d.a
        public h b(wj.a aVar) {
            return isUnsubscribed() ? ik.f.e() : this.f33855e.i(aVar, 0L, null, this.f33852b);
        }

        @Override // qj.d.a
        public h c(wj.a aVar, long j10, TimeUnit timeUnit) {
            return isUnsubscribed() ? ik.f.e() : this.f33855e.j(aVar, j10, timeUnit, this.f33853c);
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f33854d.isUnsubscribed();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f33854d.unsubscribe();
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f33856a;

        /* renamed from: b */
        public final c[] f33857b;

        /* renamed from: c */
        public long f33858c;

        public b() {
            int i10 = a.f33850e;
            this.f33856a = i10;
            this.f33857b = new c[i10];
            for (int i11 = 0; i11 < this.f33856a; i11++) {
                this.f33857b[i11] = new c(a.f33848c);
            }
        }

        public c a() {
            c[] cVarArr = this.f33857b;
            long j10 = this.f33858c;
            this.f33858c = 1 + j10;
            return cVarArr[(int) (j10 % this.f33856a)];
        }
    }

    public static final class c extends zj.b {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger(f33849d, 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f33850e = intValue;
    }

    @Override // qj.d
    public d.a a() {
        return new C0855a(this.f33851a.a());
    }

    public h d(wj.a aVar) {
        return this.f33851a.a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }
}
