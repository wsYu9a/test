package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.opos.acs.st.utils.ErrorContants;
import com.umeng.analytics.pro.am;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes4.dex */
public class n {
    public static int a() {
        return 1010;
    }

    private static int a(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(am.aj)) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    private static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128).packageName.equals(str);
        } catch (Exception unused) {
            return false;
        }
    }

    private static int b(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("biz_version")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    public static String c(Context context) {
        String str;
        String str2;
        try {
            String a2 = c.a("Y29tLmhleXRhcC54Z2FtZQ==");
            String str3 = context.getPackageManager().getPackageInfo(a2, 0).versionName;
            if (str3.contains("_")) {
                str3 = str3.substring(0, str3.indexOf("_"));
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(a2, 128);
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            if (applicationInfo.metaData.get(am.aj) == null) {
                str = "";
            } else {
                str = "_" + applicationInfo.metaData.get(am.aj);
            }
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (applicationInfo.metaData.get("versionCommit") == null) {
                str2 = "";
            } else {
                str2 = "_" + applicationInfo.metaData.get("versionCommit");
            }
            sb3.append(str2);
            return sb3.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static int e(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c.a("Y29tLmhleXRhcC54Z2FtZQ=="), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("platformVersion")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    public static String f(Context context) {
        if (!g(context)) {
            return ErrorContants.NET_ERROR;
        }
        int e2 = e(context);
        int a2 = a(context);
        int b2 = b(context);
        if (-1 == e2 || -1 == a2 || -1 == b2) {
            return ErrorContants.NET_ERROR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("/");
        sb.append(e2);
        sb.append("/");
        sb.append(b2);
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return sb.toString();
        }
    }

    public static boolean g(Context context) {
        return a(context, c.a("Y29tLmhleXRhcC54Z2FtZQ=="));
    }
}
