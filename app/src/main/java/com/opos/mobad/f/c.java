package com.opos.mobad.f;

import android.content.Context;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: a */
    private static c f20808a;

    private c() {
    }

    public static final void b(Context context) {
        synchronized (c.class) {
            c cVar = f20808a;
            if (cVar != null) {
                cVar.c();
                f20808a = null;
            }
        }
    }

    public static c d() {
        c cVar = f20808a;
        if (cVar == null) {
            synchronized (c.class) {
                if (f20808a == null) {
                    f20808a = new c();
                }
                cVar = f20808a;
            }
        }
        return cVar;
    }

    public void a(Context context, String str, int i2, boolean z, boolean z2) {
        com.opos.cmn.an.f.a.b("", "tourist mode = " + z2);
        Context applicationContext = context.getApplicationContext();
        a(applicationContext, (Integer) 1, (com.opos.mobad.ad.c) new com.opos.mobad.e(applicationContext, i2));
        a(applicationContext, z);
    }
}
