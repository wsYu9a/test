package com.sigmob.sdk.downloader;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public long f19438a;

    /* renamed from: b */
    public long f19439b;

    /* renamed from: c */
    public long f19440c;

    /* renamed from: d */
    public long f19441d;

    /* renamed from: e */
    public long f19442e;

    /* renamed from: f */
    public long f19443f;

    public String a() {
        return o();
    }

    public synchronized void b() {
        this.f19442e = l();
    }

    public synchronized void c() {
        long l10 = l();
        long j10 = this.f19439b;
        long max = Math.max(1L, l10 - this.f19438a);
        this.f19439b = 0L;
        this.f19438a = l10;
        this.f19440c = (long) ((j10 / max) * 1000.0f);
    }

    public synchronized long d() {
        long l10 = l() - this.f19438a;
        if (l10 < 1000) {
            long j10 = this.f19440c;
            if (j10 != 0) {
                return j10;
            }
        }
        if (this.f19440c == 0 && l10 < 500) {
            return 0L;
        }
        return f();
    }

    public synchronized long e() {
        long j10;
        try {
            j10 = this.f19442e;
            if (j10 == 0) {
                j10 = l();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (long) ((this.f19443f / Math.max(1L, j10 - this.f19441d)) * 1000.0f);
    }

    public long f() {
        c();
        return this.f19440c;
    }

    public synchronized long g() {
        return l() - this.f19438a;
    }

    public String h() {
        return a(f(), false);
    }

    public String i() {
        return a(f(), true);
    }

    public String j() {
        return i();
    }

    public String k() {
        return a(this.f19440c, true);
    }

    public long l() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void m() {
        this.f19438a = 0L;
        this.f19439b = 0L;
        this.f19440c = 0L;
        this.f19441d = 0L;
        this.f19442e = 0L;
        this.f19443f = 0L;
    }

    public String n() {
        return a(d(), true);
    }

    public String o() {
        return a(e(), true);
    }

    public synchronized void a(long j10) {
        try {
            if (this.f19438a == 0) {
                long l10 = l();
                this.f19438a = l10;
                this.f19441d = l10;
            }
            this.f19439b += j10;
            this.f19443f += j10;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static String a(long j10, boolean z10) {
        return com.sigmob.sdk.downloader.core.c.a(j10, z10) + "/s";
    }
}
