package rx.observables;

import rx.a;
import rx.h;
import rx.internal.operators.i;
import rx.internal.operators.u;
import rx.k.m;

/* loaded from: classes5.dex */
public abstract class b<T> extends rx.a<T> {

    class a implements rx.k.b<h> {

        /* renamed from: a */
        final /* synthetic */ h[] f37093a;

        a(h[] hVarArr) {
            this.f37093a = hVarArr;
        }

        @Override // rx.k.b
        public void call(h hVar) {
            this.f37093a[0] = hVar;
        }
    }

    protected b(a.m0<T> m0Var) {
        super(m0Var);
    }

    public abstract void A5(rx.k.b<? super h> bVar);

    public rx.a<T> B5() {
        return rx.a.b0(new u(this));
    }

    @rx.j.b
    public rx.a<T> w5() {
        return x5(1);
    }

    @rx.j.b
    public rx.a<T> x5(int i2) {
        return y5(i2, m.a());
    }

    @rx.j.b
    public rx.a<T> y5(int i2, rx.k.b<? super h> bVar) {
        if (i2 > 0) {
            return rx.a.b0(new i(this, i2, bVar));
        }
        A5(bVar);
        return this;
    }

    public final h z5() {
        h[] hVarArr = new h[1];
        A5(new a(hVarArr));
        return hVarArr[0];
    }
}
