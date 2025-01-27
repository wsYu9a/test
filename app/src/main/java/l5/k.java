package l5;

import b5.u;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@a5.c
@e
/* loaded from: classes2.dex */
public abstract class k<X extends Number & Comparable<X>> {

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27929a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f27929a = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27929a[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27929a[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27929a[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27929a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27929a[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27929a[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27929a[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public abstract X a(X x10, X x11);

    public final double b(X x10, RoundingMode roundingMode) {
        X x11;
        double d10;
        u.F(x10, "x");
        u.F(roundingMode, "mode");
        double c10 = c(x10);
        if (Double.isInfinite(c10)) {
            switch (a.f27929a[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return d(x10) * Double.MAX_VALUE;
                case 5:
                    return c10 == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return c10 == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return c10;
                case 8:
                    String valueOf = String.valueOf(x10);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 44);
                    sb2.append(valueOf);
                    sb2.append(" cannot be represented precisely as a double");
                    throw new ArithmeticException(sb2.toString());
            }
        }
        X e10 = e(c10, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) x10).compareTo(e10);
        int[] iArr = a.f27929a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                return d(x10) >= 0 ? compareTo >= 0 ? c10 : d.f(c10) : compareTo <= 0 ? c10 : Math.nextUp(c10);
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d10 = Math.nextUp(c10);
                    if (d10 == Double.POSITIVE_INFINITY) {
                        return c10;
                    }
                    x11 = e(d10, RoundingMode.CEILING);
                } else {
                    double f10 = d.f(c10);
                    if (f10 == Double.NEGATIVE_INFINITY) {
                        return c10;
                    }
                    X e11 = e(f10, RoundingMode.FLOOR);
                    x11 = e10;
                    e10 = e11;
                    d10 = c10;
                    c10 = f10;
                }
                int compareTo2 = ((Comparable) a(x10, e10)).compareTo(a(x11, x10));
                if (compareTo2 < 0) {
                    return c10;
                }
                if (compareTo2 > 0) {
                    return d10;
                }
                int i10 = iArr[roundingMode.ordinal()];
                if (i10 == 2) {
                    return (Double.doubleToRawLongBits(c10) & 1) == 0 ? c10 : d10;
                }
                if (i10 == 3) {
                    return d(x10) >= 0 ? c10 : d10;
                }
                if (i10 == 4) {
                    return d(x10) >= 0 ? d10 : c10;
                }
                throw new AssertionError("impossible");
            case 5:
                return compareTo >= 0 ? c10 : d.f(c10);
            case 6:
                return compareTo <= 0 ? c10 : Math.nextUp(c10);
            case 7:
                return d(x10) >= 0 ? compareTo <= 0 ? c10 : Math.nextUp(c10) : compareTo >= 0 ? c10 : d.f(c10);
            case 8:
                g.k(compareTo == 0);
                return c10;
            default:
                throw new AssertionError("impossible");
        }
    }

    public abstract double c(X x10);

    public abstract int d(X x10);

    public abstract X e(double d10, RoundingMode roundingMode);
}
