package com.vivo.ic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class CLog {
    private static String PRE_TAG = "CommonLib.";
    private static String TAG = "CLog";
    private static String clientPkgName = "";
    private static int clientVersionCode = -1;
    private static String clientVersionName = "";
    private static boolean sIsDebug = false;

    public static void d(String str, String str2) {
        if (sIsDebug) {
            VLog.d(PRE_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        VLog.e(PRE_TAG + str, str2);
    }

    private static String getVersionDescribe() {
        return "lib name:CommonLib,version name:2.2.0,version code:219,build time:2019-06-13 17:49:24,commit id:b02e907,client pkg name:" + clientPkgName + ",client version name:" + clientVersionName + ",client version code:" + clientVersionCode;
    }

    public static void i(String str, String str2) {
        VLog.i(PRE_TAG + str, str2);
    }

    public static void initVersionInfo(Context context) {
        VLog.i(TAG, "initVersionInfo");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                String packageName = context.getPackageName();
                clientPkgName = packageName;
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    clientVersionCode = packageInfo.versionCode;
                    clientVersionName = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static boolean isConnectNull(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED;
    }

    private static boolean isReportSuccess(Context context) {
        return BuildConfig.VERSION_NAME.equals(context.getSharedPreferences("vivo_lib_version", 0).getString("report_success_version", ""));
    }

    private static void markReportSuccess(Context context) {
        context.getSharedPreferences("vivo_lib_version", 0).edit().putString("report_success_version", BuildConfig.VERSION_NAME).apply();
    }

    public static void setPreTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PRE_TAG = str;
    }

    public static void v(String str, String str2) {
        VLog.v(PRE_TAG + str, str2);
    }

    public static void w(String str, String str2) {
        VLog.w(PRE_TAG + str, str2);
    }

    public void setDebug(boolean z) {
        sIsDebug = z;
    }

    public static void e(String str, String str2, Throwable th) {
        VLog.e(PRE_TAG + str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        VLog.i(PRE_TAG + str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        VLog.v(PRE_TAG + str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        VLog.w(PRE_TAG + str, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        if (sIsDebug) {
            VLog.d(PRE_TAG + str, str2, th);
        }
    }
}
