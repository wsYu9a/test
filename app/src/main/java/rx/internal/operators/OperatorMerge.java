package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import qj.a;
import qj.g;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class OperatorMerge<T> implements a.n0<T, qj.a<? extends T>> {

    /* renamed from: b */
    public final boolean f30474b;

    /* renamed from: c */
    public final int f30475c;

    public static final class MergeProducer<T> extends AtomicLong implements qj.c {
        private static final long serialVersionUID = -1214379189873595503L;
        final e<T> subscriber;

        public MergeProducer(e<T> eVar) {
            this.subscriber = eVar;
        }

        public long produced(int i10) {
            return addAndGet(-i10);
        }

        @Override // qj.c
        public void request(long j10) {
            if (j10 <= 0) {
                if (j10 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                xj.a.a(this, j10);
                this.subscriber.i();
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        public static final OperatorMerge<Object> f30476a = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    public static final class c {

        /* renamed from: a */
        public static final OperatorMerge<Object> f30477a = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    public static final class d<T> extends g<T> {

        /* renamed from: l */
        public static final int f30478l = ak.e.f246h / 4;

        /* renamed from: g */
        public final e<T> f30479g;

        /* renamed from: h */
        public final long f30480h;

        /* renamed from: i */
        public volatile boolean f30481i;

        /* renamed from: j */
        public volatile ak.e f30482j;

        /* renamed from: k */
        public int f30483k;

        public d(e<T> eVar, long j10) {
            this.f30479g = eVar;
            this.f30480h = j10;
        }

        @Override // qj.g
        public void d() {
            int i10 = ak.e.f246h;
            this.f30483k = i10;
            e(i10);
        }

        public void g(long j10) {
            int i10 = this.f30483k - ((int) j10);
            if (i10 > f30478l) {
                this.f30483k = i10;
                return;
            }
            int i11 = ak.e.f246h;
            this.f30483k = i11;
            int i12 = i11 - i10;
            if (i12 > 0) {
                e(i12);
            }
        }

        @Override // qj.b
        public void onCompleted() {
            this.f30481i = true;
            this.f30479g.i();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30481i = true;
            this.f30479g.n().offer(th2);
            this.f30479g.i();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f30479g.v(this, t10);
        }
    }

    public static final class e<T> extends g<qj.a<? extends T>> {

        /* renamed from: w */
        public static final d<?>[] f30484w = new d[0];

        /* renamed from: g */
        public final g<? super T> f30485g;

        /* renamed from: h */
        public final boolean f30486h;

        /* renamed from: i */
        public final int f30487i;

        /* renamed from: j */
        public MergeProducer<T> f30488j;

        /* renamed from: k */
        public volatile ak.e f30489k;

        /* renamed from: l */
        public volatile ik.b f30490l;

        /* renamed from: m */
        public volatile ConcurrentLinkedQueue<Throwable> f30491m;

        /* renamed from: o */
        public volatile boolean f30493o;

        /* renamed from: p */
        public boolean f30494p;

        /* renamed from: q */
        public boolean f30495q;

        /* renamed from: t */
        public long f30498t;

        /* renamed from: u */
        public long f30499u;

        /* renamed from: v */
        public int f30500v;

        /* renamed from: n */
        public final NotificationLite<T> f30492n = NotificationLite.f();

        /* renamed from: r */
        public final Object f30496r = new Object();

        /* renamed from: s */
        public volatile d<?>[] f30497s = f30484w;

        public e(g<? super T> gVar, boolean z10, int i10) {
            this.f30485g = gVar;
            this.f30486h = z10;
            this.f30487i = i10;
            e(Math.min(i10, ak.e.f246h));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(d<T> dVar) {
            m().a(dVar);
            synchronized (this.f30496r) {
                d<?>[] dVarArr = this.f30497s;
                int length = dVarArr.length;
                d<?>[] dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
                this.f30497s = dVarArr2;
            }
        }

        public boolean h() {
            if (this.f30485g.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f30491m;
            if (this.f30486h || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                s();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public void i() {
            synchronized (this) {
                try {
                    if (this.f30494p) {
                        this.f30495q = true;
                    } else {
                        this.f30494p = true;
                        j();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00c1 A[Catch: all -> 0x005d, TryCatch #9 {all -> 0x005d, blocks: (B:3:0x0003, B:4:0x0005, B:6:0x000c, B:15:0x0030, B:18:0x003f, B:23:0x0068, B:40:0x004b, B:45:0x004f, B:42:0x0061, B:53:0x007f, B:60:0x009a, B:63:0x00a5, B:67:0x00ad, B:69:0x00b1, B:72:0x00b8, B:74:0x00c1, B:77:0x00bc, B:79:0x00c7, B:81:0x00ce, B:85:0x00f9, B:87:0x0100, B:91:0x0108, B:93:0x010f, B:95:0x0114, B:97:0x011d, B:117:0x0143, B:118:0x014f, B:124:0x0159, B:127:0x0161, B:129:0x0167, B:131:0x0171, B:135:0x0177, B:139:0x017c, B:143:0x0180, B:145:0x018c, B:148:0x0194, B:192:0x00dc, B:194:0x00e5, B:198:0x00ea, B:202:0x00ed), top: B:2:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void j() {
            /*
                Method dump skipped, instructions count: 440
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.j():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void k(T r5, long r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                qj.g<? super T> r2 = r4.f30485g     // Catch: java.lang.Throwable -> L8
                r2.onNext(r5)     // Catch: java.lang.Throwable -> L8
                goto L23
            L8:
                r5 = move-exception
                boolean r2 = r4.f30486h     // Catch: java.lang.Throwable -> L19
                if (r2 != 0) goto L1c
                vj.a.e(r5)     // Catch: java.lang.Throwable -> L19
                r4.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r4.onError(r5)     // Catch: java.lang.Throwable -> L17
                return
            L17:
                r5 = move-exception
                goto L4a
            L19:
                r5 = move-exception
                r0 = 0
                goto L4a
            L1c:
                java.util.Queue r2 = r4.n()     // Catch: java.lang.Throwable -> L19
                r2.offer(r5)     // Catch: java.lang.Throwable -> L19
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L31
                rx.internal.operators.OperatorMerge$MergeProducer<T> r5 = r4.f30488j     // Catch: java.lang.Throwable -> L19
                r5.produced(r0)     // Catch: java.lang.Throwable -> L19
            L31:
                r5 = 1
                r4.t(r5)     // Catch: java.lang.Throwable -> L19
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L19
                boolean r5 = r4.f30495q     // Catch: java.lang.Throwable -> L3f
                if (r5 != 0) goto L41
                r4.f30494p = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                return
            L3f:
                r5 = move-exception
                goto L48
            L41:
                r4.f30495q = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                r4.j()
                return
            L48:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                throw r5     // Catch: java.lang.Throwable -> L17
            L4a:
                if (r0 != 0) goto L54
                monitor-enter(r4)
                r4.f30494p = r1     // Catch: java.lang.Throwable -> L51
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                goto L54
            L51:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                throw r5
            L54:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.k(java.lang.Object, long):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(rx.internal.operators.OperatorMerge.d<T> r5, T r6, long r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                qj.g<? super T> r2 = r4.f30485g     // Catch: java.lang.Throwable -> L8
                r2.onNext(r6)     // Catch: java.lang.Throwable -> L8
                goto L23
            L8:
                r6 = move-exception
                boolean r2 = r4.f30486h     // Catch: java.lang.Throwable -> L19
                if (r2 != 0) goto L1c
                vj.a.e(r6)     // Catch: java.lang.Throwable -> L19
                r5.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r5.onError(r6)     // Catch: java.lang.Throwable -> L17
                return
            L17:
                r5 = move-exception
                goto L4a
            L19:
                r5 = move-exception
                r0 = 0
                goto L4a
            L1c:
                java.util.Queue r2 = r4.n()     // Catch: java.lang.Throwable -> L19
                r2.offer(r6)     // Catch: java.lang.Throwable -> L19
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L31
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.f30488j     // Catch: java.lang.Throwable -> L19
                r6.produced(r0)     // Catch: java.lang.Throwable -> L19
            L31:
                r6 = 1
                r5.g(r6)     // Catch: java.lang.Throwable -> L19
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L19
                boolean r5 = r4.f30495q     // Catch: java.lang.Throwable -> L3f
                if (r5 != 0) goto L41
                r4.f30494p = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                return
            L3f:
                r5 = move-exception
                goto L48
            L41:
                r4.f30495q = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                r4.j()
                return
            L48:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                throw r5     // Catch: java.lang.Throwable -> L17
            L4a:
                if (r0 != 0) goto L54
                monitor-enter(r4)
                r4.f30494p = r1     // Catch: java.lang.Throwable -> L51
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                goto L54
            L51:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                throw r5
            L54:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.e.l(rx.internal.operators.OperatorMerge$d, java.lang.Object, long):void");
        }

        public ik.b m() {
            boolean z10;
            ik.b bVar = this.f30490l;
            if (bVar == null) {
                synchronized (this) {
                    try {
                        bVar = this.f30490l;
                        if (bVar == null) {
                            bVar = new ik.b();
                            this.f30490l = bVar;
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (z10) {
                    b(bVar);
                }
            }
            return bVar;
        }

        public Queue<Throwable> n() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f30491m;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    try {
                        concurrentLinkedQueue = this.f30491m;
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            this.f30491m = concurrentLinkedQueue;
                        }
                    } finally {
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        /* renamed from: o */
        public void onNext(qj.a<? extends T> aVar) {
            if (aVar == null) {
                return;
            }
            if (aVar instanceof ak.g) {
                u(((ak.g) aVar).y5());
                return;
            }
            long j10 = this.f30498t;
            this.f30498t = 1 + j10;
            d dVar = new d(this, j10);
            g(dVar);
            aVar.T4(dVar);
            i();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f30493o = true;
            i();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            n().offer(th2);
            this.f30493o = true;
            i();
        }

        public void p(T t10) {
            ak.e eVar = this.f30489k;
            if (eVar == null) {
                eVar = ak.e.g();
                b(eVar);
                this.f30489k = eVar;
            }
            try {
                eVar.n(this.f30492n.l(t10));
                i();
            } catch (IllegalStateException e10) {
                if (isUnsubscribed()) {
                    return;
                }
                unsubscribe();
                onError(e10);
            } catch (MissingBackpressureException e11) {
                unsubscribe();
                onError(e11);
            }
        }

        public void q(d<T> dVar, T t10) {
            ak.e eVar = dVar.f30482j;
            if (eVar == null) {
                eVar = ak.e.g();
                dVar.b(eVar);
                dVar.f30482j = eVar;
            }
            try {
                eVar.n(this.f30492n.l(t10));
                i();
            } catch (IllegalStateException e10) {
                if (dVar.isUnsubscribed()) {
                    return;
                }
                dVar.unsubscribe();
                dVar.onError(e10);
            } catch (MissingBackpressureException e11) {
                dVar.unsubscribe();
                dVar.onError(e11);
            }
        }

        public void r(d<T> dVar) {
            ak.e eVar = dVar.f30482j;
            if (eVar != null) {
                eVar.q();
            }
            this.f30490l.d(dVar);
            synchronized (this.f30496r) {
                try {
                    d<?>[] dVarArr = this.f30497s;
                    int length = dVarArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            i10 = -1;
                            break;
                        } else if (!dVar.equals(dVarArr[i10])) {
                            i10++;
                        }
                    }
                    if (i10 < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.f30497s = f30484w;
                        return;
                    }
                    d<?>[] dVarArr2 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i10);
                    System.arraycopy(dVarArr, i10 + 1, dVarArr2, i10, (length - i10) - 1);
                    this.f30497s = dVarArr2;
                } finally {
                }
            }
        }

        public final void s() {
            ArrayList arrayList = new ArrayList(this.f30491m);
            if (arrayList.size() == 1) {
                this.f30485g.onError((Throwable) arrayList.get(0));
            } else {
                this.f30485g.onError(new CompositeException(arrayList));
            }
        }

        public void t(long j10) {
            e(j10);
        }

        public void u(T t10) {
            long j10 = this.f30488j.get();
            boolean z10 = false;
            if (j10 != 0) {
                synchronized (this) {
                    try {
                        if (!this.f30494p) {
                            z10 = true;
                            this.f30494p = true;
                        }
                    } finally {
                    }
                }
            }
            if (z10) {
                k(t10, j10);
            } else {
                p(t10);
            }
        }

        public void v(d<T> dVar, T t10) {
            long j10 = this.f30488j.get();
            boolean z10 = false;
            if (j10 != 0) {
                synchronized (this) {
                    try {
                        if (!this.f30494p) {
                            z10 = true;
                            this.f30494p = true;
                        }
                    } finally {
                    }
                }
            }
            if (z10) {
                l(dVar, t10, j10);
            } else {
                q(dVar, t10);
            }
        }
    }

    public /* synthetic */ OperatorMerge(boolean z10, int i10, a aVar) {
        this(z10, i10);
    }

    public static <T> OperatorMerge<T> a(boolean z10) {
        return z10 ? (OperatorMerge<T>) b.f30476a : (OperatorMerge<T>) c.f30477a;
    }

    public static <T> OperatorMerge<T> b(boolean z10, int i10) {
        return i10 == Integer.MAX_VALUE ? a(z10) : new OperatorMerge<>(z10, i10);
    }

    public OperatorMerge(boolean z10, int i10) {
        this.f30474b = z10;
        this.f30475c = i10;
    }

    @Override // wj.o
    public g<qj.a<? extends T>> call(g<? super T> gVar) {
        e eVar = new e(gVar, this.f30474b, this.f30475c);
        MergeProducer<T> mergeProducer = new MergeProducer<>(eVar);
        eVar.f30488j = mergeProducer;
        gVar.b(eVar);
        gVar.f(mergeProducer);
        return eVar;
    }
}
