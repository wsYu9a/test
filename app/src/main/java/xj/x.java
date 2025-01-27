package xj;

import java.util.concurrent.TimeUnit;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class x implements a.m0<Long> {

    /* renamed from: b */
    public final long f32814b;

    /* renamed from: c */
    public final long f32815c;

    /* renamed from: d */
    public final TimeUnit f32816d;

    /* renamed from: e */
    public final qj.d f32817e;

    public class a implements wj.a {

        /* renamed from: b */
        public long f32818b;

        /* renamed from: c */
        public final /* synthetic */ qj.g f32819c;

        /* renamed from: d */
        public final /* synthetic */ d.a f32820d;

        public a(qj.g gVar, d.a aVar) {
            this.f32819c = gVar;
            this.f32820d = aVar;
        }

        @Override // wj.a
        public void call() {
            try {
                qj.g gVar = this.f32819c;
                long j10 = this.f32818b;
                this.f32818b = 1 + j10;
                gVar.onNext(Long.valueOf(j10));
            } catch (Throwable th2) {
                try {
                    this.f32819c.onError(th2);
                } finally {
                    this.f32820d.unsubscribe();
                }
            }
        }
    }

    public x(long j10, long j11, TimeUnit timeUnit, qj.d dVar) {
        this.f32814b = j10;
        this.f32815c = j11;
        this.f32816d = timeUnit;
        this.f32817e = dVar;
    }

    @Override // wj.b
    public void call(qj.g<? super Long> gVar) {
        d.a a10 = this.f32817e.a();
        gVar.b(a10);
        a10.d(new a(gVar, a10), this.f32814b, this.f32815c, this.f32816d);
    }
}
