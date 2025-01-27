package com.shu.priory.param;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.baidu.mobads.sdk.internal.bm;
import com.kuaishou.weapon.p0.g;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import com.shu.priory.utils.i;
import com.shu.priory.utils.k;
import com.umeng.analytics.pro.bt;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    private static String f17179a = null;

    /* renamed from: b */
    private static String f17180b = null;

    /* renamed from: c */
    private static volatile int f17181c = -1;

    /* renamed from: com.shu.priory.param.c$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17182a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.n(context);
        }
    }

    public static int a() {
        return f17181c;
    }

    private static int b() {
        return 0;
    }

    private static String c() {
        return Build.VERSION.RELEASE;
    }

    private static String d() {
        return k.a();
    }

    public static int e(Context context) {
        return o(context).widthPixels;
    }

    public static int f(Context context) {
        return o(context).heightPixels;
    }

    public static String g(Context context) {
        String a10 = a(context, "com.huawei.hwid");
        return a10 == null ? "" : a10;
    }

    private static int i(Context context) {
        if (f17181c != -1) {
            return f17181c;
        }
        String d10 = d(context);
        if (TextUtils.isEmpty(d10)) {
            return -1;
        }
        int i10 = 0;
        if ((!d10.contains("Mobile") || !d10.contains("Android")) && d10.contains("Android") && j(context)) {
            i10 = 1;
        }
        f17181c = i10;
        return i10;
    }

    private static boolean j(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static int k(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    private static int l(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                return 0;
            }
            if (!networkOperator.contains("46000") && !networkOperator.contains("46002") && !networkOperator.contains("46004") && !networkOperator.contains("46007")) {
                if (!networkOperator.contains("46001") && !networkOperator.contains("46006") && !networkOperator.contains("46009")) {
                    if (!networkOperator.contains("46003") && !networkOperator.contains("46005")) {
                        if (!networkOperator.contains("46011")) {
                            return 0;
                        }
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "Get carrier failed:" + th2.getMessage());
            return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static int m(Context context) {
        if (!i.a(context, g.f11101b)) {
            return 0;
        }
        String c10 = k.c(context);
        if (c10.contains("wifi")) {
            return 2;
        }
        if (c10.contains("2g")) {
            return 4;
        }
        if (c10.contains("3g")) {
            return 5;
        }
        return c10.contains("4g") ? 6 : 0;
    }

    public static String n(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        if (context.getFilesDir().getPath().contains(context.getPackageName())) {
            try {
                str = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable th2) {
                h.d(SDKConstants.TAG, "get UA failed:" + th2.toString());
            }
        }
        if (!TextUtils.isEmpty(str)) {
            com.shu.priory.utils.e.a(context, "IFLY_AD_UA", str);
        }
        return str;
    }

    private static DisplayMetrics o(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private static int p(Context context) {
        return 0;
    }

    private static String q(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    private static String r(Context context) {
        String a10 = a(context, "com.huawei.appmarket");
        return a10 == null ? "" : a10;
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo b10 = b(context, str);
            if (b10 == null) {
                return null;
            }
            return String.valueOf(b10.versionCode);
        } catch (AndroidRuntimeException | Exception unused) {
            h.d(SDKConstants.TAG, "getVersionCode fail");
            return null;
        }
    }

    public static PackageInfo b(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            h.d(SDKConstants.TAG, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "getPackageInfo Exception";
            h.d(SDKConstants.TAG, str2);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L91;
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r5) {
        /*
            java.lang.String r0 = com.shu.priory.param.c.f17180b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r5 = com.shu.priory.param.c.f17180b
            return r5
        Lb:
            java.lang.String r0 = "IFLY_AD_IMEI"
            java.lang.String r1 = com.shu.priory.utils.e.c(r5, r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L1a
            com.shu.priory.param.c.f17180b = r1
            return r1
        L1a:
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r5, r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L25
            return r2
        L25:
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r5.getSystemService(r1)     // Catch: java.lang.Throwable -> L5e
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Throwable -> L5e
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5e
            r4 = 28
            if (r3 < r4) goto L35
            r5 = 0
            return r5
        L35:
            r4 = 26
            if (r3 < r4) goto L3f
            java.lang.String r1 = b1.e.a(r1)     // Catch: java.lang.Throwable -> L5e
        L3d:
            r2 = r1
            goto L53
        L3f:
            r4 = 23
            if (r3 < r4) goto L4e
            r3 = 1
            java.lang.String r2 = m4.b.a(r1, r3)     // Catch: java.lang.Throwable -> L5e
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L53
        L4e:
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L5e
            goto L3d
        L53:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L5e
            com.shu.priory.param.c.f17180b = r2     // Catch: java.lang.Throwable -> L5e
            com.shu.priory.utils.e.a(r5, r0, r2)     // Catch: java.lang.Throwable -> L5e
        L5e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.param.c.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        if (context == null) {
            return f17179a;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - com.shu.priory.utils.e.b(context, "KEY_UPDATE_UA_INTERVAL") > 1800000) {
            new Thread(new Runnable() { // from class: com.shu.priory.param.c.1

                /* renamed from: a */
                final /* synthetic */ Context f17182a;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.n(context);
                }
            }).start();
            com.shu.priory.utils.e.a(context2, "KEY_UPDATE_UA_INTERVAL", currentTimeMillis);
        }
        if (!TextUtils.isEmpty(f17179a)) {
            return f17179a;
        }
        String c10 = com.shu.priory.utils.e.c(context2, "IFLY_AD_UA");
        if (!TextUtils.isEmpty(c10)) {
            f17179a = c10;
            return c10;
        }
        if (TextUtils.isEmpty(f17179a)) {
            f17179a = n(context2);
        }
        return f17179a;
    }

    private static String e() {
        return Build.MANUFACTURER;
    }

    private static String f() {
        return Build.MODEL;
    }

    @SuppressLint({"MissingPermission"})
    private static String a(TelephonyManager telephonyManager) {
        String deviceId = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return a(telephonyManager, "getDeviceId", 1);
        }
        if (deviceId.length() == 15) {
            return deviceId;
        }
        String a10 = a(telephonyManager, "getImei", 0);
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        String a11 = a(telephonyManager, "getImei", 1);
        return !TextUtils.isEmpty(a11) ? a11 : deviceId;
    }

    public static String b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getAndroidID:" + th2.getMessage());
            return "";
        }
    }

    private static String a(TelephonyManager telephonyManager, String str, int i10) {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getMethod(str, Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i10));
            return invoke != null ? invoke.toString() : "";
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "get invoke imei:" + th2.getMessage());
            return "";
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bt.f23592ai, i(context));
            jSONObject.put(bt.f23628x, b());
            jSONObject.put("osv", c());
            jSONObject.put("density", k(context));
            jSONObject.put(bt.P, l(context));
            jSONObject.put("net", m(context));
            jSONObject.put("ip", d());
            jSONObject.put("dvw", e(context));
            jSONObject.put("dvh", f(context));
            jSONObject.put("orientation", p(context));
            jSONObject.put("make", e());
            jSONObject.put(bm.f6904i, f());
            jSONObject.put("lan", q(context));
            jSONObject.put("hms_ag_version", r(context));
            jSONObject.put("hms_version", g(context));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "get device:" + th2.getMessage());
        }
        return jSONObject;
    }

    public static void a(int i10) {
        f17181c = i10;
    }
}
