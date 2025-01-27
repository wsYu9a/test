package com.google.common.primitives;

import a5.b;
import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import n5.f;

@b
@a5.a
@n5.b
/* loaded from: classes2.dex */
public final class UnsignedLongs {

    /* renamed from: a */
    public static final long f10201a = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                long j10 = jArr[i10];
                long j11 = jArr2[i10];
                if (j10 != j11) {
                    return UnsignedLongs.a(j10, j11);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class a {

        /* renamed from: a */
        public static final long[] f10202a = new long[37];

        /* renamed from: b */
        public static final int[] f10203b = new int[37];

        /* renamed from: c */
        public static final int[] f10204c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = i10;
                f10202a[i10] = UnsignedLongs.c(-1L, j10);
                f10203b[i10] = (int) UnsignedLongs.k(-1L, j10);
                f10204c[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        public static boolean a(long j10, int i10, int i11) {
            if (j10 < 0) {
                return true;
            }
            long j11 = f10202a[i11];
            if (j10 < j11) {
                return false;
            }
            return j10 > j11 || i10 > f10203b[i11];
        }
    }

    public static int a(long j10, long j11) {
        return Longs.d(d(j10), d(j11));
    }

    @CanIgnoreReturnValue
    public static long b(String str) {
        f a10 = f.a(str);
        try {
            return j(a10.f28778a, a10.f28779b);
        } catch (NumberFormatException e10) {
            String valueOf = String.valueOf(str);
            NumberFormatException numberFormatException = new NumberFormatException(valueOf.length() != 0 ? "Error parsing value: ".concat(valueOf) : new String("Error parsing value: "));
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static long c(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? 0L : 1L;
        }
        if (j10 >= 0) {
            return j10 / j11;
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        return j12 + (a(j10 - (j12 * j11), j11) < 0 ? 0 : 1);
    }

    public static long d(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }

    public static String e(String str, long... jArr) {
        u.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(jArr.length * 5);
        sb2.append(p(jArr[0]));
        for (int i10 = 1; i10 < jArr.length; i10++) {
            sb2.append(str);
            sb2.append(p(jArr[i10]));
        }
        return sb2.toString();
    }

    public static Comparator<long[]> f() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long g(long... jArr) {
        u.d(jArr.length > 0);
        long d10 = d(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long d11 = d(jArr[i10]);
            if (d11 > d10) {
                d10 = d11;
            }
        }
        return d(d10);
    }

    public static long h(long... jArr) {
        u.d(jArr.length > 0);
        long d10 = d(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long d11 = d(jArr[i10]);
            if (d11 < d10) {
                d10 = d11;
            }
        }
        return d(d10);
    }

    @CanIgnoreReturnValue
    public static long i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    public static long j(String str, int i10) {
        u.E(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i10 < 2 || i10 > 36) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("illegal radix: ");
            sb2.append(i10);
            throw new NumberFormatException(sb2.toString());
        }
        int i11 = a.f10204c[i10] - 1;
        long j10 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            int digit = Character.digit(str.charAt(i12), i10);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i12 > i11 && a.a(j10, digit, i10)) {
                throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
            }
            j10 = (j10 * i10) + digit;
        }
        return j10;
    }

    public static long k(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? j10 : j10 - j11;
        }
        if (j10 >= 0) {
            return j10 % j11;
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (a(j12, j11) < 0) {
            j11 = 0;
        }
        return j12 - j11;
    }

    public static void l(long[] jArr) {
        u.E(jArr);
        m(jArr, 0, jArr.length);
    }

    public static void m(long[] jArr, int i10, int i11) {
        u.E(jArr);
        u.f0(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = d(jArr[i12]);
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = d(jArr[i10]);
            i10++;
        }
    }

    public static void n(long[] jArr) {
        u.E(jArr);
        o(jArr, 0, jArr.length);
    }

    public static void o(long[] jArr, int i10, int i11) {
        u.E(jArr);
        u.f0(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = Long.MAX_VALUE ^ jArr[i12];
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = jArr[i10] ^ Long.MAX_VALUE;
            i10++;
        }
    }

    public static String p(long j10) {
        return q(j10, 10);
    }

    public static String q(long j10, int i10) {
        u.k(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        if (j10 == 0) {
            return "0";
        }
        if (j10 > 0) {
            return Long.toString(j10, i10);
        }
        int i11 = 64;
        char[] cArr = new char[64];
        int i12 = i10 - 1;
        if ((i10 & i12) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
            do {
                i11--;
                cArr[i11] = Character.forDigit(((int) j10) & i12, i10);
                j10 >>>= numberOfTrailingZeros;
            } while (j10 != 0);
        } else {
            long c10 = (i10 & 1) == 0 ? (j10 >>> 1) / (i10 >>> 1) : c(j10, i10);
            long j11 = i10;
            int i13 = 63;
            cArr[63] = Character.forDigit((int) (j10 - (c10 * j11)), i10);
            while (c10 > 0) {
                i13--;
                cArr[i13] = Character.forDigit((int) (c10 % j11), i10);
                c10 /= j11;
            }
            i11 = i13;
        }
        return new String(cArr, i11, 64 - i11);
    }
}
