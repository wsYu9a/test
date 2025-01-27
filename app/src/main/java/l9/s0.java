package l9;

/* loaded from: classes3.dex */
public class s0 {
    /* JADX WARN: Removed duplicated region for block: B:35:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(java.lang.String r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            r5.<init>()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.io.InputStream r1 = r1.openStream()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
        L13:
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r4 = -1
            if (r4 == r3) goto L24
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            goto L13
        L1f:
            r5 = move-exception
            r0 = r1
            goto L48
        L22:
            r5 = move-exception
            goto L3a
        L24:
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r2 = 1
            android.graphics.Bitmap r5 = l9.b.i(r5, r2)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r1.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r0 = move-exception
            r0.printStackTrace()
        L35:
            return r5
        L36:
            r5 = move-exception
            goto L48
        L38:
            r5 = move-exception
            r1 = r0
        L3a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r5 = move-exception
            r5.printStackTrace()
        L47:
            return r0
        L48:
            if (r0 == 0) goto L52
            r0.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r0 = move-exception
            r0.printStackTrace()
        L52:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.s0.a(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(java.lang.String r5, int r6, int r7) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            r5.<init>()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            java.io.InputStream r1 = r1.openStream()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
        L13:
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r4 = -1
            if (r4 == r3) goto L24
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            goto L13
        L1f:
            r5 = move-exception
            r0 = r1
            goto L47
        L22:
            r5 = move-exception
            goto L39
        L24:
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            android.graphics.Bitmap r5 = l9.b.j(r5, r6, r7)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r1.close()     // Catch: java.io.IOException -> L30
            goto L34
        L30:
            r6 = move-exception
            r6.printStackTrace()
        L34:
            return r5
        L35:
            r5 = move-exception
            goto L47
        L37:
            r5 = move-exception
            r1 = r0
        L39:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r5 = move-exception
            r5.printStackTrace()
        L46:
            return r0
        L47:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r6 = move-exception
            r6.printStackTrace()
        L51:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.s0.b(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] c(java.lang.String r5) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r5.<init>()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            java.io.InputStream r1 = r1.openStream()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
        L13:
            int r3 = r1.read(r2)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r4 = -1
            if (r4 == r3) goto L24
            r4 = 0
            r5.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            goto L13
        L1f:
            r5 = move-exception
            r0 = r1
            goto L43
        L22:
            r5 = move-exception
            goto L35
        L24:
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            r1.close()     // Catch: java.io.IOException -> L2c
            goto L30
        L2c:
            r0 = move-exception
            r0.printStackTrace()
        L30:
            return r5
        L31:
            r5 = move-exception
            goto L43
        L33:
            r5 = move-exception
            r1 = r0
        L35:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r5 = move-exception
            r5.printStackTrace()
        L42:
            return r0
        L43:
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.io.IOException -> L49
            goto L4d
        L49:
            r0 = move-exception
            r0.printStackTrace()
        L4d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.s0.c(java.lang.String):byte[]");
    }
}
