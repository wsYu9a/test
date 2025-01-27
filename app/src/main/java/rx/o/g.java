package rx.o;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.a;
import rx.internal.operators.NotificationLite;
import rx.k.m;

/* loaded from: classes5.dex */
final class g<T> implements a.m0<T> {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater<g, b> f37037a = AtomicReferenceFieldUpdater.newUpdater(g.class, b.class, "c");

    /* renamed from: b */
    static final AtomicReferenceFieldUpdater<g, Object> f37038b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "d");

    /* renamed from: d */
    volatile Object f37040d;

    /* renamed from: c */
    volatile b<T> f37039c = b.f37050c;

    /* renamed from: e */
    boolean f37041e = true;

    /* renamed from: f */
    rx.k.b<c<T>> f37042f = m.a();

    /* renamed from: g */
    rx.k.b<c<T>> f37043g = m.a();

    /* renamed from: h */
    rx.k.b<c<T>> f37044h = m.a();

    /* renamed from: i */
    public final NotificationLite<T> f37045i = NotificationLite.f();

    class a implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ c f37046a;

        a(c cVar) {
            this.f37046a = cVar;
        }

        @Override // rx.k.a
        public void call() {
            g.this.f(this.f37046a);
        }
    }

    protected static final class b<T> {

        /* renamed from: a */
        static final c[] f37048a;

        /* renamed from: b */
        static final b f37049b;

        /* renamed from: c */
        static final b f37050c;

        /* renamed from: d */
        final boolean f37051d;

        /* renamed from: e */
        final c[] f37052e;

        static {
            c[] cVarArr = new c[0];
            f37048a = cVarArr;
            f37049b = new b(true, cVarArr);
            f37050c = new b(false, cVarArr);
        }

        public b(boolean z, c[] cVarArr) {
            this.f37051d = z;
            this.f37052e = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f37052e;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f37051d, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f37052e;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f37050c;
            }
            if (length == 0) {
                return this;
            }
            int i2 = length - 1;
            c[] cVarArr2 = new c[i2];
            int i3 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i3 == i2) {
                        return this;
                    }
                    cVarArr2[i3] = cVar2;
                    i3++;
                }
            }
            if (i3 == 0) {
                return f37050c;
            }
            if (i3 < i2) {
                c[] cVarArr3 = new c[i3];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i3);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f37051d, cVarArr2);
        }
    }

    protected static final class c<T> implements rx.b<T> {

        /* renamed from: a */
        final rx.b<? super T> f37053a;

        /* renamed from: b */
        boolean f37054b = true;

        /* renamed from: c */
        boolean f37055c;

        /* renamed from: d */
        List<Object> f37056d;

        /* renamed from: e */
        boolean f37057e;

        /* renamed from: f */
        protected volatile boolean f37058f;

        /* renamed from: g */
        private volatile Object f37059g;

        public c(rx.b<? super T> bVar) {
            this.f37053a = bVar;
        }

        protected void a(Object obj, NotificationLite<T> notificationLite) {
            if (obj != null) {
                notificationLite.a(this.f37053a, obj);
            }
        }

        protected void b(Object obj, NotificationLite<T> notificationLite) {
            synchronized (this) {
                if (this.f37054b && !this.f37055c) {
                    this.f37054b = false;
                    this.f37055c = obj != null;
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
        protected void c(java.util.List<java.lang.Object> r5, java.lang.Object r6, rx.internal.operators.NotificationLite<T> r7) {
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
                java.util.List<java.lang.Object> r5 = r4.f37056d     // Catch: java.lang.Throwable -> L2e
                r3 = 0
                r4.f37056d = r3     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L2c
                r4.f37055c = r2     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                return
            L2c:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2e
                goto L2
            L2e:
                r5 = move-exception
                r0 = 0
            L30:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                throw r5     // Catch: java.lang.Throwable -> L32
            L32:
                r5 = move-exception
                goto L36
            L34:
                r5 = move-exception
                goto L30
            L36:
                if (r0 != 0) goto L40
                monitor-enter(r4)
                r4.f37055c = r2     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                goto L40
            L3d:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                throw r5
            L40:
                goto L42
            L41:
                throw r5
            L42:
                goto L41
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.o.g.c.c(java.util.List, java.lang.Object, rx.internal.operators.NotificationLite):void");
        }

        protected void d(Object obj, NotificationLite<T> notificationLite) {
            if (!this.f37057e) {
                synchronized (this) {
                    this.f37054b = false;
                    if (this.f37055c) {
                        if (this.f37056d == null) {
                            this.f37056d = new ArrayList();
                        }
                        this.f37056d.add(obj);
                        return;
                    }
                    this.f37057e = true;
                }
            }
            notificationLite.a(this.f37053a, obj);
        }

        protected rx.b<? super T> e() {
            return this.f37053a;
        }

        public <I> I f() {
            return (I) this.f37059g;
        }

        public void g(Object obj) {
            this.f37059g = obj;
        }

        @Override // rx.b
        public void onCompleted() {
            this.f37053a.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f37053a.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f37053a.onNext(t);
        }
    }

    g() {
    }

    boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = this.f37039c;
            if (bVar.f37051d) {
                this.f37044h.call(cVar);
                return false;
            }
        } while (!f37037a.compareAndSet(this, bVar, bVar.a(cVar)));
        this.f37043g.call(cVar);
        return true;
    }

    void b(rx.g<? super T> gVar, c<T> cVar) {
        gVar.b(rx.p.f.a(new a(cVar)));
    }

    Object c() {
        return this.f37040d;
    }

    c<T>[] d(Object obj) {
        g(obj);
        return this.f37039c.f37052e;
    }

    c<T>[] e() {
        return this.f37039c.f37052e;
    }

    void f(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        do {
            bVar = this.f37039c;
            if (bVar.f37051d || (b2 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!f37037a.compareAndSet(this, bVar, b2));
    }

    void g(Object obj) {
        this.f37040d = obj;
    }

    c<T>[] h(Object obj) {
        g(obj);
        this.f37041e = false;
        return this.f37039c.f37051d ? b.f37048a : f37037a.getAndSet(this, b.f37049b).f37052e;
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        c<T> cVar = new c<>(gVar);
        b(gVar, cVar);
        this.f37042f.call(cVar);
        if (!gVar.isUnsubscribed() && a(cVar) && gVar.isUnsubscribed()) {
            f(cVar);
        }
    }
}
