package dk;

import qj.a;
import qj.h;
import wj.m;
import xj.i;
import xj.u;

/* loaded from: classes5.dex */
public abstract class b<T> extends qj.a<T> {

    public class a implements wj.b<h> {

        /* renamed from: b */
        public final /* synthetic */ h[] f25572b;

        public a(h[] hVarArr) {
            this.f25572b = hVarArr;
        }

        @Override // wj.b
        public void call(h hVar) {
            this.f25572b[0] = hVar;
        }
    }

    public b(a.m0<T> m0Var) {
        super(m0Var);
    }

    public abstract void A5(wj.b<? super h> bVar);

    public qj.a<T> B5() {
        return qj.a.b0(new u(this));
    }

    @uj.b
    public qj.a<T> w5() {
        return x5(1);
    }

    @uj.b
    public qj.a<T> x5(int i10) {
        return y5(i10, m.a());
    }

    @uj.b
    public qj.a<T> y5(int i10, wj.b<? super h> bVar) {
        if (i10 > 0) {
            return qj.a.b0(new i(this, i10, bVar));
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
