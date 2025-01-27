package com.shu.priory.webclient;

import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class a extends WebChromeClient {

    /* renamed from: a */
    private int f17461a;

    /* renamed from: b */
    private c f17462b;

    public a(c cVar) {
        this.f17462b = cVar;
    }

    public int a() {
        return this.f17461a;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.f17462b.a(str, str2, str3, jsPromptResult);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        a(i10);
        this.f17462b.a(i10);
    }

    private void a(int i10) {
        this.f17461a = i10;
    }
}
