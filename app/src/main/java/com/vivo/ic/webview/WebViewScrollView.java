package com.vivo.ic.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes4.dex */
public class WebViewScrollView extends NestedScrollView {
    private boolean isRecLayoutShow;
    private boolean isWebViewOnTop;
    private float mDownY;

    public WebViewScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownY = y;
        } else if (action == 2) {
            return y - this.mDownY < 0.0f ? this.isRecLayoutShow : this.isWebViewOnTop;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setIsRecLayoutShow(boolean z) {
        this.isRecLayoutShow = z;
    }

    public void setIsWebViewOnTop(boolean z) {
        this.isWebViewOnTop = z;
    }
}
