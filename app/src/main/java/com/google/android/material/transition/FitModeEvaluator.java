package com.google.android.material.transition;

import android.graphics.RectF;

/* loaded from: classes2.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f10, FitModeResult fitModeResult);

    FitModeResult evaluate(float f10, float f11, float f12, float f13, float f14, float f15, float f16);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
