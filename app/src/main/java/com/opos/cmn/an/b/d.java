package com.opos.cmn.an.b;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static final String f16366a;

    /* renamed from: b */
    public static final String f16367b;

    /* renamed from: c */
    public static final String f16368c;

    /* renamed from: d */
    public static final String f16369d;

    /* renamed from: e */
    private static String f16370e;

    /* renamed from: f */
    private static String f16371f;

    /* renamed from: g */
    private static final String f16372g;

    /* renamed from: h */
    private static final String f16373h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("ro.build.version.");
        String str = com.opos.cmn.an.a.a.f16359c;
        sb.append(str);
        sb.append("rom");
        f16372g = sb.toString();
        f16373h = "persist.sys." + str + ".region";
        f16366a = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1ZFUlNJT04=");
        f16367b = com.opos.cmn.an.a.b.a("Y29tLmNvbG9yLm9zLkNvbG9yQnVpbGQ=");
        f16368c = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1Zlck5hbWU=");
        f16369d = com.opos.cmn.an.a.b.a("Z2V0Q29sb3JPU1ZlckNvZGU=");
    }

    public static String a() {
        if (f16370e == null) {
            try {
                f16370e = SystemProperties.get("ro.build.display.id");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("OSPropertyTool", "getOSVerName", e2);
            }
        }
        String str = f16370e;
        return str != null ? str : "";
    }

    public static String b() {
        if (f16371f == null) {
            if (Build.VERSION.SDK_INT > 29) {
                try {
                    f16371f = SystemProperties.get("ro.build.version.oplusrom");
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(f16371f)) {
                try {
                    f16371f = SystemProperties.get(f16372g);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("OSPropertyTool", f16368c, e2);
                }
            }
        }
        String str = f16371f;
        return str != null ? str : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            java.lang.String r2 = "cn"
            r3 = 29
            if (r0 <= r3) goto L11
            java.lang.String r0 = "persist.sys.oplus.region"
            java.lang.String r0 = android.os.SystemProperties.get(r0, r2)     // Catch: java.lang.Exception -> L11
            goto L12
        L11:
            r0 = r1
        L12:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L40
            java.lang.String r3 = com.opos.cmn.an.b.c.d()     // Catch: java.lang.Exception -> L38
            boolean r4 = com.opos.cmn.an.c.a.a(r3)     // Catch: java.lang.Exception -> L38
            if (r4 != 0) goto L35
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = com.opos.cmn.an.a.a.f16357a     // Catch: java.lang.Exception -> L38
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L35
            java.lang.String r3 = "persist.sys.oem.region"
        L30:
            java.lang.String r0 = android.os.SystemProperties.get(r3, r2)     // Catch: java.lang.Exception -> L38
            goto L40
        L35:
            java.lang.String r3 = com.opos.cmn.an.b.d.f16373h     // Catch: java.lang.Exception -> L38
            goto L30
        L38:
            r2 = move-exception
            java.lang.String r3 = "OSPropertyTool"
            java.lang.String r4 = "getRegion"
            com.opos.cmn.an.f.a.c(r3, r4, r2)
        L40:
            if (r0 == 0) goto L43
            r1 = r0
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.b.d.c():java.lang.String");
    }
}
