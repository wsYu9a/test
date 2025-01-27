package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes7.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(float f2, float f3) {
        this(createQuad(f2, f3));
    }

    PathInterpolatorApi14(float f2, float f3, float f4, float f5) {
        this(createCubic(f2, f3, f4, f5));
    }

    PathInterpolatorApi14(Path path) {
        Object[] objArr = {new Integer(8131487), new Integer(5289120), new Integer(9103506), new Integer(-9250537), new Float(PRECISION)};
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int floatValue = (int) (length / ((Float) objArr[4]).floatValue());
        int intValue = 8131486 ^ ((Integer) objArr[0]).intValue();
        int i2 = floatValue + intValue;
        this.mX = new float[i2];
        this.mY = new float[i2];
        float[] fArr = new float[((Integer) objArr[1]).intValue() ^ 5289122];
        for (int i3 = 0; i3 < i2; i3 = (((Integer) objArr[2]).intValue() ^ 9103507) + i3) {
            pathMeasure.getPosTan((i3 * length) / ((((Integer) objArr[3]).intValue() ^ 9250536) + i2), fArr, null);
            this.mX[i3] = fArr[0];
            this.mY[i3] = fArr[intValue];
        }
    }

    private static Path createCubic(float f2, float f3, float f4, float f5) {
        Object[] objArr = {new Float(1.0f), new Float(1.0f)};
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, ((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue());
        return path;
    }

    private static Path createQuad(float f2, float f3) {
        Float f4 = new Float(1.0f);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float floatValue = ((Float) new Object[]{f4}[0]).floatValue();
        path.quadTo(f2, f3, floatValue, floatValue);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        int i2;
        Object[] objArr = {new Integer(7454573), new Float(1.0f), new Integer(909825)};
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float floatValue = ((Float) objArr[1]).floatValue();
        if (f2 >= floatValue) {
            return floatValue;
        }
        int length = this.mX.length;
        int intValue = ((Integer) objArr[2]).intValue() ^ 909824;
        int i3 = length - intValue;
        int i4 = 0;
        while (i3 - i4 > intValue) {
            int intValue2 = (i4 + i3) / (((Integer) objArr[0]).intValue() ^ 7454575);
            if (f2 < this.mX[intValue2]) {
                i2 = i4;
            } else {
                int i5 = i3;
                i2 = intValue2;
                intValue2 = i5;
            }
            i4 = i2;
            i3 = intValue2;
        }
        float[] fArr = this.mX;
        float f3 = fArr[i3];
        float f4 = fArr[i4];
        float f5 = f3 - f4;
        if (f5 == 0.0f) {
            return this.mY[i4];
        }
        float[] fArr2 = this.mY;
        float f6 = fArr2[i4];
        return (((f2 - f4) / f5) * (fArr2[i3] - f6)) + f6;
    }
}
