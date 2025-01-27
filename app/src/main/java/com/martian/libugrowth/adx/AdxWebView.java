package com.martian.libugrowth.adx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.http.HttpHost;

/* loaded from: classes3.dex */
public class AdxWebView extends WebView {

    private static class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return !AdxWebView.c(url);
        }
    }

    public AdxWebView(Context context) {
        super(context);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(final String url) {
        if (url == null) {
            return false;
        }
        if (url.startsWith("about:blank") || url.equals("")) {
            return true;
        }
        String scheme = Uri.parse(url).getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || b.b.a.b.b.f4198a.equalsIgnoreCase(scheme);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void b() {
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new b());
    }

    public AdxWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        b();
    }

    public AdxWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        b();
    }
}
