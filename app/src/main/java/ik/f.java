package ik;

import java.util.concurrent.Future;
import qj.h;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a */
    public static final c f27048a = new c();

    public static final class b implements h {

        /* renamed from: b */
        public final Future<?> f27049b;

        public b(Future<?> future) {
            this.f27049b = future;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f27049b.isCancelled();
        }

        @Override // qj.h
        public void unsubscribe() {
            this.f27049b.cancel(true);
        }
    }

    public static final class c implements h {
        public c() {
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return true;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // qj.h
        public void unsubscribe() {
        }
    }

    public f() {
        throw new IllegalStateException("No instances!");
    }

    public static h a(wj.a aVar) {
        return ik.a.b(aVar);
    }

    public static h b() {
        return ik.a.a();
    }

    public static ik.b c(h... hVarArr) {
        return new ik.b(hVarArr);
    }

    public static h d(Future<?> future) {
        return new b(future);
    }

    @uj.b
    public static h e() {
        return f27048a;
    }
}
