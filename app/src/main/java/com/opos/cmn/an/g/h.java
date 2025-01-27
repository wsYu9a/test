package com.opos.cmn.an.g;

import com.opos.cmn.an.g.e;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    private static e f16521a;

    /* renamed from: b */
    private static final byte[] f16522b = new byte[0];

    /* renamed from: c */
    private static AtomicLong f16523c = new AtomicLong(0);

    public static long a() {
        return f16523c.getAndIncrement();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.cmn.an.g.g a(android.content.Context r3, long r4, com.opos.cmn.an.g.f r6) {
        /*
            b()
            java.lang.String r0 = "NetTool"
            if (r3 == 0) goto L59
            if (r6 == 0) goto L59
            int r1 = r6.f16493a     // Catch: java.lang.Exception -> L53
            if (r1 == 0) goto L4a
            r2 = 1
            if (r1 == r2) goto L3d
            r2 = 2
            if (r1 == r2) goto L30
            r2 = 3
            if (r1 == r2) goto L23
            com.opos.cmn.an.g.e r1 = com.opos.cmn.an.g.h.f16521a     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.b r1 = r1.f16485a     // Catch: java.lang.Exception -> L53
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L53
        L1e:
            com.opos.cmn.an.g.g r3 = r1.a(r3, r4, r6)     // Catch: java.lang.Exception -> L53
            goto L5a
        L23:
            com.opos.cmn.an.g.e r1 = com.opos.cmn.an.g.h.f16521a     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.d r1 = r1.f16488d     // Catch: java.lang.Exception -> L53
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.g r3 = r1.a(r3, r4, r6)     // Catch: java.lang.Exception -> L53
            goto L5a
        L30:
            com.opos.cmn.an.g.e r1 = com.opos.cmn.an.g.h.f16521a     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.a r1 = r1.f16487c     // Catch: java.lang.Exception -> L53
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.g r3 = r1.a(r3, r4, r6)     // Catch: java.lang.Exception -> L53
            goto L5a
        L3d:
            com.opos.cmn.an.g.e r1 = com.opos.cmn.an.g.h.f16521a     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.c r1 = r1.f16486b     // Catch: java.lang.Exception -> L53
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.g r3 = r1.a(r3, r4, r6)     // Catch: java.lang.Exception -> L53
            goto L5a
        L4a:
            com.opos.cmn.an.g.e r1 = com.opos.cmn.an.g.h.f16521a     // Catch: java.lang.Exception -> L53
            com.opos.cmn.an.g.b r1 = r1.f16485a     // Catch: java.lang.Exception -> L53
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L53
            goto L1e
        L53:
            r3 = move-exception
            java.lang.String r1 = "execute"
            com.opos.cmn.an.f.a.c(r0, r1, r3)
        L59:
            r3 = 0
        L5a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "execute taskCode="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = ",netRequest="
            r1.append(r4)
            java.lang.String r4 = "null"
            if (r6 == 0) goto L75
            java.lang.String r5 = r6.toString()
            goto L76
        L75:
            r5 = r4
        L76:
            r1.append(r5)
            java.lang.String r5 = ",netResponse="
            r1.append(r5)
            if (r3 == 0) goto L81
            r4 = r3
        L81:
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.g.h.a(android.content.Context, long, com.opos.cmn.an.g.f):com.opos.cmn.an.g.g");
    }

    public static void a(long j2) {
        com.opos.cmn.an.f.a.b("NetTool", "shutDown taskCode=" + j2);
        try {
            f16521a.f16485a.a(j2);
            f16521a.f16486b.a(j2);
            f16521a.f16487c.a(j2);
            f16521a.f16488d.a(j2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("NetTool", "shutDown", e2);
        }
    }

    private static void b() {
        if (f16521a == null) {
            synchronized (f16522b) {
                if (f16521a == null) {
                    f16521a = new e.a().a(new com.opos.cmn.an.g.a.c.a()).a(new com.opos.cmn.an.g.a.b.a()).a(new com.opos.cmn.an.g.a.d.a()).a(new com.opos.cmn.an.g.a.e.a()).a();
                }
            }
        }
    }
}
