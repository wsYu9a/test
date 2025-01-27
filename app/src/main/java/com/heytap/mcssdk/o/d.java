package com.heytap.mcssdk.o;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final int f8935a = 1024;

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063 A[Catch: IOException -> 0x006a, TryCatch #0 {IOException -> 0x006a, blocks: (B:28:0x005e, B:30:0x0063, B:31:0x0066), top: B:27:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r6) {
        /*
            if (r6 == 0) goto L6f
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto L6f
        La:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r6 = r6.getBytes()
            r1.<init>(r6)
            r6 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L41
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L41
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L5d
        L22:
            int r3 = r1.read(r6)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L5d
            if (r3 <= 0) goto L30
            r4 = 0
            r2.write(r6, r4, r3)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L5d
            r2.flush()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L5d
            goto L22
        L30:
            r1.close()     // Catch: java.io.IOException -> L54
            r2.close()     // Catch: java.io.IOException -> L54
            r0.close()     // Catch: java.io.IOException -> L54
            goto L58
        L3a:
            r6 = move-exception
            goto L45
        L3c:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5e
        L41:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L45:
            com.heytap.mcssdk.o.e.c(r6)     // Catch: java.lang.Throwable -> L5d
            r1.close()     // Catch: java.io.IOException -> L54
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L54
        L50:
            r0.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r6 = move-exception
            r6.printStackTrace()
        L58:
            byte[] r6 = r0.toByteArray()
            return r6
        L5d:
            r6 = move-exception
        L5e:
            r1.close()     // Catch: java.io.IOException -> L6a
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L6a
        L66:
            r0.close()     // Catch: java.io.IOException -> L6a
            goto L6e
        L6a:
            r0 = move-exception
            r0.printStackTrace()
        L6e:
            throw r6
        L6f:
            java.lang.String r6 = ""
            byte[] r6 = r6.getBytes()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.mcssdk.o.d.a(java.lang.String):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(byte[] r6) {
        /*
            if (r6 == 0) goto L67
            int r0 = r6.length
            if (r0 != 0) goto L6
            goto L67
        L6:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L39
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L55
        L1a:
            int r3 = r2.read(r6)     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L55
            if (r3 <= 0) goto L28
            r4 = 0
            r0.write(r6, r4, r3)     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L55
            r0.flush()     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L55
            goto L1a
        L28:
            r2.close()     // Catch: java.io.IOException -> L4c
            r1.close()     // Catch: java.io.IOException -> L4c
            r0.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L32:
            r6 = move-exception
            goto L3d
        L34:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L56
        L39:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L3d:
            com.heytap.mcssdk.o.e.c(r6)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.io.IOException -> L4c
        L45:
            r1.close()     // Catch: java.io.IOException -> L4c
            r0.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r6 = move-exception
            r6.printStackTrace()
        L50:
            java.lang.String r6 = r0.toString()
            return r6
        L55:
            r6 = move-exception
        L56:
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.io.IOException -> L62
        L5b:
            r1.close()     // Catch: java.io.IOException -> L62
            r0.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r0 = move-exception
            r0.printStackTrace()
        L66:
            throw r6
        L67:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.mcssdk.o.d.b(byte[]):java.lang.String");
    }
}
