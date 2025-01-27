package com.opos.mobad.model.d;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class f extends q {

    /* renamed from: a */
    private p f21576a = new p();

    /* renamed from: b */
    private long f21577b = SystemClock.elapsedRealtime();

    public f a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f21577b;
        this.f21577b = elapsedRealtime;
        this.f21576a.a("1", String.valueOf(elapsedRealtime - j2));
        return this;
    }

    public f b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f21577b;
        this.f21577b = elapsedRealtime;
        this.f21576a.a("2", String.valueOf(elapsedRealtime - j2));
        return this;
    }

    public f c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f21577b;
        this.f21577b = elapsedRealtime;
        this.f21576a.a("3", String.valueOf(elapsedRealtime - j2));
        return this;
    }

    public f d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f21577b;
        this.f21577b = elapsedRealtime;
        this.f21576a.a("4", String.valueOf(elapsedRealtime - j2));
        return this;
    }

    public f e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f21577b;
        this.f21577b = elapsedRealtime;
        this.f21576a.a("5", String.valueOf(elapsedRealtime - j2));
        return this;
    }

    protected String f() {
        return com.opos.cmn.i.n.a(this.f21576a.a());
    }
}
