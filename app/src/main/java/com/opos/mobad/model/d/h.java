package com.opos.mobad.model.d;

import android.content.Context;

/* loaded from: classes4.dex */
public class h extends q {

    /* renamed from: a */
    private String f21615a;

    /* renamed from: b */
    private String f21616b;

    /* renamed from: c */
    private long f21617c = System.currentTimeMillis();

    public h(String str, String str2) {
        this.f21615a = str;
        this.f21616b = str2;
    }

    public void a(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21615a, this.f21616b, 0, g(), System.currentTimeMillis() - this.f21617c);
    }

    public void a(Context context, int i2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f21615a, this.f21616b, i2, g(), System.currentTimeMillis() - this.f21617c);
    }
}
