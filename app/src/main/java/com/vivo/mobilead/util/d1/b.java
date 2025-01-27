package com.vivo.mobilead.util.d1;

import android.graphics.Color;

/* loaded from: classes4.dex */
public class b {
    private static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private static int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    private static int b(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    public static int c(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int b2 = b(alpha2, alpha);
        return Color.argb(b2, a(Color.red(i2), alpha2, Color.red(i3), alpha, b2), a(Color.green(i2), alpha2, Color.green(i3), alpha, b2), a(Color.blue(i2), alpha2, Color.blue(i3), alpha, b2));
    }

    public static int d(int i2, int i3) {
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i2 & 16777215) | (i3 << 24);
    }

    public static double a(int i2) {
        double red = Color.red(i2);
        Double.isNaN(red);
        double d2 = red / 255.0d;
        double pow = d2 < 0.03928d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double green = Color.green(i2);
        Double.isNaN(green);
        double d3 = green / 255.0d;
        double pow2 = d3 < 0.03928d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double blue = Color.blue(i2);
        Double.isNaN(blue);
        double d4 = blue / 255.0d;
        return (pow * 0.2126d) + (pow2 * 0.7152d) + ((d4 < 0.03928d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d)) * 0.0722d);
    }

    public static double a(int i2, int i3) {
        if (Color.alpha(i3) == 255) {
            if (Color.alpha(i2) < 255) {
                i2 = c(i2, i3);
            }
            double a2 = a(i2) + 0.05d;
            double a3 = a(i3) + 0.05d;
            return Math.max(a2, a3) / Math.min(a2, a3);
        }
        throw new IllegalArgumentException("background can not be translucent");
    }

    public static int a(int i2, int i3, float f2) {
        int i4 = 255;
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException("background can not be translucent");
        }
        double d2 = f2;
        if (a(d(i2, 255), i3) < d2) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 <= 10 && i4 - i5 > 10; i6++) {
            int i7 = (i5 + i4) / 2;
            if (a(d(i2, i7), i3) < d2) {
                i5 = i7;
            } else {
                i4 = i7;
            }
        }
        return i4;
    }

    public static void a(int i2, int i3, int i4, float[] fArr) {
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
        fArr[0] = a(f8, 0.0f, 360.0f);
        fArr[1] = a(abs, 0.0f, 1.0f);
        fArr[2] = a(f7, 0.0f, 1.0f);
    }

    public static void a(int i2, float[] fArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }
}
