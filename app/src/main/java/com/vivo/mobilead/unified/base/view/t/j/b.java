package com.vivo.mobilead.unified.base.view.t.j;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.HtmlWebChromeClient;
import com.vivo.ic.webview.IBridge;

/* loaded from: classes4.dex */
public class b extends CommonWebView {

    /* renamed from: a */
    private com.vivo.mobilead.unified.base.view.r.b f30233a;

    /* renamed from: b */
    private Handler f30234b;

    /* renamed from: c */
    private float f30235c;

    /* renamed from: d */
    private float f30236d;

    /* renamed from: e */
    private float f30237e;

    /* renamed from: f */
    private float f30238f;

    /* renamed from: g */
    private float f30239g;

    /* renamed from: h */
    private com.vivo.mobilead.util.f1.b f30240h;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (b.this.f30233a != null) {
                b.this.f30233a.b();
            }
            if (b.this.f30234b != null) {
                b.this.f30234b.postDelayed(b.this.f30240h, 1000L);
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        Handler handler = this.f30234b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30234b = null;
        }
    }

    @Override // com.vivo.ic.webview.CommonWebView, android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.vivo.ic.webview.CommonWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.vivo.mobilead.unified.base.view.r.b bVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f30235c = motionEvent.getX();
            this.f30236d = motionEvent.getY();
        } else if (action == 1) {
            this.f30237e = motionEvent.getX();
            this.f30238f = motionEvent.getY();
            if (Math.abs(this.f30237e - this.f30235c) <= this.f30239g && Math.abs(this.f30238f - this.f30236d) <= this.f30239g && (bVar = this.f30233a) != null) {
                bVar.a(-1, false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setData(com.vivo.ad.model.b bVar) {
        if (TextUtils.isEmpty(bVar.v())) {
            return;
        }
        loadUrl(bVar.v());
        a();
    }

    public void setWebCallback(com.vivo.mobilead.unified.base.view.r.b bVar) {
        this.f30233a = bVar;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        Handler handler = this.f30234b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void b() {
        Handler handler = this.f30234b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30234b.postDelayed(this.f30240h, 1000L);
        }
    }

    public void c() {
        Handler handler = this.f30234b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30234b = null;
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.t.j.b$b */
    class C0638b extends com.vivo.mobilead.web.b {
        C0638b(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, boolean z2) {
            super(context, iBridge, commonWebView, z, z2);
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (b.this.f30233a != null) {
                b.this.f30233a.a(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (b.this.f30233a != null) {
                b.this.f30233a.a();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (b.this.f30233a != null) {
                b.this.f30233a.a();
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (b.this.f30233a != null) {
                b.this.f30233a.a();
            }
        }

        @Override // com.vivo.mobilead.web.b, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (b.this.f30233a != null) {
                b.this.f30233a.a();
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30234b = new Handler(Looper.getMainLooper());
        this.f30239g = 30.0f;
        this.f30240h = new a();
        a(context);
    }

    private void a(Context context) {
        setWebChromeClient(new HtmlWebChromeClient(context));
        setWebViewClient(new C0638b(context, this, this, false, false));
    }
}
