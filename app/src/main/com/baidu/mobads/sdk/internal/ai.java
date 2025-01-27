package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f6717a;

    /* renamed from: b */
    final /* synthetic */ WebView f6718b;

    /* renamed from: c */
    final /* synthetic */ ae f6719c;

    public ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.f6719c = aeVar;
        this.f6717a = jSONObject;
        this.f6718b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6717a == null || this.f6718b == null) {
            return;
        }
        this.f6718b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f6717a.toString().replace("\"", "\\\"") + "\")");
    }
}
