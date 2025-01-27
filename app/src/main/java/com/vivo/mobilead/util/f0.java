package com.vivo.mobilead.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class f0 {

    /* renamed from: a */
    private static long f30620a = 0;

    /* renamed from: b */
    private static int f30621b = -1;

    public static String a(Context context) {
        if (context == null || context.getPackageManager() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(5);
            if (installedPackages != null && installedPackages.size() > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < installedPackages.size() && i2 < 300; i3++) {
                    PackageInfo packageInfo = installedPackages.get(i3);
                    if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) <= 0 && !TextUtils.isEmpty(packageInfo.packageName)) {
                        i2++;
                        if (sb.length() == 0) {
                            sb.append("{");
                        }
                        sb.append(packageInfo.packageName);
                        sb.append(",");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "}");
        }
        return sb.toString();
    }

    public static boolean b() {
        return h0.K().I();
    }

    public static boolean c() {
        return System.currentTimeMillis() - a() > 3600000;
    }

    public static int a(Context context, String str) {
        int i2 = f30621b;
        if (i2 != -1) {
            return i2;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            PackageInfo packageInfo = null;
            try {
                if (context.getPackageManager() != null) {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                }
            } catch (Exception unused) {
            }
            if (packageInfo == null) {
                f30621b = 0;
            } else {
                f30621b = 1;
            }
            return f30621b;
        }
        f30621b = 0;
        return 0;
    }

    public static void a(long j2) {
        f30620a = j2;
        com.vivo.mobilead.manager.b.l().a(j2);
    }

    private static long a() {
        long j2 = f30620a;
        return j2 != 0 ? j2 : com.vivo.mobilead.manager.b.l().a();
    }
}
