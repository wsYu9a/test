package xj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class u2<T, U> implements a.n0<qj.a<T>, T> {

    /* renamed from: c */
    public static final Object f32705c = new Object();

    /* renamed from: d */
    public static final NotificationLite<Object> f32706d = NotificationLite.f();

    /* renamed from: b */
    public final qj.a<U> f32707b;

    public static final class a<T, U> extends qj.g<U> {

        /* renamed from: g */
        public final b<T> f32708g;

        public a(qj.g<?> gVar, b<T> bVar) {
            this.f32708g = bVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32708g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32708g.onError(th2);
        }

        @Override // qj.b
        public void onNext(U u10) {
            this.f32708g.m();
        }
    }

    public static final class b<T> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32709g;

        /* renamed from: h */
        public final Object f32710h = new Object();

        /* renamed from: i */
        public qj.b<T> f32711i;

        /* renamed from: j */
        public qj.a<T> f32712j;

        /* renamed from: k */
        public boolean f32713k;

        /* renamed from: l */
        public List<Object> f32714l;

        public b(qj.g<? super qj.a<T>> gVar) {
            this.f32709g = new ek.d(gVar);
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public void g() {
            qj.b<T> bVar = this.f32711i;
            this.f32711i = null;
            this.f32712j = null;
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f32709g.onCompleted();
            unsubscribe();
        }

        public void h() {
            g G5 = g.G5();
            this.f32711i = G5;
            this.f32712j = G5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void i(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == u2.f32705c) {
                    l();
                } else {
                    NotificationLite<Object> notificationLite = u2.f32706d;
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

        public void j(T t10) {
            qj.b<T> bVar = this.f32711i;
            if (bVar != null) {
                bVar.onNext(t10);
            }
        }

        public void k(Throwable th2) {
            qj.b<T> bVar = this.f32711i;
            this.f32711i = null;
            this.f32712j = null;
            if (bVar != null) {
                bVar.onError(th2);
            }
            this.f32709g.onError(th2);
            unsubscribe();
        }

        public void l() {
            qj.b<T> bVar = this.f32711i;
            if (bVar != null) {
                bVar.onCompleted();
            }
            h();
            this.f32709g.onNext(this.f32712j);
        }

        public void m() {
            synchronized (this.f32710h) {
                try {
                    if (this.f32713k) {
                        if (this.f32714l == null) {
                            this.f32714l = new ArrayList();
                        }
                        this.f32714l.add(u2.f32705c);
                        return;
                    }
                    List<Object> list = this.f32714l;
                    this.f32714l = null;
                    boolean z10 = true;
                    this.f32713k = true;
                    boolean z11 = true;
                    while (true) {
                        try {
                            i(list);
                            if (z11) {
                                l();
                                z11 = false;
                            }
                            try {
                                synchronized (this.f32710h) {
                                    try {
                                        List<Object> list2 = this.f32714l;
                                        this.f32714l = null;
                                        if (list2 == null) {
                                            this.f32713k = false;
                                            return;
                                        } else {
                                            if (this.f32709g.isUnsubscribed()) {
                                                synchronized (this.f32710h) {
                                                    this.f32713k = false;
                                                }
                                                return;
                                            }
                                            list = list2;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z10 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (!z10) {
                                                synchronized (this.f32710h) {
                                                    this.f32713k = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z10 = false;
                        }
                    }
                } finally {
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            synchronized (this.f32710h) {
                try {
                    if (this.f32713k) {
                        if (this.f32714l == null) {
                            this.f32714l = new ArrayList();
                        }
                        this.f32714l.add(u2.f32706d.b());
                        return;
                    }
                    List<Object> list = this.f32714l;
                    this.f32714l = null;
                    this.f32713k = true;
                    try {
                        i(list);
                        g();
                    } catch (Throwable th2) {
                        k(th2);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            synchronized (this.f32710h) {
                try {
                    if (this.f32713k) {
                        this.f32714l = Collections.singletonList(u2.f32706d.c(th2));
                        return;
                    }
                    this.f32714l = null;
                    this.f32713k = true;
                    k(th2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            synchronized (this.f32710h) {
                try {
                    if (this.f32713k) {
                        if (this.f32714l == null) {
                            this.f32714l = new ArrayList();
                        }
                        this.f32714l.add(t10);
                        return;
                    }
                    List<Object> list = this.f32714l;
                    this.f32714l = null;
                    boolean z10 = true;
                    this.f32713k = true;
                    boolean z11 = true;
                    while (true) {
                        try {
                            i(list);
                            if (z11) {
                                j(t10);
                                z11 = false;
                            }
                            try {
                                synchronized (this.f32710h) {
                                    try {
                                        List<Object> list2 = this.f32714l;
                                        this.f32714l = null;
                                        if (list2 == null) {
                                            this.f32713k = false;
                                            return;
                                        } else {
                                            if (this.f32709g.isUnsubscribed()) {
                                                synchronized (this.f32710h) {
                                                    this.f32713k = false;
                                                }
                                                return;
                                            }
                                            list = list2;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z10 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (!z10) {
                                                synchronized (this.f32710h) {
                                                    this.f32713k = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z10 = false;
                        }
                    }
                } finally {
                }
            }
        }
    }

    public u2(qj.a<U> aVar) {
        this.f32707b = aVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<T>> gVar) {
        b bVar = new b(gVar);
        a aVar = new a(gVar, bVar);
        gVar.b(bVar);
        gVar.b(aVar);
        bVar.m();
        this.f32707b.T4(aVar);
        return bVar;
    }
}
