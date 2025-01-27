package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class RatioFrameLayout extends FrameLayout {
    private double arO;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public double getRatio() {
        return this.arO;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.arO != l5.c.f27899e) {
            int size = View.MeasureSpec.getSize(i10);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            i11 = View.MeasureSpec.makeMeasureSpec((int) (((double) size) * this.arO), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    public void setRatio(double d10) {
        this.arO = d10;
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.arO = l5.c.f27899e;
    }
}
