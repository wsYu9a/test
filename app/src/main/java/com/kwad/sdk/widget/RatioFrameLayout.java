package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class RatioFrameLayout extends FrameLayout {
    private double aii;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aii = 0.0d;
    }

    public double getRatio() {
        return this.aii;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.aii != 0.0d) {
            int size = View.MeasureSpec.getSize(i2);
            Log.d("RatioFrameLayout", "widthSize:" + size);
            double d2 = (double) size;
            double d3 = this.aii;
            Double.isNaN(d2);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (d2 * d3), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setRatio(double d2) {
        this.aii = d2;
    }
}
