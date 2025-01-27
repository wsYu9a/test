package kotlin.math;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.umeng.analytics.pro.bd;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import l5.c;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", bd.f23522b, "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", TypedValues.TransitionType.S_TO, "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/math/MathKt")
/* loaded from: classes4.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double d10, double d11) {
        return Math.IEEEremainder(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double d10) {
        return Math.abs(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double d10) {
        return Math.acos(d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double acosh(double d10) {
        if (d10 < 1.0d) {
            return Double.NaN;
        }
        if (d10 > Constants.upper_taylor_2_bound) {
            return Math.log(d10) + Constants.LN2;
        }
        double d11 = 1;
        double d12 = d10 - d11;
        if (d12 >= Constants.taylor_n_bound) {
            return Math.log(d10 + Math.sqrt((d10 * d10) - d11));
        }
        double sqrt = Math.sqrt(d12);
        if (sqrt >= Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double d10) {
        return Math.asin(d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double d10) {
        double d11 = Constants.taylor_n_bound;
        if (d10 < d11) {
            return d10 <= (-d11) ? -asinh(-d10) : Math.abs(d10) >= Constants.taylor_2_bound ? d10 - (((d10 * d10) * d10) / 6) : d10;
        }
        if (d10 <= Constants.upper_taylor_n_bound) {
            return Math.log(d10 + Math.sqrt((d10 * d10) + 1));
        }
        if (d10 > Constants.upper_taylor_2_bound) {
            return Math.log(d10) + Constants.LN2;
        }
        double d12 = d10 * 2;
        return Math.log(d12 + (1 / d12));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double d10) {
        return Math.atan(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double d10, double d11) {
        return Math.atan2(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double d10) {
        if (Math.abs(d10) < Constants.taylor_n_bound) {
            return Math.abs(d10) > Constants.taylor_2_bound ? d10 + (((d10 * d10) * d10) / 3) : d10;
        }
        double d11 = 1;
        return Math.log((d11 + d10) / (d11 - d10)) / 2;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final double cbrt(double d10) {
        return Math.cbrt(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double d10) {
        return Math.ceil(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double d10) {
        return Math.cos(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double d10) {
        return Math.cosh(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double d10) {
        return Math.exp(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double d10) {
        return Math.expm1(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double d10) {
        return Math.floor(d10);
    }

    private static final double getAbsoluteValue(double d10) {
        return Math.abs(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d10) {
    }

    public static int getSign(int i10) {
        if (i10 < 0) {
            return -1;
        }
        return i10 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double d10) {
    }

    private static final double getUlp(double d10) {
        return Math.ulp(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double d10, double d11) {
        return Math.hypot(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln(double d10) {
        return Math.log(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double d10) {
        return Math.log1p(d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double d10, double d11) {
        if (d11 <= c.f27899e || d11 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d10) / Math.log(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double d10) {
        return Math.log10(d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double d10) {
        return Math.log(d10) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double d10, double d11) {
        return Math.max(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double d10, double d11) {
        return Math.min(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double d10) {
        return Math.nextAfter(d10, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double d10, double d11) {
        return Math.nextAfter(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double d10) {
        return Math.nextUp(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d10, double d11) {
        return Math.pow(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double d10) {
        return Math.rint(d10);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double d10) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d10 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d10 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d10);
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double d10) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double d10) {
        return Math.signum(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double d10) {
        return Math.sin(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double d10) {
        return Math.sinh(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double d10) {
        return Math.sqrt(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double d10) {
        return Math.tan(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double d10) {
        return Math.tanh(d10);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double d10) {
        return (Double.isNaN(d10) || Double.isInfinite(d10)) ? d10 : d10 > c.f27899e ? Math.floor(d10) : Math.ceil(d10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d10, double d11) {
        return Math.copySign(d10, d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float f10, float f11) {
        return (float) Math.IEEEremainder(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float f10) {
        return Math.abs(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float f10) {
        return (float) Math.acos(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float f10) {
        return (float) Math.asin(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float f10) {
        return (float) Math.atan(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float f10, float f11) {
        return (float) Math.atan2(f10, f11);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final float cbrt(float f10) {
        return (float) Math.cbrt(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float f10) {
        return (float) Math.ceil(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float f10) {
        return (float) Math.cos(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float f10) {
        return (float) Math.cosh(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float f10) {
        return (float) Math.exp(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float f10) {
        return (float) Math.expm1(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float f10) {
        return (float) Math.floor(f10);
    }

    private static final float getAbsoluteValue(float f10) {
        return Math.abs(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f10) {
    }

    public static int getSign(long j10) {
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float f10) {
    }

    private static final float getUlp(float f10) {
        return Math.ulp(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float f10, float f11) {
        return (float) Math.hypot(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln(float f10) {
        return (float) Math.log(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float f10) {
        return (float) Math.log1p(f10);
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float f10, float f11) {
        if (f11 <= 0.0f || f11 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f10) / Math.log(f11));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float f10) {
        return (float) Math.log10(f10);
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float f10) {
        return (float) (Math.log(f10) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float f10, float f11) {
        return Math.max(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float f10, float f11) {
        return Math.min(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float f10) {
        return Math.nextAfter(f10, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float f10, float f11) {
        return Math.nextAfter(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float f10) {
        return Math.nextUp(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double d10, int i10) {
        return Math.pow(d10, i10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float f10) {
        return (float) Math.rint(f10);
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float f10) {
        return MathKt.roundToLong(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float f10) {
        return Math.signum(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float f10) {
        return (float) Math.sin(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float f10) {
        return (float) Math.sinh(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float f10) {
        return (float) Math.sqrt(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float f10) {
        return (float) Math.tan(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float f10) {
        return (float) Math.tanh(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double d10, int i10) {
        return Math.copySign(d10, i10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int i10) {
        return Math.abs(i10);
    }

    private static final int getAbsoluteValue(int i10) {
        return Math.abs(i10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i10) {
    }

    private static final double getSign(double d10) {
        return Math.signum(d10);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int i10, int i11) {
        return Math.max(i10, i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int i10, int i11) {
        return Math.min(i10, i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f10, float f11) {
        return (float) Math.pow(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f10, float f11) {
        return Math.copySign(f10, f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long j10) {
        return Math.abs(j10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float f10) {
        return (float) atanh(f10);
    }

    private static final long getAbsoluteValue(long j10) {
        return Math.abs(j10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j10) {
    }

    private static final float getSign(float f10) {
        return Math.signum(f10);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long j10, long j11) {
        return Math.max(j10, j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long j10, long j11) {
        return Math.min(j10, j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float f10, int i10) {
        return (float) Math.pow(f10, i10);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(float f10) {
        if (Float.isNaN(f10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f10);
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float f10) {
        double ceil;
        if (Float.isNaN(f10) || Float.isInfinite(f10)) {
            return f10;
        }
        if (f10 > 0.0f) {
            ceil = Math.floor(f10);
        } else {
            ceil = Math.ceil(f10);
        }
        return (float) ceil;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float f10, int i10) {
        return Math.copySign(f10, i10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float f10) {
        return (float) acosh(f10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float f10) {
        return (float) asinh(f10);
    }
}
