package com.opos.mobad.f.a;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class n implements Runnable {

    /* renamed from: a */
    private Runnable f20788a;

    /* renamed from: b */
    private volatile long f20789b = Long.MAX_VALUE;

    public n(Runnable runnable) {
        this.f20788a = runnable;
    }

    public void a() {
        this.f20789b = Long.MAX_VALUE;
    }

    public void a(long j2) {
        long max = Math.max(0L, j2);
        this.f20789b = SystemClock.uptimeMillis() + max;
        com.opos.mobad.service.c.a(this, max);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.f20789b && (runnable = this.f20788a) != null) {
            runnable.run();
        }
    }
}
