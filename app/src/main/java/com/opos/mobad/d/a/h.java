package com.opos.mobad.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.mobad.d.a.d;

/* loaded from: classes4.dex */
public class h implements Runnable {

    /* renamed from: c */
    private static Handler f20433c = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private Runnable f20434a;

    /* renamed from: b */
    private volatile long f20435b = Long.MAX_VALUE;

    /* renamed from: d */
    private int f20436d;

    public h(d.a aVar) {
        this.f20436d = aVar.a();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f20434a != null) {
            com.opos.cmn.an.f.a.b("TimeoutController", "start but is running");
            return;
        }
        this.f20434a = runnable;
        long max = Math.max(0L, j2);
        this.f20435b = SystemClock.elapsedRealtime() + max;
        f20433c.postDelayed(this, max);
    }

    public boolean a() {
        return this.f20434a != null;
    }

    public int b() {
        return this.f20436d;
    }

    public void c() {
        this.f20435b = Long.MAX_VALUE;
    }

    public void d() {
        f20433c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.elapsedRealtime() >= this.f20435b && (runnable = this.f20434a) != null) {
            runnable.run();
            this.f20434a = null;
        }
    }
}
