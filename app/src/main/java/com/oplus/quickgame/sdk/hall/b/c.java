package com.oplus.quickgame.sdk.hall.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.oplus.quickgame.sdk.hall.Constant;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {
    public static boolean a(Context context) {
        return a(context, Constant.Pkg.HALL_PKG);
    }

    private static boolean a(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        com.oplus.quickgame.sdk.hall.c.b b2 = com.oplus.quickgame.sdk.hall.c.b.b(map);
        int b3 = b(context, Constant.Pkg.HALL_PKG);
        return b3 >= 2100 && (!b2.c().equals(Constant.Path.PRO_MODE) || b3 >= 2400) && (!(b2.c().equals(Constant.Path.RECOMMEND) || b2.c().equals(Constant.Path.RECOMMEND)) || b3 >= 2800);
    }

    private static int b(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean b(Context context) {
        return a(context, Constant.Pkg.RPK_HALL_PKG);
    }
}
