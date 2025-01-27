package com.opos.cmn.an.f.a;

import android.content.Context;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static volatile boolean f16449a = false;

    public static void a(Context context, boolean z) {
        synchronized (f.class) {
            f16449a = z;
        }
    }

    public static boolean a(Context context) {
        boolean z;
        synchronized (f.class) {
            z = f16449a;
        }
        return z;
    }
}
