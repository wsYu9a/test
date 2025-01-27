package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private String f21628a;

    /* renamed from: b */
    private String f21629b;

    /* renamed from: c */
    private long f21630c = SystemClock.elapsedRealtime();

    /* renamed from: d */
    private p f21631d = new p();

    public k(String str, String str2) {
        this.f21629b = str;
        this.f21628a = str2;
    }

    public void a(int i2) {
        this.f21631d.a("1", i2);
    }

    public void a(Context context, int i2, String str, boolean z, String str2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21629b, this.f21628a, i2, SystemClock.elapsedRealtime() - this.f21630c, z, com.opos.cmn.i.n.a(this.f21631d.a()), str2);
    }

    public void a(Context context, String str, boolean z, String str2, int i2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21629b, str, this.f21628a, SystemClock.elapsedRealtime() - this.f21630c, z, com.opos.cmn.i.n.a(this.f21631d.a()), str2, i2);
    }

    public void b(int i2) {
        this.f21631d.a("2", i2);
    }

    public void c(int i2) {
        this.f21631d.a("3", i2);
    }

    public void d(int i2) {
        this.f21631d.a("4", i2);
    }
}
