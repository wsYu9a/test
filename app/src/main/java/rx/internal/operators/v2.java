package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class v2<T, U> implements a.n0<rx.a<T>, T> {

    /* renamed from: a */
    static final Object f36558a = new Object();

    /* renamed from: b */
    static final NotificationLite<Object> f36559b = NotificationLite.f();

    /* renamed from: c */
    final rx.k.n<? extends rx.a<? extends U>> f36560c;

    static final class a<T, U> extends rx.g<U> {

        /* renamed from: f */
        final b<T, U> f36561f;

        /* renamed from: g */
        boolean f36562g;

        public a(rx.g<?> gVar, b<T, U> bVar) {
            this.f36561f = bVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36562g) {
                return;
            }
            this.f36562g = true;
            this.f36561f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36561f.onError(th);
        }

        @Override // rx.b
        public void onNext(U u) {
            if (this.f36562g) {
                return;
            }
            this.f36562g = true;
            this.f36561f.m();
        }
    }

    static final class b<T, U> extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36563f;

        /* renamed from: g */
        final Object f36564g = new Object();

        /* renamed from: h */
        rx.b<T> f36565h;

        /* renamed from: i */
        rx.a<T> f36566i;

        /* renamed from: j */
        boolean f36567j;
        List<Object> k;
        final rx.p.e l;
        final rx.k.n<? extends rx.a<? extends U>> m;

        public b(rx.g<? super rx.a<T>> gVar, rx.k.n<? extends rx.a<? extends U>> nVar) {
            this.f36563f = new rx.l.d(gVar);
            rx.p.e eVar = new rx.p.e();
            this.l = eVar;
            this.m = nVar;
            b(eVar);
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        void g() {
            rx.b<T> bVar = this.f36565h;
            this.f36565h = null;
            this.f36566i = null;
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f36563f.onCompleted();
            unsubscribe();
        }

        void h() {
            g G5 = g.G5();
            this.f36565h = G5;
            this.f36566i = G5;
            try {
                rx.a<? extends U> call = this.m.call();
                a aVar = new a(this.f36563f, this);
                this.l.b(aVar);
                call.T4(aVar);
            } catch (Throwable th) {
                this.f36563f.onError(th);
                unsubscribe();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void i(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == v2.f36558a) {
                    l();
                } else {
                    NotificationLite<Object> notificationLite = v2.f36559b;
                    if (notificationLite.h(obj)) {
                        k(notificationLite.d(obj));
                        return;
                    } else {
                        if (notificationLite.g(obj)) {
                            g();
                            return;
                        }
                        j(obj);
                    }
                }
            }
        }

        void j(T t) {
            rx.b<T> bVar = this.f36565h;
            if (bVar != null) {
                bVar.onNext(t);
            }
        }

        void k(Throwable th) {
            rx.b<T> bVar = this.f36565h;
            this.f36565h = null;
            this.f36566i = null;
            if (bVar != null) {
                bVar.onError(th);
            }
            this.f36563f.onError(th);
            unsubscribe();
        }

        void l() {
            rx.b<T> bVar = this.f36565h;
            if (bVar != null) {
                bVar.onCompleted();
            }
            h();
            this.f36563f.onNext(this.f36566i);
        }

        void m() {
            synchronized (this.f36564g) {
                if (this.f36567j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(v2.f36558a);
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                boolean z = true;
                this.f36567j = true;
                boolean z2 = true;
                while (true) {
                    try {
                        i(list);
                        if (z2) {
                            l();
                            z2 = false;
                        }
                        try {
                            synchronized (this.f36564g) {
                                try {
                                    List<Object> list2 = this.k;
                                    this.k = null;
                                    if (list2 == null) {
                                        this.f36567j = false;
                                        return;
                                    } else {
                                        if (this.f36563f.isUnsubscribed()) {
                                            synchronized (this.f36564g) {
                                                this.f36567j = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f36564g) {
                                                this.f36567j = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            synchronized (this.f36564g) {
                if (this.f36567j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(v2.f36559b.b());
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                this.f36567j = true;
                try {
                    i(list);
                    g();
                } catch (Throwable th) {
                    k(th);
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            synchronized (this.f36564g) {
                if (this.f36567j) {
                    this.k = Collections.singletonList(v2.f36559b.c(th));
                    return;
                }
                this.k = null;
                this.f36567j = true;
                k(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this.f36564g) {
                if (this.f36567j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(t);
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                boolean z = true;
                this.f36567j = true;
                boolean z2 = true;
                while (true) {
                    try {
                        i(list);
                        if (z2) {
                            j(t);
                            z2 = false;
                        }
                        try {
                            synchronized (this.f36564g) {
                                try {
                                    List<Object> list2 = this.k;
                                    this.k = null;
                                    if (list2 == null) {
                                        this.f36567j = false;
                                        return;
                                    } else {
                                        if (this.f36563f.isUnsubscribed()) {
                                            synchronized (this.f36564g) {
                                                this.f36567j = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f36564g) {
                                                this.f36567j = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }
    }

    public v2(rx.k.n<? extends rx.a<? extends U>> nVar) {
        this.f36560c = nVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<T>> gVar) {
        b bVar = new b(gVar, this.f36560c);
        gVar.b(bVar);
        bVar.m();
        return bVar;
    }
}
