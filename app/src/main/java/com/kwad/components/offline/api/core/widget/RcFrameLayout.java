package com.kwad.components.offline.api.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.utils.TkViewRCHelper;

/* loaded from: classes2.dex */
public class RcFrameLayout extends FrameLayout {
    private float mRatio;
    private TkViewRCHelper mViewRCHelper;
    private boolean widthBasedRatio;

    public RcFrameLayout(@NonNull Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    private float[] getRadius(float f2, float f3, float f4, float f5) {
        return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TkViewRCHelper tkViewRCHelper = new TkViewRCHelper();
        this.mViewRCHelper = tkViewRCHelper;
        tkViewRCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    protected boolean enableFirstVisible() {
        return true;
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * this.mRatio), 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mViewRCHelper.onSizeChanged(i2, i3);
    }

    public void setRadius(float f2) {
        this.mViewRCHelper.setRadius(f2);
        postInvalidate();
    }

    public void setRadius(float f2, float f3, float f4, float f5) {
        this.mViewRCHelper.setRadius(getRadius(f2, f3, f4, f5));
        postInvalidate();
    }

    public void setRatio(float f2) {
        this.mRatio = f2;
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }
}
