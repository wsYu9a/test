package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class x implements a.m0<Long> {

    /* renamed from: a */
    final long f36602a;

    /* renamed from: b */
    final long f36603b;

    /* renamed from: c */
    final TimeUnit f36604c;

    /* renamed from: d */
    final rx.d f36605d;

    class a implements rx.k.a {

        /* renamed from: a */
        long f36606a;

        /* renamed from: b */
        final /* synthetic */ rx.g f36607b;

        /* renamed from: c */
        final /* synthetic */ d.a f36608c;

        a(rx.g gVar, d.a aVar) {
            this.f36607b = gVar;
            this.f36608c = aVar;
        }

        @Override // rx.k.a
        public void call() {
            try {
                rx.g gVar = this.f36607b;
                long j2 = this.f36606a;
                this.f36606a = 1 + j2;
                gVar.onNext(Long.valueOf(j2));
            } catch (Throwable th) {
                try {
                    this.f36607b.onError(th);
                } finally {
                    this.f36608c.unsubscribe();
                }
            }
        }
    }

    public x(long j2, long j3, TimeUnit timeUnit, rx.d dVar) {
        this.f36602a = j2;
        this.f36603b = j3;
        this.f36604c = timeUnit;
        this.f36605d = dVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super Long> gVar) {
        d.a a2 = this.f36605d.a();
        gVar.b(a2);
        a2.f(new a(gVar, a2), this.f36602a, this.f36603b, this.f36604c);
    }
}
