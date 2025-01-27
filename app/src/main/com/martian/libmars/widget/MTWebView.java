package com.martian.libmars.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.data.WebEvent;
import com.martian.libsupport.data.WebParams;

/* loaded from: classes3.dex */
public class MTWebView extends WebView {

    /* renamed from: b */
    public c f12655b;

    /* renamed from: c */
    public boolean f12656c;

    public class a extends WebChromeClient {
        public a() {
        }

        public void a(ValueCallback<Uri> valueCallback) {
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.K0(valueCallback, "image/*", "filesystem");
            }
        }

        public void b(ValueCallback<Uri> valueCallback, String str) {
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.K0(valueCallback, str, "filesystem");
            }
        }

        public void c(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.K0(valueCallback, str, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            return false;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.V(webView, i10);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.b(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (MTWebView.this.f12655b == null) {
                return true;
            }
            MTWebView.this.f12655b.S0(webView, valueCallback, fileChooserParams);
            return true;
        }
    }

    public class b extends WebViewClient {

        /* renamed from: a */
        public boolean f12658a = false;

        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.N0(str);
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!this.f12658a) {
                shouldOverrideUrlLoading(webView, str);
            }
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.c0(str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.L(i10, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (MTWebView.this.f12655b != null) {
                MTWebView.this.f12655b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.f12658a = true;
            if (MTWebView.this.e(webView, str) || MTWebView.h(str)) {
                return true;
            }
            if (MTWebView.this.f12655b != null) {
                return MTWebView.this.f12655b.shouldOverrideUrlLoading(webView, str);
            }
            return false;
        }
    }

    public interface c {
        void D(String str);

        void E(WebView webView, String str, boolean z10);

        boolean F(WebView webView, String str, String str2);

        void J(String str, String str2, String str3);

        void K0(ValueCallback<Uri> valueCallback, String str, String str2);

        void L(int i10, String str, String str2);

        void N0(String str);

        void S0(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        void V(WebView webView, int i10);

        void b(WebView webView, String str);

        void c0(String str, Bitmap bitmap);

        void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

        void onScrollChanged(int i10, int i11, int i12, int i13);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public MTWebView(Context context) {
        super(context);
        this.f12655b = null;
        this.f12656c = true;
        f();
    }

    public static boolean c(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean h(String str) {
        return !i(str);
    }

    public static boolean i(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("about:blank") || str.equals("")) {
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    public String d(@NonNull WebParams webParams) {
        WebEvent webEvent = new WebEvent();
        webEvent.setType(webParams.getType());
        webEvent.setParams(webParams);
        return "javascript:if (typeof(tyWebEvent) === 'function') { tyWebEvent(" + GsonUtils.b().toJson(webEvent) + ") }";
    }

    public boolean e(WebView webView, String str) {
        if (!this.f12656c) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        if (!h(str)) {
            return false;
        }
        if (c(getContext(), intent)) {
            try {
                getContext().startActivity(intent);
                c cVar = this.f12655b;
                if (cVar != null) {
                    cVar.E(webView, str, true);
                    return true;
                }
            } catch (Exception unused) {
            }
        } else {
            c cVar2 = this.f12655b;
            if (cVar2 != null) {
                cVar2.E(webView, str, false);
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void f() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setCacheMode(2);
        settings.setAllowFileAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setDefaultTextEncodingName("utf-8");
        CookieManager.getInstance().setAcceptCookie(true);
        settings.setSupportZoom(true);
        setLongClickable(true);
        setScrollbarFadingEnabled(true);
        setScrollBarStyle(0);
        setDrawingCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        setDownloadListener(new DownloadListener() { // from class: n9.k
            public /* synthetic */ k() {
            }

            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                MTWebView.this.j(str, str2, str3, str4, j10);
            }
        });
        setWebViewClient(new b());
        setWebChromeClient(new a());
    }

    public boolean g() {
        return this.f12656c;
    }

    public final /* synthetic */ void j(String str, String str2, String str3, String str4, long j10) {
        c cVar = this.f12655b;
        if (cVar != null) {
            cVar.J(str, str3, str4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        c cVar = this.f12655b;
        if (cVar != null) {
            cVar.onScrollChanged(i10, i11, i12, i13);
        }
    }

    public void setBlockImage(boolean z10) {
        getSettings().setBlockNetworkImage(z10);
    }

    public void setCanHandleDeepLink(boolean z10) {
        this.f12656c = z10;
    }

    public void setOnPageStateChangedListener(c cVar) {
        this.f12655b = cVar;
    }

    public MTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12655b = null;
        this.f12656c = true;
        f();
    }

    public MTWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12655b = null;
        this.f12656c = true;
        f();
    }
}
