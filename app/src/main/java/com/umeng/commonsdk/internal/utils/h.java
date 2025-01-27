package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.kuaishou.weapon.p0.bi;
import com.umeng.commonsdk.internal.utils.e;
import java.io.File;

/* loaded from: classes4.dex */
public class h {
    public static boolean a() {
        return b() || c() || d() || e();
    }

    private static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return new File("/system/app/Kinguser.apk").exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    private static boolean d() {
        return new e().a(e.a.check_su_binary) != null;
    }

    private static boolean e() {
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i10 = 0; i10 < 12; i10++) {
            if (new File(strArr[i10] + bi.f10829y).exists()) {
                return true;
            }
        }
        return false;
    }
}
