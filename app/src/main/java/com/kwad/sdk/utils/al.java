package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class al {
    private static Map<String, Integer> aAb;
    private static Set<String> aAc;
    private static Method aAd;

    static {
        HashSet hashSet = new HashSet();
        aAc = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aAc.add("android.permission.WRITE_SETTINGS");
        aAc.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int al(Context context, String str) {
        int am;
        if (aAb == null) {
            h(aj.cg(context));
        }
        if (aAc.contains(str) && (am = am(context, str)) != -2) {
            return am;
        }
        int an = an(context, str);
        if (an != -2) {
            return an;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return an;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int am(Context context, String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -2078357533:
                if (str.equals("android.permission.WRITE_SETTINGS")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1561629405:
                if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1777263169:
                if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.System.canWrite(context)) {
                        }
                    } catch (Throwable unused) {
                        return -2;
                    }
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.canDrawOverlays(context)) {
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        return -2;
                    }
                }
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= 26) {
                    if (aj.cf(context)) {
                    }
                }
                break;
        }
        return 0;
    }

    private static int an(Context context, String str) {
        if (aAb == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (!aAb.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = aAb.get(str);
            if (num == null) {
                return -2;
            }
            if (aAd == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                aAd = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) aAd.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return 0;
        }
    }

    public static boolean ch(Context context) {
        int i2;
        try {
            i2 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i2 = 0;
        }
        return i2 == 1;
    }

    private static String eJ(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private static void h(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        aAb = new HashMap();
        for (String str : strArr) {
            try {
                int intValue = ((Integer) s.c((Class<?>) AppOpsManager.class, "OP_" + eJ(str))).intValue();
                if (intValue >= 0) {
                    aAb.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
