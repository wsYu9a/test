package com.martian.libmars.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
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
import com.martian.libsupport.data.WebEvent;
import com.martian.libsupport.data.WebParams;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.apache.http.HttpHost;

/* loaded from: classes2.dex */
public class MTWebView extends WebView {

    /* renamed from: a */
    private c f10348a;

    /* renamed from: b */
    private boolean f10349b;

    public class a extends WebChromeClient {

        /* renamed from: com.martian.libmars.widget.MTWebView$a$a */
        class C0259a extends WebViewClient {
            C0259a() {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (MTWebView.this.f10348a == null) {
                    return true;
                }
                MTWebView.this.f10348a.g(url);
                return true;
            }
        }

        public a() {
        }

        public void a(ValueCallback<Uri> uploadMsg) {
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.t(uploadMsg, "image/*", "filesystem");
            }
        }

        public void b(ValueCallback<Uri> uploadMsg, String acceptType) {
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.t(uploadMsg, acceptType, "filesystem");
            }
        }

        public void c(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.t(uploadMsg, acceptType, capture);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView webView = new WebView(view.getContext());
            webView.setWebViewClient(new C0259a());
            ((WebView.WebViewTransport) resultMsg.obj).setWebView(webView);
            resultMsg.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.p(view, newProgress);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.c(view, title);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
            if (MTWebView.this.f10348a == null) {
                return true;
            }
            MTWebView.this.f10348a.u(webView, uploadMsg, fileChooserParams);
            return true;
        }
    }

    class b extends WebViewClient {

        /* renamed from: a */
        private boolean f10352a = false;

        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.onPageFinished(url);
            }
            super.onPageFinished(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (!this.f10352a) {
                shouldOverrideUrlLoading(view, url);
            }
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.q(url, favicon);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.l(errorCode, description, failingUrl);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            if (MTWebView.this.f10348a != null) {
                MTWebView.this.f10348a.onReceivedSslError(view, handler, error);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            this.f10352a = true;
            if (MTWebView.this.d(view, url) || MTWebView.g(url)) {
                return true;
            }
            if (MTWebView.this.f10348a != null) {
                return MTWebView.this.f10348a.shouldOverrideUrlLoading(view, url);
            }
            return false;
        }
    }

    public interface c {
        void c(WebView view, String title);

        void g(String url);

        void h(WebView view, String deeplink, boolean canHandle);

        boolean i(WebView view, String url, String message);

        void k(String url, String contentDisposition, String mimetype);

        void l(int errorCode, String description, String failingUrl);

        void onPageFinished(String url);

        void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error);

        void onScrollChanged(int l, int t, int oldl, int oldt);

        void p(WebView view, int newProgress);

        void q(String url, Bitmap favicon);

        boolean shouldOverrideUrlLoading(WebView view, String url);

        void t(ValueCallback<Uri> callback, String acceptType, String capture);

        void u(WebView webView, ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams);
    }

    public MTWebView(Context context) {
        super(context);
        this.f10348a = null;
        this.f10349b = true;
        e();
    }

    public static boolean b(final Context context, final Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean g(final String url) {
        return !h(url);
    }

    public static boolean h(final String url) {
        if (url == null) {
            return false;
        }
        if (url.startsWith("about:blank") || url.equals("")) {
            return true;
        }
        String scheme = Uri.parse(url).getScheme();
        return HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || b.b.a.b.b.f4198a.equalsIgnoreCase(scheme);
    }

    /* renamed from: i */
    public /* synthetic */ void j(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        c cVar = this.f10348a;
        if (cVar != null) {
            cVar.k(url, contentDisposition, mimetype);
        }
    }

    public String c(@NonNull WebParams webParams) {
        WebEvent webEvent = new WebEvent();
        webEvent.setType(webParams.getType());
        webEvent.setParams(webParams);
        return "javascript:if (typeof(tyWebEvent) === 'function') { tyWebEvent(" + GsonUtils.b().toJson(webEvent) + ") }";
    }

    protected boolean d(WebView view, String url) {
        if (!this.f10349b) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        if (!g(url)) {
            return false;
        }
        if (b(getContext(), intent)) {
            try {
                getContext().startActivity(intent);
                c cVar = this.f10348a;
                if (cVar != null) {
                    cVar.h(view, url, true);
                    return true;
                }
            } catch (Exception unused) {
            }
        } else {
            c cVar2 = this.f10348a;
            if (cVar2 != null) {
                cVar2.h(view, url, false);
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void e() {
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
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setDefaultTextEncodingName("utf-8");
        CookieManager.getInstance().setAcceptCookie(true);
        settings.setSupportZoom(true);
        setLongClickable(true);
        setScrollbarFadingEnabled(true);
        setScrollBarStyle(0);
        setDrawingCacheEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(getContext().getDir("cache", 0).getPath());
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        if (com.martian.libsupport.l.n()) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (com.martian.libsupport.l.r()) {
            settings.setMixedContentMode(0);
        }
        setDownloadListener(new DownloadListener() { // from class: com.martian.libmars.widget.f
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                MTWebView.this.j(str, str2, str3, str4, j2);
            }
        });
        setWebViewClient(new b());
        setWebChromeClient(new a());
    }

    public boolean f() {
        return this.f10349b;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        c cVar = this.f10348a;
        if (cVar != null) {
            cVar.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public void setBlockImage(boolean block) {
        getSettings().setBlockNetworkImage(block);
    }

    public void setCanHandleDeepLink(boolean canHandleDeepLink) {
        this.f10349b = canHandleDeepLink;
    }

    public void setOnPageStateChangedListener(c l) {
        this.f10348a = l;
    }

    public MTWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10348a = null;
        this.f10349b = true;
        e();
    }

    public MTWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10348a = null;
        this.f10349b = true;
        e();
    }
}
