package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class w implements a.m0<Long> {

    /* renamed from: a */
    final long f36568a;

    /* renamed from: b */
    final TimeUnit f36569b;

    /* renamed from: c */
    final rx.d f36570c;

    class a implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.g f36571a;

        a(rx.g gVar) {
            this.f36571a = gVar;
        }

        @Override // rx.k.a
        public void call() {
            try {
                this.f36571a.onNext(0L);
                this.f36571a.onCompleted();
            } catch (Throwable th) {
                this.f36571a.onError(th);
            }
        }
    }

    public w(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36568a = j2;
        this.f36569b = timeUnit;
        this.f36570c = dVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super Long> gVar) {
        d.a a2 = this.f36570c.a();
        gVar.b(a2);
        a2.e(new a(gVar), this.f36568a, this.f36569b);
    }
}
