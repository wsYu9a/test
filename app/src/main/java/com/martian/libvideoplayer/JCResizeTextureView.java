package com.martian.libvideoplayer;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes3.dex */
public class JCResizeTextureView extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f10677a = "JCResizeTextureView";

    /* renamed from: b, reason: collision with root package name */
    protected Point f10678b;

    public JCResizeTextureView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f10678b = new Point(0, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2;
        int i3;
        Log.i(f10677a, "onMeasure  [" + hashCode() + "] ");
        int rotation = (int) getRotation();
        Point point = this.f10678b;
        int i4 = point.x;
        int i5 = point.y;
        Log.i(f10677a, "videoWidth = " + i4 + ", videoHeight = " + i5);
        StringBuilder sb = new StringBuilder();
        sb.append("viewRotation = ");
        sb.append(rotation);
        Log.i(f10677a, sb.toString());
        if (rotation == 90 || rotation == 270) {
            heightMeasureSpec = widthMeasureSpec;
            widthMeasureSpec = heightMeasureSpec;
        }
        int defaultSize = TextureView.getDefaultSize(i4, widthMeasureSpec);
        int defaultSize2 = TextureView.getDefaultSize(i5, heightMeasureSpec);
        if (i4 > 0 && i5 > 0) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            Log.i(f10677a, "widthMeasureSpec  [" + View.MeasureSpec.toString(widthMeasureSpec) + "]");
            Log.i(f10677a, "heightMeasureSpec [" + View.MeasureSpec.toString(heightMeasureSpec) + "]");
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = i4 * size2;
                int i7 = size * i5;
                if (i6 < i7) {
                    defaultSize = i6 / i5;
                } else if (i6 > i7) {
                    i3 = i7 / i4;
                    defaultSize = size;
                    defaultSize2 = i3;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                i3 = (size * i5) / i4;
                if (mode2 == Integer.MIN_VALUE && i3 > size2) {
                    defaultSize = (i4 * size2) / i5;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = i3;
            } else if (mode2 == 1073741824) {
                i2 = (size2 * i4) / i5;
                if (mode == Integer.MIN_VALUE && i2 > size) {
                    i3 = (i5 * size) / i4;
                    defaultSize = size;
                    defaultSize2 = i3;
                }
                defaultSize = i2;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i5 <= size2) {
                    size2 = i5;
                    i2 = i4;
                } else {
                    i2 = (size2 * i4) / i5;
                }
                if (mode == Integer.MIN_VALUE && i2 > size) {
                    i3 = (i5 * size) / i4;
                    defaultSize = size;
                    defaultSize2 = i3;
                }
                defaultSize = i2;
                defaultSize2 = size2;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float rotation) {
        if (rotation != getRotation()) {
            super.setRotation(rotation);
            requestLayout();
        }
    }

    public void setVideoSize(Point videoSize) {
        if (videoSize == null || this.f10678b.equals(videoSize)) {
            return;
        }
        this.f10678b = videoSize;
        requestLayout();
    }

    public JCResizeTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }
}
