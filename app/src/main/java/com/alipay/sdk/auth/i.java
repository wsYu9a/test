package com.alipay.sdk.auth;

import android.webkit.WebView;

/* loaded from: classes.dex */
final class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5361a;

    /* renamed from: b */
    final /* synthetic */ AuthActivity f5362b;

    i(AuthActivity authActivity, String str) {
        this.f5362b = authActivity;
        this.f5361a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        webView = this.f5362b.f5342c;
        webView.loadUrl(this.f5361a);
    }
}
