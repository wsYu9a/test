package com.jd.ad.sdk.jad_il;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.kuaishou.weapon.p0.an;

/* loaded from: classes2.dex */
public class jad_an {
    public static Context jad_an = null;
    public static boolean jad_bo = false;

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|2|3|(2:29|30)|5|(3:6|7|8)|(8:10|(1:12)|13|14|(1:16)|(1:18)|21|22)|26|(0)|13|14|(0)|(0)|21|22) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an
            r1 = 0
            boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch: java.lang.Exception -> L8
            goto La
        L8:
            r2 = 0
        La:
            if (r2 == 0) goto L13
            long r2 = com.jd.ad.sdk.jad_kn.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r4 = 1
            long r2 = r2 | r4
            com.jd.ad.sdk.jad_kn.jad_an.jad_an = r2     // Catch: java.lang.Exception -> L43
        L13:
            r2 = 1
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L20
            int r3 = r3.flags     // Catch: java.lang.Exception -> L20
            r3 = r3 & 2
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L20:
        L21:
            r3 = 0
        L22:
            if (r3 == 0) goto L2b
            long r3 = com.jd.ad.sdk.jad_kn.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r5 = 2
            long r3 = r3 | r5
            com.jd.ad.sdk.jad_kn.jad_an.jad_an = r3     // Catch: java.lang.Exception -> L43
        L2b:
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L39
            java.lang.String r3 = "adb_enabled"
            int r0 = android.provider.Settings.Secure.getInt(r0, r3, r1)     // Catch: java.lang.Exception -> L39
            if (r0 <= 0) goto L3a
            r1 = 1
            goto L3a
        L39:
        L3a:
            if (r1 == 0) goto L43
            long r0 = com.jd.ad.sdk.jad_kn.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r2 = 4
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_kn.jad_an.jad_an = r0     // Catch: java.lang.Exception -> L43
        L43:
            long r0 = com.jd.ad.sdk.jad_kn.jad_an.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_il.jad_an.jad_an():java.lang.String");
    }

    public static String jad_bo() {
        Boolean bool;
        try {
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an(jad_an).booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an().booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 4;
            }
            try {
                try {
                    Class.forName("de.robv.android.xposed.XC_MethodHook");
                    bool = Boolean.TRUE;
                } catch (Exception unused) {
                    bool = Boolean.FALSE;
                }
            } catch (Exception unused2) {
                Class.forName(an.f10771a);
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 8;
            }
            Boolean bool2 = Boolean.FALSE;
            try {
                if (System.getProperty("vxp") != null) {
                    bool2 = Boolean.TRUE;
                }
            } catch (Exception unused3) {
            }
            if (bool2.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 16;
            }
        } catch (Exception unused4) {
        }
        return String.valueOf(com.jd.ad.sdk.jad_kn.jad_bo.jad_an);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_cp() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an
            boolean r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an(r0)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto Lf
            long r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r3 = 1
            long r1 = r1 | r3
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        Lf:
            java.io.File r1 = r0.getFilesDir()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Exception -> Lad
            java.lang.String[] r2 = com.jd.ad.sdk.jad_kn.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lad
            int r3 = r2.length     // Catch: java.lang.Exception -> Lad
            r4 = 0
            r5 = 0
        L1c:
            if (r5 >= r3) goto L31
            r6 = r2[r5]     // Catch: java.lang.Exception -> Lad
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Exception -> Lad
            if (r6 == 0) goto L2e
            long r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 2
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
            goto L31
        L2e:
            int r5 = r5 + 1
            goto L1c
        L31:
            boolean r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an()     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L3e
            long r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 4
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L3e:
            android.net.LocalServerSocket r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_bo     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L43
            goto L56
        L43:
            android.net.LocalServerSocket r1 = new android.net.LocalServerSocket     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            java.lang.String r2 = r0.getPackageName()     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            r1.<init>(r2)     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            com.jd.ad.sdk.jad_kn.jad_cp.jad_bo = r1     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            goto L56
        L4f:
            long r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 16
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L56:
            java.lang.String r1 = r0.getPackageName()     // Catch: java.lang.Exception -> Lad
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lad
            if (r2 == 0) goto L61
            goto L80
        L61:
            java.lang.String r2 = "com.jingdong.app.mall"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r2 != 0) goto L79
            java.lang.String r2 = "com.jd.pingou"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r2 != 0) goto L79
            java.lang.String r2 = "com.jd.jdlite"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L80
        L79:
            long r1 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 32
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L80:
            java.util.List r0 = com.jd.ad.sdk.jad_jm.jad_an.jad_an(r0)     // Catch: java.lang.Exception -> Lad
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lad
        L88:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto Lad
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lad
            java.lang.String[] r2 = com.jd.ad.sdk.jad_kn.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lad
            int r3 = r2.length     // Catch: java.lang.Exception -> Lad
            r5 = 0
        L98:
            if (r5 >= r3) goto L88
            r6 = r2[r5]     // Catch: java.lang.Exception -> Lad
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Exception -> Lad
            if (r6 == 0) goto Laa
            long r0 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r2 = 64
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_kn.jad_cp.jad_an = r0     // Catch: java.lang.Exception -> Lad
            goto Lad
        Laa:
            int r5 = r5 + 1
            goto L98
        Lad:
            long r0 = com.jd.ad.sdk.jad_kn.jad_cp.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_il.jad_an.jad_cp():java.lang.String");
    }

    public static boolean jad_dq() {
        try {
            return ((KeyguardManager) jad_an.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e10) {
            Logger.e("AntiSDK", e10.getMessage());
            return false;
        }
    }

    public static boolean jad_er() {
        try {
            return !((PowerManager) jad_an.getSystemService("power")).isScreenOn();
        } catch (Exception e10) {
            Logger.e("AntiSDK", e10.getMessage());
            return false;
        }
    }
}
