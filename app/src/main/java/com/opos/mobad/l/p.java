package com.opos.mobad.l;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class p implements Runnable {

    /* renamed from: a */
    private Runnable f21228a;

    /* renamed from: b */
    private volatile long f21229b = Long.MAX_VALUE;

    /* renamed from: c */
    private Handler f21230c;

    public p(Handler handler, Runnable runnable) {
        this.f21230c = handler;
        this.f21228a = runnable;
    }

    public void a() {
        this.f21229b = Long.MAX_VALUE;
    }

    public void a(long j2) {
        long max = Math.max(0L, j2);
        this.f21229b = SystemClock.uptimeMillis() + max;
        this.f21230c.postDelayed(this, max);
    }

    public void b() {
        this.f21230c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.f21229b && (runnable = this.f21228a) != null) {
            runnable.run();
        }
    }
}
