package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.f */
/* loaded from: classes4.dex */
public class C0902f {

    /* renamed from: a */
    private static final char[] f25065a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    public static final byte[] f25066b = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f25065a;
            cArr[i3 + 1] = cArr2[b2 & 15];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
