package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.vivo.mobilead.unified.base.callback.MediaListener;

/* loaded from: classes4.dex */
public class NativeVideoView extends RelativeLayout {
    private static final String TAG = NativeVideoView.class.getSimpleName();
    private com.vivo.ad.nativead.d nativeVideoControl;

    public NativeVideoView(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void pause() {
        com.vivo.ad.nativead.d dVar = this.nativeVideoControl;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void release() {
        com.vivo.ad.nativead.d dVar = this.nativeVideoControl;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void setMediaListener(MediaListener mediaListener) {
        com.vivo.ad.nativead.d dVar = this.nativeVideoControl;
        if (dVar != null) {
            dVar.a(mediaListener);
        }
    }

    public void setView(View view, com.vivo.ad.nativead.d dVar) {
        if (view == null || dVar == null) {
            return;
        }
        this.nativeVideoControl = dVar;
        removeAllViews();
        addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public void start() {
        com.vivo.ad.nativead.d dVar = this.nativeVideoControl;
        if (dVar != null) {
            dVar.a();
        }
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
