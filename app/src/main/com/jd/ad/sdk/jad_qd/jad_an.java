package com.jd.ad.sdk.jad_qd;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import com.baidu.mobads.sdk.internal.bm;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.jd.android.sdk.coreinfo.CoreInfo;
import com.jd.android.sdk.coreinfo.util.Logger;

/* loaded from: classes2.dex */
public class jad_an {
    public static int jad_an(Context context) {
        try {
            if (!jad_iv() && jad_cp.jad_an.jad_an.jad_an("sl") && context != null) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_dq() ? 1 : 0;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int jad_bo(Context context) {
        try {
            if (!jad_iv() && jad_cp.jad_an.jad_an.jad_an("sof") && context != null) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_er() ^ true ? 1 : 0;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static String jad_cp() {
        String str = "";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("hardware")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("hardware", true)) {
            return jad_anVar.jad_dq("hardware");
        }
        str = CoreInfo.Device.getHardwareName();
        jad_anVar.jad_bo("hardware", str);
        return str;
    }

    public static String jad_dq() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("launcher")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("launcher", true)) {
            return jad_anVar.jad_dq("launcher");
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = com.jd.ad.sdk.jad_il.jad_an.jad_an.getPackageManager().resolveActivity(intent, 0);
        String str2 = "";
        if (resolveActivity != null) {
            String str3 = resolveActivity.activityInfo.packageName;
            int i10 = com.jd.ad.sdk.jad_jm.jad_bo.jad_an;
            if (str3 != null) {
                str2 = str3;
            }
        }
        str = str2;
        jad_anVar.jad_bo("launcher", str);
        return str;
    }

    public static String jad_er() {
        String str = "";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("make")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("make", true)) {
            return jad_anVar.jad_dq("make");
        }
        str = CoreInfo.Device.getManufacture();
        jad_anVar.jad_bo("make", str);
        return str;
    }

    public static String jad_fs() {
        String str = "";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an(bm.f6904i)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(bm.f6904i, true)) {
            return jad_anVar.jad_dq(bm.f6904i);
        }
        str = CoreInfo.Device.getModel();
        jad_anVar.jad_bo(bm.f6904i, str);
        return str;
    }

    public static String jad_hu() {
        int i10;
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("brightness")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("brightness", true)) {
            return jad_anVar.jad_dq("brightness");
        }
        try {
            i10 = Settings.System.getInt(com.jd.ad.sdk.jad_il.jad_an.jad_an.getContentResolver(), "screen_brightness");
        } catch (Exception e10) {
            Logger.e("AntiSDK", e10.getMessage());
            i10 = 0;
        }
        str = String.valueOf(i10);
        jad_an.jad_bo.jad_an.jad_bo("brightness", str);
        return str;
    }

    public static boolean jad_iv() {
        return jad_dq.jad_an.jad_an.jad_an(11, (String) null);
    }

    public static String jad_jt() {
        try {
            return !jad_cp.jad_an.jad_an.jad_an("soaid") ? "NA" : com.jd.ad.sdk.jad_jw.jad_an.jad_an;
        } catch (Exception unused) {
            return "NA";
        }
    }

    public static int jad_jw() {
        try {
            if (jad_iv()) {
                return -1;
            }
            return !jad_cp.jad_an.jad_an.jad_an("af") ? -1 : 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String jad_kx() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("isDebug")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isDebug", true)) {
            return jad_anVar.jad_dq("isDebug");
        }
        str = com.jd.ad.sdk.jad_il.jad_an.jad_an();
        jad_anVar.jad_bo("isDebug", str);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    public static int jad_ly() {
        int i10 = -1;
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("jailbreak")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("jailbreak", true)) {
            return jad_anVar.jad_cp("jailbreak");
        }
        i10 = CoreInfo.Device.isRoot();
        jad_anVar.jad_bo("jailbreak", Integer.valueOf((int) i10));
        return i10;
    }

    public static String jad_mz() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("isHooked")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isHooked", true)) {
            return jad_anVar.jad_dq("isHooked");
        }
        str = com.jd.ad.sdk.jad_il.jad_an.jad_bo();
        jad_anVar.jad_bo("isHooked", str);
        return str;
    }

    public static String jad_na() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("isMoreOpen")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isMoreOpen", true)) {
            return jad_anVar.jad_dq("isMoreOpen");
        }
        str = com.jd.ad.sdk.jad_il.jad_an.jad_cp();
        jad_anVar.jad_bo("isMoreOpen", str);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if (r2.getType() == 17) goto L111;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_ob() {
        /*
            java.lang.String r0 = "vpnConnect"
            java.lang.String r1 = "NA"
            boolean r2 = jad_iv()     // Catch: java.lang.Exception -> L65
            if (r2 == 0) goto Lb
            return r1
        Lb:
            com.jd.ad.sdk.jad_qd.jad_cp r2 = com.jd.ad.sdk.jad_qd.jad_cp.jad_an.jad_an     // Catch: java.lang.Exception -> L65
            boolean r2 = r2.jad_an(r0)     // Catch: java.lang.Exception -> L65
            if (r2 != 0) goto L14
            return r1
        L14:
            com.jd.ad.sdk.jad_uh.jad_an r2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L65
            r3 = 1
            boolean r3 = r2.jad_an(r0, r3)     // Catch: java.lang.Exception -> L65
            if (r3 == 0) goto L22
            java.lang.String r0 = r2.jad_dq(r0)     // Catch: java.lang.Exception -> L65
            goto L66
        L22:
            android.content.Context r2 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch: java.lang.Exception -> L46
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Exception -> L46
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L46
            r4 = 23
            if (r3 < r4) goto L48
            if (r2 == 0) goto L5e
            android.net.Network r3 = d1.a.a(r2)     // Catch: java.lang.Exception -> L46
            android.net.NetworkCapabilities r2 = r2.getNetworkCapabilities(r3)     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            r3 = 4
            boolean r2 = r2.hasTransport(r3)     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            goto L58
        L46:
            r2 = move-exception
            goto L5b
        L48:
            if (r2 == 0) goto L5e
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            int r2 = r2.getType()     // Catch: java.lang.Exception -> L46
            r3 = 17
            if (r2 != r3) goto L5e
        L58:
            java.lang.String r1 = "1"
            goto L60
        L5b:
            r2.printStackTrace()     // Catch: java.lang.Exception -> L65
        L5e:
            java.lang.String r1 = "0"
        L60:
            com.jd.ad.sdk.jad_uh.jad_an r2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L65
            r2.jad_bo(r0, r1)     // Catch: java.lang.Exception -> L65
        L65:
            r0 = r1
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_qd.jad_an.jad_ob():java.lang.String");
    }

    public static String jad_an() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("packagename")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("packagename", true)) {
            return jad_anVar.jad_dq("packagename");
        }
        str = CoreInfo.App.getPackageName(com.jd.ad.sdk.jad_il.jad_an.jad_an);
        jad_anVar.jad_bo("packagename", str);
        return str;
    }

    public static String jad_bo() {
        String str = "NA";
        if (jad_iv() || !jad_cp.jad_an.jad_an.jad_an("batteryVoltage")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("batteryVoltage", true)) {
            return jad_anVar.jad_dq("batteryVoltage");
        }
        int i10 = -1;
        try {
            if (com.jd.ad.sdk.jad_il.jad_an.jad_an != null) {
                i10 = com.jd.ad.sdk.jad_il.jad_an.jad_an.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("voltage", -1);
            }
        } catch (Throwable unused) {
        }
        str = String.valueOf(i10);
        jad_an.jad_bo.jad_an.jad_bo("batteryVoltage", str);
        return str;
    }
}
