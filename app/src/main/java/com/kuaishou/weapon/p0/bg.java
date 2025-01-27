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
import com.opos.acs.st.STManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.dm.Downloads;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bg {

    /* renamed from: com.kuaishou.weapon.p0.bg$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f9105a;

        /* renamed from: b */
        final /* synthetic */ String f9106b;

        AnonymousClass1(Context context, String str) {
            context = context;
            jSONObject = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            co.a(context, jSONObject);
        }
    }

    public static String A(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            String[] strArr = {g.f9318c, g.f9324i, g.f9325j, "android.permission.READ_CONTACTS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", g.f9322g, g.f9323h, "android.permission.BLUETOOTH", "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
            for (int i2 = 0; i2 < 11; i2++) {
                sb.append(g.a(context, strArr[i2]) == 0 ? "1" : "0");
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String B(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject C = C(context);
            if (C != null && (keys = C.keys()) != null) {
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = C.getString(next);
                    sb.append(str);
                    str = ";";
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static JSONObject C(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String l = l();
            String str2 = WeaponHI.sChannel;
            String k = k();
            String j2 = j();
            String str3 = "";
            jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
            jSONObject.put("platform", TextUtils.isEmpty(l) ? "" : URLEncoder.encode(l, "UTF-8"));
            jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            try {
                if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                    jSONObject.put("mod", TextUtils.isEmpty(k) ? "" : URLEncoder.encode(k, "UTF-8"));
                    if (!TextUtils.isEmpty(j2)) {
                        str3 = URLEncoder.encode(j2, "UTF-8");
                    }
                } else {
                    jSONObject.put("mod", "");
                }
                jSONObject.put("sysver", str3);
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static double a() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().getLocation());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return new JSONObject(c2).getDouble(STManager.KEY_LATITUDE);
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int lastIndexOf = id.lastIndexOf("/");
        return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String a(Context context, int i2) {
        try {
            return i2 == 1 ? c(com.kwad.sdk.d.b.Ax().Ao()) : c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable unused) {
            return bh.f9110d;
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

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method b2 = b(cls, str, clsArr);
            try {
                b2.setAccessible(true);
                return b2;
            } catch (Throwable unused) {
                return b2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void a(Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(de.bj, 1) == 0) {
            return;
        }
        try {
            JSONObject a2 = new cl(str, cj.f9197j).a(context);
            if (map == null || map.size() <= 0) {
                a2.put("module_section", new JSONObject());
            } else {
                a2.put("module_section", new JSONObject(map));
            }
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bg.1

                /* renamed from: a */
                final /* synthetic */ Context f9105a;

                /* renamed from: b */
                final /* synthetic */ String f9106b;

                AnonymousClass1(Context context2, String str2) {
                    context = context2;
                    jSONObject = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    co.a(context, jSONObject);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static double b() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().getLocation());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return new JSONObject(c2).getDouble(STManager.KEY_LONGITUDE);
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
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

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String b(Context context, int i2) {
        try {
            return i2 == 1 ? c(com.kwad.sdk.d.b.Ax().Ao()) : c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable unused) {
            return bh.f9110d;
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

    public static String c() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().At());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(c2);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return c2;
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Al());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String c(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i2 = jSONObject.getInt("errorCode");
            if (i2 != 0) {
                return i2 == 3 ? bh.f9109c : i2 == 1 ? bh.f9107a : bh.f9110d;
            }
            str2 = jSONObject.getString(Downloads.RequestHeaders.COLUMN_VALUE);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String d() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Av());
            if (!TextUtils.isEmpty(c2)) {
                if (c2.startsWith("RISK")) {
                }
            }
            return c2;
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Aq());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().getIccId());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static JSONArray e() {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Au());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(c2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i2).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i2).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String f() {
        try {
            return c(com.kwad.sdk.d.b.Ax().getIp());
        } catch (Throwable unused) {
            return bh.f9109c;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().Am());
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.d.b.Ax().An());
        } catch (Throwable unused) {
            return bh.f9109c;
        }
    }

    public static boolean g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String h() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean h(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT <= 16 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static String i() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static String i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            StringBuilder sb = new StringBuilder();
            Iterator<InputMethodInfo> it = inputMethodList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getId());
                sb.append(";");
            }
            if (TextUtils.isEmpty(sb)) {
                return bh.f9109c;
            }
            String sb2 = sb.toString();
            return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
        } catch (Exception unused) {
            return bh.f9110d;
        }
    }

    public static String j() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static String j(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        int i2 = -1;
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
                                i2 = activityInfo.launchMode;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = str + packageName + "-" + settingsActivity + "-" + String.format("%d", Integer.valueOf(i2)) + ";";
                }
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String k() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return bh.f9111e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? bh.f9109c : string;
        } catch (Throwable unused) {
            return bh.f9110d;
        }
    }

    private static String l() {
        return "ANDROID_PHONE";
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
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
            if (r5 == 0) goto L43
            int r1 = r5.size()     // Catch: java.lang.Exception -> L43
            if (r1 <= 0) goto L43
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Exception -> L43
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L41
        L21:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L44
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
            goto L44
        L43:
            r1 = r0
        L44:
            if (r1 != 0) goto L47
            return r0
        L47:
            int r5 = r1.length()
            if (r5 <= 0) goto L56
            int r5 = r1.length()
            int r5 = r5 + (-1)
            r1.deleteCharAt(r5)
        L56:
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bg.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb2 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String a2 = a(it.next());
                        if (sb.indexOf(a2) == -1) {
                            sb.append(a2);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused) {
                    sb2 = sb;
                    sb = sb2;
                    return sb.toString();
                }
            }
        } catch (Exception unused2) {
        }
        if (sb == null) {
            return null;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String n(Context context) {
        return bh.f9110d;
    }

    public static String o(Context context) {
        return bh.f9109c;
    }

    public static String p(Context context) {
        return bh.f9107a;
    }

    public static String q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String r(Context context) {
        try {
            return (String) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.name;
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    public static int u(Context context) {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().Ar());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return Integer.parseInt(c2);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    public static int v(Context context) {
        try {
            String c2 = c(com.kwad.sdk.d.b.Ax().As());
            if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                return Integer.parseInt(c2);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String w(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.firstInstallTime);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String x(Context context) {
        return bh.f9109c;
    }

    public static String y(Context context) {
        try {
            return c(com.kwad.sdk.d.b.Ax().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String z(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i2 = 0; i2 < 27; i2++) {
                sb.append(packageManager.hasSystemFeature(strArr[i2]) ? "1" : "0");
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
