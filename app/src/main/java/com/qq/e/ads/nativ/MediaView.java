package com.qq.e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public final class MediaView extends FrameLayout {
    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected void onAttachedToWindow() {
        GDTLogger.d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 11 || isHardwareAccelerated()) {
            return;
        }
        GDTLogger.w("硬件加速未开启");
    }
}
