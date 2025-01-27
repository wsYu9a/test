package hk;

import hk.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class b<T> extends f<T, T> {

    /* renamed from: e */
    public final g<T> f26742e;

    /* renamed from: f */
    public final NotificationLite<T> f26743f;

    public static class a implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26744b;

        public a(g gVar) {
            this.f26744b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f26744b.c(), this.f26744b.f26793h);
        }
    }

    public b(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f26743f = NotificationLite.f();
        this.f26742e = gVar;
    }

    public static <T> b<T> F5() {
        return H5(null, false);
    }

    public static <T> b<T> G5(T t10) {
        return H5(t10, true);
    }

    public static <T> b<T> H5(T t10, boolean z10) {
        g gVar = new g();
        if (z10) {
            gVar.g(NotificationLite.f().l(t10));
        }
        a aVar = new a(gVar);
        gVar.f26791f = aVar;
        gVar.f26792g = aVar;
        return new b<>(gVar, gVar);
    }

    @Override // hk.f
    @uj.b
    public boolean A5() {
        return this.f26743f.g(this.f26742e.c());
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26742e.e().length > 0;
    }

    @Override // hk.f
    @uj.b
    public boolean C5() {
        return this.f26743f.h(this.f26742e.c());
    }

    @Override // hk.f
    @uj.b
    public boolean D5() {
        return this.f26743f.i(this.f26742e.c());
    }

    public int I5() {
        return this.f26742e.e().length;
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f26742e.c() == null || this.f26742e.f26789d) {
            Object b10 = this.f26743f.b();
            for (g.c<T> cVar : this.f26742e.h(b10)) {
                cVar.d(b10, this.f26742e.f26793h);
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        if (this.f26742e.c() == null || this.f26742e.f26789d) {
            Object c10 = this.f26743f.c(th2);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f26742e.h(c10)) {
                try {
                    cVar.d(c10, this.f26742e.f26793h);
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
        if (this.f26742e.c() == null || this.f26742e.f26789d) {
            Object l10 = this.f26743f.l(t10);
            for (g.c<T> cVar : this.f26742e.d(l10)) {
                cVar.d(l10, this.f26742e.f26793h);
            }
        }
    }

    @Override // hk.f
    @uj.b
    public Throwable w5() {
        Object c10 = this.f26742e.c();
        if (this.f26743f.h(c10)) {
            return this.f26743f.d(c10);
        }
        return null;
    }

    @Override // hk.f
    @uj.b
    public T x5() {
        Object c10 = this.f26742e.c();
        if (this.f26743f.i(c10)) {
            return this.f26743f.e(c10);
        }
        return null;
    }

    @Override // hk.f
    @uj.b
    public T[] z5(T[] tArr) {
        Object c10 = this.f26742e.c();
        if (this.f26743f.i(c10)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = this.f26743f.e(c10);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
