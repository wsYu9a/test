package com.google.common.primitives;

import a5.b;
import b5.u;
import java.util.Arrays;
import java.util.Comparator;

@b
@n5.b
/* loaded from: classes2.dex */
public final class SignedBytes {

    /* renamed from: a */
    public static final byte f10194a = 64;

    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int b10 = SignedBytes.b(bArr[i10], bArr2[i10]);
                if (b10 != 0) {
                    return b10;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j10) {
        byte b10 = (byte) j10;
        u.p(((long) b10) == j10, "Out of range: %s", j10);
        return b10;
    }

    public static int b(byte b10, byte b11) {
        return b10 - b11;
    }

    public static String c(String str, byte... bArr) {
        u.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 5);
        sb2.append((int) bArr[0]);
        for (int i10 = 1; i10 < bArr.length; i10++) {
            sb2.append(str);
            sb2.append((int) bArr[i10]);
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> d() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte e(byte... bArr) {
        u.d(bArr.length > 0);
        byte b10 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            byte b11 = bArr[i10];
            if (b11 > b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static byte f(byte... bArr) {
        u.d(bArr.length > 0);
        byte b10 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            byte b11 = bArr[i10];
            if (b11 < b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static byte g(long j10) {
        if (j10 > 127) {
            return Byte.MAX_VALUE;
        }
        if (j10 < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) j10;
    }

    public static void h(byte[] bArr) {
        u.E(bArr);
        i(bArr, 0, bArr.length);
    }

    public static void i(byte[] bArr, int i10, int i11) {
        u.E(bArr);
        u.f0(i10, i11, bArr.length);
        Arrays.sort(bArr, i10, i11);
        Bytes.n(bArr, i10, i11);
    }
}
