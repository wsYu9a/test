package b.h.b.a;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import h.a.a.a;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static boolean f5042a;

    /* renamed from: b */
    public static boolean f5043b;

    /* renamed from: c */
    public static boolean f5044c;

    public static Context a(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static boolean b() {
        if (f5044c) {
            if (!f5042a) {
                Log.e("StdIDHelper", "1001");
            }
            return f5043b;
        }
        if (!a.e.f35297a) {
            Log.e("IDHelper", "1001");
        }
        return a.e.f35298b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r6) {
        /*
            java.lang.String r0 = "com.oplus.stdid"
            b.h.b.a.d r1 = b.h.b.a.d.b.f5054a
            android.content.Context r2 = a(r6)
            r1.getClass()
            java.lang.String r1 = "2008"
            b.h.b.a.b.a(r1)
            r1 = 0
            r3 = 1
            android.content.pm.PackageManager r4 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r4 == 0) goto L28
            int r4 = r4.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r4 < r3) goto L28
            boolean r0 = h.a.a.a.b.f(r2, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r0 == 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            b.h.b.a.a.f5043b = r0
            b.h.b.a.a.f5042a = r3
            if (r0 == 0) goto L33
            b.h.b.a.a.f5044c = r3
            goto Lb0
        L33:
            b.h.b.a.a.f5044c = r1
            h.a.a.a$d r0 = h.a.a.a.d.b.f35296a
            android.content.Context r2 = h.a.a.a.e.a(r6)
            r0.getClass()
            java.lang.String r0 = "Y29tLmhleXRhcC5vcGVuaWQ="
            java.lang.String r0 = h.a.a.a.b.d(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "2008:"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            h.a.a.a.g.a(r4)
            android.content.pm.PackageManager r4 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6e
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6e
            if (r4 == 0) goto L6e
            int r4 = r4.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6e
            if (r4 < r3) goto L6e
            boolean r0 = h.a.a.a.b.f(r2, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6e
            if (r0 == 0) goto L6e
            r0 = 1
            goto L6f
        L6e:
            r0 = 0
        L6f:
            h.a.a.a.e.f35298b = r0
            h.a.a.a.e.f35297a = r3
            if (r0 == 0) goto L7c
            h.a.a.a$c r6 = h.a.a.a.c.b()
            r6.f35289c = r3
            goto Lb0
        L7c:
            h.a.a.a$c r0 = h.a.a.a.c.b()
            r0.f35289c = r1
            h.a.a.a$h r0 = h.a.a.a.h.b.f35308a
            android.content.Context r6 = h.a.a.a.e.a(r6)
            r0.getClass()
            java.lang.String r0 = "Y29tLmNvbG9yb3MubWNz"
            java.lang.String r0 = h.a.a.a.b.d(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            h.a.a.a.g.a(r2)
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lae
            if (r6 == 0) goto Lae
            r1 = 1
        Lae:
            h.a.a.a.e.f35298b = r1
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.b.a.a.c(android.content.Context):void");
    }

    public static boolean d() {
        String str;
        if (!f5042a) {
            str = "1001";
        } else if (!f5043b) {
            str = "1002";
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            }
            str = "1003";
        }
        Log.e("StdIDHelper", str);
        return false;
    }

    public static String e(Context context) {
        if (f5044c) {
            b.a("2001");
            return !d() ? "" : c.a().b(a(context), "GUID");
        }
        a.g.a("2001");
        return !a.e.b() ? "" : a.c.b().a(a.e.a(context), "GUID");
    }

    public static boolean f(Context context) {
        if (f5044c) {
            b.a("2002");
        } else {
            a.g.a("2002");
            if (a.e.b()) {
                return "TRUE".equalsIgnoreCase(a.c.b().a(a.e.a(context), "OUID_STATUS"));
            }
        }
        return false;
    }

    public static String g(Context context) {
        if (f5044c) {
            b.a("2003");
            return null;
        }
        a.g.a("2003");
        return !a.e.b() ? "" : a.c.b().a(a.e.a(context), "OUID");
    }

    public static String h(Context context) {
        if (f5044c) {
            b.a("2004");
            return !d() ? "" : c.a().b(a(context), "DUID");
        }
        a.g.a("2004");
        return !a.e.b() ? "" : a.c.b().a(a.e.a(context), "DUID");
    }
}
