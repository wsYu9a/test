package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class m<T> implements a.m0<T> {

    /* renamed from: a */
    final rx.a<? extends T> f36239a;

    /* renamed from: b */
    final long f36240b;

    /* renamed from: c */
    final TimeUnit f36241c;

    /* renamed from: d */
    final rx.d f36242d;

    class a implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.g f36243a;

        a(rx.g gVar) {
            this.f36243a = gVar;
        }

        @Override // rx.k.a
        public void call() {
            if (this.f36243a.isUnsubscribed()) {
                return;
            }
            m.this.f36239a.T4(rx.l.e.f(this.f36243a));
        }
    }

    public m(rx.a<? extends T> aVar, long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36239a = aVar;
        this.f36240b = j2;
        this.f36241c = timeUnit;
        this.f36242d = dVar;
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        d.a a2 = this.f36242d.a();
        gVar.b(a2);
        a2.e(new a(gVar), this.f36240b, this.f36241c);
    }
}
