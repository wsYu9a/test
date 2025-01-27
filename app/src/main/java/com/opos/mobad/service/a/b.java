package com.opos.mobad.service.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Map<String, Long> f23480a = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "CommonConfig"
            boolean r1 = com.opos.cmn.an.c.a.a(r6)     // Catch: java.lang.Exception -> L1d
            if (r1 != 0) goto L23
            java.util.Map<java.lang.String, java.lang.Long> r1 = r5.f23480a     // Catch: java.lang.Exception -> L1d
            boolean r1 = r1.containsKey(r6)     // Catch: java.lang.Exception -> L1d
            if (r1 == 0) goto L23
            java.util.Map<java.lang.String, java.lang.Long> r1 = r5.f23480a     // Catch: java.lang.Exception -> L1d
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Exception -> L1d
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Exception -> L1d
            long r1 = r1.longValue()     // Catch: java.lang.Exception -> L1d
            goto L26
        L1d:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L23:
            r1 = 60000(0xea60, double:2.9644E-319)
        L26:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getRefreshTime posId="
            r3.append(r4)
            if (r6 == 0) goto L33
            goto L35
        L33:
            java.lang.String r6 = "null"
        L35:
            r3.append(r6)
            java.lang.String r6 = ",result="
            r3.append(r6)
            r3.append(r1)
            java.lang.String r6 = r3.toString()
            com.opos.cmn.an.f.a.b(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.b.a(java.lang.String):long");
    }

    public void a(String str, int i2) {
        try {
            if (!com.opos.cmn.an.c.a.a(str) && i2 > 0) {
                this.f23480a.put(str, Long.valueOf(i2 * 1000));
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setRefreshTime posId=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",refreshTime=");
        sb.append(i2);
        com.opos.cmn.an.f.a.b("CommonConfig", sb.toString());
    }
}
