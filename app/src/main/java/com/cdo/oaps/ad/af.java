package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cdo.oaps.ad.Launcher;

/* loaded from: classes.dex */
public class af {

    /* renamed from: a */
    public static final int f6504a = 5100;

    /* renamed from: b */
    public static final int f6505b = 4600;

    /* renamed from: c */
    public static final int f6506c = 4550;

    /* renamed from: d */
    public static final int f6507d = 390;

    /* renamed from: e */
    public static final String f6508e = "com.heytap.market";

    /* renamed from: f */
    public static final String[] f6509f = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home"};

    /* renamed from: g */
    public static final String[] f6510g = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home", Launcher.Path.PREDOWN};

    /* renamed from: h */
    public static final String[] f6511h = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home", Launcher.Path.PREDOWN, "/web"};

    public static int a(Context context) {
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
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(f6508e, 0);
                if (packageInfo2 != null) {
                    return packageInfo2.versionCode;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
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
        int a2 = a(context);
        return a2 != 0 && a2 >= i2;
    }

    public static boolean a(Context context, String str, int i2) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i2;
    }

    public static String b(Context context) {
        if (b(context, f6508e)) {
            return f6508e;
        }
        if (b(context, a.b())) {
            return a.b();
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 8192) != null;
    }
}
