package com.alipay.sdk.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.exception.NetErrorException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AuthActivity extends Activity {

    /* renamed from: a */
    static final String f5340a = "params";

    /* renamed from: b */
    static final String f5341b = "redirectUri";

    /* renamed from: c */
    private WebView f5342c;

    /* renamed from: d */
    private String f5343d;

    /* renamed from: e */
    private b.b.a.g.a f5344e;

    /* renamed from: g */
    private boolean f5346g;

    /* renamed from: f */
    private Handler f5345f = new Handler();

    /* renamed from: h */
    private Runnable f5347h = new e(this);

    private class a extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(AuthActivity authActivity, byte b2) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message)) {
                return super.onConsoleMessage(consoleMessage);
            }
            String replaceFirst = message.startsWith("h5container.message: ") ? message.replaceFirst("h5container.message: ", "") : null;
            if (TextUtils.isEmpty(replaceFirst)) {
                return super.onConsoleMessage(consoleMessage);
            }
            AuthActivity.k(AuthActivity.this, replaceFirst);
            return super.onConsoleMessage(consoleMessage);
        }
    }

    class b extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(AuthActivity authActivity, byte b2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            AuthActivity.this.q();
            AuthActivity.this.f5345f.removeCallbacks(AuthActivity.this.f5347h);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthActivity.this.p();
            AuthActivity.this.f5345f.postDelayed(AuthActivity.this.f5347h, 30000L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!AuthActivity.this.f5346g) {
                AuthActivity.this.runOnUiThread(new o(this, sslErrorHandler));
            } else {
                sslErrorHandler.proceed();
                AuthActivity.this.f5346g = false;
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!AuthActivity.this.h(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.stopLoading();
            return true;
        }
    }

    private void a() {
        p();
        try {
            String string = getIntent().getExtras().getString("params");
            this.f5343d = getIntent().getExtras().getString(f5341b);
            b.b.a.c.e b2 = b.b.a.c.b.b(new b.b.a.c.c(), string, new JSONObject());
            b.b.a.c.a aVar = b2.f4235a;
            aVar.f4219b = "com.alipay.mobilecashier";
            aVar.f4222e = "com.alipay.mcpay";
            aVar.f4221d = "4.0.0";
            aVar.f4220c = "/cashier/main";
            try {
                JSONObject jSONObject = new b.b.a.e.d(new b.b.a.c.c()).a(this, b2, false).f5419c;
                q();
                e(jSONObject);
            } catch (NetErrorException unused) {
                runOnUiThread(new g(this));
            } catch (Exception unused2) {
                runOnUiThread(new h(this));
            } finally {
                q();
            }
        } catch (Exception unused3) {
            q();
            finish();
        }
    }

    static /* synthetic */ void b(AuthActivity authActivity) {
        authActivity.p();
        try {
            String string = authActivity.getIntent().getExtras().getString("params");
            authActivity.f5343d = authActivity.getIntent().getExtras().getString(f5341b);
            b.b.a.c.e b2 = b.b.a.c.b.b(new b.b.a.c.c(), string, new JSONObject());
            b.b.a.c.a aVar = b2.f4235a;
            aVar.f4219b = "com.alipay.mobilecashier";
            aVar.f4222e = "com.alipay.mcpay";
            aVar.f4221d = "4.0.0";
            aVar.f4220c = "/cashier/main";
            try {
                JSONObject jSONObject = new b.b.a.e.d(new b.b.a.c.c()).a(authActivity, b2, false).f5419c;
                authActivity.q();
                authActivity.e(jSONObject);
            } catch (NetErrorException unused) {
                authActivity.runOnUiThread(new g(authActivity));
            } catch (Exception unused2) {
                authActivity.runOnUiThread(new h(authActivity));
            } finally {
                authActivity.q();
            }
        } catch (Exception unused3) {
            authActivity.q();
            authActivity.finish();
        }
    }

    static /* synthetic */ void c(AuthActivity authActivity, com.alipay.sdk.authjs.a aVar) {
        if (authActivity.f5342c == null || aVar == null) {
            return;
        }
        try {
            authActivity.runOnUiThread(new d(authActivity, String.format("AlipayJSBridge._invokeJS(%s)", aVar.a())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void d(com.alipay.sdk.authjs.a aVar) {
        if (this.f5342c == null || aVar == null) {
            return;
        }
        try {
            runOnUiThread(new d(this, String.format("AlipayJSBridge._invokeJS(%s)", aVar.a())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void e(JSONObject jSONObject) {
        for (com.alipay.sdk.protocol.a aVar : com.alipay.sdk.protocol.a.a(com.alipay.sdk.protocol.b.d(jSONObject.optJSONObject(b.b.a.b.c.f4210c), b.b.a.b.c.f4211d))) {
            if (aVar == com.alipay.sdk.protocol.a.WapPay) {
                String str = com.alipay.sdk.util.a.a(aVar.e())[0];
                if (com.alipay.sdk.util.j.e(str)) {
                    runOnUiThread(new i(this, str));
                    return;
                } else {
                    finish();
                    return;
                }
            }
        }
    }

    public boolean h(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, this.f5343d)) {
                str = str + "?resultCode=150";
            }
            r.b(this, str);
        }
        finish();
        return true;
    }

    private void i() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("不能连接到服务器，是否重试？");
        builder.setPositiveButton("确定", new j(this));
        builder.setNeutralButton("取消", new l(this));
        builder.create().show();
    }

    static /* synthetic */ void j(AuthActivity authActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(authActivity);
        builder.setMessage("不能连接到服务器，是否重试？");
        builder.setPositiveButton("确定", new j(authActivity));
        builder.setNeutralButton("取消", new l(authActivity));
        builder.create().show();
    }

    static /* synthetic */ void k(AuthActivity authActivity, String str) {
        new com.alipay.sdk.authjs.d(authActivity, new n(authActivity)).f(str);
    }

    private void l(String str) {
        new com.alipay.sdk.authjs.d(this, new n(this)).f(str);
    }

    private void m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("系统繁忙，请稍后再试");
        builder.setNeutralButton("确定", new m(this));
        builder.create().show();
    }

    static /* synthetic */ void n(AuthActivity authActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(authActivity);
        builder.setMessage("系统繁忙，请稍后再试");
        builder.setNeutralButton("确定", new m(authActivity));
        builder.create().show();
    }

    public void p() {
        try {
            if (this.f5344e == null) {
                this.f5344e = new b.b.a.g.a(this);
            }
            this.f5344e.f();
        } catch (Exception unused) {
            this.f5344e = null;
        }
    }

    public void q() {
        b.b.a.g.a aVar = this.f5344e;
        if (aVar != null && aVar.d()) {
            this.f5344e.g();
        }
        this.f5344e = null;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        super.requestWindowFeature(1);
        b.b.a.f.a.a().c(this, b.b.a.c.d.a());
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        setContentView(linearLayout, layoutParams);
        WebView webView = new WebView(this);
        this.f5342c = webView;
        layoutParams.weight = 1.0f;
        webView.setVisibility(0);
        linearLayout.addView(this.f5342c, layoutParams);
        WebSettings settings = this.f5342c.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.j.j(this));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        this.f5342c.setVerticalScrollbarOverlay(true);
        this.f5342c.setWebViewClient(new b(this, (byte) 0));
        this.f5342c.setWebChromeClient(new a(this, (byte) 0));
        this.f5342c.setDownloadListener(new c(this));
        new Thread(new f(this)).start();
        if (Build.VERSION.SDK_INT >= 7) {
            try {
                Method method = this.f5342c.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                if (method != null) {
                    method.invoke(this.f5342c.getSettings(), Boolean.TRUE);
                }
            } catch (Exception unused) {
            }
        }
        try {
            Method method2 = this.f5342c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method2 != null) {
                method2.invoke(this.f5342c, "searchBoxJavaBridge_");
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
