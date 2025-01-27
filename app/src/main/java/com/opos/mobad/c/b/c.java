package com.opos.mobad.c.b;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a */
    private Runnable f20037a;

    /* renamed from: b */
    private volatile long f20038b = Long.MAX_VALUE;

    /* renamed from: c */
    private Handler f20039c;

    public c(Handler handler, Runnable runnable) {
        this.f20039c = handler;
        this.f20037a = runnable;
    }

    public void a() {
        this.f20038b = Long.MAX_VALUE;
    }

    public void a(long j2) {
        long max = Math.max(0L, j2);
        this.f20038b = SystemClock.uptimeMillis() + max;
        this.f20039c.postDelayed(this, max);
    }

    public void b() {
        this.f20039c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis >= this.f20038b) {
            Runnable runnable = this.f20037a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.f20038b + ",current:" + uptimeMillis);
    }
}
