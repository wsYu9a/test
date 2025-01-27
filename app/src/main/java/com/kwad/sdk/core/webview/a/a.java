package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* loaded from: classes3.dex */
public class a extends WebViewClient {
    private boolean aIq = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z10) {
        this.aIq = z10;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aIq || !d.DJ()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse aa2 = com.kwad.sdk.core.webview.b.a.IL().aa(str, this.mUniqueId);
        return aa2 == null ? super.shouldInterceptRequest(webView, str) : aa2;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aIq && d.DJ()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse aa2 = com.kwad.sdk.core.webview.b.a.IL().aa(uri, this.mUniqueId);
            return aa2 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : aa2;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
