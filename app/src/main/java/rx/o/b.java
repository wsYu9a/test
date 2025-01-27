package rx.o;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.a;
import rx.internal.operators.NotificationLite;
import rx.o.g;

/* loaded from: classes5.dex */
public final class b<T> extends f<T, T> {

    /* renamed from: d */
    private final g<T> f36994d;

    /* renamed from: e */
    private final NotificationLite<T> f36995e;

    static class a implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f36996a;

        a(g gVar) {
            this.f36996a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f36996a.c(), this.f36996a.f37045i);
        }
    }

    protected b(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f36995e = NotificationLite.f();
        this.f36994d = gVar;
    }

    public static <T> b<T> F5() {
        return H5(null, false);
    }

    public static <T> b<T> G5(T t) {
        return H5(t, true);
    }

    private static <T> b<T> H5(T t, boolean z) {
        g gVar = new g();
        if (z) {
            gVar.g(NotificationLite.f().l(t));
        }
        a aVar = new a(gVar);
        gVar.f37043g = aVar;
        gVar.f37044h = aVar;
        return new b<>(gVar, gVar);
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean A5() {
        return this.f36995e.g(this.f36994d.c());
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f36994d.e().length > 0;
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean C5() {
        return this.f36995e.h(this.f36994d.c());
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean D5() {
        return this.f36995e.i(this.f36994d.c());
    }

    int I5() {
        return this.f36994d.e().length;
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f36994d.c() == null || this.f36994d.f37041e) {
            Object b2 = this.f36995e.b();
            for (g.c<T> cVar : this.f36994d.h(b2)) {
                cVar.d(b2, this.f36994d.f37045i);
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        if (this.f36994d.c() == null || this.f36994d.f37041e) {
            Object c2 = this.f36995e.c(th);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f36994d.h(c2)) {
                try {
                    cVar.d(c2, this.f36994d.f37045i);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.b
    public void onNext(T t) {
        if (this.f36994d.c() == null || this.f36994d.f37041e) {
            Object l = this.f36995e.l(t);
            for (g.c<T> cVar : this.f36994d.d(l)) {
                cVar.d(l, this.f36994d.f37045i);
            }
        }
    }

    @Override // rx.o.f
    @rx.j.b
    public Throwable w5() {
        Object c2 = this.f36994d.c();
        if (this.f36995e.h(c2)) {
            return this.f36995e.d(c2);
        }
        return null;
    }

    @Override // rx.o.f
    @rx.j.b
    public T x5() {
        Object c2 = this.f36994d.c();
        if (this.f36995e.i(c2)) {
            return this.f36995e.e(c2);
        }
        return null;
    }

    @Override // rx.o.f
    @rx.j.b
    public T[] z5(T[] tArr) {
        Object c2 = this.f36994d.c();
        if (this.f36995e.i(c2)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = this.f36995e.e(c2);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
