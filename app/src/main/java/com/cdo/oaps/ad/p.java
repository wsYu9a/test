package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    public static final int f6549a = 5100;

    /* renamed from: b */
    public static final int f6550b = 5000;

    /* renamed from: c */
    public static final int f6551c = 4600;

    /* renamed from: d */
    public static final int f6552d = 4550;

    /* renamed from: e */
    public static final int f6553e = 390;

    /* renamed from: f */
    public static final int f6554f = 6500;

    /* renamed from: g */
    public static final int f6555g = 6600;

    /* renamed from: h */
    public static final int f6556h = 2000000;

    /* renamed from: i */
    public static final int f6557i = 1;

    /* renamed from: j */
    public static final int f6558j = 7200;
    public static final int k = 8300;

    public static int a(Context context) {
        return a(context, "com.nearme.gamecenter");
    }

    public static int a(Context context, String str) {
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

    public static boolean a(Context context, int i2) {
        try {
            return context.getPackageManager().getPackageInfo("com.nearme.gamecenter", 0).versionCode >= i2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, int i2) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i2;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return !"mk".equals(OapsWrapper.wrapper(map).getHost()) || b(context) >= 5320 || TextUtils.isEmpty(BaseWrapper.wrapper(map).getBasePkg());
    }

    public static int b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a.b(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e2) {
            if (!(e2 instanceof PackageManager.NameNotFoundException)) {
                return 0;
            }
            try {
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(af.f6508e, 0);
                if (packageInfo2 != null) {
                    return packageInfo2.versionCode;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public static boolean b(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 8192) != null;
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return !Launcher.Host.GC.equals(OapsWrapper.wrapper(map).getHost()) || a(context, "com.nearme.gamecenter") >= 7300;
    }
}
