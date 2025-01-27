package com.opos.cmn.an.f.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static volatile Boolean f16407a;

    /* renamed from: b */
    private static volatile Boolean f16408b;

    public static void a(boolean z) {
        synchronized (a.class) {
            f16408b = Boolean.valueOf(z);
        }
    }

    public static boolean a(Context context) {
        boolean booleanValue;
        synchronized (a.class) {
            booleanValue = Build.VERSION.SDK_INT <= 29 ? true : f16408b != null ? f16408b.booleanValue() : b(context);
        }
        return booleanValue;
    }

    public static boolean b(Context context) {
        Boolean bool;
        boolean booleanValue;
        synchronized (a.class) {
            if (f16407a == null) {
                try {
                    if (Build.VERSION.SDK_INT > 29) {
                        if (context != null) {
                            if (Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "oplus_customize_system_stable_plan_switch") == 0) {
                                bool = Boolean.FALSE;
                                f16407a = bool;
                            }
                        }
                    }
                    bool = Boolean.TRUE;
                    f16407a = bool;
                } catch (Throwable unused) {
                }
            }
            if (f16407a == null) {
                f16407a = Boolean.TRUE;
            }
            booleanValue = f16407a.booleanValue();
        }
        return booleanValue;
    }
}
