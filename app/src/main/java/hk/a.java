package hk;

import hk.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class a<T> extends f<T, T> {

    /* renamed from: e */
    public final g<T> f26738e;

    /* renamed from: f */
    public volatile Object f26739f;

    /* renamed from: g */
    public final NotificationLite<T> f26740g;

    /* renamed from: hk.a$a */
    public static class C0710a implements wj.b<g.c<T>> {

        /* renamed from: b */
        public final /* synthetic */ g f26741b;

        public C0710a(g gVar) {
            this.f26741b = gVar;
        }

        @Override // wj.b
        public void call(g.c<T> cVar) {
            Object c10 = this.f26741b.c();
            NotificationLite<T> notificationLite = this.f26741b.f26793h;
            cVar.a(c10, notificationLite);
            if (c10 == null || !(notificationLite.g(c10) || notificationLite.h(c10))) {
                cVar.onCompleted();
            }
        }
    }

    public a(a.m0<T> m0Var, g<T> gVar) {
        super(m0Var);
        this.f26740g = NotificationLite.f();
        this.f26738e = gVar;
    }

    public static <T> a<T> F5() {
        g gVar = new g();
        gVar.f26792g = new C0710a(gVar);
        return new a<>(gVar, gVar);
    }

    @Override // hk.f
    @uj.b
    public boolean A5() {
        Object c10 = this.f26738e.c();
        return (c10 == null || this.f26740g.h(c10)) ? false : true;
    }

    @Override // hk.f
    public boolean B5() {
        return this.f26738e.e().length > 0;
    }

    @Override // hk.f
    @uj.b
    public boolean C5() {
        return this.f26740g.h(this.f26738e.c());
    }

    @Override // hk.f
    @uj.b
    public boolean D5() {
        return !this.f26740g.h(this.f26738e.c()) && this.f26740g.i(this.f26739f);
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f26738e.f26789d) {
            Object obj = this.f26739f;
            if (obj == null) {
                obj = this.f26740g.b();
            }
            for (qj.b bVar : this.f26738e.h(obj)) {
                if (obj == this.f26740g.b()) {
                    bVar.onCompleted();
                } else {
                    bVar.onNext(this.f26740g.e(obj));
                    bVar.onCompleted();
                }
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        if (this.f26738e.f26789d) {
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f26738e.h(this.f26740g.c(th2))) {
                try {
                    cVar.onError(th2);
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
        this.f26739f = this.f26740g.l(t10);
    }

    @Override // hk.f
    @uj.b
    public Throwable w5() {
        Object c10 = this.f26738e.c();
        if (this.f26740g.h(c10)) {
            return this.f26740g.d(c10);
        }
        return null;
    }

    @Override // hk.f
    @uj.b
    public T x5() {
        Object obj = this.f26739f;
        if (this.f26740g.h(this.f26738e.c()) || !this.f26740g.i(obj)) {
            return null;
        }
        return this.f26740g.e(obj);
    }

    @Override // hk.f
    @uj.b
    public T[] z5(T[] tArr) {
        Object obj = this.f26739f;
        if (!this.f26740g.h(this.f26738e.c()) && this.f26740g.i(obj)) {
            T e10 = this.f26740g.e(obj);
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = e10;
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
