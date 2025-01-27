package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class ColorUtils {

    /* renamed from: a */
    private static final double f1724a = 95.047d;

    /* renamed from: b */
    private static final double f1725b = 100.0d;

    /* renamed from: c */
    private static final double f1726c = 108.883d;

    /* renamed from: d */
    private static final double f1727d = 0.008856d;

    /* renamed from: e */
    private static final double f1728e = 903.3d;

    /* renamed from: f */
    private static final int f1729f = 10;

    /* renamed from: g */
    private static final int f1730g = 1;

    /* renamed from: h */
    private static final ThreadLocal<double[]> f1731h = new ThreadLocal<>();

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float abs = (1.0f - Math.abs((f4 * 2.0f) - 1.0f)) * f3;
        float f5 = f4 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f2) / 60) {
            case 0:
                round = Math.round((abs + f5) * 255.0f);
                round2 = Math.round((abs2 + f5) * 255.0f);
                round3 = Math.round(f5 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round((abs + f5) * 255.0f);
                round3 = Math.round(f5 * 255.0f);
                break;
            case 2:
                round = Math.round(f5 * 255.0f);
                round2 = Math.round((abs + f5) * 255.0f);
                round3 = Math.round((abs2 + f5) * 255.0f);
                break;
            case 3:
                round = Math.round(f5 * 255.0f);
                round2 = Math.round((abs2 + f5) * 255.0f);
                round3 = Math.round((abs + f5) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round(f5 * 255.0f);
                round3 = Math.round((abs + f5) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f5) * 255.0f);
                round2 = Math.round(f5 * 255.0f);
                round3 = Math.round((abs2 + f5) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(e(round, 0, 255), e(round2, 0, 255), e(round3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d2, @FloatRange(from = -128.0d, to = 127.0d) double d3, @FloatRange(from = -128.0d, to = 127.0d) double d4) {
        double[] f2 = f();
        LABToXYZ(d2, d3, d4, f2);
        return XYZToColor(f2[0], f2[1], f2[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d2, @FloatRange(from = -128.0d, to = 127.0d) double d3, @FloatRange(from = -128.0d, to = 127.0d) double d4, @NonNull double[] dArr) {
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = (d3 / 500.0d) + d5;
        double d7 = d5 - (d4 / 200.0d);
        double pow = Math.pow(d6, 3.0d);
        if (pow <= f1727d) {
            pow = ((d6 * 116.0d) - 16.0d) / f1728e;
        }
        double pow2 = d2 > 7.9996247999999985d ? Math.pow(d5, 3.0d) : d2 / f1728e;
        double pow3 = Math.pow(d7, 3.0d);
        if (pow3 <= f1727d) {
            pow3 = ((d7 * 116.0d) - 16.0d) / f1728e;
        }
        dArr[0] = pow * f1724a;
        dArr[1] = pow2 * f1725b;
        dArr[2] = pow3 * f1726c;
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull float[] fArr) {
        float f2;
        float abs;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float f5 = i4 / 255.0f;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = Math.min(f3, Math.min(f4, f5));
        float f6 = max - min;
        float f7 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            abs = 0.0f;
        } else {
            f2 = max == f3 ? ((f4 - f5) / f6) % 6.0f : max == f4 ? ((f5 - f3) / f6) + 2.0f : 4.0f + ((f3 - f4) / f6);
            abs = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (f2 * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = d(f8, 0.0f, 360.0f);
        fArr[1] = d(abs, 0.0f, 1.0f);
        fArr[2] = d(f7, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull double[] dArr) {
        RGBToXYZ(i2, i3, i4, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = d2 / 255.0d;
        double pow = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = i3;
        Double.isNaN(d4);
        double d5 = d4 / 255.0d;
        double pow2 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        double d6 = i4;
        Double.isNaN(d6);
        double d7 = d6 / 255.0d;
        double pow3 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * f1725b;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * f1725b;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * f1725b;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d2, @FloatRange(from = 0.0d, to = 100.0d) double d3, @FloatRange(from = 0.0d, to = 108.883d) double d4) {
        double d5 = (((3.2406d * d2) + ((-1.5372d) * d3)) + ((-0.4986d) * d4)) / f1725b;
        double d6 = ((((-0.9689d) * d2) + (1.8758d * d3)) + (0.0415d * d4)) / f1725b;
        double d7 = (((0.0557d * d2) + ((-0.204d) * d3)) + (1.057d * d4)) / f1725b;
        return Color.rgb(e((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), e((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), e((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d2, @FloatRange(from = 0.0d, to = 100.0d) double d3, @FloatRange(from = 0.0d, to = 108.883d) double d4, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double g2 = g(d2 / f1724a);
        double g3 = g(d3 / f1725b);
        double g4 = g(d4 / f1726c);
        dArr[0] = Math.max(0.0d, (116.0d * g3) - 16.0d);
        dArr[1] = (g2 - g3) * 500.0d;
        dArr[2] = (g3 - g4) * 200.0d;
    }

    @VisibleForTesting
    static float a(float f2, float f3, float f4) {
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (f2 + ((f3 - f2) * f4)) % 360.0f;
    }

    private static int b(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f3 = 1.0f - f2;
        fArr3[0] = a(fArr[0], fArr2[0], f2);
        fArr3[1] = (fArr[1] * f3) + (fArr2[1] * f2);
        fArr3[2] = (fArr[2] * f3) + (fArr2[2] * f2);
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d2, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d3 = 1.0d - d2;
        dArr3[0] = (dArr[0] * d3) + (dArr2[0] * d2);
        dArr3[1] = (dArr[1] * d3) + (dArr2[1] * d2);
        dArr3[2] = (dArr[2] * d3) + (dArr2[2] * d2);
    }

    private static int c(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    public static double calculateContrast(@ColorInt int i2, @ColorInt int i3) {
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
        }
        if (Color.alpha(i2) < 255) {
            i2 = compositeColors(i2, i3);
        }
        double calculateLuminance = calculateLuminance(i2) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i3) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i2) {
        double[] f2 = f();
        colorToXYZ(i2, f2);
        return f2[1] / f1725b;
    }

    public static int calculateMinimumAlpha(@ColorInt int i2, @ColorInt int i3, float f2) {
        int i4 = 255;
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
        }
        double d2 = f2;
        if (calculateContrast(setAlphaComponent(i2, 255), i3) < d2) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
            int i7 = (i5 + i4) / 2;
            if (calculateContrast(setAlphaComponent(i2, i7), i3) < d2) {
                i5 = i7;
            } else {
                i4 = i7;
            }
        }
        return i4;
    }

    public static void colorToHSL(@ColorInt int i2, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static void colorToLAB(@ColorInt int i2, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    public static void colorToXYZ(@ColorInt int i2, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    public static int compositeColors(@ColorInt int i2, @ColorInt int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int b2 = b(alpha2, alpha);
        return Color.argb(b2, c(Color.red(i2), alpha2, Color.red(i3), alpha, b2), c(Color.green(i2), alpha2, Color.green(i3), alpha, b2), c(Color.blue(i2), alpha2, Color.blue(i3), alpha, b2));
    }

    private static float d(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static int e(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static double[] f() {
        ThreadLocal<double[]> threadLocal = f1731h;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double g(double d2) {
        return d2 > f1727d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * f1728e) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i2 & 16777215) | (i3 << 24);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        if (a.a(color.getModel(), color2.getModel())) {
            if (!a.a(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = color2.alpha() * (1.0f - alpha);
            int componentCount = color2.getComponentCount() - 1;
            components2[componentCount] = alpha + alpha2;
            if (components2[componentCount] > 0.0f) {
                alpha /= components2[componentCount];
                alpha2 /= components2[componentCount];
            }
            for (int i2 = 0; i2 < componentCount; i2++) {
                components2[i2] = (components[i2] * alpha) + (components2[i2] * alpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
    }
}
