package com.martian.libvideoplayer;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes3.dex */
public class JCResizeTextureView extends TextureView {

    /* renamed from: c, reason: collision with root package name */
    public static final String f13015c = "JCResizeTextureView";

    /* renamed from: b, reason: collision with root package name */
    public Point f13016b;

    public JCResizeTextureView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f13016b = new Point(0, 0);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        Log.i(f13015c, "onMeasure  [" + hashCode() + "] ");
        int rotation = (int) getRotation();
        Point point = this.f13016b;
        int i14 = point.x;
        int i15 = point.y;
        Log.i(f13015c, "videoWidth = " + i14 + ", videoHeight = " + i15);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("viewRotation = ");
        sb2.append(rotation);
        Log.i(f13015c, sb2.toString());
        if (rotation == 90 || rotation == 270) {
            i11 = i10;
            i10 = i11;
        }
        int defaultSize = View.getDefaultSize(i14, i10);
        int defaultSize2 = View.getDefaultSize(i15, i11);
        if (i14 > 0 && i15 > 0) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size2 = View.MeasureSpec.getSize(i11);
            Log.i(f13015c, "widthMeasureSpec  [" + View.MeasureSpec.toString(i10) + "]");
            Log.i(f13015c, "heightMeasureSpec [" + View.MeasureSpec.toString(i11) + "]");
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i16 = i14 * size2;
                int i17 = size * i15;
                if (i16 < i17) {
                    defaultSize = i16 / i15;
                } else if (i16 > i17) {
                    i13 = i17 / i14;
                    defaultSize = size;
                    defaultSize2 = i13;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                i13 = (size * i15) / i14;
                if (mode2 == Integer.MIN_VALUE && i13 > size2) {
                    defaultSize = (i14 * size2) / i15;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = i13;
            } else if (mode2 == 1073741824) {
                i12 = (size2 * i14) / i15;
                if (mode == Integer.MIN_VALUE && i12 > size) {
                    i13 = (i15 * size) / i14;
                    defaultSize = size;
                    defaultSize2 = i13;
                }
                defaultSize = i12;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i15 <= size2) {
                    size2 = i15;
                    i12 = i14;
                } else {
                    i12 = (size2 * i14) / i15;
                }
                if (mode == Integer.MIN_VALUE && i12 > size) {
                    i13 = (i15 * size) / i14;
                    defaultSize = size;
                    defaultSize2 = i13;
                }
                defaultSize = i12;
                defaultSize2 = size2;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        if (f10 != getRotation()) {
            super.setRotation(f10);
            requestLayout();
        }
    }

    public void setVideoSize(Point point) {
        if (point == null || this.f13016b.equals(point)) {
            return;
        }
        this.f13016b = point;
        requestLayout();
    }

    public JCResizeTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
