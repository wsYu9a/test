package com.heytap.msp.mobad.api.params;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class MediaView extends FrameLayout {
    private static final int DEFAULT_HEIGHT = 9;
    private static final int DEFAULT_WIDTH = 16;

    public MediaView(Context context) {
        super(context);
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setBackgroundColor(-16777216);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        setBackgroundColor(-16777216);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = (size * 9) / 16;
        int i5 = (size2 * 16) / 9;
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode == 1073741824) {
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, size2), 1073741824);
                }
                i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else {
                if (mode2 == 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, size), 1073741824);
                    }
                } else if (mode != Integer.MIN_VALUE ? mode2 != Integer.MIN_VALUE : mode2 != Integer.MIN_VALUE || size2 / 9 > size / 16) {
                    i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                    i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    i3 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }
}
