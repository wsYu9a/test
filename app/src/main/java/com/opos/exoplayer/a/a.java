package com.opos.exoplayer.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public final class a extends FrameLayout {

    /* renamed from: a */
    private float f17447a;

    /* renamed from: b */
    private int f17448b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17448b = 0;
    }

    public void a(float f2) {
        if (this.f17447a != f2) {
            this.f17447a = f2;
            requestLayout();
        }
    }

    public void a(int i2) {
        if (this.f17448b != i2) {
            this.f17448b = i2;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f17448b == 3 || this.f17447a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = measuredWidth;
        float f3 = measuredHeight;
        float f4 = (this.f17447a / (f2 / f3)) - 1.0f;
        if (Math.abs(f4) > 0.01f) {
            int i4 = this.f17448b;
            if (i4 == 1 || (i4 != 2 && (i4 == 4 ? f4 <= 0.0f : f4 > 0.0f))) {
                measuredHeight = (int) (f2 / this.f17447a);
            } else {
                measuredWidth = (int) (f3 * this.f17447a);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }
}
