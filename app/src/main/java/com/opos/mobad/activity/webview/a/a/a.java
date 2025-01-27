package com.opos.mobad.activity.webview.a.a;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static final byte[] f19401a = new byte[0];

    /* renamed from: b */
    private static volatile ExecutorService f19402b;

    public static int a() {
        return 107;
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    return com.opos.cmn.biz.b.a.a(context, str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("JSUtils", "", (Throwable) e2);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "JSUtils"
            if (r4 == 0) goto L34
            boolean r1 = com.opos.cmn.an.c.a.a(r5)
            if (r1 != 0) goto L34
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L2e
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = "android.intent.category.BROWSABLE"
            r1.addCategory(r2)     // Catch: java.lang.Exception -> L2e
            r2 = 0
            r1.setComponent(r2)     // Catch: java.lang.Exception -> L2e
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> L2e
            boolean r2 = com.opos.cmn.an.h.d.a.a(r4, r1)     // Catch: java.lang.Exception -> L2e
            if (r2 == 0) goto L34
            r4.startActivity(r1)     // Catch: java.lang.Exception -> L2e
            r4 = 1
            goto L35
        L2e:
            r4 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r4)
        L34:
            r4 = 0
        L35:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "launchAppPage url="
            r1.append(r2)
            if (r5 == 0) goto L42
            goto L44
        L42:
            java.lang.String r5 = "null"
        L44:
            r1.append(r5)
            java.lang.String r5 = "result="
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.a.a.b(android.content.Context, java.lang.String):boolean");
    }
}
