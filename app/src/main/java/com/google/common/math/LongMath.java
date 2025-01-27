package com.google.common.math;

import a5.c;
import a5.d;
import androidx.media3.common.C;
import b5.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import l5.e;
import l5.f;
import l5.g;
import okhttp3.internal.connection.RealConnection;

@a5.b(emulated = true)
@e
/* loaded from: classes2.dex */
public final class LongMath {

    /* renamed from: a */
    @d
    public static final long f10154a = 4611686018427387904L;

    /* renamed from: b */
    @d
    public static final long f10155b = -5402926248376769404L;

    /* renamed from: f */
    @d
    public static final long f10159f = 3037000499L;

    /* renamed from: j */
    public static final int f10163j = -545925251;

    /* renamed from: c */
    @d
    public static final byte[] f10156c = {19, b5.a.f1194u, b5.a.f1194u, b5.a.f1194u, b5.a.f1194u, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: d */
    @d
    @c
    public static final long[] f10157d = {1, 10, 100, 1000, 10000, 100000, C.MICROS_PER_SECOND, 10000000, 100000000, C.NANOS_PER_SECOND, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: e */
    @d
    @c
    public static final long[] f10158e = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: g */
    public static final long[] f10160g = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: h */
    public static final int[] f10161h = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: i */
    @d
    public static final int[] f10162i = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_SDK_MONITOR_SCENE, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: k */
    public static final long[][] f10164k = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                return (j10 * j11) % j12;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                return (j10 * j10) % j11;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j10, long j11, long j12) {
                long j13 = j10 + j11;
                return j10 >= j12 - j11 ? j13 - j12 : j13;
            }

            private long times2ToThe32Mod(long j10, long j11) {
                int i10 = 32;
                do {
                    int min = Math.min(i10, Long.numberOfLeadingZeros(j10));
                    j10 = UnsignedLongs.k(j10 << min, j11);
                    i10 -= min;
                } while (i10 > 0);
                return j10;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                long j13 = j10 >>> 32;
                long j14 = j11 >>> 32;
                long j15 = j10 & 4294967295L;
                long j16 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j14, j12) + (j13 * j16);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.k(times2ToThe32Mod, j12);
                }
                Long.signum(j15);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j14 * j15), j12), UnsignedLongs.k(j15 * j16, j12), j12);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                long j12 = j10 >>> 32;
                long j13 = j10 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j12 * j12, j11);
                long j14 = j12 * j13 * 2;
                if (j14 < 0) {
                    j14 = UnsignedLongs.k(j14, j11);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j14, j11), UnsignedLongs.k(j13 * j13, j11), j11);
            }
        };

        /* renamed from: com.google.common.math.LongMath$MillerRabinTester$1 */
        public enum AnonymousClass1 extends MillerRabinTester {
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                return (j10 * j11) % j12;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                return (j10 * j10) % j11;
            }
        }

        /* renamed from: com.google.common.math.LongMath$MillerRabinTester$2 */
        public enum AnonymousClass2 extends MillerRabinTester {
            private long plusMod(long j10, long j11, long j12) {
                long j13 = j10 + j11;
                return j10 >= j12 - j11 ? j13 - j12 : j13;
            }

            private long times2ToThe32Mod(long j10, long j11) {
                int i10 = 32;
                do {
                    int min = Math.min(i10, Long.numberOfLeadingZeros(j10));
                    j10 = UnsignedLongs.k(j10 << min, j11);
                    i10 -= min;
                } while (i10 > 0);
                return j10;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                long j13 = j10 >>> 32;
                long j14 = j11 >>> 32;
                long j15 = j10 & 4294967295L;
                long j16 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j14, j12) + (j13 * j16);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.k(times2ToThe32Mod, j12);
                }
                Long.signum(j15);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j14 * j15), j12), UnsignedLongs.k(j15 * j16, j12), j12);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                long j12 = j10 >>> 32;
                long j13 = j10 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j12 * j12, j11);
                long j14 = j12 * j13 * 2;
                if (j14 < 0) {
                    j14 = UnsignedLongs.k(j14, j11);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j14, j11), UnsignedLongs.k(j13 * j13, j11), j11);
            }
        }

        private long powMod(long j10, long j11, long j12) {
            long j13 = 1;
            while (j11 != 0) {
                if ((j11 & 1) != 0) {
                    j13 = mulMod(j13, j10, j12);
                }
                j10 = squareMod(j10, j12);
                j11 >>= 1;
            }
            return j13;
        }

        public static boolean test(long j10, long j11) {
            return (j11 <= LongMath.f10159f ? SMALL : LARGE).testWitness(j10, j11);
        }

        private boolean testWitness(long j10, long j11) {
            long j12 = j11 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j12);
            long j13 = j12 >> numberOfTrailingZeros;
            long j14 = j10 % j11;
            if (j14 == 0) {
                return true;
            }
            long powMod = powMod(j14, j13, j11);
            if (powMod == 1) {
                return true;
            }
            int i10 = 0;
            while (powMod != j12) {
                i10++;
                if (i10 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j11);
            }
            return true;
        }

        public abstract long mulMod(long j10, long j11, long j12);

        public abstract long squareMod(long j10, long j11);

        /* synthetic */ MillerRabinTester(a aVar) {
            this();
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10165a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f10165a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10165a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10165a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10165a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10165a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10165a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10165a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10165a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @a5.a
    public static long A(long j10, long j11) {
        long j12 = j10 - j11;
        return (((j11 ^ j10) > 0L ? 1 : ((j11 ^ j10) == 0L ? 0 : -1)) >= 0) | ((j10 ^ j12) >= 0) ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @c
    public static long B(long j10, RoundingMode roundingMode) {
        g.f("x", j10);
        if (i(j10)) {
            return f.x((int) j10, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j10);
        long j11 = sqrt * sqrt;
        switch (a.f10165a[roundingMode.ordinal()]) {
            case 1:
                g.k(j11 == j10);
                return sqrt;
            case 2:
            case 3:
                return j10 < j11 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j10 > j11 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                return (sqrt - (j10 < j11 ? 1 : 0)) + n((r0 * r0) + r0, j10);
            default:
                throw new AssertionError();
        }
    }

    public static long a(int i10, int i11) {
        g.e("n", i10);
        g.e("k", i11);
        u.m(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        long j10 = 1;
        if (i11 == 0) {
            return 1L;
        }
        if (i11 == 1) {
            return i10;
        }
        long[] jArr = f10160g;
        if (i10 < jArr.length) {
            return jArr[i10] / (jArr[i11] * jArr[i10 - i11]);
        }
        int[] iArr = f10161h;
        if (i11 >= iArr.length || i10 > iArr[i11]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f10162i;
        if (i11 < iArr2.length && i10 <= iArr2[i11]) {
            int i12 = i10 - 1;
            long j11 = i10;
            for (int i13 = 2; i13 <= i11; i13++) {
                j11 = (j11 * i12) / i13;
                i12--;
            }
            return j11;
        }
        long j12 = i10;
        int q10 = q(j12, RoundingMode.CEILING);
        int i14 = i10 - 1;
        int i15 = q10;
        long j13 = j12;
        int i16 = 2;
        long j14 = 1;
        while (i16 <= i11) {
            i15 += q10;
            if (i15 < 63) {
                j13 *= i14;
                j14 *= i16;
            } else {
                j10 = u(j10, j13, j14);
                j13 = i14;
                j14 = i16;
                i15 = q10;
            }
            i16++;
            i14--;
        }
        return u(j10, j13, j14);
    }

    @a5.a
    public static long b(long j10) {
        g.i("x", j10);
        if (j10 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j10 - 1));
        }
        StringBuilder sb2 = new StringBuilder(70);
        sb2.append("ceilingPowerOfTwo(");
        sb2.append(j10);
        sb2.append(") is not representable as a long");
        throw new ArithmeticException(sb2.toString());
    }

    @c
    public static long c(long j10, long j11) {
        long j12 = j10 + j11;
        g.c(((j10 ^ j11) < 0) | ((j10 ^ j12) >= 0), "checkedAdd", j10, j11);
        return j12;
    }

    public static long d(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        g.c(numberOfLeadingZeros >= 64, "checkedMultiply", j10, j11);
        g.c((j10 >= 0) | (j11 != Long.MIN_VALUE), "checkedMultiply", j10, j11);
        long j12 = j10 * j11;
        g.c(j10 == 0 || j12 / j10 == j11, "checkedMultiply", j10, j11);
        return j12;
    }

    @c
    public static long e(long j10, int i10) {
        g.e("exponent", i10);
        long j11 = 1;
        if (!(j10 >= -2) || !(j10 <= 2)) {
            long j12 = j10;
            int i11 = i10;
            while (i11 != 0) {
                if (i11 == 1) {
                    return d(j11, j12);
                }
                long d10 = (i11 & 1) != 0 ? d(j11, j12) : j11;
                int i12 = i11 >> 1;
                if (i12 > 0) {
                    g.c(-3037000499L <= j12 && j12 <= f10159f, "checkedPow", j12, i12);
                    j12 *= j12;
                }
                j11 = d10;
                i11 = i12;
            }
            return j11;
        }
        int i13 = (int) j10;
        if (i13 == -2) {
            g.c(i10 < 64, "checkedPow", j10, i10);
            return (i10 & 1) == 0 ? 1 << i10 : (-1) << i10;
        }
        if (i13 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i13 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i13 == 1) {
            return 1L;
        }
        if (i13 != 2) {
            throw new AssertionError();
        }
        g.c(i10 < 63, "checkedPow", j10, i10);
        return 1 << i10;
    }

    @c
    public static long f(long j10, long j11) {
        long j12 = j10 - j11;
        g.c(((j10 ^ j11) >= 0) | ((j10 ^ j12) >= 0), "checkedSubtract", j10, j11);
        return j12;
    }

    @c
    public static long g(long j10, long j11, RoundingMode roundingMode) {
        u.E(roundingMode);
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        if (j13 == 0) {
            return j12;
        }
        int i10 = ((int) ((j10 ^ j11) >> 63)) | 1;
        switch (a.f10165a[roundingMode.ordinal()]) {
            case 1:
                g.k(j13 == 0);
                return j12;
            case 2:
                return j12;
            case 3:
                if (i10 >= 0) {
                    return j12;
                }
                break;
            case 4:
                break;
            case 5:
                if (i10 <= 0) {
                    return j12;
                }
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j13);
                long abs2 = abs - (Math.abs(j11) - abs);
                if (abs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j12) == 0)) {
                        return j12;
                    }
                } else if (abs2 <= 0) {
                    return j12;
                }
                break;
            default:
                throw new AssertionError();
        }
        return j12 + i10;
    }

    @c
    public static long h(int i10) {
        g.e("n", i10);
        long[] jArr = f10160g;
        if (i10 < jArr.length) {
            return jArr[i10];
        }
        return Long.MAX_VALUE;
    }

    public static boolean i(long j10) {
        return ((long) ((int) j10)) == j10;
    }

    @a5.a
    public static long j(long j10) {
        g.i("x", j10);
        return 1 << (63 - Long.numberOfLeadingZeros(j10));
    }

    public static long k(long j10, long j11) {
        g.f("a", j10);
        g.f("b", j11);
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j12 = j10 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros2;
        while (j12 != j13) {
            long j14 = j12 - j13;
            long j15 = (j14 >> 63) & j14;
            long j16 = (j14 - j15) - j15;
            j13 += j15;
            j12 = j16 >> Long.numberOfTrailingZeros(j16);
        }
        return j12 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean l(long j10) {
        return (j10 > 0) & ((j10 & (j10 - 1)) == 0);
    }

    @a5.a
    @c
    public static boolean m(long j10) {
        if (j10 < 2) {
            g.f("n", j10);
            return false;
        }
        if (j10 < 66) {
            return ((722865708377213483 >> (((int) j10) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j10 % 30))) & f10163j) != 0 || j10 % 7 == 0 || j10 % 11 == 0 || j10 % 13 == 0) {
            return false;
        }
        if (j10 < 289) {
            return true;
        }
        for (long[] jArr : f10164k) {
            if (j10 <= jArr[0]) {
                for (int i10 = 1; i10 < jArr.length; i10++) {
                    if (!MillerRabinTester.test(jArr[i10], j10)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @d
    public static int n(long j10, long j11) {
        return (int) ((~(~(j10 - j11))) >>> 63);
    }

    @c
    public static int o(long j10, RoundingMode roundingMode) {
        int n10;
        g.i("x", j10);
        int p10 = p(j10);
        long j11 = f10157d[p10];
        switch (a.f10165a[roundingMode.ordinal()]) {
            case 1:
                g.k(j10 == j11);
            case 2:
            case 3:
                return p10;
            case 4:
            case 5:
                n10 = n(j11, j10);
                return p10 + n10;
            case 6:
            case 7:
            case 8:
                n10 = n(f10158e[p10], j10);
                return p10 + n10;
            default:
                throw new AssertionError();
        }
    }

    @c
    public static int p(long j10) {
        byte b10 = f10156c[Long.numberOfLeadingZeros(j10)];
        return b10 - n(j10, f10157d[b10]);
    }

    public static int q(long j10, RoundingMode roundingMode) {
        g.i("x", j10);
        switch (a.f10165a[roundingMode.ordinal()]) {
            case 1:
                g.k(l(j10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10);
                return (63 - numberOfLeadingZeros) + n(f10155b >>> numberOfLeadingZeros, j10);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j10);
    }

    public static long r(long j10, long j11) {
        return (j10 & j11) + ((j10 ^ j11) >> 1);
    }

    @c
    public static int s(long j10, int i10) {
        return (int) t(j10, i10);
    }

    @c
    public static long t(long j10, long j11) {
        if (j11 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j12 = j10 % j11;
        return j12 >= 0 ? j12 : j12 + j11;
    }

    public static long u(long j10, long j11, long j12) {
        if (j10 == 1) {
            return j11 / j12;
        }
        long k10 = k(j10, j12);
        return (j10 / k10) * (j11 / (j12 / k10));
    }

    @c
    public static long v(long j10, int i10) {
        g.e("exponent", i10);
        if (-2 > j10 || j10 > 2) {
            long j11 = 1;
            while (i10 != 0) {
                if (i10 == 1) {
                    return j11 * j10;
                }
                j11 *= (i10 & 1) == 0 ? 1L : j10;
                j10 *= j10;
                i10 >>= 1;
            }
            return j11;
        }
        int i11 = (int) j10;
        if (i11 == -2) {
            if (i10 < 64) {
                return (i10 & 1) == 0 ? 1 << i10 : -(1 << i10);
            }
            return 0L;
        }
        if (i11 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i11 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i11 == 1) {
            return 1L;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        if (i10 < 64) {
            return 1 << i10;
        }
        return 0L;
    }

    @c
    public static double w(long j10, RoundingMode roundingMode) {
        double d10;
        long j11;
        double d11 = j10;
        long j12 = (long) d11;
        int d12 = j12 == Long.MAX_VALUE ? -1 : Longs.d(j10, j12);
        int[] iArr = a.f10165a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                g.k(d12 == 0);
                return d11;
            case 2:
                return j10 >= 0 ? d12 >= 0 ? d11 : l5.d.f(d11) : d12 <= 0 ? d11 : Math.nextUp(d11);
            case 3:
                return d12 >= 0 ? d11 : l5.d.f(d11);
            case 4:
                return j10 >= 0 ? d12 <= 0 ? d11 : Math.nextUp(d11) : d12 >= 0 ? d11 : l5.d.f(d11);
            case 5:
                return d12 <= 0 ? d11 : Math.nextUp(d11);
            case 6:
            case 7:
            case 8:
                if (d12 >= 0) {
                    d10 = Math.nextUp(d11);
                    j11 = (long) Math.ceil(d10);
                } else {
                    double f10 = l5.d.f(d11);
                    j12 = (long) Math.floor(f10);
                    d10 = d11;
                    d11 = f10;
                    j11 = j12;
                }
                long j13 = j10 - j12;
                long j14 = j11 - j10;
                if (j11 == Long.MAX_VALUE) {
                    j14++;
                }
                int d13 = Longs.d(j13, j14);
                if (d13 < 0) {
                    return d11;
                }
                if (d13 > 0) {
                    return d10;
                }
                int i10 = iArr[roundingMode.ordinal()];
                if (i10 == 6) {
                    return j10 >= 0 ? d11 : d10;
                }
                if (i10 == 7) {
                    return j10 >= 0 ? d10 : d11;
                }
                if (i10 == 8) {
                    return (l5.d.c(d11) & 1) == 0 ? d11 : d10;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    @a5.a
    public static long x(long j10, long j11) {
        long j12 = j10 + j11;
        return (((j11 ^ j10) > 0L ? 1 : ((j11 ^ j10) == 0L ? 0 : -1)) < 0) | ((j10 ^ j12) >= 0) ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @a5.a
    public static long y(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        if ((numberOfLeadingZeros < 64) || ((j11 == Long.MIN_VALUE) & (j10 < 0))) {
            return j12;
        }
        long j13 = j10 * j11;
        return (j10 == 0 || j13 / j10 == j11) ? j13 : j12;
    }

    @a5.a
    public static long z(long j10, int i10) {
        g.e("exponent", i10);
        long j11 = 1;
        if (!(j10 >= -2) || !(j10 <= 2)) {
            long j12 = ((j10 >>> 63) & i10 & 1) + Long.MAX_VALUE;
            while (i10 != 0) {
                if (i10 == 1) {
                    return y(j11, j10);
                }
                if ((i10 & 1) != 0) {
                    j11 = y(j11, j10);
                }
                i10 >>= 1;
                if (i10 > 0) {
                    if ((-3037000499L > j10) || (j10 > f10159f)) {
                        return j12;
                    }
                    j10 *= j10;
                }
            }
            return j11;
        }
        int i11 = (int) j10;
        if (i11 == -2) {
            return i10 >= 64 ? (i10 & 1) + Long.MAX_VALUE : (i10 & 1) == 0 ? 1 << i10 : (-1) << i10;
        }
        if (i11 == -1) {
            return (i10 & 1) == 0 ? 1L : -1L;
        }
        if (i11 == 0) {
            return i10 == 0 ? 1L : 0L;
        }
        if (i11 == 1) {
            return 1L;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        if (i10 >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i10;
    }
}
