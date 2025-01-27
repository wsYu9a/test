package com.vivo.ic.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public class NestedScrollWebView extends WebView {
    private OnOverScrollListener mOnOverScrollListener;

    public interface OnOverScrollListener {
        void onOverScrolled(NestedScrollWebView nestedScrollWebView, boolean z);
    }

    public NestedScrollWebView(Context context) {
        this(context, null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebSettings() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setSupportZoom(false);
            settings.setLoadWithOverviewMode(true);
            settings.setDomStorageEnabled(true);
            try {
                Class<?> cls = Class.forName("android.webkit.WebSettings");
                cls.getMethod("setAppCacheEnabled", Boolean.TYPE).invoke(cls.newInstance(), Boolean.TRUE);
            } catch (Throwable unused) {
            }
        }
        removeJs();
    }

    private void removeJs() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void onDestroy() {
        clearHistory();
        ((ViewGroup) getParent()).removeView(this);
        destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
        OnOverScrollListener onOverScrollListener = this.mOnOverScrollListener;
        if (onOverScrollListener != null) {
            onOverScrollListener.onOverScrolled(this, i3 == 0 && z2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        scrollTo(0, i3);
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        this.mOnOverScrollListener = onOverScrollListener;
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setFocusable(true);
        setFocusableInTouchMode(true);
        initWebSettings();
    }
}
