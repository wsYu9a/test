package com.opos.mobad.service;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile Context f23541a;

    /* renamed from: b */
    private static volatile Context f23542b;

    public static Context a(Context context) {
        return f23541a != null ? f23541a : context;
    }

    public static void a() {
        f23541a = null;
        f23542b = null;
    }

    public static void a(Context context, Context context2) {
        f23541a = context;
        f23542b = context2;
    }

    public static Context b(Context context) {
        return f23542b != null ? f23542b : context;
    }
}
