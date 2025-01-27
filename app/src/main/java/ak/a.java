package ak;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@uj.b
/* loaded from: classes5.dex */
public final class a implements qj.c {

    /* renamed from: g */
    public static final AtomicLongFieldUpdater<a> f220g = AtomicLongFieldUpdater.newUpdater(a.class, "b");

    /* renamed from: b */
    public volatile long f221b;

    /* renamed from: c */
    public boolean f222c;

    /* renamed from: d */
    public volatile boolean f223d;

    /* renamed from: e */
    public Throwable f224e;

    /* renamed from: f */
    public final InterfaceC0003a f225f;

    /* renamed from: ak.a$a */
    public interface InterfaceC0003a {
        void a(Throwable th2);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public a(InterfaceC0003a interfaceC0003a) {
        this.f225f = interfaceC0003a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        r1 = r13.f223d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r5.peek() == null) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
    
        if (r13.f221b != Long.MAX_VALUE) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r2 != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        if (r1 != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r13.f222c = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        r9 = ak.a.f220g.addAndGet(r13, -r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0067, code lost:
    
        if (r9 == 0) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r2 != false) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        if (r1 == false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        if (r2 == false) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0045, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0073, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007a, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007b, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002e, code lost:
    
        if (r2 == 0) goto L270;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.f222c     // Catch: java.lang.Throwable -> L7
            if (r0 == 0) goto La
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r0 = move-exception
            goto L94
        La:
            r0 = 1
            r13.f222c = r0     // Catch: java.lang.Throwable -> L7
            boolean r1 = r13.f223d     // Catch: java.lang.Throwable -> L7
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            long r2 = r13.f221b
            r4 = 0
            ak.a$a r5 = r13.f225f     // Catch: java.lang.Throwable -> L31
        L15:
            r6 = 0
        L16:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L1e
            if (r1 == 0) goto L3a
        L1e:
            if (r1 == 0) goto L34
            java.lang.Object r10 = r5.peek()     // Catch: java.lang.Throwable -> L31
            if (r10 != 0) goto L2e
            java.lang.Throwable r1 = r13.f224e     // Catch: java.lang.Throwable -> L2c
            r5.a(r1)     // Catch: java.lang.Throwable -> L2c
            return
        L2c:
            r1 = move-exception
            goto L89
        L2e:
            if (r9 != 0) goto L34
            goto L3a
        L31:
            r1 = move-exception
            r0 = 0
            goto L89
        L34:
            java.lang.Object r9 = r5.poll()     // Catch: java.lang.Throwable -> L31
            if (r9 != 0) goto L7c
        L3a:
            monitor-enter(r13)     // Catch: java.lang.Throwable -> L31
            boolean r1 = r13.f223d     // Catch: java.lang.Throwable -> L73
            java.lang.Object r2 = r5.peek()     // Catch: java.lang.Throwable -> L73
            if (r2 == 0) goto L45
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            long r9 = r13.f221b     // Catch: java.lang.Throwable -> L73
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L5d
            if (r2 != 0) goto L5b
            if (r1 != 0) goto L5b
            r13.f222c = r4     // Catch: java.lang.Throwable -> L59
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L59
            return
        L59:
            r1 = move-exception
            goto L7a
        L5b:
            r2 = r11
            goto L71
        L5d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater<ak.a> r3 = ak.a.f220g     // Catch: java.lang.Throwable -> L73
            int r6 = -r6
            long r9 = (long) r6     // Catch: java.lang.Throwable -> L73
            long r9 = r3.addAndGet(r13, r9)     // Catch: java.lang.Throwable -> L73
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L6b
            if (r2 != 0) goto L70
        L6b:
            if (r1 == 0) goto L76
            if (r2 == 0) goto L70
            goto L76
        L70:
            r2 = r9
        L71:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L73
            goto L15
        L73:
            r1 = move-exception
            r0 = 0
            goto L7a
        L76:
            r13.f222c = r4     // Catch: java.lang.Throwable -> L59
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L59
            return
        L7a:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L59
            throw r1     // Catch: java.lang.Throwable -> L2c
        L7c:
            boolean r7 = r5.accept(r9)     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L83
            return
        L83:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L16
        L89:
            if (r0 != 0) goto L93
            monitor-enter(r13)
            r13.f222c = r4     // Catch: java.lang.Throwable -> L90
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L90
            goto L93
        L90:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L90
            throw r0
        L93:
            throw r1
        L94:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ak.a.a():void");
    }

    public final boolean b() {
        return this.f223d;
    }

    public final void c() {
        this.f223d = true;
    }

    public final void d(Throwable th2) {
        if (this.f223d) {
            return;
        }
        this.f224e = th2;
        this.f223d = true;
    }

    public final void e() {
        this.f223d = true;
        a();
    }

    public final void f(Throwable th2) {
        if (this.f223d) {
            return;
        }
        this.f224e = th2;
        this.f223d = true;
        a();
    }

    @Override // qj.c
    public final void request(long j10) {
        boolean z10;
        long j11;
        if (j10 == 0) {
            return;
        }
        while (true) {
            long j12 = this.f221b;
            boolean z11 = true;
            z10 = j12 == 0;
            if (j12 == Long.MAX_VALUE) {
                break;
            }
            if (j10 == Long.MAX_VALUE) {
                j11 = j10;
            } else {
                j11 = j12 <= Long.MAX_VALUE - j10 ? j12 + j10 : Long.MAX_VALUE;
                z11 = z10;
            }
            if (f220g.compareAndSet(this, j12, j11)) {
                z10 = z11;
                break;
            }
        }
        if (z10) {
            a();
        }
    }
}
