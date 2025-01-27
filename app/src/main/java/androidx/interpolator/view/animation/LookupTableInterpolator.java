package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f2533a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2534b;

    protected LookupTableInterpolator(float[] fArr) {
        this.f2533a = fArr;
        this.f2534b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f2533a;
        int min = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f2534b;
        float f4 = (f2 - (min * f3)) / f3;
        float[] fArr2 = this.f2533a;
        return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
    }
}
