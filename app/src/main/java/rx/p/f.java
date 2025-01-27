package rx.p;

import java.util.concurrent.Future;
import rx.h;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a */
    private static final c f37119a = new c();

    private static final class b implements h {

        /* renamed from: a */
        final Future<?> f37120a;

        public b(Future<?> future) {
            this.f37120a = future;
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return this.f37120a.isCancelled();
        }

        @Override // rx.h
        public void unsubscribe() {
            this.f37120a.cancel(true);
        }
    }

    private static final class c implements h {
        private c() {
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.h
        public void unsubscribe() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }

    public static h a(rx.k.a aVar) {
        return rx.p.a.b(aVar);
    }

    public static h b() {
        return rx.p.a.a();
    }

    public static h c(Future<?> future) {
        return new b(future);
    }

    public static rx.p.b d(h... hVarArr) {
        return new rx.p.b(hVarArr);
    }

    @rx.j.b
    public static h e() {
        return f37119a;
    }
}
