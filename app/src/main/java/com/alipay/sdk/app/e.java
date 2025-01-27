package com.alipay.sdk.app;

import android.webkit.WebView;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5309a;

    /* renamed from: b */
    final /* synthetic */ a f5310b;

    e(a aVar, String str) {
        this.f5310b = aVar;
        this.f5309a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        try {
            webView = this.f5310b.f5286a;
            webView.loadUrl("javascript:" + this.f5309a);
        } catch (Exception unused) {
        }
    }
}
