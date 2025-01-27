package com.alipay.sdk.app;

import android.webkit.WebView;

/* loaded from: classes.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5315a;

    /* renamed from: b */
    final /* synthetic */ a f5316b;

    j(a aVar, String str) {
        this.f5316b = aVar;
        this.f5315a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        webView = this.f5316b.f5286a;
        webView.loadUrl(this.f5315a);
    }
}
