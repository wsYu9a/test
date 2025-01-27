package com.opos.cmn.i;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class m implements Runnable {

    /* renamed from: a */
    private Runnable f17435a;

    /* renamed from: b */
    private volatile long f17436b = Long.MAX_VALUE;

    /* renamed from: c */
    private Handler f17437c;

    public m(Handler handler, Runnable runnable) {
        this.f17437c = handler;
        this.f17435a = runnable;
    }

    public void a() {
        this.f17436b = Long.MAX_VALUE;
    }

    public void a(long j2) {
        long max = Math.max(0L, j2);
        this.f17436b = SystemClock.uptimeMillis() + max;
        this.f17437c.postDelayed(this, max);
    }

    public void b() {
        this.f17437c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis >= this.f17436b) {
            Runnable runnable = this.f17435a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.f17436b + ",current:" + uptimeMillis);
    }
}
