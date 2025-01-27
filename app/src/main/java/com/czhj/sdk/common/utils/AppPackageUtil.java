package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes2.dex */
public class AppPackageUtil {

    /* renamed from: a */
    public static String f8578a;

    /* renamed from: b */
    public static String f8579b;

    /* renamed from: c */
    public static PackageInfo f8580c;

    /* renamed from: d */
    public static String f8581d;

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f8581d)) {
            return f8581d;
        }
        try {
            if (context.getApplicationInfo() != null) {
                f8581d = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return f8581d;
    }

    public static String getAppPackageName(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f8578a)) {
            return f8578a;
        }
        String packageName = context.getPackageName();
        f8578a = packageName;
        return packageName;
    }

    public static String getAppVersionFromContext(Context context) {
        try {
            if (!TextUtils.isEmpty(f8579b)) {
                return f8579b;
            }
            PackageInfo packageInfo = getPackageInfo(context);
            if (packageInfo != null) {
                f8579b = packageInfo.versionName;
            }
            return f8579b;
        } catch (Throwable unused) {
            SigmobLog.d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (f8580c == null) {
            PackageManager packageManager = getPackageManager(context);
            String appPackageName = getAppPackageName(context);
            if (packageManager == null || appPackageName == null) {
                return null;
            }
            try {
                f8580c = packageManager.getPackageInfo(appPackageName, 0);
            } catch (Throwable unused) {
            }
        }
        return f8580c;
    }

    public static PackageManager getPackageManager(Context context) {
        if (context != null) {
            return context.getPackageManager();
        }
        return null;
    }

    public static int getPackageVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return -1;
        }
    }
}
