package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.a;

/* loaded from: classes5.dex */
public final class u2<T, U> implements a.n0<rx.a<T>, T> {

    /* renamed from: a */
    static final Object f36512a = new Object();

    /* renamed from: b */
    static final NotificationLite<Object> f36513b = NotificationLite.f();

    /* renamed from: c */
    final rx.a<U> f36514c;

    static final class a<T, U> extends rx.g<U> {

        /* renamed from: f */
        final b<T> f36515f;

        public a(rx.g<?> gVar, b<T> bVar) {
            this.f36515f = bVar;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36515f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36515f.onError(th);
        }

        @Override // rx.b
        public void onNext(U u) {
            this.f36515f.m();
        }
    }

    static final class b<T> extends rx.g<T> {

        /* renamed from: f */
        final rx.g<? super rx.a<T>> f36516f;

        /* renamed from: g */
        final Object f36517g = new Object();

        /* renamed from: h */
        rx.b<T> f36518h;

        /* renamed from: i */
        rx.a<T> f36519i;

        /* renamed from: j */
        boolean f36520j;
        List<Object> k;

        public b(rx.g<? super rx.a<T>> gVar) {
            this.f36516f = new rx.l.d(gVar);
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        void g() {
            rx.b<T> bVar = this.f36518h;
            this.f36518h = null;
            this.f36519i = null;
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f36516f.onCompleted();
            unsubscribe();
        }

        void h() {
            g G5 = g.G5();
            this.f36518h = G5;
            this.f36519i = G5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void i(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == u2.f36512a) {
                    l();
                } else {
                    NotificationLite<Object> notificationLite = u2.f36513b;
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
            rx.b<T> bVar = this.f36518h;
            if (bVar != null) {
                bVar.onNext(t);
            }
        }

        void k(Throwable th) {
            rx.b<T> bVar = this.f36518h;
            this.f36518h = null;
            this.f36519i = null;
            if (bVar != null) {
                bVar.onError(th);
            }
            this.f36516f.onError(th);
            unsubscribe();
        }

        void l() {
            rx.b<T> bVar = this.f36518h;
            if (bVar != null) {
                bVar.onCompleted();
            }
            h();
            this.f36516f.onNext(this.f36519i);
        }

        void m() {
            synchronized (this.f36517g) {
                if (this.f36520j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(u2.f36512a);
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                boolean z = true;
                this.f36520j = true;
                boolean z2 = true;
                while (true) {
                    try {
                        i(list);
                        if (z2) {
                            l();
                            z2 = false;
                        }
                        try {
                            synchronized (this.f36517g) {
                                try {
                                    List<Object> list2 = this.k;
                                    this.k = null;
                                    if (list2 == null) {
                                        this.f36520j = false;
                                        return;
                                    } else {
                                        if (this.f36516f.isUnsubscribed()) {
                                            synchronized (this.f36517g) {
                                                this.f36520j = false;
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
                                            synchronized (this.f36517g) {
                                                this.f36520j = false;
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
            synchronized (this.f36517g) {
                if (this.f36520j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(u2.f36513b.b());
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                this.f36520j = true;
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
            synchronized (this.f36517g) {
                if (this.f36520j) {
                    this.k = Collections.singletonList(u2.f36513b.c(th));
                    return;
                }
                this.k = null;
                this.f36520j = true;
                k(th);
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            synchronized (this.f36517g) {
                if (this.f36520j) {
                    if (this.k == null) {
                        this.k = new ArrayList();
                    }
                    this.k.add(t);
                    return;
                }
                List<Object> list = this.k;
                this.k = null;
                boolean z = true;
                this.f36520j = true;
                boolean z2 = true;
                while (true) {
                    try {
                        i(list);
                        if (z2) {
                            j(t);
                            z2 = false;
                        }
                        try {
                            synchronized (this.f36517g) {
                                try {
                                    List<Object> list2 = this.k;
                                    this.k = null;
                                    if (list2 == null) {
                                        this.f36520j = false;
                                        return;
                                    } else {
                                        if (this.f36516f.isUnsubscribed()) {
                                            synchronized (this.f36517g) {
                                                this.f36520j = false;
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
                                            synchronized (this.f36517g) {
                                                this.f36520j = false;
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

    public u2(rx.a<U> aVar) {
        this.f36514c = aVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.a<T>> gVar) {
        b bVar = new b(gVar);
        a aVar = new a(gVar, bVar);
        gVar.b(bVar);
        gVar.b(aVar);
        bVar.m();
        this.f36514c.T4(aVar);
        return bVar;
    }
}
