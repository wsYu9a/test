package rx.o;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.a;
import rx.internal.operators.NotificationLite;
import rx.o.g;

/* loaded from: classes5.dex */
public final class a<T> extends f<T, T> {

    /* renamed from: d */
    final g<T> f36990d;

    /* renamed from: e */
    volatile Object f36991e;

    /* renamed from: f */
    private final NotificationLite<T> f36992f;

    /* renamed from: rx.o.a$a */
    static class C0891a implements rx.k.b<g.c<T>> {

        /* renamed from: a */
        final /* synthetic */ g f36993a;

        C0891a(g gVar) {
            this.f36993a = gVar;
        }

        @Override // rx.k.b
        public void call(g.c<T> cVar) {
            Object c2 = this.f36993a.c();
            NotificationLite<T> notificationLite = this.f36993a.f37045i;
            cVar.a(c2, notificationLite);
            if (c2 == null || !(notificationLite.g(c2) || notificationLite.h(c2))) {
                cVar.onCompleted();
            }
        }
    }

    protected a(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f36992f = NotificationLite.f();
        this.f36990d = gVar;
    }

    public static <T> a<T> F5() {
        g gVar = new g();
        gVar.f37044h = new C0891a(gVar);
        return new a<>(gVar, gVar);
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean A5() {
        Object c2 = this.f36990d.c();
        return (c2 == null || this.f36992f.h(c2)) ? false : true;
    }

    @Override // rx.o.f
    public boolean B5() {
        return this.f36990d.e().length > 0;
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean C5() {
        return this.f36992f.h(this.f36990d.c());
    }

    @Override // rx.o.f
    @rx.j.b
    public boolean D5() {
        return !this.f36992f.h(this.f36990d.c()) && this.f36992f.i(this.f36991e);
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f36990d.f37041e) {
            Object obj = this.f36991e;
            if (obj == null) {
                obj = this.f36992f.b();
            }
            for (rx.b bVar : this.f36990d.h(obj)) {
                if (obj == this.f36992f.b()) {
                    bVar.onCompleted();
                } else {
                    bVar.onNext(this.f36992f.e(obj));
                    bVar.onCompleted();
                }
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        if (this.f36990d.f37041e) {
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f36990d.h(this.f36992f.c(th))) {
                try {
                    cVar.onError(th);
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
        this.f36991e = this.f36992f.l(t);
    }

    @Override // rx.o.f
    @rx.j.b
    public Throwable w5() {
        Object c2 = this.f36990d.c();
        if (this.f36992f.h(c2)) {
            return this.f36992f.d(c2);
        }
        return null;
    }

    @Override // rx.o.f
    @rx.j.b
    public T x5() {
        Object obj = this.f36991e;
        if (this.f36992f.h(this.f36990d.c()) || !this.f36992f.i(obj)) {
            return null;
        }
        return this.f36992f.e(obj);
    }

    @Override // rx.o.f
    @rx.j.b
    public T[] z5(T[] tArr) {
        Object obj = this.f36991e;
        if (!this.f36992f.h(this.f36990d.c()) && this.f36992f.i(obj)) {
            T e2 = this.f36992f.e(obj);
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = e2;
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
