package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cdo.oaps.ad.Launcher;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6559a = 2000000;

    /* renamed from: b, reason: collision with root package name */
    public static final int f6560b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6561c = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home"};

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

    public static boolean a(Context context, String str, int i2) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i2;
    }
}
