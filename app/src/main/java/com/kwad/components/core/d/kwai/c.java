package com.kwad.components.core.d.kwai;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class c {
    private final int[] Iu;

    private c(int[] iArr) {
        this.Iu = iArr;
    }

    private static long a(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 32) & 65535;
        return (e(i2, iArr, j3) << 32) | ((((j2 & 65535) ^ e(i2, iArr, j3)) ^ (i2 + 1)) << 48) | (j4 << 16) | ((j2 >> 16) & 65535);
    }

    private static long a(long j2, int[] iArr) {
        int i2 = 0;
        while (i2 < 8) {
            j2 = a(i2, iArr, j2);
            i2++;
        }
        while (i2 < 16) {
            j2 = b(i2, iArr, j2);
            i2++;
        }
        while (i2 < 24) {
            j2 = a(i2, iArr, j2);
            i2++;
        }
        while (i2 < 32) {
            j2 = b(i2, iArr, j2);
            i2++;
        }
        return j2;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 16) & 65535;
        long e2 = e(i2, iArr, j3);
        return (((i2 + 1) ^ (j3 ^ ((j2 >> 32) & 65535))) << 16) | ((j2 & 65535) << 48) | (e2 << 32) | j4;
    }

    private static long b(long j2, int[] iArr) {
        int i2 = 31;
        while (i2 > 23) {
            j2 = d(i2, iArr, j2);
            i2--;
        }
        while (i2 > 15) {
            j2 = c(i2, iArr, j2);
            i2--;
        }
        while (i2 > 7) {
            j2 = d(i2, iArr, j2);
            i2--;
        }
        while (i2 >= 0) {
            j2 = c(i2, iArr, j2);
            i2--;
        }
        return j2;
    }

    private static long c(int i2, int[] iArr, long j2) {
        long j3 = (j2 >> 32) & 65535;
        long j4 = (j2 >> 16) & 65535;
        return ((i2 + 1) ^ ((j2 >>> 48) ^ j3)) | ((j2 & 65535) << 16) | (f(i2, iArr, j3) << 48) | (j4 << 32);
    }

    private static long d(int i2, int[] iArr, long j2) {
        long j3 = (j2 >> 32) & 65535;
        return (((i2 + 1) ^ (f(i2, iArr, j3) ^ ((j2 >> 16) & 65535))) << 32) | (f(i2, iArr, j3) << 48) | ((j2 & 65535) << 16) | (j2 >>> 48);
    }

    private static long e(int i2, int[] iArr, long j2) {
        int i3 = (int) (j2 >>> 8);
        int i4 = (int) (j2 & 255);
        int i5 = i2 * 4;
        int i6 = iArr[i5 % 10];
        int i7 = iArr[(i5 + 1) % 10];
        int i8 = iArr[(i5 + 2) % 10];
        int i9 = iArr[(i5 + 3) % 10];
        int[] iArr2 = b.It;
        int i10 = iArr2[i6 ^ i4] ^ i3;
        return ((i10 ^ iArr2[(i4 ^ iArr2[i7 ^ i10]) ^ i8]) << 8) | (iArr2[i9 ^ r7] ^ r8);
    }

    private static long f(int i2, int[] iArr, long j2) {
        int i3 = (int) (255 & j2);
        int i4 = (int) (j2 >>> 8);
        int i5 = i2 * 4;
        int i6 = iArr[(i5 + 3) % 10];
        int i7 = iArr[(i5 + 2) % 10];
        int i8 = iArr[(i5 + 1) % 10];
        int i9 = iArr[i5 % 10];
        int[] iArr2 = b.It;
        int i10 = iArr2[i6 ^ i4] ^ i3;
        return ((iArr2[i9 ^ r6] ^ r7) << 8) | (i10 ^ iArr2[(i4 ^ iArr2[i10 ^ i7]) ^ i8]);
    }

    public final long an(String str) {
        byte[] decode = com.kwad.sdk.core.kwai.c.vK().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.Iu);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    public final String p(long j2) {
        return com.kwad.sdk.core.kwai.c.vI().encodeToString(ByteBuffer.allocate(8).putLong(a(j2, this.Iu)).array());
    }
}
