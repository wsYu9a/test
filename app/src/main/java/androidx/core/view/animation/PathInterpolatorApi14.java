package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private static final float f2141a = 0.002f;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f2142b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f2143c;

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = ((int) (length / f2141a)) + 1;
        this.f2142b = new float[i2];
        this.f2143c = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / (i2 - 1), fArr, null);
            this.f2142b[i3] = fArr[0];
            this.f2143c[i3] = fArr[1];
        }
    }

    private static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    private static Path b(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
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
        int length = this.f2142b.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f2142b[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f2142b;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f2143c[i2];
        }
        float f4 = (f2 - fArr[i2]) / f3;
        float[] fArr2 = this.f2143c;
        float f5 = fArr2[i2];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    PathInterpolatorApi14(float f2, float f3) {
        this(b(f2, f3));
    }

    PathInterpolatorApi14(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }
}
