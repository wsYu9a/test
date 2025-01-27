package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f5502a;

    /* renamed from: b */
    final /* synthetic */ WebView f5503b;

    /* renamed from: c */
    final /* synthetic */ ad f5504c;

    ah(ad adVar, JSONObject jSONObject, WebView webView) {
        this.f5504c = adVar;
        this.f5502a = jSONObject;
        this.f5503b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5502a == null || this.f5503b == null) {
            return;
        }
        this.f5503b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f5502a.toString().replace("\"", "\\\"") + "\")");
    }
}
