package android.support.v4.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes7.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArr) {
        Object[] objArr = {new Float(1.0f), new Integer(-4602158)};
        this.mValues = fArr;
        this.mStepSize = ((Float) objArr[0]).floatValue() / ((((Integer) objArr[1]).intValue() ^ 4602157) + fArr.length);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        Object[] objArr = {new Integer(-7034382), new Float(1.0f), new Integer(9216115), new Integer(-7010405)};
        float floatValue = ((Float) objArr[1]).floatValue();
        if (f2 >= floatValue) {
            return floatValue;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((((Integer) objArr[3]).intValue() ^ 7010404) + r1.length) * f2), (((Integer) objArr[0]).intValue() ^ 7034380) + this.mValues.length);
        float f3 = this.mStepSize;
        float f4 = (f2 - (min * f3)) / f3;
        float[] fArr = this.mValues;
        float f5 = fArr[min];
        return ((fArr[(((Integer) objArr[2]).intValue() ^ 9216114) + min] - f5) * f4) + f5;
    }
}
