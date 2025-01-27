package com.bytedance.hume.readapk.a;

import java.io.DataInput;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f7439a = {108, 116, 108, 111, 118, 101, 122, 104};

    /* JADX WARN: Removed duplicated region for block: B:60:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x007e -> B:17:0x009c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r7) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68 java.io.IOException -> L6b java.io.FileNotFoundException -> L6e java.io.UnsupportedEncodingException -> L71
            java.lang.String r2 = "r"
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68 java.io.IOException -> L6b java.io.FileNotFoundException -> L6e java.io.UnsupportedEncodingException -> L71
            long r2 = r1.length()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            byte[] r7 = com.bytedance.hume.readapk.a.a.f7439a     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            int r4 = r7.length     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            int r7 = r7.length     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            long r5 = (long) r7     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            long r2 = r2 - r5
            r1.seek(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            r1.readFully(r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            boolean r7 = a(r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            java.lang.String r4 = ""
            if (r7 != 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r7 = move-exception
            r7.printStackTrace()
        L2a:
            return r4
        L2b:
            r5 = 2
            long r2 = r2 - r5
            r1.seek(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            short r7 = a(r1)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            if (r7 > 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r7 = move-exception
            r7.printStackTrace()
        L3f:
            return r4
        L40:
            long r4 = (long) r7
            long r2 = r2 - r4
            r1.seek(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            r1.readFully(r7)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            java.lang.String r3 = "UTF-8"
            r2.<init>(r7, r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e java.io.IOException -> L60 java.io.FileNotFoundException -> L62 java.io.UnsupportedEncodingException -> L64
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r7 = move-exception
            r7.printStackTrace()
        L59:
            r0 = r2
            goto L9c
        L5b:
            r7 = move-exception
            r0 = r1
            goto L9d
        L5e:
            r7 = move-exception
            goto L74
        L60:
            r7 = move-exception
            goto L82
        L62:
            r7 = move-exception
            goto L8b
        L64:
            r7 = move-exception
            goto L94
        L66:
            r7 = move-exception
            goto L9d
        L68:
            r7 = move-exception
            r1 = r0
            goto L74
        L6b:
            r7 = move-exception
            r1 = r0
            goto L82
        L6e:
            r7 = move-exception
            r1 = r0
            goto L8b
        L71:
            r7 = move-exception
            r1 = r0
            goto L94
        L74:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L9c
        L7d:
            r7 = move-exception
            r7.printStackTrace()
            goto L9c
        L82:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L9c
        L8b:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L9c
        L94:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.io.IOException -> L7d
        L9c:
            return r0
        L9d:
            if (r0 == 0) goto La7
            r0.close()     // Catch: java.io.IOException -> La3
            goto La7
        La3:
            r0 = move-exception
            r0.printStackTrace()
        La7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.hume.readapk.a.a.a(java.io.File):java.lang.String");
    }

    private static short a(DataInput dataInput) {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != f7439a.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f7439a;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }
}
