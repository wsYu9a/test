package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* loaded from: classes3.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.PQ());
        return valueAnimator;
    }
}
