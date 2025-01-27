package hk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.a;
import rx.internal.operators.NotificationLite;
import wj.m;

/* loaded from: classes5.dex */
public final class g<T> implements a.m0<T> {

    /* renamed from: i */
    public static final AtomicReferenceFieldUpdater<g, b> f26785i = AtomicReferenceFieldUpdater.newUpdater(g.class, b.class, "b");

    /* renamed from: j */
    public static final AtomicReferenceFieldUpdater<g, Object> f26786j = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "c");

    /* renamed from: c */
    public volatile Object f26788c;

    /* renamed from: b */
    public volatile b<T> f26787b = b.f26798e;

    /* renamed from: d */
    public boolean f26789d = true;

    /* renamed from: e */
    public wj.b<c<T>> f26790e = m.a();

    /* renamed from: f */
    public wj.b<c<T>> f26791f = m.a();

    /* renamed from: g */
    public wj.b<c<T>> f26792g = m.a();

    /* renamed from: h */
    public final NotificationLite<T> f26793h = NotificationLite.f();

    public class a implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ c f26794b;

        public a(c cVar) {
            this.f26794b = cVar;
        }

        @Override // wj.a
        public void call() {
            g.this.f(this.f26794b);
        }
    }

    public static final class b<T> {

        /* renamed from: c */
        public static final c[] f26796c;

        /* renamed from: d */
        public static final b f26797d;

        /* renamed from: e */
        public static final b f26798e;

        /* renamed from: a */
        public final boolean f26799a;

        /* renamed from: b */
        public final c[] f26800b;

        static {
            c[] cVarArr = new c[0];
            f26796c = cVarArr;
            f26797d = new b(true, cVarArr);
            f26798e = new b(false, cVarArr);
        }

        public b(boolean z10, c[] cVarArr) {
            this.f26799a = z10;
            this.f26800b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f26800b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f26799a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f26800b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f26798e;
            }
            if (length == 0) {
                return this;
            }
            int i10 = length - 1;
            c[] cVarArr2 = new c[i10];
            int i11 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i11 == i10) {
                        return this;
                    }
                    cVarArr2[i11] = cVar2;
                    i11++;
                }
            }
            if (i11 == 0) {
                return f26798e;
            }
            if (i11 < i10) {
                c[] cVarArr3 = new c[i11];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i11);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f26799a, cVarArr2);
        }
    }

    public static final class c<T> implements qj.b<T> {

        /* renamed from: b */
        public final qj.b<? super T> f26801b;

        /* renamed from: c */
        public boolean f26802c = true;

        /* renamed from: d */
        public boolean f26803d;

        /* renamed from: e */
        public List<Object> f26804e;

        /* renamed from: f */
        public boolean f26805f;

        /* renamed from: g */
        public volatile boolean f26806g;

        /* renamed from: h */
        public volatile Object f26807h;

        public c(qj.b<? super T> bVar) {
            this.f26801b = bVar;
        }

        public void a(Object obj, NotificationLite<T> notificationLite) {
            if (obj != null) {
                notificationLite.a(this.f26801b, obj);
            }
        }

        public void b(Object obj, NotificationLite<T> notificationLite) {
            synchronized (this) {
                if (this.f26802c && !this.f26803d) {
                    this.f26802c = false;
                    this.f26803d = obj != null;
                    if (obj != null) {
                        c(null, obj, notificationLite);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c(java.util.List<java.lang.Object> r5, java.lang.Object r6, rx.internal.operators.NotificationLite<T> r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 1
            L2:
                r2 = 0
                if (r5 == 0) goto L1a
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L17
            L9:
                boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r3 == 0) goto L1a
                java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L17
                r4.a(r3, r7)     // Catch: java.lang.Throwable -> L17
                goto L9
            L17:
                r5 = move-exception
                r0 = 0
                goto L36
            L1a:
                if (r1 == 0) goto L20
                r4.a(r6, r7)     // Catch: java.lang.Throwable -> L17
                r1 = 0
            L20:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L17
                java.util.List<java.lang.Object> r5 = r4.f26804e     // Catch: java.lang.Throwable -> L2e
                r3 = 0
                r4.f26804e = r3     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L31
                r4.f26803d = r2     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
                return
            L2c:
                r5 = move-exception
                goto L33
            L2e:
                r5 = move-exception
                r0 = 0
                goto L33
            L31:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2e
                goto L2
            L33:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
                throw r5     // Catch: java.lang.Throwable -> L35
            L35:
                r5 = move-exception
            L36:
                if (r0 != 0) goto L40
                monitor-enter(r4)
                r4.f26803d = r2     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                goto L40
            L3d:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                throw r5
            L40:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: hk.g.c.c(java.util.List, java.lang.Object, rx.internal.operators.NotificationLite):void");
        }

        public void d(Object obj, NotificationLite<T> notificationLite) {
            if (!this.f26805f) {
                synchronized (this) {
                    try {
                        this.f26802c = false;
                        if (this.f26803d) {
                            if (this.f26804e == null) {
                                this.f26804e = new ArrayList();
                            }
                            this.f26804e.add(obj);
                            return;
                        }
                        this.f26805f = true;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            notificationLite.a(this.f26801b, obj);
        }

        public qj.b<? super T> e() {
            return this.f26801b;
        }

        public <I> I f() {
            return (I) this.f26807h;
        }

        public void g(Object obj) {
            this.f26807h = obj;
        }

        @Override // qj.b
        public void onCompleted() {
            this.f26801b.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f26801b.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f26801b.onNext(t10);
        }
    }

    public boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = this.f26787b;
            if (bVar.f26799a) {
                this.f26792g.call(cVar);
                return false;
            }
        } while (!k.a.a(f26785i, this, bVar, bVar.a(cVar)));
        this.f26791f.call(cVar);
        return true;
    }

    public void b(qj.g<? super T> gVar, c<T> cVar) {
        gVar.b(ik.f.a(new a(cVar)));
    }

    public Object c() {
        return this.f26788c;
    }

    public c<T>[] d(Object obj) {
        g(obj);
        return this.f26787b.f26800b;
    }

    public c<T>[] e() {
        return this.f26787b.f26800b;
    }

    public void f(c<T> cVar) {
        b<T> bVar;
        b<T> b10;
        do {
            bVar = this.f26787b;
            if (bVar.f26799a || (b10 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!k.a.a(f26785i, this, bVar, b10));
    }

    public void g(Object obj) {
        this.f26788c = obj;
    }

    public c<T>[] h(Object obj) {
        g(obj);
        this.f26789d = false;
        return this.f26787b.f26799a ? b.f26796c : f26785i.getAndSet(this, b.f26797d).f26800b;
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        c<T> cVar = new c<>(gVar);
        b(gVar, cVar);
        this.f26790e.call(cVar);
        if (!gVar.isUnsubscribed() && a(cVar) && gVar.isUnsubscribed()) {
            f(cVar);
        }
    }
}
