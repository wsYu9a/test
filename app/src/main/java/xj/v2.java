package xj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class v2<T, U> implements a.n0<qj.a<T>, T> {

    /* renamed from: c */
    public static final Object f32767c = new Object();

    /* renamed from: d */
    public static final NotificationLite<Object> f32768d = NotificationLite.f();

    /* renamed from: b */
    public final wj.n<? extends qj.a<? extends U>> f32769b;

    public static final class a<T, U> extends qj.g<U> {

        /* renamed from: g */
        public final b<T, U> f32770g;

        /* renamed from: h */
        public boolean f32771h;

        public a(qj.g<?> gVar, b<T, U> bVar) {
            this.f32770g = bVar;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32771h) {
                return;
            }
            this.f32771h = true;
            this.f32770g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32770g.onError(th2);
        }

        @Override // qj.b
        public void onNext(U u10) {
            if (this.f32771h) {
                return;
            }
            this.f32771h = true;
            this.f32770g.m();
        }
    }

    public static final class b<T, U> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super qj.a<T>> f32772g;

        /* renamed from: h */
        public final Object f32773h = new Object();

        /* renamed from: i */
        public qj.b<T> f32774i;

        /* renamed from: j */
        public qj.a<T> f32775j;

        /* renamed from: k */
        public boolean f32776k;

        /* renamed from: l */
        public List<Object> f32777l;

        /* renamed from: m */
        public final ik.e f32778m;

        /* renamed from: n */
        public final wj.n<? extends qj.a<? extends U>> f32779n;

        public b(qj.g<? super qj.a<T>> gVar, wj.n<? extends qj.a<? extends U>> nVar) {
            this.f32772g = new ek.d(gVar);
            ik.e eVar = new ik.e();
            this.f32778m = eVar;
            this.f32779n = nVar;
            b(eVar);
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public void g() {
            qj.b<T> bVar = this.f32774i;
            this.f32774i = null;
            this.f32775j = null;
            if (bVar != null) {
                bVar.onCompleted();
            }
            this.f32772g.onCompleted();
            unsubscribe();
        }

        public void h() {
            g G5 = g.G5();
            this.f32774i = G5;
            this.f32775j = G5;
            try {
                qj.a<? extends U> call = this.f32779n.call();
                a aVar = new a(this.f32772g, this);
                this.f32778m.b(aVar);
                call.T4(aVar);
            } catch (Throwable th2) {
                this.f32772g.onError(th2);
                unsubscribe();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void i(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == v2.f32767c) {
                    l();
                } else {
                    NotificationLite<Object> notificationLite = v2.f32768d;
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
            qj.b<T> bVar = this.f32774i;
            if (bVar != null) {
                bVar.onNext(t10);
            }
        }

        public void k(Throwable th2) {
            qj.b<T> bVar = this.f32774i;
            this.f32774i = null;
            this.f32775j = null;
            if (bVar != null) {
                bVar.onError(th2);
            }
            this.f32772g.onError(th2);
            unsubscribe();
        }

        public void l() {
            qj.b<T> bVar = this.f32774i;
            if (bVar != null) {
                bVar.onCompleted();
            }
            h();
            this.f32772g.onNext(this.f32775j);
        }

        public void m() {
            synchronized (this.f32773h) {
                try {
                    if (this.f32776k) {
                        if (this.f32777l == null) {
                            this.f32777l = new ArrayList();
                        }
                        this.f32777l.add(v2.f32767c);
                        return;
                    }
                    List<Object> list = this.f32777l;
                    this.f32777l = null;
                    boolean z10 = true;
                    this.f32776k = true;
                    boolean z11 = true;
                    while (true) {
                        try {
                            i(list);
                            if (z11) {
                                l();
                                z11 = false;
                            }
                            try {
                                synchronized (this.f32773h) {
                                    try {
                                        List<Object> list2 = this.f32777l;
                                        this.f32777l = null;
                                        if (list2 == null) {
                                            this.f32776k = false;
                                            return;
                                        } else {
                                            if (this.f32772g.isUnsubscribed()) {
                                                synchronized (this.f32773h) {
                                                    this.f32776k = false;
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
                                                synchronized (this.f32773h) {
                                                    this.f32776k = false;
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
            synchronized (this.f32773h) {
                try {
                    if (this.f32776k) {
                        if (this.f32777l == null) {
                            this.f32777l = new ArrayList();
                        }
                        this.f32777l.add(v2.f32768d.b());
                        return;
                    }
                    List<Object> list = this.f32777l;
                    this.f32777l = null;
                    this.f32776k = true;
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
            synchronized (this.f32773h) {
                try {
                    if (this.f32776k) {
                        this.f32777l = Collections.singletonList(v2.f32768d.c(th2));
                        return;
                    }
                    this.f32777l = null;
                    this.f32776k = true;
                    k(th2);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            synchronized (this.f32773h) {
                try {
                    if (this.f32776k) {
                        if (this.f32777l == null) {
                            this.f32777l = new ArrayList();
                        }
                        this.f32777l.add(t10);
                        return;
                    }
                    List<Object> list = this.f32777l;
                    this.f32777l = null;
                    boolean z10 = true;
                    this.f32776k = true;
                    boolean z11 = true;
                    while (true) {
                        try {
                            i(list);
                            if (z11) {
                                j(t10);
                                z11 = false;
                            }
                            try {
                                synchronized (this.f32773h) {
                                    try {
                                        List<Object> list2 = this.f32777l;
                                        this.f32777l = null;
                                        if (list2 == null) {
                                            this.f32776k = false;
                                            return;
                                        } else {
                                            if (this.f32772g.isUnsubscribed()) {
                                                synchronized (this.f32773h) {
                                                    this.f32776k = false;
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
                                                synchronized (this.f32773h) {
                                                    this.f32776k = false;
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

    public v2(wj.n<? extends qj.a<? extends U>> nVar) {
        this.f32769b = nVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super qj.a<T>> gVar) {
        b bVar = new b(gVar, this.f32769b);
        gVar.b(bVar);
        bVar.m();
        return bVar;
    }
}
