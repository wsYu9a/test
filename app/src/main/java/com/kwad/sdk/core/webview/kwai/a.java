package com.kwad.sdk.core.webview.kwai;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* loaded from: classes2.dex */
public class a extends WebViewClient {
    private boolean apD = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.apD = z;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.apD || !d.uD()) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        String uri = webResourceRequest.getUrl().toString();
        com.kwad.sdk.core.d.b.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
        WebResourceResponse K = com.kwad.sdk.core.webview.a.a.za().K(uri, this.mUniqueId);
        return K == null ? super.shouldInterceptRequest(webView, webResourceRequest) : K;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.apD || !d.uD()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.b.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse K = com.kwad.sdk.core.webview.a.a.za().K(str, this.mUniqueId);
        return K == null ? super.shouldInterceptRequest(webView, str) : K;
    }
}
