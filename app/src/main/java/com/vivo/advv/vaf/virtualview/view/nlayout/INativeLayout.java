package com.vivo.advv.vaf.virtualview.view.nlayout;

import android.graphics.Canvas;

/* loaded from: classes4.dex */
public interface INativeLayout {
    void layoutDraw(Canvas canvas);

    void onLayoutLayout(boolean z, int i2, int i3, int i4, int i5);

    void onLayoutMeasure(int i2, int i3);
}
