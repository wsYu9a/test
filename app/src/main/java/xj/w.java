package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class w implements a.m0<Long> {

    /* renamed from: b */
    public final long f32780b;

    /* renamed from: c */
    public final TimeUnit f32781c;

    /* renamed from: d */
    public final qj.d f32782d;

    public class a implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ qj.g f32783b;

        public a(qj.g gVar) {
            this.f32783b = gVar;
        }

        @Override // wj.a
        public void call() {
            try {
                this.f32783b.onNext(0L);
                this.f32783b.onCompleted();
            } catch (Throwable th2) {
                this.f32783b.onError(th2);
            }
        }
    }

    public w(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32780b = j10;
        this.f32781c = timeUnit;
        this.f32782d = dVar;
    }

    @Override // wj.b
    public void call(qj.g<? super Long> gVar) {
        d.a a10 = this.f32782d.a();
        gVar.b(a10);
        a10.c(new a(gVar), this.f32780b, this.f32781c);
    }
}
