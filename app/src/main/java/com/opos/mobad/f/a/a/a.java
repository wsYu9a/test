package com.opos.mobad.f.a.a;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    private com.opos.mobad.service.i.c f20556a = new com.opos.mobad.service.i.c();

    /* renamed from: b */
    private String f20557b;

    /* renamed from: c */
    private String f20558c;

    /* renamed from: d */
    private volatile long f20559d;

    /* renamed from: e */
    private long f20560e;

    public a(String str, long j2) {
        this.f20557b = str;
        this.f20560e = j2;
        this.f20560e = j2;
    }

    public void a() {
        a("t", 0);
    }

    public void a(int i2) {
        a(this.f20557b, this.f20560e, this.f20558c, i2, SystemClock.elapsedRealtime() - this.f20559d, this.f20556a.b());
        this.f20558c = null;
        this.f20556a = new com.opos.mobad.service.i.c();
    }

    public void a(int i2, int i3) {
        a(String.valueOf(i2), i3);
    }

    public void a(String str) {
        this.f20558c = str;
        this.f20559d = SystemClock.elapsedRealtime();
    }

    protected final void a(String str, int i2) {
        if (this.f20556a.a() >= 1024) {
            com.opos.cmn.an.f.a.b("", "illegal append report");
        } else {
            this.f20556a.a(str, String.valueOf(i2));
        }
    }

    protected abstract void a(String str, long j2, String str2, int i2, long j3, String str3);

    public void b() {
        a("t", 1);
    }

    public void b(int i2) {
        b(this.f20557b, this.f20560e, this.f20558c, i2, SystemClock.elapsedRealtime() - this.f20559d, this.f20556a.b());
        this.f20558c = null;
        this.f20556a = new com.opos.mobad.service.i.c();
    }

    protected abstract void b(String str, long j2, String str2, int i2, long j3, String str3);

    public void c() {
        a("t", 2);
    }

    public void c(int i2) {
        if (i2 != 1035) {
            b(i2);
        } else {
            com.opos.mobad.service.d.b.a().a(this.f20557b);
            this.f20556a = new com.opos.mobad.service.i.c();
        }
    }
}
