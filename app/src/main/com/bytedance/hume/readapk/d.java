package com.bytedance.hume.readapk;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d {
    private d() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r1 == null) goto L136;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.Integer, java.nio.ByteBuffer> a(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L31
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L31
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2a
            com.bytedance.hume.readapk.c r2 = com.bytedance.hume.readapk.a.c(r3)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            java.util.Map r0 = com.bytedance.hume.readapk.a.a(r2)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            if (r3 == 0) goto L1f
            r3.close()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L4c
        L1f:
            r1.close()     // Catch: java.lang.Throwable -> L4c
            goto L4c
        L23:
            r2 = move-exception
            goto L35
        L25:
            goto L42
        L27:
            r2 = move-exception
            r3 = r0
            goto L35
        L2a:
            r3 = r0
            goto L42
        L2d:
            r2 = move-exception
            r3 = r0
            r1 = r3
            goto L35
        L31:
            r3 = r0
            r1 = r3
            goto L42
        L35:
            if (r3 == 0) goto L3c
            r3.close()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4c
            goto L3c
        L3b:
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L4c
        L41:
            throw r2     // Catch: java.lang.Throwable -> L4c
        L42:
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.io.IOException -> L48 java.lang.Throwable -> L4c
            goto L49
        L48:
        L49:
            if (r1 == 0) goto L4c
            goto L1f
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.hume.readapk.d.a(java.io.File):java.util.Map");
    }

    public static byte[][] b(File file, int[] iArr) {
        Map<Integer, ByteBuffer> a10 = a(file);
        if (a10 == null || iArr.length <= 0) {
            return null;
        }
        byte[][] bArr = new byte[iArr.length][];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            ByteBuffer byteBuffer = a10.get(Integer.valueOf(iArr[i10]));
            if (byteBuffer != null) {
                bArr[i10] = a(byteBuffer);
            }
        }
        return bArr;
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String[] a(File file, int[] iArr) {
        byte[][] b10 = b(file, iArr);
        if (b10 == null) {
            return null;
        }
        String[] strArr = new String[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            try {
                byte[] bArr = b10[i10];
                if (bArr != null) {
                    strArr[i10] = new String(bArr, "UTF-8");
                } else {
                    strArr[i10] = "";
                }
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        return strArr;
    }
}
