package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bh {

    /* renamed from: a */
    private static String f10801a;

    /* renamed from: b */
    private static String f10802b;

    /* renamed from: com.kuaishou.weapon.p0.bh$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f10803a;

        /* renamed from: b */
        final /* synthetic */ String f10804b;

        public AnonymousClass1(Context context, String str) {
            context = context;
            jSONObject = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cp.a(context, jSONObject);
        }
    }

    public static String a() {
        return null;
    }

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().JV());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().JV());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().Ka());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().getIccId());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().JW());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static boolean g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            StringBuilder sb2 = new StringBuilder();
            Iterator<InputMethodInfo> it = inputMethodList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().getId());
                sb2.append(";");
            }
            if (TextUtils.isEmpty(sb2)) {
                return bi.f10807c;
            }
            String sb3 = sb2.toString();
            return sb3.endsWith(";") ? sb3.substring(0, sb3.length() - 1) : sb3;
        } catch (Exception unused) {
            return bi.f10808d;
        }
    }

    public static String j(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (string == null) {
                string = "null";
            }
            String str = "1=" + string + ";";
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                str = str + "2=";
                int i10 = -1;
                for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                    String packageName = inputMethodInfo.getPackageName();
                    if (packageName == null) {
                        packageName = "null";
                    }
                    String settingsActivity = inputMethodInfo.getSettingsActivity();
                    if (settingsActivity == null) {
                        settingsActivity = "null";
                    }
                    if (packageManager != null) {
                        try {
                            if (!packageName.equals("null") && !settingsActivity.equals("null") && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                                i10 = activityInfo.launchMode;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = str + packageName + "-" + settingsActivity + "-" + String.format("%d", Integer.valueOf(i10)) + ";";
                }
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return bi.f10809e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? bi.f10807c : string;
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l(android.content.Context r5) {
        /*
            java.lang.String r0 = "accessibility"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r5 = (android.view.accessibility.AccessibilityManager) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            java.util.List r5 = r5.getInstalledAccessibilityServiceList()     // Catch: java.lang.Exception -> L43
            if (r5 == 0) goto L44
            int r1 = r5.size()     // Catch: java.lang.Exception -> L43
            if (r1 <= 0) goto L44
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Exception -> L43
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L41
        L21:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Exception -> L41
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = a(r2)     // Catch: java.lang.Exception -> L41
            int r3 = r1.indexOf(r2)     // Catch: java.lang.Exception -> L41
            r4 = -1
            if (r3 != r4) goto L21
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            goto L21
        L41:
            goto L45
        L43:
        L44:
            r1 = r0
        L45:
            if (r1 != 0) goto L48
            return r0
        L48:
            int r5 = r1.length()
            if (r5 <= 0) goto L57
            int r5 = r1.length()
            int r5 = r5 + (-1)
            r1.deleteCharAt(r5)
        L57:
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bh.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder sb2;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb3 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb2 = null;
            } else {
                sb2 = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String a10 = a(it.next());
                        if (sb2.indexOf(a10) == -1) {
                            sb2.append(a10);
                            sb2.append("|");
                        }
                    }
                } catch (Exception unused) {
                    sb3 = sb2;
                    sb2 = sb3;
                    return sb2.toString();
                }
            }
        } catch (Exception unused2) {
        }
        if (sb2 == null) {
            return null;
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '|') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static String n(Context context) {
        return bi.f10808d;
    }

    public static String o(Context context) {
        return bi.f10807c;
    }

    public static String p(Context context) {
        return bi.f10805a;
    }

    public static String q(Context context) {
        try {
            if (TextUtils.isEmpty(f10801a)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                f10802b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                f10801a = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return f10801a;
    }

    public static String r(Context context) {
        return f10802b;
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    public static int t(Context context) {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().Kb());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                return Integer.parseInt(c10);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    public static int u(Context context) {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().Kc());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                return Integer.parseInt(c10);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String v(Context context) {
        return bi.f10807c;
    }

    public static String w(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String x(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i10 = 0; i10 < 27; i10++) {
                if (packageManager.hasSystemFeature(strArr[i10])) {
                    sb2.append("1");
                } else {
                    sb2.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb2.toString();
    }

    public static String y(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb2 = new StringBuilder();
            JSONObject z10 = z(context);
            if (z10 != null && (keys = z10.keys()) != null) {
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = z10.getString(next);
                    sb2.append(str);
                    str = ";";
                    sb2.append(next);
                    sb2.append("=");
                    sb2.append(string);
                }
                return sb2.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static JSONObject z(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String m10 = m();
            String str2 = WeaponHI.sChannel;
            String l10 = l();
            String k10 = k();
            String str3 = "";
            jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
            jSONObject.put("platform", TextUtils.isEmpty(m10) ? "" : URLEncoder.encode(m10, "UTF-8"));
            jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            try {
                if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                    jSONObject.put("mod", TextUtils.isEmpty(l10) ? "" : URLEncoder.encode(l10, "UTF-8"));
                    if (!TextUtils.isEmpty(k10)) {
                        str3 = URLEncoder.encode(k10, "UTF-8");
                    }
                    jSONObject.put("sysver", str3);
                } else {
                    jSONObject.put("mod", "");
                    jSONObject.put("sysver", "");
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.e.b.Kh().getIp());
        } catch (Throwable unused) {
            return bi.f10807c;
        }
    }

    public static String h() {
        try {
            return c(com.kwad.sdk.e.b.Kh().JX());
        } catch (Throwable unused) {
            return bi.f10807c;
        }
    }

    public static String b(Context context, int i10) {
        try {
            if (i10 == 1) {
                return c(com.kwad.sdk.e.b.Kh().JY());
            }
            return c(com.kwad.sdk.e.b.Kh().JV());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static double c() {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().getLocation());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                return new JSONObject(c10).getDouble("longitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    public static String d() {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().Kd());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(c10);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return c10;
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String e() {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().Kf());
            if (!TextUtils.isEmpty(c10)) {
                c10.startsWith("RISK");
            }
            return c10;
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static JSONArray f() {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().Ke());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(c10);
                for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i10).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i10).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Kh().JV());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static String a(Context context, int i10) {
        try {
            if (i10 == 1) {
                return c(com.kwad.sdk.e.b.Kh().JY());
            }
            return c(com.kwad.sdk.e.b.Kh().JV());
        } catch (Throwable unused) {
            return bi.f10808d;
        }
    }

    public static String c(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt(MediationConstant.KEY_ERROR_CODE);
            if (i10 == 0) {
                str2 = jSONObject.getString("value");
                return str2;
            }
            if (i10 == 3) {
                return bi.f10807c;
            }
            if (i10 == 1) {
                return bi.f10805a;
            }
            return bi.f10808d;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String k() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method b10 = b(cls, str, clsArr);
            try {
                b10.setAccessible(true);
                return b10;
            } catch (Throwable unused) {
                return b10;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static double b() {
        try {
            String c10 = c(com.kwad.sdk.e.b.Kh().getLocation());
            if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                return new JSONObject(c10).getDouble("latitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id2 = accessibilityServiceInfo.getId();
        int lastIndexOf = id2.lastIndexOf("/");
        return lastIndexOf > 0 ? id2.substring(0, lastIndexOf) : id2;
    }

    public static String i() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static void a(Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(df.br, 1) == 0) {
            return;
        }
        try {
            JSONObject a10 = new cm(str, ck.f10916l).a(context);
            if (map == null || map.size() <= 0) {
                a10.put("module_section", new JSONObject());
            } else {
                a10.put("module_section", new JSONObject(map));
            }
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bh.1

                /* renamed from: a */
                final /* synthetic */ Context f10803a;

                /* renamed from: b */
                final /* synthetic */ String f10804b;

                public AnonymousClass1(Context context2, String str2) {
                    context = context2;
                    jSONObject = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    cp.a(context, jSONObject);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static String m() {
        return "ANDROID_PHONE";
    }

    public static String j() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
