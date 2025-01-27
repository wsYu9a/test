package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import l5.c;

/* loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d10) {
        return d10;
    }

    public double getDiff(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1 */
        double f294x1;

        /* renamed from: x2 */
        double f295x2;

        /* renamed from: y1 */
        double f296y1;

        /* renamed from: y2 */
        double f297y2;

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f294x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i10 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i10);
            this.f296y1 = Double.parseDouble(str.substring(i10, indexOf3).trim());
            int i11 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i11);
            this.f295x2 = Double.parseDouble(str.substring(i11, indexOf4).trim());
            int i12 = indexOf4 + 1;
            this.f297y2 = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        private double getDiffX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.f294x1;
            double d13 = this.f295x2;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        private double getDiffY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.f296y1;
            double d13 = this.f297y2;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        private double getX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f294x1 * d11 * d12 * d10) + (this.f295x2 * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        private double getY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f296y1 * d11 * d12 * d10) + (this.f297y2 * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d10) {
            if (d10 <= c.f27899e) {
                return c.f27899e;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > error) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double x10 = getX(d13);
            double d14 = d12 + d11;
            double x11 = getX(d14);
            double y10 = getY(d13);
            return (((getY(d14) - y10) * (d10 - x10)) / (x11 - x10)) + y10;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > d_error) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (getY(d14) - getY(d13)) / (getX(d14) - getX(d13));
        }

        public void setup(double d10, double d11, double d12, double d13) {
            this.f294x1 = d10;
            this.f296y1 = d11;
            this.f295x2 = d12;
            this.f297y2 = d13;
        }

        public CubicEasing(double d10, double d11, double d12, double d13) {
            setup(d10, d11, d12, d13);
        }
    }
}
