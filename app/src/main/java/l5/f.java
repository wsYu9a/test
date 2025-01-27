package l5;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import b5.u;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.qq.e.comm.constants.ErrorCode;
import java.math.RoundingMode;
import okhttp3.internal.http2.Http2Connection;

@a5.b(emulated = true)
@e
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a */
    @a5.d
    public static final int f27910a = 1073741824;

    /* renamed from: b */
    @a5.d
    public static final int f27911b = -1257966797;

    /* renamed from: f */
    @a5.d
    public static final int f27915f = 46340;

    /* renamed from: c */
    @a5.d
    public static final byte[] f27912c = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: d */
    @a5.d
    public static final int[] f27913d = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* renamed from: e */
    @a5.d
    public static final int[] f27914e = {3, 31, TypedValues.AttributesType.TYPE_PATH_ROTATE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: g */
    public static final int[] f27916g = {1, 1, 2, 6, 24, 120, 720, ErrorCode.VIDEO_DURATION_ERROR, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: h */
    @a5.d
    public static int[] f27917h = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27918a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f27918a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27918a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27918a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27918a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27918a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27918a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27918a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27918a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i10, int i11) {
        g.e("n", i10);
        g.e("k", i11);
        int i12 = 0;
        u.m(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        int[] iArr = f27917h;
        if (i11 >= iArr.length || i10 > iArr[i11]) {
            return Integer.MAX_VALUE;
        }
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return i10;
        }
        long j10 = 1;
        while (i12 < i11) {
            long j11 = j10 * (i10 - i12);
            i12++;
            j10 = j11 / i12;
        }
        return (int) j10;
    }

    @a5.a
    public static int b(int i10) {
        g.h("x", i10);
        if (i10 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i10 - 1));
        }
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("ceilingPowerOfTwo(");
        sb2.append(i10);
        sb2.append(") not representable as an int");
        throw new ArithmeticException(sb2.toString());
    }

    public static int c(int i10, int i11) {
        long j10 = i10 + i11;
        int i12 = (int) j10;
        g.b(j10 == ((long) i12), "checkedAdd", i10, i11);
        return i12;
    }

    public static int d(int i10, int i11) {
        long j10 = i10 * i11;
        int i12 = (int) j10;
        g.b(j10 == ((long) i12), "checkedMultiply", i10, i11);
        return i12;
    }

    public static int e(int i10, int i11) {
        g.e("exponent", i11);
        if (i10 == -2) {
            g.b(i11 < 32, "checkedPow", i10, i11);
            return (i11 & 1) == 0 ? 1 << i11 : (-1) << i11;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            g.b(i11 < 31, "checkedPow", i10, i11);
            return 1 << i11;
        }
        int i12 = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return d(i12, i10);
            }
            if ((i11 & 1) != 0) {
                i12 = d(i12, i10);
            }
            i11 >>= 1;
            if (i11 > 0) {
                g.b((-46340 <= i10) & (i10 <= 46340), "checkedPow", i10, i11);
                i10 *= i10;
            }
        }
        return i12;
    }

    public static int f(int i10, int i11) {
        long j10 = i10 - i11;
        int i12 = (int) j10;
        g.b(j10 == ((long) i12), "checkedSubtract", i10, i11);
        return i12;
    }

    public static int g(int i10, int i11, RoundingMode roundingMode) {
        u.E(roundingMode);
        if (i11 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i12 = i10 / i11;
        int i13 = i10 - (i11 * i12);
        if (i13 == 0) {
            return i12;
        }
        int i14 = ((i10 ^ i11) >> 31) | 1;
        switch (a.f27918a[roundingMode.ordinal()]) {
            case 1:
                g.k(i13 == 0);
                return i12;
            case 2:
                return i12;
            case 3:
                if (i14 >= 0) {
                    return i12;
                }
                break;
            case 4:
                break;
            case 5:
                if (i14 <= 0) {
                    return i12;
                }
                break;
            case 6:
            case 7:
            case 8:
                int abs = Math.abs(i13);
                int abs2 = abs - (Math.abs(i11) - abs);
                if (abs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i12 & 1) != 0))) {
                            return i12;
                        }
                    }
                } else if (abs2 <= 0) {
                    return i12;
                }
                break;
            default:
                throw new AssertionError();
        }
        return i12 + i14;
    }

    public static int h(int i10) {
        g.e("n", i10);
        int[] iArr = f27916g;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return Integer.MAX_VALUE;
    }

    @a5.a
    public static int i(int i10) {
        g.h("x", i10);
        return Integer.highestOneBit(i10);
    }

    public static int j(int i10, int i11) {
        g.e("a", i10);
        g.e("b", i11);
        if (i10 == 0) {
            return i11;
        }
        if (i11 == 0) {
            return i10;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
        int i12 = i10 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i11);
        int i13 = i11 >> numberOfTrailingZeros2;
        while (i12 != i13) {
            int i14 = i12 - i13;
            int i15 = (i14 >> 31) & i14;
            int i16 = (i14 - i15) - i15;
            i13 += i15;
            i12 = i16 >> Integer.numberOfTrailingZeros(i16);
        }
        return i12 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean k(int i10) {
        return (i10 > 0) & ((i10 & (i10 + (-1))) == 0);
    }

    @a5.a
    @a5.c
    public static boolean l(int i10) {
        return LongMath.m(i10);
    }

    @a5.d
    public static int m(int i10, int i11) {
        return (~(~(i10 - i11))) >>> 31;
    }

    @a5.c
    public static int n(int i10, RoundingMode roundingMode) {
        int m10;
        g.h("x", i10);
        int o10 = o(i10);
        int i11 = f27913d[o10];
        switch (a.f27918a[roundingMode.ordinal()]) {
            case 1:
                g.k(i10 == i11);
            case 2:
            case 3:
                return o10;
            case 4:
            case 5:
                m10 = m(i11, i10);
                return o10 + m10;
            case 6:
            case 7:
            case 8:
                m10 = m(f27914e[o10], i10);
                return o10 + m10;
            default:
                throw new AssertionError();
        }
    }

    public static int o(int i10) {
        byte b10 = f27912c[Integer.numberOfLeadingZeros(i10)];
        return b10 - m(i10, f27913d[b10]);
    }

    public static int p(int i10, RoundingMode roundingMode) {
        g.h("x", i10);
        switch (a.f27918a[roundingMode.ordinal()]) {
            case 1:
                g.k(k(i10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
                return (31 - numberOfLeadingZeros) + m(f27911b >>> numberOfLeadingZeros, i10);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static int q(int i10, int i11) {
        return (i10 & i11) + ((i10 ^ i11) >> 1);
    }

    public static int r(int i10, int i11) {
        if (i11 > 0) {
            int i12 = i10 % i11;
            return i12 >= 0 ? i12 : i12 + i11;
        }
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("Modulus ");
        sb2.append(i11);
        sb2.append(" must be > 0");
        throw new ArithmeticException(sb2.toString());
    }

    @a5.c
    public static int s(int i10, int i11) {
        g.e("exponent", i11);
        if (i10 == -2) {
            if (i11 < 32) {
                return (i11 & 1) == 0 ? 1 << i11 : -(1 << i11);
            }
            return 0;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            if (i11 < 32) {
                return 1 << i11;
            }
            return 0;
        }
        int i12 = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return i10 * i12;
            }
            i12 *= (i11 & 1) == 0 ? 1 : i10;
            i10 *= i10;
            i11 >>= 1;
        }
        return i12;
    }

    @a5.a
    public static int t(int i10, int i11) {
        return Ints.x(i10 + i11);
    }

    @a5.a
    public static int u(int i10, int i11) {
        return Ints.x(i10 * i11);
    }

    @a5.a
    public static int v(int i10, int i11) {
        g.e("exponent", i11);
        if (i10 == -2) {
            return i11 >= 32 ? (i11 & 1) + Integer.MAX_VALUE : (i11 & 1) == 0 ? 1 << i11 : (-1) << i11;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            if (i11 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i11;
        }
        int i12 = ((i10 >>> 31) & i11 & 1) + Integer.MAX_VALUE;
        int i13 = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return u(i13, i10);
            }
            if ((i11 & 1) != 0) {
                i13 = u(i13, i10);
            }
            i11 >>= 1;
            if (i11 > 0) {
                if ((-46340 > i10) || (i10 > 46340)) {
                    return i12;
                }
                i10 *= i10;
            }
        }
        return i13;
    }

    @a5.a
    public static int w(int i10, int i11) {
        return Ints.x(i10 - i11);
    }

    @a5.c
    public static int x(int i10, RoundingMode roundingMode) {
        int m10;
        g.e("x", i10);
        int y10 = y(i10);
        switch (a.f27918a[roundingMode.ordinal()]) {
            case 1:
                g.k(y10 * y10 == i10);
            case 2:
            case 3:
                return y10;
            case 4:
            case 5:
                m10 = m(y10 * y10, i10);
                return y10 + m10;
            case 6:
            case 7:
            case 8:
                m10 = m((y10 * y10) + y10, i10);
                return y10 + m10;
            default:
                throw new AssertionError();
        }
    }

    public static int y(int i10) {
        return (int) Math.sqrt(i10);
    }
}
