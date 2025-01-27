package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9316a = "android.permission.INTERNET";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9317b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9318c = "android.permission.READ_PHONE_STATE";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9319d = "android.permission.ACCESS_WIFI_STATE";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9320e = "android.permission.GET_TASKS";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9321f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9322g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9323h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i, reason: collision with root package name */
    public static final String f9324i = "android.permission.READ_EXTERNAL_STORAGE";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9325j = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (a(context, str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
