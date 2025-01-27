package com.opos.cmn.g.a;

import android.content.Context;

/* loaded from: classes4.dex */
public final class b {
    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L13
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld
            java.lang.String r2 = com.opos.cmn.g.a.h.c(r2)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r2 = move-exception
            java.lang.String r1 = "IdTool"
            com.opos.cmn.an.f.a.c(r1, r0, r2)
        L13:
            r2 = r0
        L14:
            if (r2 == 0) goto L17
            r0 = r2
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.b.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L13
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld
            java.lang.String r2 = com.opos.cmn.g.a.h.d(r2)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r2 = move-exception
            java.lang.String r1 = "IdTool"
            com.opos.cmn.an.f.a.c(r1, r0, r2)
        L13:
            r2 = r0
        L14:
            if (r2 == 0) goto L17
            r0 = r2
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.b.b(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L13
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld
            java.lang.String r2 = com.opos.cmn.g.a.h.e(r2)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r2 = move-exception
            java.lang.String r1 = "IdTool"
            com.opos.cmn.an.f.a.c(r1, r0, r2)
        L13:
            r2 = r0
        L14:
            if (r2 == 0) goto L17
            r0 = r2
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.b.c(android.content.Context):java.lang.String");
    }

    public static void d(Context context) {
        try {
            h.a(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("IdTool", "", e2);
        }
    }

    public static boolean e(Context context) {
        if (context != null) {
            try {
                return g.d(context.getApplicationContext());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("IdTool", "", e2);
            }
        }
        return false;
    }

    public static void f(Context context) {
        try {
            e.b(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("IdTool", "", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L13
            android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> Ld
            java.lang.String r2 = com.opos.cmn.g.a.e.a(r2)     // Catch: java.lang.Exception -> Ld
            goto L14
        Ld:
            r2 = move-exception
            java.lang.String r1 = "IdTool"
            com.opos.cmn.an.f.a.c(r1, r0, r2)
        L13:
            r2 = r0
        L14:
            if (r2 == 0) goto L17
            r0 = r2
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.b.g(android.content.Context):java.lang.String");
    }

    public static boolean h(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            z = h.f(context.getApplicationContext());
            h.b(context.getApplicationContext());
            com.opos.cmn.an.f.a.b("IdTool", "getOUIDStatus costTime=" + (System.currentTimeMillis() - currentTimeMillis) + " result=" + z);
            return z;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("IdTool", "", e2);
            return z;
        }
    }
}
