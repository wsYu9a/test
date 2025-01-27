package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.g.a.f;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static final byte[] f17390a = new byte[0];

    /* renamed from: b */
    private static volatile boolean f17391b = false;

    /* renamed from: c */
    private static volatile f.a f17392c;

    /* renamed from: com.opos.cmn.g.a.e$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17393a;

        AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (e.f17390a) {
                    com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID begin!");
                    f.a a2 = f.a(applicationContext);
                    if (a2 != null) {
                        f.a unused = e.f17392c = a2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateGAID gaid:");
                        sb.append(e.f17392c.a());
                        sb.append(" gaidStatus:");
                        sb.append(!e.f17392c.b());
                        com.opos.cmn.an.f.a.b("GAIDUtils", sb.toString());
                    }
                    if (e.f17392c != null) {
                        if (!TextUtils.isEmpty(e.f17392c.a())) {
                            i.d(applicationContext, e.f17392c.a());
                        }
                        i.b(applicationContext, !a2.b());
                    }
                    com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID end!");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("GAIDUtils", "", e2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        r2 = "";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5) {
        /*
            java.lang.String r0 = "GAIDUtils"
            java.lang.String r1 = ""
            com.opos.cmn.g.a.f$a r2 = com.opos.cmn.g.a.e.f17392c     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L1b
            com.opos.cmn.g.a.f$a r2 = com.opos.cmn.g.a.e.f17392c     // Catch: java.lang.Exception -> L22
            java.lang.String r2 = r2.a()     // Catch: java.lang.Exception -> L22
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L22
            if (r2 != 0) goto L1b
            com.opos.cmn.g.a.f$a r2 = com.opos.cmn.g.a.e.f17392c     // Catch: java.lang.Exception -> L22
            java.lang.String r2 = r2.a()     // Catch: java.lang.Exception -> L22
            goto L27
        L1b:
            if (r5 == 0) goto L26
            java.lang.String r2 = com.opos.cmn.g.a.i.d(r5)     // Catch: java.lang.Exception -> L22
            goto L27
        L22:
            r2 = move-exception
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L26:
            r2 = r1
        L27:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getGAID "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.opos.cmn.an.f.a.b(r0, r3)
            boolean r0 = com.opos.cmn.g.a.e.f17391b
            if (r0 != 0) goto L42
            b(r5)
        L42:
            if (r2 == 0) goto L45
            r1 = r2
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.g.a.e.a(android.content.Context):java.lang.String");
    }

    public static void b(Context context) {
        synchronized (e.class) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f17391b = true;
                    new Thread(new Runnable() { // from class: com.opos.cmn.g.a.e.1

                        /* renamed from: a */
                        final /* synthetic */ Context f17393a;

                        AnonymousClass1(Context applicationContext2) {
                            applicationContext = applicationContext2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                synchronized (e.f17390a) {
                                    com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID begin!");
                                    f.a a2 = f.a(applicationContext);
                                    if (a2 != null) {
                                        f.a unused = e.f17392c = a2;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("updateGAID gaid:");
                                        sb.append(e.f17392c.a());
                                        sb.append(" gaidStatus:");
                                        sb.append(!e.f17392c.b());
                                        com.opos.cmn.an.f.a.b("GAIDUtils", sb.toString());
                                    }
                                    if (e.f17392c != null) {
                                        if (!TextUtils.isEmpty(e.f17392c.a())) {
                                            i.d(applicationContext, e.f17392c.a());
                                        }
                                        i.b(applicationContext, !a2.b());
                                    }
                                    com.opos.cmn.an.f.a.b("GAIDUtils", "updateGAID end!");
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.c("GAIDUtils", "", e2);
                            }
                        }
                    }).start();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("GAIDUtils", "", e2);
                }
            }
        }
    }
}
