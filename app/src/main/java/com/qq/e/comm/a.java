package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.kuaishou.weapon.p0.g;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        boolean z2;
        Class<?> cls;
        Intent intent;
        String str;
        try {
            String[] strArr = {"android.permission.INTERNET", g.f9317b, g.f9319d};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    str = strArr[i2];
                } catch (Throwable th) {
                    GDTLogger.e("检查权限时发生异常", th);
                }
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z || !a(context, Class.forName(CustomPkgConstants.getADActivityName())) || !a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) || !a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
            for (int i3 = 0; i3 < 1; i3++) {
                try {
                    cls = clsArr[i3];
                    intent = new Intent();
                    intent.setClass(context, cls);
                } catch (Throwable th2) {
                    GDTLogger.e("检查Service时发生异常", th2);
                }
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            return z2;
        } catch (Throwable th3) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th3);
            return false;
        }
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i2]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i2].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }
}
