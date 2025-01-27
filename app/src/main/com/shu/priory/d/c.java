package com.shu.priory.d;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class c {
    private static byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[] r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.write(r3)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            r2.finish()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            r2.close()     // Catch: java.io.IOException -> L1f
            r1.close()     // Catch: java.io.IOException -> L1f
            goto L38
        L1f:
            r3 = move-exception
            r3.printStackTrace()
            goto L38
        L24:
            r3 = move-exception
            r0 = r2
            goto L39
        L27:
            r3 = move-exception
            goto L2d
        L29:
            r3 = move-exception
            goto L39
        L2b:
            r3 = move-exception
            r2 = r0
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.io.IOException -> L1f
        L35:
            r1.close()     // Catch: java.io.IOException -> L1f
        L38:
            return r0
        L39:
            if (r0 == 0) goto L41
            r0.close()     // Catch: java.io.IOException -> L3f
            goto L41
        L3f:
            r0 = move-exception
            goto L45
        L41:
            r1.close()     // Catch: java.io.IOException -> L3f
            goto L48
        L45:
            r0.printStackTrace()
        L48:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.d.c.a(byte[]):byte[]");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i10) {
        byte b10;
        String str;
        byte[] a10;
        if (bArr2 == null) {
            return null;
        }
        try {
            byte[] a11 = a.a(a(bArr2), bArr);
            if (i10 == 1) {
                str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt8H0BF3SquJmk6xIo2bTldgvtazLIeSbR4cle\np7zeUAtI/mC7UgFl8xXFCTemVambyQFnM5GsZOI1BpAMJO7N/YHRX7hvCZG6D0rEXQEdKXhKFIBQ\nmOYRYZP042vWRcKZ6iQLdLYmyg6tIzjYVfH0f6YX8OLIU7fy0TA/c88rzwIDAQAB";
                b10 = 3;
            } else {
                b10 = 2;
                if (i10 == 2) {
                    str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv2WHuBUFQep01EvclA9XzXuR9\np48QRafJ6PBKKEJqDTKIyCqSiu4BRbuiriN6U6jMZ+3hIuayj3GdX5EPETVOGrUe\ng68xjwl2kQ+71rZ/NrTkpbi3AWP39ba8ytvAXpZmOYCepmjhpdLtBBpO51cLY1ZK\nQAzR5DofY5y91rOecQIDAQAB";
                } else {
                    str = null;
                    b10 = 0;
                }
            }
            if (!TextUtils.isEmpty(str) && (a10 = g.a(bArr, g.a(str))) != null && a11 != null) {
                int length = a10.length;
                int length2 = a11.length;
                byte[] bArr3 = new byte[length + length2 + 10];
                bArr3[0] = 1;
                System.arraycopy(a(length), 0, bArr3, 1, 4);
                System.arraycopy(a10, 0, bArr3, 5, length);
                bArr3[5 + length] = b10;
                System.arraycopy(a(length2), 0, bArr3, length + 6, 4);
                System.arraycopy(a11, 0, bArr3, length + 10, length2);
                return bArr3;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
