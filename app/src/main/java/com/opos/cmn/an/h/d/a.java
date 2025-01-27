package com.opos.cmn.an.h.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static PackageManager f16529a;

    /* renamed from: b */
    private static final String f16530b = "com." + com.opos.cmn.an.a.a.f16359c + ".feature.screen.heteromorphism";

    public static PackageManager a(Context context) {
        if (f16529a == null && context != null) {
            f16529a = context.getApplicationContext().getPackageManager();
        }
        return f16529a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3, android.content.Intent r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            if (r3 == 0) goto L1a
            if (r4 == 0) goto L1a
            android.content.pm.PackageManager r3 = a(r3)     // Catch: java.lang.Exception -> L14
            r1 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r3 = r3.resolveActivity(r4, r1)     // Catch: java.lang.Exception -> L14
            if (r3 == 0) goto L1a
            r3 = 1
            goto L1b
        L14:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L1a:
            r3 = 0
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isActivityExists intent="
            r1.append(r2)
            if (r4 == 0) goto L2c
            java.lang.String r4 = r4.toString()
            goto L2e
        L2c:
            java.lang.String r4 = "null"
        L2e:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.a(android.content.Context, android.content.Intent):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0027 -> B:16:0x002c). Please report as a decompilation issue!!! */
    public static boolean a(Context context, View view) {
        boolean z;
        WindowInsets rootWindowInsets;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (view != null && (rootWindowInsets = view.getRootWindowInsets()) != null && rootWindowInsets.getDisplayCutout() != null) {
                z = true;
            }
            z = false;
        } else {
            if (context != null) {
                z = a(context).hasSystemFeature(f16530b);
            }
            z = false;
        }
        com.opos.cmn.an.f.a.b("PkgMgrTool", "isShapedScreen=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            if (r3 == 0) goto L18
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L12
            if (r1 != 0) goto L18
            int r3 = r3.checkCallingOrSelfPermission(r4)     // Catch: java.lang.Exception -> L12
            if (r3 != 0) goto L18
            r3 = 1
            goto L19
        L12:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L18:
            r3 = 0
        L19:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkCallingOrSelfPermission pmName="
            r1.append(r2)
            if (r4 == 0) goto L26
            goto L28
        L26:
            java.lang.String r4 = "null"
        L28:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.a(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            android.content.pm.PackageManager r3 = a(r3)     // Catch: java.lang.Exception -> L1d
            if (r3 == 0) goto L23
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L1d
            if (r1 != 0) goto L23
            r1 = 0
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L16 java.lang.Exception -> L1d
            int r3 = r3.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L16 java.lang.Exception -> L1d
            goto L24
        L16:
            r3 = move-exception
            java.lang.String r1 = "getAppVerCode"
            com.opos.cmn.an.f.a.b(r0, r1, r3)     // Catch: java.lang.Exception -> L1d
            goto L23
        L1d:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L23:
            r3 = -1
        L24:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAppVerCode pkgName="
            r1.append(r2)
            if (r4 == 0) goto L31
            goto L33
        L31:
            java.lang.String r4 = "null"
        L33:
            r1.append(r4)
            java.lang.String r4 = ",appVerCode="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.b(android.content.Context, java.lang.String):int");
    }

    @Deprecated
    public static List<String> b(Context context) {
        com.opos.cmn.an.f.a.b("PkgMgrTool", "getAllInstalledPkgName=" + ((Object) "null"));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r4 = a(r4)     // Catch: java.lang.Exception -> L1f
            if (r4 == 0) goto L23
            boolean r2 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L1f
            if (r2 != 0) goto L23
            r2 = 0
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L18 java.lang.Exception -> L1f
            java.lang.String r4 = r4.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L18 java.lang.Exception -> L1f
            goto L24
        L18:
            r4 = move-exception
            java.lang.String r2 = "getAppVerCode"
            com.opos.cmn.an.f.a.b(r0, r2, r4)     // Catch: java.lang.Exception -> L1f
            goto L23
        L1f:
            r4 = move-exception
            com.opos.cmn.an.f.a.c(r0, r1, r4)
        L23:
            r4 = r1
        L24:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getAppVerName pkgName="
            r2.append(r3)
            if (r5 == 0) goto L31
            goto L33
        L31:
            java.lang.String r5 = "null"
        L33:
            r2.append(r5)
            java.lang.String r5 = ",appVerName="
            r2.append(r5)
            if (r4 == 0) goto L3f
            r5 = r4
            goto L40
        L3f:
            r5 = r1
        L40:
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            if (r4 == 0) goto L4d
            r1 = r4
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.c(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            if (r3 == 0) goto L20
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L1a
            if (r1 != 0) goto L20
            android.content.pm.PackageManager r3 = a(r3)     // Catch: java.lang.Exception -> L1a
            if (r3 == 0) goto L20
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r4, r1)     // Catch: java.lang.Exception -> L20
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L1a:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L20:
            r3 = 0
        L21:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "hasPkgInstalled pkgName="
            r1.append(r2)
            if (r4 == 0) goto L2e
            goto L30
        L2e:
            java.lang.String r4 = "null"
        L30:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.d(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean e(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "PkgMgrTool"
            if (r4 == 0) goto L2b
            boolean r2 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L27
            if (r2 != 0) goto L2b
            android.content.pm.PackageManager r2 = a(r4)     // Catch: java.lang.Exception -> L27
            if (r2 == 0) goto L2b
            android.content.Intent r2 = r2.getLaunchIntentForPackage(r5)     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L2b
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r3)     // Catch: java.lang.Exception -> L22
            r4.startActivity(r2)     // Catch: java.lang.Exception -> L22
            r4 = 1
            goto L2c
        L22:
            r4 = move-exception
            com.opos.cmn.an.f.a.c(r1, r0, r4)     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r4 = move-exception
            com.opos.cmn.an.f.a.c(r1, r0, r4)
        L2b:
            r4 = 0
        L2c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "launchAppHomePage pkgName="
            r0.append(r2)
            if (r5 == 0) goto L39
            goto L3b
        L39:
            java.lang.String r5 = "null"
        L3b:
            r0.append(r5)
            java.lang.String r5 = ",result="
            r0.append(r5)
            r0.append(r4)
            java.lang.String r5 = r0.toString()
            com.opos.cmn.an.f.a.b(r1, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.e(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable f(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            android.content.pm.PackageManager r3 = a(r3)     // Catch: java.lang.Exception -> L1a
            if (r3 == 0) goto L20
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L1a
            if (r1 != 0) goto L20
            android.graphics.drawable.Drawable r3 = r3.getApplicationIcon(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L13 java.lang.Exception -> L1a
            goto L21
        L13:
            r3 = move-exception
            java.lang.String r1 = "getAppVerCode"
            com.opos.cmn.an.f.a.b(r0, r1, r3)     // Catch: java.lang.Exception -> L1a
            goto L20
        L1a:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L20:
            r3 = 0
        L21:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getAppIcon pkgName="
            r1.append(r2)
            java.lang.String r2 = "null"
            if (r4 == 0) goto L30
            goto L31
        L30:
            r4 = r2
        L31:
            r1.append(r4)
            java.lang.String r4 = ",appIcon="
            r1.append(r4)
            if (r3 == 0) goto L3c
            r2 = r3
        L3c:
            r1.append(r2)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.f(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    public static String g(Context context, String str) {
        PackageManager a2;
        String str2 = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str) && (a2 = a(context)) != null) {
                    try {
                        ApplicationInfo applicationInfo = a2.getApplicationInfo(str, 128);
                        if (applicationInfo != null) {
                            str2 = applicationInfo.loadLabel(a2).toString();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("PkgMgrTool", "", e2);
                    }
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("PkgMgrTool", str2, e3);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAppName pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(str2);
        com.opos.cmn.an.f.a.b("PkgMgrTool", sb.toString());
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.ApplicationInfo h(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "PkgMgrTool"
            if (r3 == 0) goto L1d
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L17
            if (r1 != 0) goto L1d
            android.content.pm.PackageManager r3 = a(r3)     // Catch: java.lang.Exception -> L17
            if (r3 == 0) goto L1d
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r4, r1)     // Catch: java.lang.Exception -> L1d
            goto L1e
        L17:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L1d:
            r3 = 0
        L1e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getApplicationInfo pkgName="
            r1.append(r2)
            if (r4 == 0) goto L2b
            goto L2d
        L2b:
            java.lang.String r4 = "null"
        L2d:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.d.a.h(android.content.Context, java.lang.String):android.content.pm.ApplicationInfo");
    }
}
