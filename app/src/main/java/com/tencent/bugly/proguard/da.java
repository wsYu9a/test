package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class da implements Runnable {

    /* renamed from: a */
    private final Handler f25052a;

    /* renamed from: b */
    private final String f25053b;

    /* renamed from: c */
    private long f25054c;

    /* renamed from: d */
    private final long f25055d;

    /* renamed from: e */
    private boolean f25056e = true;

    /* renamed from: f */
    private long f25057f;

    da(Handler handler, String str, long j2) {
        this.f25052a = handler;
        this.f25053b = str;
        this.f25054c = j2;
        this.f25055d = j2;
    }

    public int a() {
        if (this.f25056e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f25057f < this.f25054c ? 1 : 3;
    }

    public Looper b() {
        return this.f25052a.getLooper();
    }

    public String c() {
        return this.f25053b;
    }

    public boolean d() {
        return !this.f25056e && SystemClock.uptimeMillis() > this.f25057f + this.f25054c;
    }

    public void e() {
        this.f25054c = this.f25055d;
    }

    public void f() {
        if (this.f25056e) {
            this.f25056e = false;
            this.f25057f = SystemClock.uptimeMillis();
            this.f25052a.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f25056e = true;
        e();
    }

    public void a(long j2) {
        this.f25054c = j2;
    }
}
