package com.vivo.mobilead.lottie.a;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes4.dex */
class b implements Interpolator {

    /* renamed from: a */
    private final float[] f29071a;

    /* renamed from: b */
    private final float[] f29072b;

    b(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }

    b(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = ((int) (length / 0.002f)) + 1;
        this.f29071a = new float[i2];
        this.f29072b = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / (i2 - 1), fArr, null);
            this.f29071a[i3] = fArr[0];
            this.f29072b[i3] = fArr[1];
        }
    }

    private static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f29071a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f29071a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f29071a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f29072b[i2];
        }
        float[] fArr2 = this.f29072b;
        return fArr2[i2] + (((f2 - fArr[i2]) / f3) * (fArr2[length] - fArr2[i2]));
    }
}
