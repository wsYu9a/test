package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class l extends f {

    /* renamed from: a */
    private String f21632a;

    /* renamed from: b */
    private String f21633b;

    /* renamed from: c */
    private long f21634c = SystemClock.elapsedRealtime();

    public l(String str, String str2) {
        this.f21633b = str;
        this.f21632a = str2;
    }

    public void a(Context context, int i2, String str, boolean z, String str2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21633b, this.f21632a, i2, g(), SystemClock.elapsedRealtime() - this.f21634c, z, f(), str2);
    }

    public void a(Context context, String str, boolean z, String str2, int i2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21633b, str, this.f21632a, g(), SystemClock.elapsedRealtime() - this.f21634c, z, f(), str2, i2);
    }
}
