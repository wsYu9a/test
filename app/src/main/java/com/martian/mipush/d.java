package com.martian.mipush;

import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import com.martian.libsupport.k;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final String f14900a = "Rom";

    /* renamed from: b */
    public static final String f14901b = "MIUI";

    /* renamed from: c */
    public static final String f14902c = "EMUI";

    /* renamed from: d */
    public static final String f14903d = "FLYME";

    /* renamed from: e */
    public static final String f14904e = "OPPO";

    /* renamed from: f */
    public static final String f14905f = "SMARTISAN";

    /* renamed from: g */
    public static final String f14906g = "VIVO";

    /* renamed from: h */
    public static final String f14907h = "QIKU";

    /* renamed from: i */
    private static final String f14908i = "ro.miui.ui.version.name";

    /* renamed from: j */
    private static final String f14909j = "ro.build.version.emui";
    private static final String k = "ro.build.version.opporom";
    private static final String l = "ro.smartisan.version";
    private static final String m = "ro.vivo.os.version";
    private static String n;
    private static String o;

    public static boolean a(String rom) {
        String str = n;
        if (str != null) {
            return str.equals(rom);
        }
        String d2 = d(f14908i);
        o = d2;
        if (k.p(d2)) {
            String d3 = d(f14909j);
            o = d3;
            if (k.p(d3)) {
                String d4 = d(k);
                o = d4;
                if (k.p(d4)) {
                    String d5 = d(m);
                    o = d5;
                    if (k.p(d5)) {
                        String d6 = d(l);
                        o = d6;
                        if (k.p(d6)) {
                            String str2 = Build.DISPLAY;
                            o = str2;
                            if (str2.toUpperCase().contains(f14903d)) {
                                n = f14903d;
                            } else {
                                o = EnvironmentCompat.MEDIA_UNKNOWN;
                                n = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            n = f14905f;
                        }
                    } else {
                        n = "VIVO";
                    }
                } else {
                    n = "OPPO";
                }
            } else {
                n = f14902c;
            }
        } else {
            n = f14901b;
        }
        return n.equals(rom);
    }

    public static String b() {
        return g() ? "huawei" : l() ? "vivo" : j() ? "oppo" : i() ? "xiaomi" : h() ? "flyme" : f() ? "360" : k() ? "smartisan" : !k.p(n) ? n : "others";
    }

    public static String c() {
        if (n == null) {
            a("");
        }
        return n;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0062: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0062 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.append(r6)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L61
            r2.close()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L61
            r2.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r6 = move-exception
            r6.printStackTrace()
        L39:
            return r1
        L3a:
            r1 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L63
        L3e:
            r1 = move-exception
            r2 = r0
        L40:
            java.lang.String r3 = "Rom"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r4.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = "Unable to read prop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L61
            r4.append(r6)     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L61
            android.util.Log.e(r3, r6, r1)     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r6 = move-exception
            r6.printStackTrace()
        L60:
            return r0
        L61:
            r6 = move-exception
            r0 = r2
        L63:
            if (r0 == 0) goto L6d
            r0.close()     // Catch: java.io.IOException -> L69
            goto L6d
        L69:
            r0 = move-exception
            r0.printStackTrace()
        L6d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mipush.d.d(java.lang.String):java.lang.String");
    }

    public static String e() {
        if (o == null) {
            a("");
        }
        return o;
    }

    public static boolean f() {
        return a(f14907h) || a("360");
    }

    public static boolean g() {
        return a(f14902c);
    }

    public static boolean h() {
        return a(f14903d);
    }

    public static boolean i() {
        return a(f14901b);
    }

    public static boolean j() {
        return a("OPPO");
    }

    public static boolean k() {
        return a(f14905f);
    }

    public static boolean l() {
        return a("VIVO");
    }
}
