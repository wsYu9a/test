package rx.n;

import java.util.concurrent.TimeUnit;
import rx.d;

/* loaded from: classes5.dex */
public final class d extends rx.d {

    /* renamed from: a */
    private static final d f36949a = new d();

    d() {
    }

    static d c() {
        return f36949a;
    }

    @Override // rx.d
    public d.a a() {
        return new b();
    }

    private class b extends d.a implements rx.h {

        /* renamed from: a */
        final rx.p.a f36950a;

        private b() {
            this.f36950a = new rx.p.a();
        }

        @Override // rx.d.a
        public rx.h d(rx.k.a aVar) {
            aVar.call();
            return rx.p.f.e();
        }

        @Override // rx.d.a
        public rx.h e(rx.k.a aVar, long j2, TimeUnit timeUnit) {
            return d(new g(aVar, this, d.this.b() + timeUnit.toMillis(j2)));
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f36950a.isUnsubscribed();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f36950a.unsubscribe();
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }
}
