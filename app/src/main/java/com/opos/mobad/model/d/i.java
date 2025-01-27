package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public class i extends f {

    /* renamed from: a */
    private String f21618a;

    /* renamed from: b */
    private String f21619b;

    /* renamed from: c */
    private long f21620c = SystemClock.elapsedRealtime();

    /* renamed from: d */
    private boolean f21621d;

    public i(String str, String str2, boolean z) {
        this.f21619b = str;
        this.f21618a = str2;
        this.f21621d = z;
    }

    public void a(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21619b, this.f21618a, "6", g(), SystemClock.elapsedRealtime() - this.f21620c, f(), this.f21621d);
    }

    public void a(Context context, int i2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21619b, this.f21618a, i2, g(), SystemClock.elapsedRealtime() - this.f21620c, f(), this.f21621d);
    }

    public void b(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21619b, this.f21618a, "1", g(), SystemClock.elapsedRealtime() - this.f21620c, f(), this.f21621d);
    }
}
