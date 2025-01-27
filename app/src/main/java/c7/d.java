package c7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a */
    public static final int f1709a = 1024;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0064 A[Catch: IOException -> 0x0068, TryCatch #1 {IOException -> 0x0068, blocks: (B:29:0x005f, B:31:0x0064, B:32:0x006a), top: B:28:0x005f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r6) {
        /*
            if (r6 == 0) goto L72
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto L72
        La:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r6 = r6.getBytes()
            r1.<init>(r6)
            r6 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L48
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
        L22:
            int r3 = r1.read(r6)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            if (r3 <= 0) goto L34
            r4 = 0
            r2.write(r6, r4, r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r2.flush()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            goto L22
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r6 = move-exception
            goto L4c
        L34:
            r1.close()     // Catch: java.io.IOException -> L3e
            r2.close()     // Catch: java.io.IOException -> L3e
            r0.close()     // Catch: java.io.IOException -> L3e
            goto L5a
        L3e:
            r6 = move-exception
            r6.printStackTrace()
            goto L5a
        L43:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5f
        L48:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L4c:
            c7.e.c(r6)     // Catch: java.lang.Throwable -> L30
            r1.close()     // Catch: java.io.IOException -> L3e
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L3e
        L57:
            r0.close()     // Catch: java.io.IOException -> L3e
        L5a:
            byte[] r6 = r0.toByteArray()
            return r6
        L5f:
            r1.close()     // Catch: java.io.IOException -> L68
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> L68
            goto L6a
        L68:
            r0 = move-exception
            goto L6e
        L6a:
            r0.close()     // Catch: java.io.IOException -> L68
            goto L71
        L6e:
            r0.printStackTrace()
        L71:
            throw r6
        L72:
            java.lang.String r6 = ""
            byte[] r6 = r6.getBytes()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c7.d.a(java.lang.String):byte[]");
    }

    public static String b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        IOException e10;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                } catch (IOException e11) {
                    gZIPInputStream = null;
                    e10 = e11;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            gZIPInputStream2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                        byteArrayOutputStream.flush();
                    }
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e13) {
                    e10 = e13;
                    e.c(e10);
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            return byteArrayOutputStream.toString();
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
