package com.opos.mobad.model.e;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static volatile com.opos.cmn.an.d.d.a f21750a;

    /* renamed from: b */
    private static final byte[] f21751b = new byte[0];

    /* renamed from: c */
    private static Map<String, Boolean> f21752c = new ConcurrentHashMap();

    private static com.opos.cmn.an.d.d.a a(Context context) {
        com.opos.cmn.an.d.d.a aVar = f21750a;
        if (aVar == null) {
            synchronized (f21751b) {
                aVar = f21750a;
                if (aVar == null) {
                    aVar = new com.opos.cmn.an.d.d.a(context, "mobad.record.show.prefs", 0);
                    f21750a = aVar;
                }
            }
        }
        return aVar;
    }

    public static String a() {
        return "https://uapi.ads.heytapmobi.com/union/ads/v2/show";
    }

    public static void a(Context context, String str, boolean z) {
        try {
            com.opos.cmn.an.f.a.b("Utils", "updateRecordEvent posId=" + str + ",record=" + z);
            if (z != a(context, str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("really updateRecordEvent=");
                sb.append(str != null ? str : "null");
                sb.append(",record=");
                sb.append(z);
                com.opos.cmn.an.f.a.b("Utils", sb.toString());
                f21752c.put(str, Boolean.valueOf(z));
                b(context, str, z);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static boolean a(Context context, String str) {
        boolean z = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    if (f21752c.containsKey(str)) {
                        z = f21752c.get(str).booleanValue();
                    } else {
                        z = b(context, str);
                        f21752c.put(str, Boolean.valueOf(z));
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("recordShowEvent posId=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return z;
    }

    private static void b(Context context, String str, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("putRecordShowEvent posId=");
            sb.append(str != null ? str : "null");
            sb.append(",record=");
            sb.append(z);
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (context == null || com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            a(context).a(str, Boolean.valueOf(z));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "Utils"
            if (r3 == 0) goto L1a
            boolean r1 = com.opos.cmn.an.c.a.a(r4)     // Catch: java.lang.Exception -> L14
            if (r1 != 0) goto L1a
            com.opos.cmn.an.d.d.a r3 = a(r3)     // Catch: java.lang.Exception -> L14
            r1 = 1
            boolean r3 = r3.a(r4, r1)     // Catch: java.lang.Exception -> L14
            goto L1b
        L14:
            r3 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r3)
        L1a:
            r3 = 0
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getRecordShowEvent posId="
            r1.append(r2)
            if (r4 == 0) goto L28
            goto L2a
        L28:
            java.lang.String r4 = "null"
        L2a:
            r1.append(r4)
            java.lang.String r4 = ",result="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.e.d.b(android.content.Context, java.lang.String):boolean");
    }
}
