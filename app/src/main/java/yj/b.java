package yj;

import java.util.ArrayList;
import java.util.List;
import qj.c;
import qj.g;

/* loaded from: classes5.dex */
public final class b<T> implements c, qj.b<T> {

    /* renamed from: k */
    public static final c f33553k = new a();

    /* renamed from: b */
    public final g<? super T> f33554b;

    /* renamed from: c */
    public boolean f33555c;

    /* renamed from: d */
    public List<T> f33556d;

    /* renamed from: e */
    public c f33557e;

    /* renamed from: f */
    public long f33558f;

    /* renamed from: g */
    public long f33559g;

    /* renamed from: h */
    public c f33560h;

    /* renamed from: i */
    public Object f33561i;

    /* renamed from: j */
    public volatile boolean f33562j;

    public b(g<? super T> gVar) {
        this.f33554b = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0002, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r15 = this;
            qj.g<? super T> r0 = r15.f33554b
        L2:
            monitor-enter(r15)
            long r1 = r15.f33559g     // Catch: java.lang.Throwable -> L1c
            qj.c r3 = r15.f33560h     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r4 = r15.f33561i     // Catch: java.lang.Throwable -> L1c
            java.util.List<T> r5 = r15.f33556d     // Catch: java.lang.Throwable -> L1c
            r6 = 0
            r7 = 0
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 != 0) goto L1f
            if (r3 != 0) goto L1f
            if (r5 != 0) goto L1f
            if (r4 != 0) goto L1f
            r15.f33555c = r6     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L1c
            return
        L1c:
            r0 = move-exception
            goto Lc2
        L1f:
            r15.f33559g = r7     // Catch: java.lang.Throwable -> L1c
            r10 = 0
            r15.f33560h = r10     // Catch: java.lang.Throwable -> L1c
            r15.f33556d = r10     // Catch: java.lang.Throwable -> L1c
            r15.f33561i = r10     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L1c
            if (r5 == 0) goto L31
            boolean r11 = r5.isEmpty()
            if (r11 == 0) goto L32
        L31:
            r6 = 1
        L32:
            if (r4 == 0) goto L44
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            if (r4 == r11) goto L3e
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0.onError(r4)
            return
        L3e:
            if (r6 == 0) goto L44
            r0.onCompleted()
            return
        L44:
            if (r5 == 0) goto L76
            java.util.Iterator r4 = r5.iterator()
        L4a:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L70
            java.lang.Object r6 = r4.next()
            boolean r11 = r0.isUnsubscribed()
            if (r11 == 0) goto L5b
            return
        L5b:
            boolean r11 = r15.f33562j
            if (r11 == 0) goto L60
            goto L2
        L60:
            r0.onNext(r6)     // Catch: java.lang.Throwable -> L64
            goto L4a
        L64:
            r1 = move-exception
            vj.a.e(r1)
            java.lang.Throwable r1 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r6)
            r0.onError(r1)
            return
        L70:
            int r4 = r5.size()
            long r4 = (long) r4
            goto L77
        L76:
            r4 = r7
        L77:
            long r11 = r15.f33558f
            r13 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 == 0) goto La2
            if (r9 == 0) goto L8a
            long r11 = r11 + r1
            int r6 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r6 >= 0) goto L8a
            r11 = r13
        L8a:
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 == 0) goto La0
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 == 0) goto La0
            long r11 = r11 - r4
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 < 0) goto L98
            goto La0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "More produced than requested"
            r0.<init>(r1)
            throw r0
        La0:
            r15.f33558f = r11
        La2:
            if (r3 == 0) goto Lb7
            qj.c r1 = yj.b.f33553k
            if (r3 != r1) goto Lac
            r15.f33557e = r10
            goto L2
        Lac:
            r15.f33557e = r3
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 == 0) goto L2
            r3.request(r11)
            goto L2
        Lb7:
            qj.c r3 = r15.f33557e
            if (r3 == 0) goto L2
            if (r9 == 0) goto L2
            r3.request(r1)
            goto L2
        Lc2:
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L1c
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yj.b.a():void");
    }

    public void b(c cVar) {
        synchronized (this) {
            try {
                if (this.f33555c) {
                    if (cVar == null) {
                        cVar = f33553k;
                    }
                    this.f33560h = cVar;
                    return;
                }
                this.f33555c = true;
                try {
                    this.f33557e = cVar;
                    long j10 = this.f33558f;
                    if (cVar != null && j10 != 0) {
                        cVar.request(j10);
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33555c = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    @Override // qj.b
    public void onCompleted() {
        synchronized (this) {
            try {
                if (this.f33555c) {
                    this.f33561i = Boolean.TRUE;
                } else {
                    this.f33555c = true;
                    this.f33554b.onCompleted();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        boolean z10;
        synchronized (this) {
            try {
                if (this.f33555c) {
                    this.f33561i = th2;
                    z10 = false;
                } else {
                    this.f33555c = true;
                    z10 = true;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z10) {
            this.f33554b.onError(th2);
        } else {
            this.f33562j = true;
        }
    }

    @Override // qj.b
    public void onNext(T t10) {
        synchronized (this) {
            try {
                if (this.f33555c) {
                    List list = this.f33556d;
                    if (list == null) {
                        list = new ArrayList(4);
                        this.f33556d = list;
                    }
                    list.add(t10);
                    return;
                }
                try {
                    this.f33554b.onNext(t10);
                    long j10 = this.f33558f;
                    if (j10 != Long.MAX_VALUE) {
                        this.f33558f = j10 - 1;
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33555c = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    @Override // qj.c
    public void request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j10 == 0) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f33555c) {
                    this.f33559g += j10;
                    return;
                }
                this.f33555c = true;
                try {
                    long j11 = this.f33558f + j10;
                    if (j11 < 0) {
                        j11 = Long.MAX_VALUE;
                    }
                    this.f33558f = j11;
                    c cVar = this.f33557e;
                    if (cVar != null) {
                        cVar.request(j10);
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33555c = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    public static class a implements c {
        @Override // qj.c
        public void request(long j10) {
        }
    }
}
