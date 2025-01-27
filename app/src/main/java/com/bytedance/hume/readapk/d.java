package com.bytedance.hume.readapk;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {
    private d() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r1 == null) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.Integer, java.nio.ByteBuffer> a(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28
            com.bytedance.hume.readapk.c r2 = com.bytedance.hume.readapk.a.c(r3)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.util.Map r0 = com.bytedance.hume.readapk.a.a(r2)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            if (r3 == 0) goto L1f
            r3.close()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
        L1f:
            r1.close()     // Catch: java.lang.Throwable -> L46
            goto L46
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r0
            goto L2d
        L28:
            r3 = r0
            goto L3c
        L2a:
            r2 = move-exception
            r3 = r0
            r1 = r3
        L2d:
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L46
            goto L34
        L33:
        L34:
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
        L39:
            throw r2     // Catch: java.lang.Throwable -> L46
        L3a:
            r3 = r0
            r1 = r3
        L3c:
            if (r3 == 0) goto L43
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L46
            goto L43
        L42:
        L43:
            if (r1 == 0) goto L46
            goto L1f
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.hume.readapk.d.a(java.io.File):java.util.Map");
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String[] a(File file, int[] iArr) {
        byte[][] b2 = b(file, iArr);
        if (b2 == null) {
            return null;
        }
        String[] strArr = new String[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            try {
                if (b2[i2] != null) {
                    strArr[i2] = new String(b2[i2], "UTF-8");
                } else {
                    strArr[i2] = "";
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return strArr;
    }

    public static byte[][] b(File file, int[] iArr) {
        Map<Integer, ByteBuffer> a2 = a(file);
        if (a2 == null || iArr.length <= 0) {
            return null;
        }
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            ByteBuffer byteBuffer = a2.get(Integer.valueOf(iArr[i2]));
            if (byteBuffer != null) {
                bArr[i2] = a(byteBuffer);
            }
        }
        return bArr;
    }
}
