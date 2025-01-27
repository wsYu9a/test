package l5;

import b5.u;
import com.google.common.math.LongMath;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@a5.b(emulated = true)
@e
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    @a5.d
    public static final int f27889a = 256;

    /* renamed from: b */
    @a5.d
    public static final BigInteger f27890b = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: c */
    public static final double f27891c = Math.log(10.0d);

    /* renamed from: d */
    public static final double f27892d = Math.log(2.0d);

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27893a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f27893a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27893a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27893a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27893a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27893a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27893a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27893a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27893a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @a5.c
    /* renamed from: l5.b$b */
    public static class C0731b extends k<BigInteger> {

        /* renamed from: a */
        public static final C0731b f27894a = new C0731b();

        @Override // l5.k
        /* renamed from: f */
        public BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger.subtract(bigInteger2);
        }

        @Override // l5.k
        /* renamed from: g */
        public double c(BigInteger bigInteger) {
            return d.a(bigInteger);
        }

        @Override // l5.k
        /* renamed from: h */
        public int d(BigInteger bigInteger) {
            return bigInteger.signum();
        }

        @Override // l5.k
        /* renamed from: i */
        public BigInteger e(double d10, RoundingMode roundingMode) {
            return c.o(d10, roundingMode);
        }
    }

    public static BigInteger a(int i10, int i11) {
        int i12;
        g.e("n", i10);
        g.e("k", i11);
        int i13 = 1;
        u.m(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        int[] iArr = LongMath.f10161h;
        if (i11 < iArr.length && i10 <= iArr[i11]) {
            return BigInteger.valueOf(LongMath.a(i10, i11));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j10 = i10;
        int q10 = LongMath.q(j10, RoundingMode.CEILING);
        long j11 = 1;
        while (true) {
            int i14 = q10;
            while (i13 < i11) {
                i12 = i10 - i13;
                i13++;
                i14 += q10;
                if (i14 >= 63) {
                    break;
                }
                j10 *= i12;
                j11 *= i13;
            }
            return bigInteger.multiply(BigInteger.valueOf(j10)).divide(BigInteger.valueOf(j11));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j10)).divide(BigInteger.valueOf(j11));
            j10 = i12;
            j11 = i13;
        }
    }

    @a5.a
    public static BigInteger b(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.CEILING));
    }

    @a5.c
    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger d(int i10) {
        g.e("n", i10);
        long[] jArr = LongMath.f10160g;
        if (i10 < jArr.length) {
            return BigInteger.valueOf(jArr[i10]);
        }
        RoundingMode roundingMode = RoundingMode.CEILING;
        ArrayList arrayList = new ArrayList(f.g(f.p(i10, roundingMode) * i10, 64, roundingMode));
        int length = jArr.length;
        long j10 = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j11 = j10 >> numberOfTrailingZeros;
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        int q10 = LongMath.q(j11, roundingMode2) + 1;
        long j12 = length;
        int q11 = LongMath.q(j12, roundingMode2);
        int i11 = q11 + 1;
        int i12 = 1 << q11;
        while (j12 <= i10) {
            if ((i12 & j12) != 0) {
                i12 <<= 1;
                i11++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j12);
            long j13 = j12 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((i11 - numberOfTrailingZeros2) + q10 >= 64) {
                arrayList.add(BigInteger.valueOf(j11));
                j11 = 1;
            }
            j11 *= j13;
            q10 = LongMath.q(j11, RoundingMode.FLOOR) + 1;
            j12++;
        }
        if (j11 > 1) {
            arrayList.add(BigInteger.valueOf(j11));
        }
        return h(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    @a5.c
    public static boolean e(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    @a5.a
    public static BigInteger f(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean g(BigInteger bigInteger) {
        u.E(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    public static BigInteger h(List<BigInteger> list) {
        return i(list, 0, list.size());
    }

    public static BigInteger i(List<BigInteger> list, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return BigInteger.ONE;
        }
        if (i12 == 1) {
            return list.get(i10);
        }
        if (i12 == 2) {
            return list.get(i10).multiply(list.get(i10 + 1));
        }
        if (i12 == 3) {
            return list.get(i10).multiply(list.get(i10 + 1)).multiply(list.get(i10 + 2));
        }
        int i13 = (i11 + i10) >>> 1;
        return i(list, i10, i13).multiply(i(list, i13, i11));
    }

    @a5.c
    public static int j(BigInteger bigInteger, RoundingMode roundingMode) {
        int i10;
        g.j("x", bigInteger);
        if (e(bigInteger)) {
            return LongMath.o(bigInteger.longValue(), roundingMode);
        }
        int k10 = (int) ((k(bigInteger, RoundingMode.FLOOR) * f27892d) / f27891c);
        BigInteger bigInteger2 = BigInteger.TEN;
        BigInteger pow = bigInteger2.pow(k10);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                k10--;
                pow = pow.divide(BigInteger.TEN);
                i10 = pow.compareTo(bigInteger);
            } while (i10 > 0);
        } else {
            BigInteger multiply = bigInteger2.multiply(pow);
            int i11 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                k10++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                pow = multiply;
                multiply = multiply2;
                i11 = compareTo2;
                compareTo2 = compareTo3;
            }
            i10 = i11;
        }
        switch (a.f27893a[roundingMode.ordinal()]) {
            case 1:
                g.k(i10 == 0);
            case 2:
            case 3:
                return k10;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? k10 : k10 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) <= 0 ? k10 : k10 + 1;
            default:
                throw new AssertionError();
        }
    }

    public static int k(BigInteger bigInteger, RoundingMode roundingMode) {
        g.j("x", (BigInteger) u.E(bigInteger));
        int bitLength = bigInteger.bitLength();
        int i10 = bitLength - 1;
        switch (a.f27893a[roundingMode.ordinal()]) {
            case 1:
                g.k(g(bigInteger));
            case 2:
            case 3:
                return i10;
            case 4:
            case 5:
                return g(bigInteger) ? i10 : bitLength;
            case 6:
            case 7:
            case 8:
                return i10 < 256 ? bigInteger.compareTo(f27890b.shiftRight(256 - i10)) <= 0 ? i10 : bitLength : bigInteger.pow(2).bitLength() + (-1) < (i10 * 2) + 1 ? i10 : bitLength;
            default:
                throw new AssertionError();
        }
    }

    @a5.c
    public static double l(BigInteger bigInteger, RoundingMode roundingMode) {
        return C0731b.f27894a.b(bigInteger, roundingMode);
    }

    @a5.c
    public static BigInteger m(BigInteger bigInteger, RoundingMode roundingMode) {
        g.g("x", bigInteger);
        if (e(bigInteger)) {
            return BigInteger.valueOf(LongMath.B(bigInteger.longValue(), roundingMode));
        }
        BigInteger o10 = o(bigInteger);
        switch (a.f27893a[roundingMode.ordinal()]) {
            case 1:
                g.k(o10.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return o10;
            case 4:
            case 5:
                int intValue = o10.intValue();
                return (intValue * intValue == bigInteger.intValue() && o10.pow(2).equals(bigInteger)) ? o10 : o10.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return o10.pow(2).add(o10).compareTo(bigInteger) >= 0 ? o10 : o10.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @a5.c
    public static BigInteger n(BigInteger bigInteger) {
        return c.o(Math.sqrt(d.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @a5.c
    public static BigInteger o(BigInteger bigInteger) {
        BigInteger shiftLeft;
        int k10 = k(bigInteger, RoundingMode.FLOOR);
        if (k10 < 1023) {
            shiftLeft = n(bigInteger);
        } else {
            int i10 = (k10 - 52) & (-2);
            shiftLeft = n(bigInteger.shiftRight(i10)).shiftLeft(i10 >> 1);
        }
        BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }
}
