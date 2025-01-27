package com.opos.cmn.an.f.c;

import android.content.Context;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static boolean f16474a = false;

    public static String a(Context context) {
        try {
            b(context);
            return b.h.b.a.a.b() ? b.h.b.a.a.g(context) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context) {
        if (f16474a) {
            return;
        }
        b.h.b.a.a.c(context);
        f16474a = true;
    }
}
