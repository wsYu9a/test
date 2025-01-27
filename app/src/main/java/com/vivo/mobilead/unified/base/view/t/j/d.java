package com.vivo.mobilead.unified.base.view.t.j;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.vivo.ad.model.q;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.HtmlWebChromeClient;
import com.vivo.ic.webview.IBridge;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.f;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u0;
import com.vivo.mobilead.util.w;

/* loaded from: classes4.dex */
public class d extends CommonWebView {

    /* renamed from: a */
    private Context f30248a;

    /* renamed from: b */
    private com.vivo.ad.model.b f30249b;

    /* renamed from: c */
    private String f30250c;

    /* renamed from: d */
    private int f30251d;

    /* renamed from: e */
    private e f30252e;

    /* renamed from: f */
    private int f30253f;

    /* renamed from: g */
    private int f30254g;

    /* renamed from: h */
    private boolean f30255h;

    /* renamed from: i */
    private com.vivo.mobilead.unified.base.view.t.j.a f30256i;

    class a extends com.vivo.mobilead.web.b {
        a(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, boolean z2) {
            super(context, iBridge, commonWebView, z, z2);
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (d.this.f30252e != null) {
                d.this.f30252e.a(str);
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (d.this.f30252e != null) {
                d.this.f30252e.a();
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (d.this.f30252e != null) {
                d.this.f30252e.a();
            }
        }
    }

    private final class b {
        private b() {
        }

        @JavascriptInterface
        public String getDownloadBtnStr() {
            try {
                return f.a(d.this.f30248a, d.this.f30249b);
            } catch (Exception e2) {
                VOpenLog.w("RewardWebView", "JSInterface.getDownloadBtnStr-->" + e2.getMessage());
                return "";
            }
        }

        @JavascriptInterface
        public void streamDownloadApp() {
            d.this.f30253f = -1;
            boolean j2 = com.vivo.mobilead.util.e.j(d.this.f30249b);
            d.this.a(j2);
            d.this.a(-1, 2, "2", j2);
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        @JavascriptInterface
        public void streamDownloadApp(int i2, boolean z) {
            d.this.f30253f = -1;
            d.this.a(z);
            d.this.a(-1, i2, "2", z);
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public void b() {
    }

    public void c() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        removeJavascriptInterface("downloadAdScript");
        removeJavascriptInterface("AppWebAdClient");
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public void setPreloadFlag(int i2) {
        this.f30256i.a(i2);
    }

    public void setWebCallback(e eVar) {
        this.f30252e = eVar;
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30256i = new com.vivo.mobilead.unified.base.view.t.j.a();
        this.f30248a = context;
        a(context);
    }

    public void a(com.vivo.ad.model.b bVar, String str, int i2, int i3) {
        this.f30249b = bVar;
        this.f30250c = str;
        this.f30251d = i3;
        this.f30254g = i2;
    }

    public void a() {
        loadUrl("javascript:if(window.pageDisplay){window.pageDisplay()}");
    }

    private void a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 11 && i2 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        addJavascriptInterface(new b(this, null), "downloadAdScript");
        addJavascriptInterface(this.f30256i, "AppWebAdClient");
        setWebChromeClient(new HtmlWebChromeClient(context));
        setWebViewClient(new a(context, this, this, false, false));
    }

    public void a(boolean z) {
        q y = this.f30249b.y();
        if (y != null) {
            if (j.b(getContext(), y.a())) {
                w.b(this.f30249b, "3005002", String.valueOf(this.f30254g));
                j.a(getContext(), y.a(), this.f30249b, this.f30250c, String.valueOf(this.f30251d), String.valueOf(this.f30254g));
                this.f30253f = 1;
            } else {
                j.a(getContext(), this.f30249b, z, this.f30250c, this.f30254g);
                this.f30253f = 2;
            }
        }
    }

    public void a(int i2, int i3, String str, boolean z) {
        com.vivo.ad.model.b bVar = this.f30249b;
        if (bVar == null) {
            return;
        }
        if (!this.f30255h && !com.vivo.mobilead.manager.b.l().getBoolean("is_click", false)) {
            this.f30255h = true;
            u0.a(bVar, a.EnumC0603a.CLICK, -999, -999, -999, -999, -999, -999, -999, -999, this.f30250c);
            com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.f30255h);
        }
        k0.a(bVar, f.b(this.f30248a, bVar), i2, i3, -999, -999, -999, -999, this.f30253f, this.f30250c, bVar.i(), c.a.f28912a + "", 1, false, str, z);
    }
}
