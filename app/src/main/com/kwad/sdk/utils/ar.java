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

/* loaded from: classes3.dex */
public final class ar {
    private static Map<String, Integer> aUd;
    private static Set<String> aUe;
    private static Method aUf;

    static {
        HashSet hashSet = new HashSet();
        aUe = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aUe.add("android.permission.WRITE_SETTINGS");
        aUe.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int ar(Context context, String str) {
        int as;
        if (aUd == null) {
            h(ao.cI(context));
        }
        if (aUe.contains(str) && (as = as(context, str)) != -2) {
            return as;
        }
        int at = at(context, str);
        if (at != -2) {
            return at;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return at;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int as(Context context, String str) {
        char c10;
        boolean canWrite;
        boolean canDrawOverlays;
        str.hashCode();
        switch (str.hashCode()) {
            case -2078357533:
                if (str.equals("android.permission.WRITE_SETTINGS")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1561629405:
                if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 1777263169:
                if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        canWrite = Settings.System.canWrite(context);
                        if (canWrite) {
                        }
                    } catch (Throwable unused) {
                        return -2;
                    }
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        canDrawOverlays = Settings.canDrawOverlays(context);
                        if (canDrawOverlays) {
                        }
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        return -2;
                    }
                }
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= 26) {
                    if (ao.cH(context)) {
                    }
                }
                break;
        }
        return -1;
    }

    private static int at(Context context, String str) {
        if (aUd == null || str == null || !aUd.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = aUd.get(str);
            if (num == null) {
                return -2;
            }
            if (aUf == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                aUf = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) aUf.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return 0;
        }
    }

    public static boolean cJ(Context context) {
        int i10;
        try {
            i10 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i10 = 0;
        }
        return i10 == 1;
    }

    private static String gU(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(p1.b.f29697h);
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
        if (strArr == null) {
            return;
        }
        aUd = new HashMap();
        for (String str : strArr) {
            try {
                Integer num = (Integer) w.c((Class<?>) AppOpsManager.class, "OP_" + gU(str));
                if (num.intValue() >= 0) {
                    aUd.put(str, num);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
