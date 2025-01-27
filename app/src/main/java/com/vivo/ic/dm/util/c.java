package com.vivo.ic.dm.util;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final String f28633a = "FileUtil";

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0073: MOVE (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:38:0x0073 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r9) {
        /*
            java.lang.String r0 = "inputStream close IOException:"
            boolean r1 = r9.exists()
            r2 = 0
            java.lang.String r3 = "FileUtil"
            if (r1 == 0) goto L7f
            boolean r1 = r9.isFile()
            if (r1 != 0) goto L13
            goto L7f
        L13:
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r1]
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
        L22:
            r9 = 0
            int r7 = r6.read(r4, r9, r1)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L72
            r8 = -1
            if (r7 == r8) goto L2e
            r5.update(r4, r9, r7)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L72
            goto L22
        L2e:
            r6.close()     // Catch: java.io.IOException -> L32
            goto L36
        L32:
            r1 = move-exception
            com.vivo.ic.VLog.e(r3, r0, r1)
        L36:
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r1 = r5.digest()
            r2 = 1
            r0.<init>(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 16
            java.lang.String r0 = r0.toString(r2)
            r1.<init>(r0)
        L4b:
            int r0 = r1.length()
            r2 = 32
            if (r0 >= r2) goto L59
            r0 = 48
            r1.insert(r9, r0)
            goto L4b
        L59:
            java.lang.String r9 = r1.toString()
            return r9
        L5e:
            r9 = move-exception
            goto L64
        L60:
            r9 = move-exception
            goto L74
        L62:
            r9 = move-exception
            r6 = r2
        L64:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L72
            if (r6 == 0) goto L71
            r6.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r9 = move-exception
            com.vivo.ic.VLog.e(r3, r0, r9)
        L71:
            return r2
        L72:
            r9 = move-exception
            r2 = r6
        L74:
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.io.IOException -> L7a
            goto L7e
        L7a:
            r1 = move-exception
            com.vivo.ic.VLog.e(r3, r0, r1)
        L7e:
            throw r9
        L7f:
            java.lang.String r9 = "getFileMD5, file not exist, return"
            com.vivo.ic.VLog.w(r3, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.util.c.a(java.io.File):java.lang.String");
    }
}
