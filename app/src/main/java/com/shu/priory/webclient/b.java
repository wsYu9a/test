package com.shu.priory.webclient;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class b extends WebViewClient {

    /* renamed from: a */
    private boolean f17463a = false;

    /* renamed from: b */
    private boolean f17464b = false;

    /* renamed from: c */
    private boolean f17465c = false;

    /* renamed from: d */
    private d f17466d;

    public b(d dVar) {
        this.f17466d = dVar;
    }

    public void a(boolean z10) {
        this.f17465c = z10;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        h.a(SDKConstants.TAG, "onPageFinished:" + this.f17464b);
        boolean z10 = this.f17464b;
        if (!z10) {
            this.f17463a = true;
        }
        if (!this.f17463a || z10) {
            this.f17464b = false;
        } else {
            this.f17466d.b();
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        a(false);
        this.f17463a = false;
        this.f17464b = false;
        this.f17466d.a();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        this.f17466d.a(i10, str);
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError.getPrimaryError() == 5) {
            sslErrorHandler.proceed();
        } else {
            sslErrorHandler.cancel();
            this.f17466d.a(-1, sslError.toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        h.a(SDKConstants.TAG, "shouldOverrideUrlLoading:" + this.f17465c + this.f17463a);
        if (this.f17465c) {
            a(false);
            this.f17466d.a(webView, str);
            return true;
        }
        if (!this.f17463a) {
            this.f17464b = true;
        }
        this.f17463a = false;
        webView.loadUrl(str);
        h.a(SDKConstants.TAG, "shouldOverrideUrlLoading click=false");
        return true;
    }
}
