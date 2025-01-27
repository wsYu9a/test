package qb;

/* loaded from: classes3.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:29:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4, long r5, long r7) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            long r7 = r7 - r5
            int r3 = (int) r7
            byte[] r7 = new byte[r3]     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r1.seek(r5)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r5 = 0
            r1.read(r7, r5, r3)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r3.<init>(r7, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r1.close()     // Catch: java.io.IOException -> L21
            goto L25
        L21:
            r4 = move-exception
            r4.printStackTrace()
        L25:
            return r3
        L26:
            r3 = move-exception
            r0 = r1
            goto L3d
        L29:
            r3 = move-exception
            goto L2f
        L2b:
            r3 = move-exception
            goto L3d
        L2d:
            r3 = move-exception
            r1 = r0
        L2f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r3 = move-exception
            r3.printStackTrace()
        L3c:
            return r0
        L3d:
            if (r0 == 0) goto L47
            r0.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r4 = move-exception
            r4.printStackTrace()
        L47:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qb.a.a(java.lang.String, java.lang.String, long, long):java.lang.String");
    }
}
