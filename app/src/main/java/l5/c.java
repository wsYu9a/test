package l5;

import b5.u;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@a5.b(emulated = true)
@e
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public static final double f27895a = -2.147483648E9d;

    /* renamed from: b */
    public static final double f27896b = 2.147483647E9d;

    /* renamed from: c */
    public static final double f27897c = -9.223372036854776E18d;

    /* renamed from: d */
    public static final double f27898d = 9.223372036854776E18d;

    /* renamed from: f */
    @a5.d
    public static final int f27900f = 170;

    /* renamed from: e */
    public static final double f27899e = Math.log(2.0d);

    /* renamed from: g */
    @a5.d
    public static final double[] f27901g = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27902a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f27902a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27902a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27902a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27902a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27902a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27902a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27902a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27902a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @CanIgnoreReturnValue
    @a5.c
    public static double a(double d10) {
        u.d(d.d(d10));
        return d10;
    }

    public static double b(int i10) {
        g.e("n", i10);
        if (i10 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d10 = 1.0d;
        for (int i11 = (i10 & (-16)) + 1; i11 <= i10; i11++) {
            d10 *= i11;
        }
        return d10 * f27901g[i10 >> 4];
    }

    public static int c(double d10, double d11, double d12) {
        if (d(d10, d11, d12)) {
            return 0;
        }
        if (d10 < d11) {
            return -1;
        }
        if (d10 > d11) {
            return 1;
        }
        return Booleans.d(Double.isNaN(d10), Double.isNaN(d11));
    }

    public static boolean d(double d10, double d11, double d12) {
        g.d("tolerance", d12);
        return Math.copySign(d10 - d11, 1.0d) <= d12 || d10 == d11 || (Double.isNaN(d10) && Double.isNaN(d11));
    }

    @a5.c
    public static boolean e(double d10) {
        return d.d(d10) && (d10 == f27899e || 52 - Long.numberOfTrailingZeros(d.c(d10)) <= Math.getExponent(d10));
    }

    @a5.c
    public static boolean f(double d10) {
        if (d10 <= f27899e || !d.d(d10)) {
            return false;
        }
        long c10 = d.c(d10);
        return (c10 & (c10 - 1)) == 0;
    }

    public static double g(double d10) {
        return Math.log(d10) / f27899e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @a5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int h(double r6, java.math.RoundingMode r8) {
        /*
            r0 = 0
            r2 = 0
            r3 = 1
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L10
            boolean r0 = l5.d.d(r6)
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r1 = "x must be positive and finite"
            b5.u.e(r0, r1)
            int r0 = java.lang.Math.getExponent(r6)
            boolean r1 = l5.d.e(r6)
            if (r1 != 0) goto L2b
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r6 = r6 * r0
            int r6 = h(r6, r8)
            int r6 = r6 + (-52)
            return r6
        L2b:
            int[] r1 = l5.c.a.f27902a
            int r8 = r8.ordinal()
            r8 = r1[r8]
            switch(r8) {
                case 1: goto L63;
                case 2: goto L6a;
                case 3: goto L5c;
                case 4: goto L54;
                case 5: goto L4a;
                case 6: goto L3c;
                case 7: goto L3c;
                case 8: goto L3c;
                default: goto L36;
            }
        L36:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L3c:
            double r6 = l5.d.g(r6)
            double r6 = r6 * r6
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L6a
            r2 = 1
            goto L6a
        L4a:
            if (r0 < 0) goto L4d
            r2 = 1
        L4d:
            boolean r6 = f(r6)
        L51:
            r6 = r6 ^ r3
            r2 = r2 & r6
            goto L6a
        L54:
            if (r0 >= 0) goto L57
            r2 = 1
        L57:
            boolean r6 = f(r6)
            goto L51
        L5c:
            boolean r6 = f(r6)
            r2 = r6 ^ 1
            goto L6a
        L63:
            boolean r6 = f(r6)
            l5.g.k(r6)
        L6a:
            if (r2 == 0) goto L6e
            int r0 = r0 + 1
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.c.h(double, java.math.RoundingMode):int");
    }

    @a5.c
    @Deprecated
    public static double i(Iterable<? extends Number> iterable) {
        return j(iterable.iterator());
    }

    @a5.c
    @Deprecated
    public static double j(Iterator<? extends Number> it) {
        u.e(it.hasNext(), "Cannot take mean of 0 values");
        double a10 = a(it.next().doubleValue());
        long j10 = 1;
        while (it.hasNext()) {
            j10++;
            a10 += (a(it.next().doubleValue()) - a10) / j10;
        }
        return a10;
    }

    @a5.c
    @Deprecated
    public static double k(double... dArr) {
        u.e(dArr.length > 0, "Cannot take mean of 0 values");
        double a10 = a(dArr[0]);
        long j10 = 1;
        for (int i10 = 1; i10 < dArr.length; i10++) {
            a(dArr[i10]);
            j10++;
            a10 += (dArr[i10] - a10) / j10;
        }
        return a10;
    }

    @Deprecated
    public static double l(int... iArr) {
        u.e(iArr.length > 0, "Cannot take mean of 0 values");
        long j10 = 0;
        for (int i10 : iArr) {
            j10 += i10;
        }
        return j10 / iArr.length;
    }

    @Deprecated
    public static double m(long... jArr) {
        u.e(jArr.length > 0, "Cannot take mean of 0 values");
        double d10 = jArr[0];
        long j10 = 1;
        for (int i10 = 1; i10 < jArr.length; i10++) {
            j10++;
            d10 += (jArr[i10] - d10) / j10;
        }
        return d10;
    }

    @a5.c
    public static double n(double d10, RoundingMode roundingMode) {
        if (!d.d(d10)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f27902a[roundingMode.ordinal()]) {
            case 1:
                g.k(e(d10));
                return d10;
            case 2:
                return (d10 >= f27899e || e(d10)) ? d10 : ((long) d10) - 1;
            case 3:
                return (d10 <= f27899e || e(d10)) ? d10 : ((long) d10) + 1;
            case 4:
                return d10;
            case 5:
                if (e(d10)) {
                    return d10;
                }
                return ((long) d10) + (d10 > f27899e ? 1 : -1);
            case 6:
                return Math.rint(d10);
            case 7:
                double rint = Math.rint(d10);
                return Math.abs(d10 - rint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : rint;
            case 8:
                double rint2 = Math.rint(d10);
                return Math.abs(d10 - rint2) == 0.5d ? d10 : rint2;
            default:
                throw new AssertionError();
        }
    }

    @a5.c
    public static BigInteger o(double d10, RoundingMode roundingMode) {
        double n10 = n(d10, roundingMode);
        if ((n10 < 9.223372036854776E18d) && ((-9.223372036854776E18d) - n10 < 1.0d)) {
            return BigInteger.valueOf((long) n10);
        }
        BigInteger shiftLeft = BigInteger.valueOf(d.c(n10)).shiftLeft(Math.getExponent(n10) - 52);
        return n10 < f27899e ? shiftLeft.negate() : shiftLeft;
    }

    @a5.c
    public static int p(double d10, RoundingMode roundingMode) {
        double n10 = n(d10, roundingMode);
        g.a((n10 > -2.147483649E9d) & (n10 < 2.147483648E9d), d10, roundingMode);
        return (int) n10;
    }

    @a5.c
    public static long q(double d10, RoundingMode roundingMode) {
        double n10 = n(d10, roundingMode);
        g.a(((-9.223372036854776E18d) - n10 < 1.0d) & (n10 < 9.223372036854776E18d), d10, roundingMode);
        return (long) n10;
    }
}
