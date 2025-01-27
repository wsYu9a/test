package com.alipay.sdk.auth;

import android.webkit.WebView;

/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5355a;

    /* renamed from: b */
    final /* synthetic */ AuthActivity f5356b;

    d(AuthActivity authActivity, String str) {
        this.f5356b = authActivity;
        this.f5355a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        try {
            webView = this.f5356b.f5342c;
            webView.loadUrl("javascript:" + this.f5355a);
        } catch (Exception unused) {
        }
    }
}
