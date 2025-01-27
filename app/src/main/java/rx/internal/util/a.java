package rx.internal.util;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@rx.j.b
/* loaded from: classes5.dex */
public final class a implements rx.c {

    /* renamed from: a */
    protected static final AtomicLongFieldUpdater<a> f36756a = AtomicLongFieldUpdater.newUpdater(a.class, "b");

    /* renamed from: b */
    protected volatile long f36757b;

    /* renamed from: c */
    protected boolean f36758c;

    /* renamed from: d */
    protected volatile boolean f36759d;

    /* renamed from: e */
    protected Throwable f36760e;

    /* renamed from: f */
    protected final InterfaceC0883a f36761f;

    /* renamed from: rx.internal.util.a$a */
    public interface InterfaceC0883a {
        void a(Throwable th);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public a(InterfaceC0883a interfaceC0883a) {
        this.f36761f = interfaceC0883a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r1 = r13.f36759d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r5.peek() == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        if (r13.f36757b != Long.MAX_VALUE) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r2 != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        if (r1 != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
    
        r13.f36758c = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
    
        r9 = rx.internal.util.a.f36756a.addAndGet(r13, -r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        if (r9 == 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        if (r2 != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0065, code lost:
    
        if (r1 == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        if (r2 == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006d, code lost:
    
        r13.f36758c = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006f, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0041, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0071, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0073, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0074, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002d, code lost:
    
        if (r2 == 0) goto L179;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.f36758c     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L7
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            return
        L7:
            r0 = 1
            r13.f36758c = r0     // Catch: java.lang.Throwable -> L91
            boolean r1 = r13.f36759d     // Catch: java.lang.Throwable -> L91
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            long r2 = r13.f36757b
            r4 = 0
            rx.internal.util.a$a r5 = r13.f36761f     // Catch: java.lang.Throwable -> L84
        L12:
            r6 = 0
        L13:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L1b
            if (r1 == 0) goto L36
        L1b:
            if (r1 == 0) goto L30
            java.lang.Object r9 = r5.peek()     // Catch: java.lang.Throwable -> L84
            if (r9 != 0) goto L2b
            java.lang.Throwable r1 = r13.f36760e     // Catch: java.lang.Throwable -> L29
            r5.a(r1)     // Catch: java.lang.Throwable -> L29
            return
        L29:
            r1 = move-exception
            goto L86
        L2b:
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 != 0) goto L30
            goto L36
        L30:
            java.lang.Object r9 = r5.poll()     // Catch: java.lang.Throwable -> L84
            if (r9 != 0) goto L77
        L36:
            monitor-enter(r13)     // Catch: java.lang.Throwable -> L84
            boolean r1 = r13.f36759d     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r5.peek()     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L41
            r2 = 1
            goto L42
        L41:
            r2 = 0
        L42:
            long r9 = r13.f36757b     // Catch: java.lang.Throwable -> L71
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L57
            if (r2 != 0) goto L55
            if (r1 != 0) goto L55
            r13.f36758c = r4     // Catch: java.lang.Throwable -> L75
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            return
        L55:
            r2 = r11
            goto L6b
        L57:
            java.util.concurrent.atomic.AtomicLongFieldUpdater<rx.internal.util.a> r3 = rx.internal.util.a.f36756a     // Catch: java.lang.Throwable -> L71
            int r6 = -r6
            long r9 = (long) r6     // Catch: java.lang.Throwable -> L71
            long r9 = r3.addAndGet(r13, r9)     // Catch: java.lang.Throwable -> L71
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L65
            if (r2 != 0) goto L6a
        L65:
            if (r1 == 0) goto L6d
            if (r2 == 0) goto L6a
            goto L6d
        L6a:
            r2 = r9
        L6b:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L71
            goto L12
        L6d:
            r13.f36758c = r4     // Catch: java.lang.Throwable -> L75
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            return
        L71:
            r1 = move-exception
            r0 = 0
        L73:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            throw r1     // Catch: java.lang.Throwable -> L29
        L75:
            r1 = move-exception
            goto L73
        L77:
            boolean r7 = r5.accept(r9)     // Catch: java.lang.Throwable -> L84
            if (r7 == 0) goto L7e
            return
        L7e:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L13
        L84:
            r1 = move-exception
            r0 = 0
        L86:
            if (r0 != 0) goto L90
            monitor-enter(r13)
            r13.f36758c = r4     // Catch: java.lang.Throwable -> L8d
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L8d
            goto L90
        L8d:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L8d
            throw r0
        L90:
            throw r1
        L91:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            goto L95
        L94:
            throw r0
        L95:
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.a.a():void");
    }

    public final boolean b() {
        return this.f36759d;
    }

    public final void c() {
        this.f36759d = true;
    }

    public final void d(Throwable th) {
        if (this.f36759d) {
            return;
        }
        this.f36760e = th;
        this.f36759d = true;
    }

    public final void e() {
        this.f36759d = true;
        a();
    }

    public final void f(Throwable th) {
        if (this.f36759d) {
            return;
        }
        this.f36760e = th;
        this.f36759d = true;
        a();
    }

    @Override // rx.c
    public final void request(long j2) {
        boolean z;
        long j3;
        if (j2 == 0) {
            return;
        }
        while (true) {
            long j4 = this.f36757b;
            boolean z2 = true;
            z = j4 == 0;
            if (j4 == Long.MAX_VALUE) {
                break;
            }
            if (j2 == Long.MAX_VALUE) {
                j3 = j2;
            } else {
                j3 = j4 <= Long.MAX_VALUE - j2 ? j4 + j2 : Long.MAX_VALUE;
                z2 = z;
            }
            if (f36756a.compareAndSet(this, j4, j3)) {
                z = z2;
                break;
            }
        }
        if (z) {
            a();
        }
    }
}
