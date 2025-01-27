package com.wbl.ad.yzz.sensor.r;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public static char[] f33834a = new char[64];

    /* renamed from: b */
    public static byte[] f33835b;

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f33834a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f33834a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f33834a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f33834a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        f33835b = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f33835b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f33835b[f33834a[i4]] = (byte) i4;
        }
    }

    public static char[] a(byte[] bArr) {
        return (char[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9781, null, bArr);
    }

    public static char[] a(byte[] bArr, int i2) {
        return (char[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9784, null, bArr, Integer.valueOf(i2));
    }
}
