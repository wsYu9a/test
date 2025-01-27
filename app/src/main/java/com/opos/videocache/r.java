package com.opos.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class r {

    /* renamed from: a */
    private final i f23848a;

    /* renamed from: b */
    private final com.opos.videocache.a f23849b;

    /* renamed from: f */
    private volatile Thread f23853f;

    /* renamed from: g */
    private volatile boolean f23854g;

    /* renamed from: c */
    private final Object f23850c = new Object();

    /* renamed from: d */
    private final Object f23851d = new Object();

    /* renamed from: h */
    private volatile int f23855h = -1;

    /* renamed from: e */
    private final AtomicInteger f23852e = new AtomicInteger();

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(r rVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.e();
        }
    }

    public r(i iVar, com.opos.videocache.a aVar) {
        this.f23848a = (i) f.a(iVar);
        this.f23849b = (com.opos.videocache.a) f.a(aVar);
    }

    private void b() {
        int i2 = this.f23852e.get();
        if (i2 < 1) {
            return;
        }
        this.f23852e.set(0);
        throw new g("Error reading source " + i2 + " times");
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f23850c) {
            this.f23850c.notifyAll();
        }
    }

    private void c() {
        synchronized (this) {
            boolean z = (this.f23853f == null || this.f23853f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.f23854g && !this.f23849b.d() && !z) {
                this.f23853f = new Thread(new a(), "Source reader for " + this.f23848a);
                this.f23853f.start();
            }
        }
    }

    private void d() {
        synchronized (this.f23850c) {
            try {
                try {
                    this.f23850c.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new g("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.opos.videocache.a r4 = r8.f23849b     // Catch: java.lang.Throwable -> L43
            long r2 = r4.a()     // Catch: java.lang.Throwable -> L43
            com.opos.videocache.i r4 = r8.f23848a     // Catch: java.lang.Throwable -> L43
            r4.a(r2)     // Catch: java.lang.Throwable -> L43
            com.opos.videocache.i r4 = r8.f23848a     // Catch: java.lang.Throwable -> L43
            long r0 = r4.a()     // Catch: java.lang.Throwable -> L43
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L43
        L19:
            com.opos.videocache.i r5 = r8.f23848a     // Catch: java.lang.Throwable -> L43
            int r5 = r5.a(r4)     // Catch: java.lang.Throwable -> L43
            r6 = -1
            if (r5 == r6) goto L3c
            java.lang.Object r6 = r8.f23851d     // Catch: java.lang.Throwable -> L43
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L43
            boolean r7 = r8.h()     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto L2d
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            goto L4c
        L2d:
            com.opos.videocache.a r7 = r8.f23849b     // Catch: java.lang.Throwable -> L39
            r7.a(r4, r5)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.b(r2, r0)     // Catch: java.lang.Throwable -> L43
            goto L19
        L39:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L39
            throw r4     // Catch: java.lang.Throwable -> L43
        L3c:
            r8.g()     // Catch: java.lang.Throwable -> L43
            r8.f()     // Catch: java.lang.Throwable -> L43
            goto L4c
        L43:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.f23852e     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            r8.a(r4)     // Catch: java.lang.Throwable -> L53
        L4c:
            r8.i()
            r8.b(r2, r0)
            return
        L53:
            r4 = move-exception
            r8.i()
            r8.b(r2, r0)
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.videocache.r.e():void");
    }

    private void f() {
        this.f23855h = 100;
        a(this.f23855h);
    }

    private void g() {
        synchronized (this.f23851d) {
            if (!h() && this.f23849b.a() == this.f23848a.a()) {
                this.f23849b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f23854g;
    }

    private void i() {
        try {
            this.f23848a.b();
        } catch (g e2) {
            a(new g("Error closing source " + this.f23848a, e2));
        }
    }

    public int a(byte[] bArr, long j2, int i2) {
        h.a(bArr, j2, i2);
        while (!this.f23849b.d() && this.f23849b.a() < i2 + j2 && !this.f23854g) {
            c();
            d();
            b();
        }
        int a2 = this.f23849b.a(bArr, j2, i2);
        if (this.f23849b.d() && this.f23855h != 100) {
            this.f23855h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f23851d) {
            com.opos.cmn.an.f.a.b("ProxyCache", "Shutdown proxy for " + this.f23848a);
            try {
                this.f23854g = true;
                if (this.f23853f != null) {
                    this.f23853f.interrupt();
                }
                this.f23849b.b();
            } catch (g e2) {
                a(e2);
            }
        }
    }

    protected void a(int i2) {
    }

    protected void a(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j2 / j3) * 100.0f);
        boolean z = i2 != this.f23855h;
        if ((j3 >= 0) && z) {
            a(i2);
        }
        this.f23855h = i2;
    }

    protected final void a(Throwable th) {
        if (th instanceof e) {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.opos.cmn.an.f.a.b("ProxyCache", "ProxyCache error", th);
        }
    }
}
