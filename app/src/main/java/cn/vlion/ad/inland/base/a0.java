package cn.vlion.ad.inland.base;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class a0 {
    public static boolean a(Context context) {
        int checkSelfPermission;
        if (context == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return true;
            }
            checkSelfPermission = context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES");
            return checkSelfPermission == 0;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static boolean b(Context context) {
        int checkSelfPermission;
        int checkSelfPermission2;
        if (context == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return context.checkPermission(com.kuaishou.weapon.p0.g.f11106g, Process.myPid(), Process.myUid()) == -1 && context.checkPermission(com.kuaishou.weapon.p0.g.f11107h, Process.myPid(), Process.myUid()) == 0;
            }
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f11106g);
            if (checkSelfPermission != 0) {
                return false;
            }
            checkSelfPermission2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f11107h);
            return checkSelfPermission2 == 0;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static boolean c(Context context) {
        int checkSelfPermission;
        if (context == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return context.checkPermission(com.kuaishou.weapon.p0.g.f11102c, Process.myPid(), Process.myUid()) == -1;
            }
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f11102c);
            return checkSelfPermission == 0;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }
}
