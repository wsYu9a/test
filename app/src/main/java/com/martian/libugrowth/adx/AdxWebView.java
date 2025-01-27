package com.martian.libugrowth.adx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes3.dex */
public class AdxWebView extends WebView {

    public static class a extends WebViewClient {
        public /* synthetic */ a(ia.a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return !AdxWebView.c(str);
        }

        public a() {
        }
    }

    public AdxWebView(Context context) {
        super(context);
        b();
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("about:blank") || str.isEmpty()) {
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void b() {
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new a());
    }

    public AdxWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AdxWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
