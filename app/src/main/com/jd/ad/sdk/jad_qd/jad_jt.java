package com.jd.ad.sdk.jad_qd;

import android.content.Context;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_fq.jad_hu;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.umeng.analytics.pro.bt;

/* loaded from: classes2.dex */
public class jad_jt {
    public static String jad_an(Context context) {
        String str = "";
        if (!jad_cp.jad_an.jad_an.jad_an("bundle")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("bundle", true)) {
            str = jad_anVar.jad_dq("bundle");
        } else if (context != null) {
            str = context.getPackageName();
            jad_anVar.jad_bo("bundle", str);
        }
        return str;
    }

    public static String jad_bo(Context context) {
        String str = "";
        if (!jad_cp.jad_an.jad_an.jad_an(bt.P)) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(bt.P, true)) {
            str = (String) jad_anVar.jad_bo(bt.P);
        } else if (context != null) {
            str = jad_hu.jad_bo(context);
            jad_anVar.jad_bo(bt.P, str);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r1 = r3.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_cp(android.content.Context r5) {
        /*
            java.lang.String r0 = "processName"
            java.lang.String r1 = ""
            com.jd.ad.sdk.jad_qd.jad_cp r2 = com.jd.ad.sdk.jad_qd.jad_cp.jad_an.jad_an     // Catch: java.lang.Exception -> Lf
            boolean r2 = r2.jad_an(r0)     // Catch: java.lang.Exception -> Lf
            if (r2 != 0) goto L11
            java.lang.String r5 = "jad_process_default"
            return r5
        Lf:
            r5 = move-exception
            goto L67
        L11:
            boolean r2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.isSupportMultiProcess()     // Catch: java.lang.Exception -> Lf
            if (r2 != 0) goto L1c
            java.lang.String r5 = jad_an(r5)     // Catch: java.lang.Exception -> Lf
            return r5
        L1c:
            com.jd.ad.sdk.jad_uh.jad_an r2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> Lf
            r3 = 1
            boolean r3 = r2.jad_an(r0, r3)     // Catch: java.lang.Exception -> Lf
            if (r3 == 0) goto L2a
            java.lang.String r1 = r2.jad_dq(r0)     // Catch: java.lang.Exception -> Lf
            goto L6a
        L2a:
            if (r5 == 0) goto L6a
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L57
            java.lang.String r3 = "activity"
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch: java.lang.Exception -> L57
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch: java.lang.Exception -> L57
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch: java.lang.Exception -> L57
            if (r5 == 0) goto L5b
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L57
        L42:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Exception -> L57
            if (r3 == 0) goto L5b
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Exception -> L57
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Exception -> L57
            if (r3 == 0) goto L42
            int r4 = r3.pid     // Catch: java.lang.Exception -> L57
            if (r4 != r2) goto L42
            java.lang.String r1 = r3.processName     // Catch: java.lang.Exception -> L57
            goto L5b
        L57:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Exception -> Lf
        L5b:
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lf
            if (r5 != 0) goto L6a
            com.jd.ad.sdk.jad_uh.jad_an r5 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> Lf
            r5.jad_bo(r0, r1)     // Catch: java.lang.Exception -> Lf
            goto L6a
        L67:
            r5.printStackTrace()
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_qd.jad_jt.jad_cp(android.content.Context):java.lang.String");
    }

    public static boolean jad_dq(Context context) {
        if (!jad_cp.jad_an.jad_an.jad_an("processName") || !JADYunSdk.isSupportMultiProcess()) {
            return true;
        }
        String jad_cp = jad_cp(context);
        String jad_an = jad_an(context);
        if (TextUtils.isEmpty(jad_an)) {
            jad_an = context.getPackageName();
        }
        if (!TextUtils.isEmpty(jad_an) && !TextUtils.isEmpty(jad_cp)) {
            if (!jad_an.equals(jad_cp)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an() {
        /*
            java.lang.String r0 = ""
            com.jd.ad.sdk.jad_qd.jad_cp r1 = com.jd.ad.sdk.jad_qd.jad_cp.jad_an.jad_an     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r1.jad_bo     // Catch: java.lang.Exception -> L2d
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r2 != 0) goto Lf
            java.lang.String r1 = r1.jad_bo     // Catch: java.lang.Exception -> L2d
            goto L25
        Lf:
            com.jd.ad.sdk.jad_uh.jad_an r2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = "didCustom"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Object r2 = r2.jad_an(r3, r4)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L2d
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r3 != 0) goto L24
            r1.jad_bo = r2     // Catch: java.lang.Exception -> L2d
            goto L26
        L24:
            r1 = r0
        L25:
            r2 = r1
        L26:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L2d
            r0 = r2
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_qd.jad_jt.jad_an():java.lang.String");
    }

    public static String jad_bo() {
        try {
            jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
            if (!jad_cpVar.jad_an("oidCustom")) {
                return "";
            }
            String jad_bo = jad_cpVar.jad_bo();
            try {
                if (TextUtils.isEmpty(jad_bo)) {
                    return "";
                }
            } catch (Exception unused) {
            }
            return jad_bo;
        } catch (Exception unused2) {
            return "";
        }
    }
}
