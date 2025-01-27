package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class OperatorMerge<T> implements a.n0<T, rx.a<? extends T>> {

    /* renamed from: a */
    final boolean f35803a;

    /* renamed from: b */
    final int f35804b;

    static final class MergeProducer<T> extends AtomicLong implements rx.c {
        private static final long serialVersionUID = -1214379189873595503L;
        final e<T> subscriber;

        public MergeProducer(e<T> eVar) {
            this.subscriber = eVar;
        }

        public long produced(int i2) {
            return addAndGet(-i2);
        }

        @Override // rx.c
        public void request(long j2) {
            if (j2 <= 0) {
                if (j2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                rx.internal.operators.a.a(this, j2);
                this.subscriber.i();
            }
        }
    }

    private static final class b {

        /* renamed from: a */
        static final OperatorMerge<Object> f35805a = new OperatorMerge<>(true, Integer.MAX_VALUE);

        private b() {
        }
    }

    private static final class c {

        /* renamed from: a */
        static final OperatorMerge<Object> f35806a = new OperatorMerge<>(false, Integer.MAX_VALUE);

        private c() {
        }
    }

    static final class d<T> extends rx.g<T> {

        /* renamed from: f */
        static final int f35807f = rx.internal.util.e.f36784c / 4;

        /* renamed from: g */
        final e<T> f35808g;

        /* renamed from: h */
        final long f35809h;

        /* renamed from: i */
        volatile boolean f35810i;

        /* renamed from: j */
        volatile rx.internal.util.e f35811j;
        int k;

        public d(e<T> eVar, long j2) {
            this.f35808g = eVar;
            this.f35809h = j2;
        }

        @Override // rx.g
        public void d() {
            int i2 = rx.internal.util.e.f36784c;
            this.k = i2;
            e(i2);
        }

        public void g(long j2) {
            int i2 = this.k - ((int) j2);
            if (i2 > f35807f) {
                this.k = i2;
                return;
            }
            int i3 = rx.internal.util.e.f36784c;
            this.k = i3;
            int i4 = i3 - i2;
            if (i4 > 0) {
                e(i4);
            }
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35810i = true;
            this.f35808g.i();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35810i = true;
            this.f35808g.n().offer(th);
            this.f35808g.i();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35808g.v(this, t);
        }
    }

    static final class e<T> extends rx.g<rx.a<? extends T>> {

        /* renamed from: f */
        static final d<?>[] f35812f = new d[0];

        /* renamed from: g */
        final rx.g<? super T> f35813g;

        /* renamed from: h */
        final boolean f35814h;

        /* renamed from: i */
        final int f35815i;

        /* renamed from: j */
        MergeProducer<T> f35816j;
        volatile rx.internal.util.e k;
        volatile rx.p.b l;
        volatile ConcurrentLinkedQueue<Throwable> m;
        volatile boolean o;
        boolean p;
        boolean q;
        long t;
        long u;
        int v;
        final NotificationLite<T> n = NotificationLite.f();
        final Object r = new Object();
        volatile d<?>[] s = f35812f;

        public e(rx.g<? super T> gVar, boolean z, int i2) {
            this.f35813g = gVar;
            this.f35814h = z;
            this.f35815i = i2;
            e(Math.min(i2, rx.internal.util.e.f36784c));
        }

        private void s() {
            ArrayList arrayList = new ArrayList(this.m);
            if (arrayList.size() == 1) {
                this.f35813g.onError((Throwable) arrayList.get(0));
            } else {
                this.f35813g.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g(d<T> dVar) {
            m().a(dVar);
            synchronized (this.r) {
                d<?>[] dVarArr = this.s;
                int length = dVarArr.length;
                d<?>[] dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
                this.s = dVarArr2;
            }
        }

        boolean h() {
            if (this.f35813g.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (this.f35814h || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                s();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void i() {
            synchronized (this) {
                if (this.p) {
                    this.q = true;
                } else {
                    this.p = true;
                    j();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x01b3  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c2 A[Catch: all -> 0x01af, TryCatch #9 {all -> 0x01af, blocks: (B:3:0x0003, B:4:0x0005, B:6:0x000c, B:15:0x0030, B:18:0x003f, B:23:0x0069, B:26:0x004c, B:32:0x0050, B:29:0x0062, B:54:0x0080, B:61:0x009b, B:64:0x00a6, B:68:0x00ae, B:70:0x00b2, B:73:0x00b9, B:75:0x00c2, B:78:0x00bd, B:80:0x00c8, B:82:0x00ce, B:86:0x00f9, B:88:0x0100, B:92:0x0108, B:94:0x010f, B:96:0x0114, B:98:0x011d, B:118:0x0143, B:119:0x014f, B:125:0x0159, B:128:0x0161, B:130:0x0167, B:132:0x0171, B:137:0x0179, B:141:0x017e, B:145:0x0182, B:147:0x018e, B:150:0x0196, B:194:0x00dc, B:196:0x00e5, B:200:0x00ea, B:204:0x00ed), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j() {
            /*
                Method dump skipped, instructions count: 446
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.j():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void k(T r5, long r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.g<? super T> r2 = r4.f35813g     // Catch: java.lang.Throwable -> L8
                r2.onNext(r5)     // Catch: java.lang.Throwable -> L8
                goto L20
            L8:
                r5 = move-exception
                boolean r2 = r4.f35814h     // Catch: java.lang.Throwable -> L46
                if (r2 != 0) goto L19
                rx.exceptions.a.e(r5)     // Catch: java.lang.Throwable -> L46
                r4.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r4.onError(r5)     // Catch: java.lang.Throwable -> L17
                return
            L17:
                r5 = move-exception
                goto L48
            L19:
                java.util.Queue r2 = r4.n()     // Catch: java.lang.Throwable -> L46
                r2.offer(r5)     // Catch: java.lang.Throwable -> L46
            L20:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L2e
                rx.internal.operators.OperatorMerge$MergeProducer<T> r5 = r4.f35816j     // Catch: java.lang.Throwable -> L46
                r5.produced(r0)     // Catch: java.lang.Throwable -> L46
            L2e:
                r5 = 1
                r4.t(r5)     // Catch: java.lang.Throwable -> L46
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L46
                boolean r5 = r4.q     // Catch: java.lang.Throwable -> L43
                if (r5 != 0) goto L3c
                r4.p = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                return
            L3c:
                r4.q = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                r4.j()
                return
            L43:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                throw r5     // Catch: java.lang.Throwable -> L17
            L46:
                r5 = move-exception
                r0 = 0
            L48:
                if (r0 != 0) goto L52
                monitor-enter(r4)
                r4.p = r1     // Catch: java.lang.Throwable -> L4f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                goto L52
            L4f:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                throw r5
            L52:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.k(java.lang.Object, long):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void l(rx.internal.operators.OperatorMerge.d<T> r5, T r6, long r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.g<? super T> r2 = r4.f35813g     // Catch: java.lang.Throwable -> L8
                r2.onNext(r6)     // Catch: java.lang.Throwable -> L8
                goto L20
            L8:
                r6 = move-exception
                boolean r2 = r4.f35814h     // Catch: java.lang.Throwable -> L46
                if (r2 != 0) goto L19
                rx.exceptions.a.e(r6)     // Catch: java.lang.Throwable -> L46
                r5.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r5.onError(r6)     // Catch: java.lang.Throwable -> L17
                return
            L17:
                r5 = move-exception
                goto L48
            L19:
                java.util.Queue r2 = r4.n()     // Catch: java.lang.Throwable -> L46
                r2.offer(r6)     // Catch: java.lang.Throwable -> L46
            L20:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L2e
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.f35816j     // Catch: java.lang.Throwable -> L46
                r6.produced(r0)     // Catch: java.lang.Throwable -> L46
            L2e:
                r6 = 1
                r5.g(r6)     // Catch: java.lang.Throwable -> L46
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L46
                boolean r5 = r4.q     // Catch: java.lang.Throwable -> L43
                if (r5 != 0) goto L3c
                r4.p = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                return
            L3c:
                r4.q = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                r4.j()
                return
            L43:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                throw r5     // Catch: java.lang.Throwable -> L17
            L46:
                r5 = move-exception
                r0 = 0
            L48:
                if (r0 != 0) goto L52
                monitor-enter(r4)
                r4.p = r1     // Catch: java.lang.Throwable -> L4f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                goto L52
            L4f:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                throw r5
            L52:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.l(rx.internal.operators.OperatorMerge$d, java.lang.Object, long):void");
        }

        rx.p.b m() {
            rx.p.b bVar;
            rx.p.b bVar2 = this.l;
            if (bVar2 != null) {
                return bVar2;
            }
            boolean z = false;
            synchronized (this) {
                bVar = this.l;
                if (bVar == null) {
                    rx.p.b bVar3 = new rx.p.b();
                    this.l = bVar3;
                    bVar = bVar3;
                    z = true;
                }
            }
            if (z) {
                b(bVar);
            }
            return bVar;
        }

        Queue<Throwable> n() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.m;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.m = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        /* renamed from: o */
        public void onNext(rx.a<? extends T> aVar) {
            if (aVar == null) {
                return;
            }
            if (aVar instanceof rx.internal.util.g) {
                u(((rx.internal.util.g) aVar).y5());
                return;
            }
            long j2 = this.t;
            this.t = 1 + j2;
            d dVar = new d(this, j2);
            g(dVar);
            aVar.T4(dVar);
            i();
        }

        @Override // rx.b
        public void onCompleted() {
            this.o = true;
            i();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            n().offer(th);
            this.o = true;
            i();
        }

        protected void p(T t) {
            rx.internal.util.e eVar = this.k;
            if (eVar == null) {
                eVar = rx.internal.util.e.g();
                b(eVar);
                this.k = eVar;
            }
            try {
                eVar.n(this.n.l(t));
                i();
            } catch (IllegalStateException e2) {
                if (isUnsubscribed()) {
                    return;
                }
                unsubscribe();
                onError(e2);
            } catch (MissingBackpressureException e3) {
                unsubscribe();
                onError(e3);
            }
        }

        protected void q(d<T> dVar, T t) {
            rx.internal.util.e eVar = dVar.f35811j;
            if (eVar == null) {
                eVar = rx.internal.util.e.g();
                dVar.b(eVar);
                dVar.f35811j = eVar;
            }
            try {
                eVar.n(this.n.l(t));
                i();
            } catch (IllegalStateException e2) {
                if (dVar.isUnsubscribed()) {
                    return;
                }
                dVar.unsubscribe();
                dVar.onError(e2);
            } catch (MissingBackpressureException e3) {
                dVar.unsubscribe();
                dVar.onError(e3);
            }
        }

        void r(d<T> dVar) {
            rx.internal.util.e eVar = dVar.f35811j;
            if (eVar != null) {
                eVar.q();
            }
            this.l.d(dVar);
            synchronized (this.r) {
                d<?>[] dVarArr = this.s;
                int length = dVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (dVar.equals(dVarArr[i3])) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    this.s = f35812f;
                    return;
                }
                d<?>[] dVarArr2 = new d[length - 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                System.arraycopy(dVarArr, i2 + 1, dVarArr2, i2, (length - i2) - 1);
                this.s = dVarArr2;
            }
        }

        public void t(long j2) {
            e(j2);
        }

        void u(T t) {
            long j2 = this.f35816j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    if (!this.p) {
                        this.p = true;
                        z = true;
                    }
                }
            }
            if (z) {
                k(t, j2);
            } else {
                p(t);
            }
        }

        void v(d<T> dVar, T t) {
            long j2 = this.f35816j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    if (!this.p) {
                        this.p = true;
                        z = true;
                    }
                }
            }
            if (z) {
                l(dVar, t, j2);
            } else {
                q(dVar, t);
            }
        }
    }

    /* synthetic */ OperatorMerge(boolean z, int i2, a aVar) {
        this(z, i2);
    }

    public static <T> OperatorMerge<T> a(boolean z) {
        return z ? (OperatorMerge<T>) b.f35805a : (OperatorMerge<T>) c.f35806a;
    }

    public static <T> OperatorMerge<T> b(boolean z, int i2) {
        return i2 == Integer.MAX_VALUE ? a(z) : new OperatorMerge<>(z, i2);
    }

    private OperatorMerge(boolean z, int i2) {
        this.f35803a = z;
        this.f35804b = i2;
    }

    @Override // rx.k.o
    public rx.g<rx.a<? extends T>> call(rx.g<? super T> gVar) {
        e eVar = new e(gVar, this.f35803a, this.f35804b);
        MergeProducer<T> mergeProducer = new MergeProducer<>(eVar);
        eVar.f35816j = mergeProducer;
        gVar.b(eVar);
        gVar.f(mergeProducer);
        return eVar;
    }
}
