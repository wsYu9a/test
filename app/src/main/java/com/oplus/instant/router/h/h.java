package com.oplus.instant.router.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import com.umeng.analytics.pro.am;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private static volatile String f16106a;

    /* renamed from: b */
    private static String f16107b = "com." + e() + ".instant.platform";

    /* renamed from: c */
    private static String f16108c = "com." + e() + ".instant.platform.tv";

    public static String a() {
        return "1.3.8_cb5042c_211129";
    }

    public static String b(Context context) {
        if (!f(context)) {
            return ErrorContants.NET_ERROR;
        }
        int k = k(context);
        int l = l(context);
        int m = m(context);
        if (-1 == k || -1 == l || -1 == m) {
            return ErrorContants.NET_ERROR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append("/");
        sb.append(k);
        sb.append("/");
        sb.append(m);
        try {
            return URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return sb.toString();
        }
    }

    private static boolean c(Context context, int i2) {
        return k(context) >= i2;
    }

    public static boolean d(Context context, String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String queryParameter = parse.getQueryParameter("min");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    int parseInt = Integer.parseInt(queryParameter);
                    if (parseInt >= 100) {
                        if (c(context, parseInt)) {
                            return true;
                        }
                    }
                } catch (NumberFormatException e2) {
                    d.d("VersionUtil", e2);
                }
            }
        }
        return false;
    }

    private static String e() {
        return a.a("bmVhcm1l");
    }

    public static boolean f(Context context) {
        return !TextUtils.isEmpty(j(context));
    }

    public static boolean g(Context context, String str) {
        Uri parse;
        return TextUtils.isEmpty(str) || !str.contains("min") || ((parse = Uri.parse(str)) != null && (TextUtils.isEmpty(parse.getQueryParameter("min")) || d(context, str)));
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(j(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            d.d("VersionUtil", e2);
            return -1;
        }
    }

    private static boolean i(Context context, String str) {
        try {
        } catch (Exception e2) {
            d.d("VersionUtil", e2);
        }
        return context.getPackageManager().getApplicationInfo(str, 128) != null;
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(f16106a)) {
            f16106a = n(context);
        }
        return f16106a;
    }

    private static int k(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("platformVersion")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            d.d("VersionUtil", e2);
        }
        return -1;
    }

    private static int l(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get(am.aj)) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            d.d("VersionUtil", e2);
        }
        return -1;
    }

    private static int m(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(j(context), 128);
            if (applicationInfo != null && (obj = applicationInfo.metaData.get("biz_version")) != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
        } catch (Exception e2) {
            d.d("VersionUtil", e2);
        }
        return -1;
    }

    private static String n(Context context) {
        if (com.oplus.instant.router.b.a()) {
            if (i(context, "com.oplus.instant.platform")) {
                return "com.oplus.instant.platform";
            }
            if (i(context, f16107b)) {
                return f16107b;
            }
        } else if (com.oplus.instant.router.b.b()) {
            if (i(context, "com.oplus.instant.platform.tv")) {
                return "com.oplus.instant.platform.tv";
            }
            if (i(context, f16108c)) {
                return f16108c;
            }
        }
        return "";
    }
}
