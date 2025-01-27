package com.martian.mibook.lib.local.c;

/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:29:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4, long r5, long r7) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            long r7 = r7 - r5
            int r3 = (int) r7
            byte[] r7 = new byte[r3]     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L3a
            r1.seek(r5)     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L3a
            r5 = 0
            r1.read(r7, r5, r3)     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L3a
            java.lang.String r3 = new java.lang.String     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L3a
            r3.<init>(r7, r4)     // Catch: java.io.IOException -> L26 java.lang.Throwable -> L3a
            r1.close()     // Catch: java.io.IOException -> L21
            goto L25
        L21:
            r4 = move-exception
            r4.printStackTrace()
        L25:
            return r3
        L26:
            r3 = move-exception
            goto L2c
        L28:
            r3 = move-exception
            goto L3c
        L2a:
            r3 = move-exception
            r1 = r0
        L2c:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r3 = move-exception
            r3.printStackTrace()
        L39:
            return r0
        L3a:
            r3 = move-exception
            r0 = r1
        L3c:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r4 = move-exception
            r4.printStackTrace()
        L46:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.lib.local.c.a.a(java.lang.String, java.lang.String, long, long):java.lang.String");
    }
}
