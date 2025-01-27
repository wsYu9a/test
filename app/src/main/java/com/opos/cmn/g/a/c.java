package com.opos.cmn.g.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static String f17384a = "localId";

    /* renamed from: b */
    private static volatile String f17385b = "";

    /* renamed from: c */
    private static volatile boolean f17386c = false;

    /* renamed from: d */
    private static final byte[] f17387d = new byte[0];

    /* renamed from: com.opos.cmn.g.a.c$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17388a;

        AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> a2 = b.c.a.b.f.f4313d.a(applicationContext);
            if (a2 != null) {
                String unused = c.f17385b = a2.get(c.f17384a);
                i.e(applicationContext, c.f17385b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "ImeiTool"
            java.lang.String r4 = ""
            r5 = 29
            if (r2 >= r5) goto L26
            if (r7 == 0) goto L21
            b.c.a.b.f r2 = b.c.a.b.f.f4313d     // Catch: java.lang.Exception -> L1b
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Exception -> L1b
            java.lang.String r7 = r2.b(r7)     // Catch: java.lang.Exception -> L1b
            goto L22
        L1b:
            r7 = move-exception
            java.lang.String r2 = "getImei"
            com.opos.cmn.an.f.a.c(r3, r2, r7)
        L21:
            r7 = r4
        L22:
            if (r7 != 0) goto L25
            goto L26
        L25:
            r4 = r7
        L26:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "getImei result:"
            r7.append(r2)
            r7.append(r4)
            java.lang.String r2 = " costTime:"
            r7.append(r2)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.opos.cmn.an.f.a.b(r3, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.c.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r7) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "ImeiTool"
            java.lang.String r4 = ""
            r5 = 29
            if (r2 >= r5) goto L26
            if (r7 == 0) goto L21
            b.c.a.b.f r2 = b.c.a.b.f.f4313d     // Catch: java.lang.Exception -> L1b
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Exception -> L1b
            java.lang.String r7 = r2.l(r7)     // Catch: java.lang.Exception -> L1b
            goto L22
        L1b:
            r7 = move-exception
            java.lang.String r2 = "refreshClientId"
            com.opos.cmn.an.f.a.c(r3, r2, r7)
        L21:
            r7 = r4
        L22:
            if (r7 != 0) goto L25
            goto L26
        L25:
            r4 = r7
        L26:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "refreshClientId result:"
            r7.append(r2)
            r7.append(r4)
            java.lang.String r2 = " costTime:"
            r7.append(r2)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.opos.cmn.an.f.a.b(r3, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.c.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 29) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (TextUtils.isEmpty(f17385b)) {
                        synchronized (f17387d) {
                            if (TextUtils.isEmpty(f17385b)) {
                                f17385b = i.f(applicationContext);
                                if (!f17386c) {
                                    f17386c = true;
                                    new Thread(new Runnable() { // from class: com.opos.cmn.g.a.c.1

                                        /* renamed from: a */
                                        final /* synthetic */ Context f17388a;

                                        AnonymousClass1(Context applicationContext2) {
                                            applicationContext = applicationContext2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Map<String, String> a2 = b.c.a.b.f.f4313d.a(applicationContext);
                                            if (a2 != null) {
                                                String unused = c.f17385b = a2.get(c.f17384a);
                                                i.e(applicationContext, c.f17385b);
                                            }
                                        }
                                    }).start();
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("ImeiTool", "getLocalId", e2);
                }
            }
            if (f17385b == null) {
                f17385b = "";
            }
        }
        com.opos.cmn.an.f.a.b("ImeiTool", "getLocalId result:" + f17385b + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return f17385b;
    }
}
