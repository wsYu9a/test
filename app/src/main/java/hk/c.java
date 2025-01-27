package hk;

import hk.g;
import java.util.ArrayList;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class c<T> extends f<T, T> {

    /* renamed from: e */
    public final g<T> f26745e;

    /* renamed from: f */
    public final NotificationLite<T> f26746f;

    public static class a implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26747b;

        public a(g gVar) {
            this.f26747b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f26747b.c(), this.f26747b.f26793h);
        }
    }

    public c(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f26746f = NotificationLite.f();
        this.f26745e = gVar;
    }

    public static <T> c<T> F5() {
        g gVar = new g();
        gVar.f26792g = new a(gVar);
        return new c<>(gVar, gVar);
    }

    @Override // hk.f
    @uj.b
    public boolean A5() {
        Object c10 = this.f26745e.c();
        return (c10 == null || this.f26746f.h(c10)) ? false : true;
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26745e.e().length > 0;
    }

    @Override // hk.f
    @uj.b
    public boolean C5() {
        return this.f26746f.h(this.f26745e.c());
    }

    @Override // hk.f
    @uj.b
    public boolean D5() {
        return false;
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f26745e.f26789d) {
            Object b10 = this.f26746f.b();
            for (g.c<T> cVar : this.f26745e.h(b10)) {
                cVar.d(b10, this.f26745e.f26793h);
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        if (this.f26745e.f26789d) {
            Object c10 = this.f26746f.c(th2);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f26745e.h(c10)) {
                try {
                    cVar.d(c10, this.f26745e.f26793h);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th3);
                }
            }
            vj.a.d(arrayList);
        }
    }

    @Override // qj.b
    public void onNext(T t10) {
        for (g.c<T> cVar : this.f26745e.e()) {
            cVar.onNext(t10);
        }
    }

    @Override // hk.f
    @uj.b
    public Throwable w5() {
        Object c10 = this.f26745e.c();
        if (this.f26746f.h(c10)) {
            return this.f26746f.d(c10);
        }
        return null;
    }

    @Override // hk.f
    @uj.b
    public T x5() {
        return null;
    }

    @Override // hk.f
    @uj.b
    public Object[] y5() {
        return new Object[0];
    }

    @Override // hk.f
    @uj.b
    public T[] z5(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
