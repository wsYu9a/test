package rx.o;

import java.util.ArrayList;
import rx.a;
import rx.internal.operators.NotificationLite;
import rx.o.g;

/* loaded from: classes5.dex */
public final class c<T> extends f<T, T> {

    /* renamed from: d */
    final g<T> f36997d;

    /* renamed from: e */
    private final NotificationLite<T> f36998e;

    static class a implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f36999a;

        a(g gVar) {
            this.f36999a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            cVar.b(this.f36999a.c(), this.f36999a.f37045i);
        }
    }

    protected c(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f36998e = NotificationLite.f();
        this.f36997d = gVar;
    }

    public static <T> c<T> F5() {
        g gVar = new g();
        gVar.f37044h = new a(gVar);
        return new c<>(gVar, gVar);
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean A5() {
        Object c2 = this.f36997d.c();
        return (c2 == null || this.f36998e.h(c2)) ? false : true;
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f36997d.e().length > 0;
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean C5() {
        return this.f36998e.h(this.f36997d.c());
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean D5() {
        return false;
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f36997d.f37041e) {
            Object b2 = this.f36998e.b();
            for (g.c<T> cVar : this.f36997d.h(b2)) {
                cVar.d(b2, this.f36997d.f37045i);
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        if (this.f36997d.f37041e) {
            Object c2 = this.f36998e.c(th);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f36997d.h(c2)) {
                try {
                    cVar.d(c2, this.f36997d.f37045i);
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
        for (g.c<T> cVar : this.f36997d.e()) {
            cVar.onNext(t);
        }
    }

    @Override // rx.o.f
    @rx.j.b
    public Throwable w5() {
        Object c2 = this.f36997d.c();
        if (this.f36998e.h(c2)) {
            return this.f36998e.d(c2);
        }
        return null;
    }

    @Override // rx.o.f
    @rx.j.b
    public T x5() {
        return null;
    }

    @Override // rx.o.f
    @rx.j.b
    public Object[] y5() {
        return new Object[0];
    }

    @Override // rx.o.f
    @rx.j.b
    public T[] z5(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
