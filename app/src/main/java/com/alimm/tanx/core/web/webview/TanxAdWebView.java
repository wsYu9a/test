package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* loaded from: classes.dex */
public class TanxAdWebView extends WebView {
    private boolean clickable;
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public TanxAdWebView(Context context) {
        super(context);
        this.clickable = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i10, i11);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.clickable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public void setWebClickable(boolean z10) {
        this.clickable = z10;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clickable = true;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.clickable = true;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.clickable = true;
    }
}
