package com.opos.cmn.func.a;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static d f17055a;

    /* renamed from: b */
    private static final byte[] f17056b = new byte[0];

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.func.a.b a(android.content.Context r3, com.opos.cmn.func.a.a r4) {
        /*
            java.lang.String r0 = "DownloadTool"
            if (r3 == 0) goto L1a
            if (r4 == 0) goto L1a
            a()
            com.opos.cmn.func.a.d r1 = com.opos.cmn.func.a.c.f17055a     // Catch: java.lang.Exception -> L14
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L14
            com.opos.cmn.func.a.b r3 = r1.a(r3, r4)     // Catch: java.lang.Exception -> L14
            goto L1b
        L14:
            r3 = move-exception
            java.lang.String r1 = "download"
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L1a:
            r3 = 0
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "download request="
            r1.append(r2)
            java.lang.String r2 = "null"
            if (r4 == 0) goto L2e
            java.lang.String r4 = r4.toString()
            goto L2f
        L2e:
            r4 = r2
        L2f:
            r1.append(r4)
            java.lang.String r4 = ",response="
            r1.append(r4)
            if (r3 == 0) goto L3d
            java.lang.String r2 = r3.toString()
        L3d:
            r1.append(r2)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.c.a(android.content.Context, com.opos.cmn.func.a.a):com.opos.cmn.func.a.b");
    }

    private static void a() {
        if (f17055a == null) {
            synchronized (f17056b) {
                if (f17055a == null) {
                    f17055a = new com.opos.cmn.func.a.a.a();
                }
            }
        }
    }
}
