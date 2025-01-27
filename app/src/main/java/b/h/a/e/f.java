package b.h.a.e;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    private static String f4977a = "";

    /* renamed from: b */
    private static String f4978b = null;

    /* renamed from: c */
    private static int f4979c = -1;

    public static String a() {
        return (d() || f()) ? g() : e() ? d.c() : "UNKNOWN";
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (b.h.a.e.g.f4983d.equalsIgnoreCase(r0) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = b.h.a.e.f.f4978b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lc
            java.lang.String r0 = b.h.a.e.f.f4978b
            goto L75
        Lc:
            r0 = 0
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r2 = b.h.a.e.g.f4980a
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L24
            java.lang.String r0 = h()
            java.lang.String r2 = b.h.a.e.g.f4983d
            boolean r2 = r2.equalsIgnoreCase(r0)
            if (r2 == 0) goto L6b
            goto L6c
        L24:
            java.lang.String r2 = b.h.a.e.g.f4983d
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 != 0) goto L6b
            java.lang.String r2 = b.h.a.e.g.f4985f
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L35
            goto L6b
        L35:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L60
            r4 = 24
            if (r3 < r4) goto L6c
            android.content.Context r3 = b.h.a.e.b.a()     // Catch: java.lang.Throwable -> L60
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "com."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = b.h.a.e.g.f4986g     // Catch: java.lang.Throwable -> L60
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = ".mobilephone"
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L60
            boolean r3 = r3.hasSystemFeature(r4)     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L6c
            r0 = r2
            goto L6c
        L60:
            r2 = move-exception
            boolean r3 = b.h.a.c.j()
            if (r3 == 0) goto L6c
            r2.printStackTrace()
            goto L6c
        L6b:
            r0 = r1
        L6c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L73
            r0 = r1
        L73:
            b.h.a.e.f.f4978b = r0
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.a.e.f.b():java.lang.String");
    }

    public static String c() {
        return String.valueOf((d() || f()) ? i() : e() ? d.a() : -1);
    }

    private static boolean d() {
        return g.f4980a.equalsIgnoreCase(TextUtils.isEmpty(f4978b) ? b() : f4978b);
    }

    private static boolean e() {
        return g.f4985f.equalsIgnoreCase(TextUtils.isEmpty(f4978b) ? b() : f4978b);
    }

    private static boolean f() {
        return g.f4983d.equalsIgnoreCase(TextUtils.isEmpty(f4978b) ? b() : f4978b);
    }

    private static String g() {
        if (TextUtils.isEmpty(f4977a)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f4977a = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.build.version." + g.f4981b + "rom", "0");
            } catch (Exception e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
            }
        }
        return f4977a;
    }

    private static String h() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "ro.product.brand.sub", "");
        } catch (Exception e2) {
            if (!b.h.a.c.j()) {
                return "";
            }
            e2.printStackTrace();
            return "";
        }
    }

    private static int i() {
        int i2;
        String str;
        String str2;
        int i3 = f4979c;
        if (i3 >= 0) {
            return i3;
        }
        try {
            if (Build.VERSION.SDK_INT > 29) {
                str2 = MonitorConstants.CONNECT_TYPE_GET + g.n + "VERSION";
                str = "com.oplus.os.OplusBuild";
            } else {
                str = "com." + g.l + ".os." + g.m;
                str2 = MonitorConstants.CONNECT_TYPE_GET + g.f4987h + "VERSION";
            }
            i2 = ((Integer) j.b(j.a(str), str2, null, null)).intValue();
        } catch (Exception e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
            i2 = 0;
        }
        if (i2 == 0) {
            try {
                String a2 = a();
                if (a2.startsWith("V1.4")) {
                    return 3;
                }
                if (a2.startsWith("V2.0")) {
                    return 4;
                }
                if (a2.startsWith("V2.1")) {
                    return 5;
                }
            } catch (Exception e3) {
                if (b.h.a.c.j()) {
                    e3.printStackTrace();
                }
            }
        }
        f4979c = i2;
        return i2;
    }
}
