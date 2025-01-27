package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class da implements Runnable {

    /* renamed from: a */
    private final Handler f22719a;

    /* renamed from: b */
    private final String f22720b;

    /* renamed from: c */
    private long f22721c;

    /* renamed from: d */
    private final long f22722d;

    /* renamed from: e */
    private boolean f22723e = true;

    /* renamed from: f */
    private long f22724f;

    public da(Handler handler, String str, long j10) {
        this.f22719a = handler;
        this.f22720b = str;
        this.f22721c = j10;
        this.f22722d = j10;
    }

    public int a() {
        if (this.f22723e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f22724f < this.f22721c ? 1 : 3;
    }

    public Looper b() {
        return this.f22719a.getLooper();
    }

    public String c() {
        return this.f22720b;
    }

    public boolean d() {
        return !this.f22723e && SystemClock.uptimeMillis() > this.f22724f + this.f22721c;
    }

    public void e() {
        this.f22721c = this.f22722d;
    }

    public void f() {
        if (this.f22723e) {
            this.f22723e = false;
            this.f22724f = SystemClock.uptimeMillis();
            this.f22719a.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22723e = true;
        e();
    }

    public void a(long j10) {
        this.f22721c = j10;
    }
}
