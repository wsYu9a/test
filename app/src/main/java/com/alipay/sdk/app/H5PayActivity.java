package com.alipay.sdk.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: a */
    private WebView f5274a;

    /* renamed from: b */
    private b.b.a.g.a f5275b;

    /* renamed from: d */
    private boolean f5277d;

    /* renamed from: e */
    private boolean f5278e;

    /* renamed from: c */
    private Handler f5276c = new Handler();

    /* renamed from: f */
    private Runnable f5279f = new t(this);

    class a extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(H5PayActivity h5PayActivity, byte b2) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            new AlertDialog.Builder(H5PayActivity.this).setTitle("提示").setMessage(str2).setPositiveButton("确定", new v(this, jsResult)).setNegativeButton("取消", new u(this, jsResult)).show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            new AlertDialog.Builder(H5PayActivity.this).setTitle("提示").setMessage(str2).setPositiveButton("确定", new x(this, jsResult)).setNegativeButton("取消", new w(this, jsResult)).show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            new AlertDialog.Builder(H5PayActivity.this).setTitle("提示").setMessage(str2).setPositiveButton("确定", new z(this, jsPromptResult)).setNegativeButton("取消", new y(this, jsPromptResult)).show();
            return true;
        }
    }

    class b extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(H5PayActivity h5PayActivity, byte b2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onFormResubmission(WebView webView, Message message, Message message2) {
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            H5PayActivity.j(H5PayActivity.this);
            H5PayActivity.this.f5276c.removeCallbacks(H5PayActivity.this.f5279f);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            H5PayActivity.g(H5PayActivity.this);
            H5PayActivity.this.f5276c.postDelayed(H5PayActivity.this.f5279f, 30000L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            H5PayActivity.b(H5PayActivity.this);
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!H5PayActivity.this.f5278e) {
                H5PayActivity.this.runOnUiThread(new a0(this, sslErrorHandler));
            } else {
                sslErrorHandler.proceed();
                H5PayActivity.this.f5278e = false;
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int parseInt;
            String b2;
            if (str.startsWith(b.b.a.b.a.p)) {
                return false;
            }
            if (TextUtils.equals(str, b.b.a.b.a.k) || TextUtils.equals(str, b.b.a.b.a.l)) {
                d.f5308a = d.a();
                H5PayActivity.this.finish();
                return true;
            }
            if (!str.startsWith(b.b.a.b.a.f4197j)) {
                webView.loadUrl(str);
                return true;
            }
            try {
                String substring = str.substring(str.indexOf(b.b.a.b.a.f4197j) + 24);
                parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(b.b.a.b.a.m) + 10));
            } catch (Exception unused) {
                d.f5308a = d.d();
            }
            if (parseInt != ac.SUCCEEDED.a() && parseInt != ac.PAY_WAITTING.a()) {
                ac a2 = ac.a(ac.FAILED.a());
                b2 = d.b(a2.a(), a2.b(), "");
                d.f5308a = b2;
                H5PayActivity.this.runOnUiThread(new c(this));
                return true;
            }
            StringBuilder sb = new StringBuilder();
            String decode = URLDecoder.decode(str);
            String substring2 = decode.substring(decode.indexOf(b.b.a.b.a.f4197j) + 24, decode.lastIndexOf(b.b.a.b.a.m));
            if (substring2.contains(b.b.a.b.a.n)) {
                String str2 = substring2.split(b.b.a.b.a.n)[0];
                int indexOf = substring2.indexOf(b.b.a.b.a.n) + 13;
                sb.append(str2);
                sb.append(b.b.a.b.a.n);
                sb.append(substring2.substring(indexOf, substring2.indexOf("\"&", indexOf)));
                sb.append(substring2.substring(substring2.indexOf("\"&", indexOf)));
                substring2 = sb.toString();
            }
            ac a3 = ac.a(parseInt);
            b2 = d.b(a3.a(), a3.b(), substring2);
            d.f5308a = b2;
            H5PayActivity.this.runOnUiThread(new c(this));
            return true;
        }
    }

    private static void a() {
        Object obj = PayTask.f5282a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ boolean b(H5PayActivity h5PayActivity) {
        h5PayActivity.f5277d = true;
        return true;
    }

    private void d() {
        if (this.f5275b == null) {
            this.f5275b = new b.b.a.g.a(this);
        }
        this.f5275b.f();
    }

    private void f() {
        b.b.a.g.a aVar = this.f5275b;
        if (aVar != null && aVar.d()) {
            this.f5275b.g();
        }
        this.f5275b = null;
    }

    static /* synthetic */ void g(H5PayActivity h5PayActivity) {
        if (h5PayActivity.f5275b == null) {
            h5PayActivity.f5275b = new b.b.a.g.a(h5PayActivity);
        }
        h5PayActivity.f5275b.f();
    }

    static /* synthetic */ void j(H5PayActivity h5PayActivity) {
        b.b.a.g.a aVar = h5PayActivity.f5275b;
        if (aVar != null && aVar.d()) {
            h5PayActivity.f5275b.g();
        }
        h5PayActivity.f5275b = null;
    }

    @Override // android.app.Activity
    public void finish() {
        Object obj = PayTask.f5282a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        String a2;
        if (!this.f5274a.canGoBack()) {
            a2 = d.a();
        } else {
            if (!this.f5277d) {
                return;
            }
            ac a3 = ac.a(ac.NETWORK_ERROR.a());
            a2 = d.b(a3.a(), a3.b(), "");
        }
        d.f5308a = a2;
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        try {
            String string = extras.getString("url");
            if (!com.alipay.sdk.util.j.e(string)) {
                finish();
                return;
            }
            super.requestWindowFeature(1);
            String string2 = extras.getString("cookie");
            if (!TextUtils.isEmpty(string2)) {
                CookieSyncManager.createInstance(this).sync();
                CookieManager.getInstance().setCookie(string, string2);
                CookieSyncManager.getInstance().sync();
            }
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            linearLayout.setOrientation(1);
            setContentView(linearLayout, layoutParams);
            WebView webView = new WebView(this);
            this.f5274a = webView;
            layoutParams.weight = 1.0f;
            webView.setVisibility(0);
            linearLayout.addView(this.f5274a, layoutParams);
            WebSettings settings = this.f5274a.getSettings();
            settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.j.j(this));
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setSupportMultipleWindows(true);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
            settings.setAllowFileAccess(false);
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            this.f5274a.setVerticalScrollbarOverlay(true);
            this.f5274a.setWebViewClient(new b(this, (byte) 0));
            this.f5274a.setWebChromeClient(new a(this, (byte) 0));
            this.f5274a.loadUrl(string);
            if (Build.VERSION.SDK_INT >= 7) {
                try {
                    Method method = this.f5274a.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                    if (method != null) {
                        method.invoke(this.f5274a.getSettings(), Boolean.TRUE);
                    }
                } catch (Exception unused) {
                }
            }
            try {
                Method method2 = this.f5274a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method2 != null) {
                    method2.invoke(this.f5274a, "searchBoxJavaBridge_");
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            finish();
        }
    }
}
