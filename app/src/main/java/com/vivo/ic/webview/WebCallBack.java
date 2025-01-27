package com.vivo.ic.webview;

import android.webkit.WebView;

/* loaded from: classes4.dex */
public interface WebCallBack {
    void onBackToLastEmptyPage();

    void onGoBack();

    void onPageFinished(String str);

    void onPageStarted(String str);

    void onProgressChanged(int i2);

    void onReceivedTitle(String str);

    void onReceiverdError(String str);

    boolean onVideoStart(String str);

    boolean shouldHandleUrl(String str);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
