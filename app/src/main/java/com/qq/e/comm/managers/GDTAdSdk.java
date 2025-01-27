package com.qq.e.comm.managers;

import android.content.Context;

/* loaded from: classes.dex */
public class GDTAdSdk {
    public static IGDTAdManager getGDTAdManger() {
        return b.b();
    }

    public static void init(Context context, String str) {
        b.b().a(context, str);
    }
}
