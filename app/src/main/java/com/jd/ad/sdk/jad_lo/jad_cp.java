package com.jd.ad.sdk.jad_lo;

/* loaded from: classes2.dex */
public class jad_cp {
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an(java.lang.String r4, boolean r5) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.io.File r1 = new java.io.File
            r1.<init>(r4)
            boolean r4 = r1.exists()
            java.lang.String r2 = "\n"
            if (r4 == 0) goto L44
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L40
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L40
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L40
        L1c:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L3a
            if (r5 == 0) goto L36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L34
            r3.append(r4)     // Catch: java.lang.Throwable -> L34
            r3.append(r2)     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Throwable -> L34
            goto L36
        L34:
            goto L41
        L36:
            r0.append(r4)     // Catch: java.lang.Throwable -> L34
            goto L1c
        L3a:
            r1.close()     // Catch: java.io.IOException -> L3e
            goto L44
        L3e:
            goto L44
        L40:
            r1 = 0
        L41:
            if (r1 == 0) goto L44
            goto L3a
        L44:
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.trim()
            if (r5 == 0) goto L5f
            boolean r5 = r4.endsWith(r2)
            if (r5 == 0) goto L5f
            int r5 = r4.length()
            int r5 = r5 + (-2)
            r0 = 0
            java.lang.String r4 = r4.substring(r0, r5)
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_lo.jad_cp.jad_an(java.lang.String, boolean):java.lang.String");
    }
}
