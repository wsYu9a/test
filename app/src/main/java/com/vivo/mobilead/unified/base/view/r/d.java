package com.vivo.mobilead.unified.base.view.r;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.HtmlWebChromeClient;
import com.vivo.ic.webview.IBridge;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.util.e;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d extends CommonWebView {

    /* renamed from: a */
    private com.vivo.ad.model.b f30018a;

    /* renamed from: b */
    private String f30019b;

    /* renamed from: c */
    private BackUrlInfo f30020c;

    /* renamed from: d */
    private int f30021d;

    /* renamed from: e */
    private int f30022e;

    /* renamed from: f */
    private com.vivo.mobilead.unified.base.view.r.b f30023f;

    /* renamed from: g */
    private boolean f30024g;

    /* renamed from: h */
    private boolean f30025h;

    /* renamed from: i */
    private Handler f30026i;

    /* renamed from: j */
    private com.vivo.mobilead.util.f1.b f30027j;
    private com.vivo.mobilead.unified.base.view.r.a k;
    private ViewTreeObserver.OnWindowFocusChangeListener l;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (d.this.f30023f != null) {
                d.this.f30023f.b();
            }
            if (d.this.f30026i != null) {
                d.this.f30026i.postDelayed(d.this.f30027j, 1000L);
            }
        }
    }

    class b extends com.vivo.mobilead.web.b {
        b(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, boolean z2) {
            super(context, iBridge, commonWebView, z, z2);
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (d.this.f30023f != null) {
                d.this.f30023f.a(str);
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (d.this.f30023f != null) {
                d.this.f30023f.a();
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (d.this.f30023f != null) {
                d.this.f30023f.a();
            }
        }
    }

    class c implements com.vivo.mobilead.unified.base.view.r.a {
        c() {
        }

        @JavascriptInterface
        public void downloadApp() {
            boolean j2 = e.j(d.this.f30018a);
            int a2 = u.a(d.this.getContext(), d.this.f30018a, j2, false, d.this.f30019b, d.this.f30018a.i(), d.this.f30020c, d.this.f30021d, d.this.f30022e);
            if (d.this.f30023f != null) {
                d.this.f30023f.a(a2, j2);
            }
        }

        @JavascriptInterface
        public Boolean isViewable() {
            return Boolean.valueOf(d.this.getVisibility() == 0 && d.this.f30024g);
        }

        @JavascriptInterface
        public void reportAdEvent(String str, String str2) {
            k0.b(d.this.f30018a, str, str2);
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.r.d$d */
    class ViewTreeObserverOnWindowFocusChangeListenerC0626d implements ViewTreeObserver.OnWindowFocusChangeListener {
        ViewTreeObserverOnWindowFocusChangeListenerC0626d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            d.this.f30024g = z;
        }
    }

    public d(Context context) {
        this(context, null);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        removeJavascriptInterface("vivoAdSDK");
        e();
        Handler handler = this.f30026i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30026i = null;
        }
    }

    @Override // com.vivo.ic.webview.CommonWebView, android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnWindowFocusChangeListener(this.l);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public void setMute(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "mutedChange");
            jSONObject.put("params", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        loadUrl("javascript:playableSDK.dispatch ('" + jSONObject.toString() + "')");
    }

    public void setWebCallback(com.vivo.mobilead.unified.base.view.r.b bVar) {
        this.f30023f = bVar;
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.l);
        }
    }

    public void b() {
        Handler handler = this.f30026i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f30025h = false;
        a(false);
    }

    public void c() {
        Handler handler = this.f30026i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30026i.postDelayed(this.f30027j, 1000L);
        }
        this.f30025h = true;
        a(true);
    }

    public void d() {
        Handler handler = this.f30026i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30026i = null;
        }
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30024g = getVisibility() == 0;
        this.f30025h = false;
        this.f30026i = new Handler(Looper.getMainLooper());
        this.f30027j = new a();
        this.k = new c();
        this.l = new ViewTreeObserverOnWindowFocusChangeListenerC0626d();
        a(context);
    }

    public void a(com.vivo.ad.model.b bVar, String str, BackUrlInfo backUrlInfo, int i2, int i3) {
        this.f30018a = bVar;
        this.f30019b = str;
        this.f30020c = backUrlInfo;
        this.f30021d = i2;
        this.f30022e = i3;
        if (bVar.t() == null || TextUtils.isEmpty(bVar.t().a())) {
            return;
        }
        loadUrl(bVar.t().a());
        b();
        setMute(false);
    }

    public boolean a() {
        return this.f30025h;
    }

    private void a(Context context) {
        addJavascriptInterface(this.k, "vivoAdSDK");
        setWebChromeClient(new HtmlWebChromeClient(context));
        setWebViewClient(new b(context, this, this, false, false));
    }

    public void a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "visibilityChange");
            jSONObject.put("params", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        loadUrl("javascript:playableSDK.dispatch ('" + jSONObject.toString() + "')");
    }
}
