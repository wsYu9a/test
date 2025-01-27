package l5;

import b5.u;
import java.math.BigInteger;

@a5.c
@e
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    public static final long f27903a = 4503599627370495L;

    /* renamed from: b */
    public static final long f27904b = 9218868437227405312L;

    /* renamed from: c */
    public static final long f27905c = Long.MIN_VALUE;

    /* renamed from: d */
    public static final int f27906d = 52;

    /* renamed from: e */
    public static final int f27907e = 1023;

    /* renamed from: f */
    public static final long f27908f = 4503599627370496L;

    /* renamed from: g */
    @a5.d
    public static final long f27909g = 4607182418800017408L;

    public static double a(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        int bitLength = abs.bitLength();
        int i10 = bitLength - 1;
        if (i10 < 63) {
            return bigInteger.longValue();
        }
        if (i10 > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i11 = bitLength - 54;
        long longValue = abs.shiftRight(i11).longValue();
        long j10 = longValue >> 1;
        long j11 = f27903a & j10;
        if ((longValue & 1) != 0 && ((j10 & 1) != 0 || abs.getLowestSetBit() < i11)) {
            j11++;
        }
        return Double.longBitsToDouble((((bitLength + 1022) << 52) + j11) | (bigInteger.signum() & Long.MIN_VALUE));
    }

    public static double b(double d10) {
        u.d(!Double.isNaN(d10));
        return Math.max(d10, c.f27899e);
    }

    public static long c(double d10) {
        u.e(d(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10) & f27903a;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | f27908f;
    }

    public static boolean d(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static boolean e(double d10) {
        return Math.getExponent(d10) >= -1022;
    }

    public static double f(double d10) {
        return -Math.nextUp(-d10);
    }

    public static double g(double d10) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d10) & f27903a) | f27909g);
    }
}
