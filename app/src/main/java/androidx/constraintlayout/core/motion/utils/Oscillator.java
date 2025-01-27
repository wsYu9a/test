package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import l5.c;

/* loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d10, float f10) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d10;
        this.mPeriod[binarySearch] = f10;
        this.mNormalized = false;
    }

    public double getDP(double d10) {
        if (d10 <= c.f27899e) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0 || binarySearch == 0) {
            return c.f27899e;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.mPosition;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return (d10 * d13) + (f11 - (d13 * d12));
    }

    public double getP(double d10) {
        if (d10 < c.f27899e) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return c.f27899e;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.mPosition;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return this.mArea[i12] + ((f11 - (d13 * d12)) * (d10 - d12)) + ((d13 * ((d10 * d10) - (d12 * d12))) / 2.0d);
    }

    public double getSlope(double d10, double d11, double d12) {
        double p10 = d11 + getP(d10);
        double dp = getDP(d10) + d12;
        switch (this.mType) {
            case 1:
                return c.f27899e;
            case 2:
                return dp * 4.0d * Math.signum((((p10 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d13 = this.PI2;
                return (-d13) * dp * Math.sin(d13 * p10);
            case 6:
                return dp * 4.0d * ((((p10 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.mCustomCurve.getSlope(p10 % 1.0d, 0);
            default:
                double d14 = this.PI2;
                return dp * d14 * Math.cos(d14 * p10);
        }
    }

    public double getValue(double d10, double d11) {
        double abs;
        double p10 = getP(d10) + d11;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p10 % 1.0d));
            case 2:
                abs = Math.abs((((p10 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p10 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((p10 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * (d11 + p10));
            case 6:
                double abs2 = 1.0d - Math.abs(((p10 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p10 % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p10);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.mPeriod.length) {
                break;
            }
            d10 += r7[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.mPosition;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = (float) (fArr2[i13] * (d10 / d11));
            i13++;
        }
        this.mArea[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i14 >= fArr3.length) {
                this.mNormalized = true;
                return;
            }
            int i15 = i14 - 1;
            float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d12 = dArr2[i14] - dArr2[i15];
            double[] dArr3 = this.mArea;
            dArr3[i14] = dArr3[i15] + (d12 * f11);
            i14++;
        }
    }

    public void setType(int i10, String str) {
        this.mType = i10;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
