package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* loaded from: classes.dex */
public class bs {

    /* renamed from: a */
    private static String f9142a;

    public static String a(int i2) {
        int nextInt;
        StringBuilder sb = new StringBuilder();
        if (i2 < 3) {
            i2 = 3;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (int i3 = 0; i3 < i2; i3++) {
            int nextInt2 = secureRandom.nextInt(3);
            if (nextInt2 != 0) {
                if (nextInt2 == 1) {
                    nextInt = secureRandom.nextInt(25) + 65;
                } else if (nextInt2 == 2) {
                    nextInt = secureRandom.nextInt(25) + 97;
                }
                sb.append((char) nextInt);
            } else {
                sb.append(secureRandom.nextInt(10));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #0 {all -> 0x009f, blocks: (B:4:0x0003, B:6:0x000b, B:10:0x000f, B:12:0x002f, B:18:0x0043, B:20:0x0049, B:24:0x0056, B:26:0x0094, B:33:0x003b), top: B:3:0x0003 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String a(android.content.Context r5) {
        /*
            java.lang.Class<com.kuaishou.weapon.p0.bs> r0 = com.kuaishou.weapon.p0.bs.class
            monitor-enter(r0)
            java.lang.String r1 = com.kuaishou.weapon.p0.bs.f9142a     // Catch: java.lang.Throwable -> L9f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9f
            if (r1 != 0) goto Lf
            java.lang.String r5 = com.kuaishou.weapon.p0.bs.f9142a     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r5
        Lf:
            java.lang.String r1 = "re_po_rt"
            com.kuaishou.weapon.p0.h r1 = com.kuaishou.weapon.p0.h.a(r5, r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.e(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.e(r3)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.de r3 = com.kuaishou.weapon.p0.de.a(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = com.kuaishou.weapon.p0.bt.a(r5, r3)     // Catch: java.lang.Throwable -> L9f
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L9f
            if (r4 != 0) goto L33
            com.kuaishou.weapon.p0.bs.f9142a = r3     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r3
        L33:
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            if (r2 != 0) goto L3b
            if (r1 == 0) goto L43
        L3b:
            java.lang.String r3 = com.kuaishou.weapon.p0.bg.c(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r4 = com.kuaishou.weapon.p0.bg.f(r5)     // Catch: java.lang.Throwable -> L9f
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L9f
            if (r1 != 0) goto L54
            java.lang.String r1 = "RISK"
            boolean r1 = r3.startsWith(r1)     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L52
            goto L54
        L52:
            r1 = r3
            goto L56
        L54:
            java.lang.String r1 = "0"
        L56:
            java.lang.String r2 = a(r5, r3, r4)     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L9f
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuffer r1 = r3.reverse()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> L9f
            r3.append(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> L9f
            r3.append(r1)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bm r2 = new com.kuaishou.weapon.p0.bm     // Catch: java.lang.Throwable -> L9f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r1 = r2.a(r1, r3)     // Catch: java.lang.Throwable -> L9f
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 != 0) goto L9f
            com.kuaishou.weapon.p0.de r2 = com.kuaishou.weapon.p0.de.a(r5)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bt.a(r1, r5, r2)     // Catch: java.lang.Throwable -> L9f
            com.kuaishou.weapon.p0.bs.f9142a = r1     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r0)
            return r1
        L9f:
            java.lang.String r5 = ""
            monitor-exit(r0)
            return r5
        La3:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bs.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str, String str2) {
        try {
            String uuid = UUID.randomUUID().toString();
            String a2 = f.a(str + str2 + (context != null ? context.getPackageName() : "") + uuid);
            return TextUtils.isEmpty(a2) ? "" : a2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
